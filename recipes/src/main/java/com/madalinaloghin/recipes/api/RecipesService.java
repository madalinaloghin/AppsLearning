package com.madalinaloghin.recipes.api;


import com.madalinaloghin.recipes.api.response.ResponseQueryRecipes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Daniel on 4/1/2017.
 */

public interface RecipesService {

    @GET("search")
    Call<ResponseQueryRecipes> queryRecipes(@Query("q") String query,
                                            @Query("app_id") String appId,
                                            @Query("app_key") String appKey,
                                            @Query("from") int from,
                                            @Query("to") int to);

}
