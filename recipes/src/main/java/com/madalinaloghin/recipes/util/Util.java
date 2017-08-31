package com.madalinaloghin.recipes.util;

import android.support.annotation.Nullable;

import com.madalinaloghin.recipes.util.object.Hit;
import com.madalinaloghin.recipes.util.object.Recipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 3/31/2017.
 */

public class Util {

    private Util() {
    }

    public static ArrayList<Recipe> fromHitListToRecipeList(@Nullable final List<Hit> data) {
        if (data == null) {
            return null;
        }

        ArrayList<Recipe> recipes = new ArrayList<>();

        for (final Hit hit : data) {
            recipes.add(hit.getRecipe());
        }

        return recipes;
    }

}
