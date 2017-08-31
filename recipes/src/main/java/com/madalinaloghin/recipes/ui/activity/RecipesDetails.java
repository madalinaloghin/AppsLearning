package com.madalinaloghin.recipes.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.madalinaloghin.recipes.R;
import com.madalinaloghin.recipes.util.object.Recipe;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipesDetails extends AppCompatActivity {

    private static final String KEY_RECIPE = "recipe";

    public static Intent getStartIntent(@NonNull final Context context, @NonNull final Recipe recipe) {
        Intent intent = new Intent(context, RecipesDetails.class);
        intent.putExtra(KEY_RECIPE, recipe);
        return intent;
    }

    @BindView(R.id.iv_recipe_details)
    ImageView ivImageRecipe;

    @BindView(R.id.tv_recipe_details_title)
    TextView tvTitleRecipe;

    @BindView(R.id.tv_recipe_diet)
    TextView tvRecipeDiet;

    @BindView(R.id.tv_ingredient_list)
    TextView tvIngredients;

    @BindView(R.id.tv_health_labels)
    TextView tvHealthLabels;

    @BindView(R.id.tv_health)
    TextView tvHealth;

    @BindView(R.id.tv_nutrient)
    TextView tvNutrient;
    @BindView(R.id.tv_nutrient_list)
    TextView tvNutrientList;

    Recipe recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_details);

        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        recipe = (Recipe) bundle.getSerializable(KEY_RECIPE);

        Glide.with(RecipesDetails.this).load(recipe.getImageUrl()).into(ivImageRecipe);

        setValues();

    }


    private void setValues() {
        tvTitleRecipe.setText(recipe.getName());

        if (recipe.getDietLabels().size() == 0) {
            tvRecipeDiet.setEnabled(false);
        } else {
            tvRecipeDiet.setText(getResources().getString(R.string.diet));
            for (int i = 0; i < recipe.getDietLabels().size(); i++) {
                tvRecipeDiet.append("\u2022 " + recipe.getDietLabels().get(i).toString() + " ");
            }
        }

        if (recipe.getHealthLabels().size() == 0) {
            tvHealth.setEnabled(false);
            tvHealthLabels.setEnabled(false);
        } else {
            tvHealthLabels.setText("");
            for (int i = 0; i < recipe.getHealthLabels().size(); i++) {
                tvHealthLabels.append("\u2022 " + recipe.getHealthLabels().get(i).toString() + "\n");
            }
        }

        tvIngredients.setText("");
        for (int i = 0; i < recipe.getIngredientLines().size(); i++) {
            tvIngredients.append("\u2022 " + recipe.getIngredientLines().get(i).toString() + "\n");
        }

        tvNutrientList.setText("");
        if (recipe.getTotalNutrients().getEnergy() != null) {
            tvNutrientList.append("Energy: "
                    + String.format("%.2f", recipe.getTotalNutrients().getEnergy().getQuantity()) + " "
                    + recipe.getTotalNutrients().getEnergy().getUnit() + "\n");
        }
        if (recipe.getTotalNutrients().getFat() != null) {
            tvNutrientList.append("Fat: "
                    + String.format("%.2f", recipe.getTotalNutrients().getFat().getQuantity()) + " "
                    + recipe.getTotalNutrients().getFat().getUnit() + "\n");
        }
        if (recipe.getTotalNutrients().getCarbs() != null) {
            tvNutrientList.append("Carbs: "
                    + String.format("%.2f", recipe.getTotalNutrients().getCarbs().getQuantity()) + " "
                    + recipe.getTotalNutrients().getCarbs().getUnit() + "\n");
        }
        if (recipe.getTotalNutrients().getFiber() != null) {
            tvNutrientList.append("Fiber: "
                    + String.format("%.2f", recipe.getTotalNutrients().getFiber().getQuantity()) + " "
                    + recipe.getTotalNutrients().getFiber().getUnit() + "\n");
        }
        if (recipe.getTotalNutrients().getSugar() != null) {
            tvNutrientList.append("Sugar: "
                    + String.format("%.2f", recipe.getTotalNutrients().getSugar().getQuantity()) + " "
                    + recipe.getTotalNutrients().getSugar().getUnit() + "\n");
        }
        if (recipe.getTotalNutrients().getProtein() != null) {
            tvNutrientList.append("Protein: "
                    + String.format("%.2f", recipe.getTotalNutrients().getProtein().getQuantity()) + " "
                    + recipe.getTotalNutrients().getProtein().getUnit() + "\n");
        }

    }

}
