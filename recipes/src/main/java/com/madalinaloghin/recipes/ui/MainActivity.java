package com.madalinaloghin.recipes.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.madalinaloghin.recipes.R;
import com.madalinaloghin.recipes.api.RequestManager;
import com.madalinaloghin.recipes.api.response.ResponseQueryRecipes;
import com.madalinaloghin.recipes.ui.activity.RecipesDetails;
import com.madalinaloghin.recipes.ui.adapter.AdapterRecipes;
import com.madalinaloghin.recipes.util.Util;
import com.madalinaloghin.recipes.util.object.Recipe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_recipes)
    RecyclerView rvRecipes;

    @BindView(R.id.et_ingredient)
    EditText etIngredient;

    private AdapterRecipes mAdapter;

    String ingredient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setupRecyclerView();

    }

    @OnClick(R.id.btn_search)
    void searchRecipes() {
        if (etIngredient.getText().toString().isEmpty()) {
            Toast.makeText(this, "You must enter an ingredient!", Toast.LENGTH_SHORT).show();
        } else {
            ingredient = etIngredient.getText().toString();
            hideKeyboard();
            getRecipes(ingredient);
        }

    }

    private void setupRecyclerView() {
        rvRecipes.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new AdapterRecipes(new AdapterRecipes.OnItemClickedListener() {
            @Override
            public void onItemClick(Recipe recipe) {
                startActivity(RecipesDetails.getStartIntent(MainActivity.this, recipe));
            }
        });
        rvRecipes.setAdapter(mAdapter);
    }

    protected void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


    private void getRecipes(String ingredient) {
        RequestManager.getInstance(this).queryRecipes(
                ingredient,
                0,
                20,
                new Callback<ResponseQueryRecipes>() {
                    @Override
                    public void onResponse(Call<ResponseQueryRecipes> call, Response<ResponseQueryRecipes> response) {
                        if (response.body().getHits().size() == 0) {
                            Toast.makeText(MainActivity.this, "You should try with another ingredient :). ", Toast.LENGTH_SHORT).show();
                        } else {
                            mAdapter.setItems(Util.fromHitListToRecipeList(response.body().getHits()));
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseQueryRecipes> call, Throwable t) {

                    }
                }
        );
    }
}
