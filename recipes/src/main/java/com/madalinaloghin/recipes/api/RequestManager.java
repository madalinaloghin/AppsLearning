package com.madalinaloghin.recipes.api;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.madalinaloghin.recipes.R;
import com.madalinaloghin.recipes.api.response.ResponseQueryRecipes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RequestManager {

    private static RequestManager instance;

    public static RequestManager getInstance(@NonNull final Context context) {
        if (instance == null) {
            instance = new RequestManager(context);
        }
        return instance;
    }

    private Context mAppContext;
    private Retrofit mRetrofit;

    private RequestManager(@NonNull final Context context) {
        mAppContext = context.getApplicationContext();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

    }

    public String getBaseUrl() {
        return "https://api.edamam.com";
    }

    public String getAppId() {
        return mAppContext.getResources().getString(R.string.edamam_app_id);
    }


    public String getAppKey() {
        return mAppContext.getResources().getString(R.string.edamam_app_key);
    }

    public void queryRecipes(@NonNull final String query, final int from, final int to, @Nullable final Callback<ResponseQueryRecipes> callback) {
        RecipesService service = mRetrofit.create(RecipesService.class);
        Call<ResponseQueryRecipes> call = service.queryRecipes(query, getAppId(), getAppKey(), from, to);
        if (callback != null) {
            call.enqueue(callback);
        }
    }

}
