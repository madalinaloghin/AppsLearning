package com.madalinaloghin.recipes.util.object;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by madalina.loghin on 7/20/2017.
 */

public class TotalNutrients implements Serializable {

    @SerializedName("ENERC_KAL")
    private Nutrient energy;

    @SerializedName("FAT")
    private Nutrient fat;

    @SerializedName("CHOCDF")
    private Nutrient carbs;

    @SerializedName("FIBER")
    private Nutrient fiber;

    @SerializedName("SUGAR")
    private Nutrient sugar;

    @SerializedName("PROCNT")
    private Nutrient protein;


    public TotalNutrients() {
    }


    public TotalNutrients(Nutrient energy, Nutrient fat, Nutrient carbs, Nutrient fiber, Nutrient sugar, Nutrient protein) {
        this.energy = energy;
        this.fat = fat;
        this.carbs = carbs;
        this.fiber = fiber;
        this.sugar = sugar;
        this.protein = protein;
    }

    public Nutrient getEnergy() {
        return energy;
    }

    public Nutrient getFat() {
        return fat;
    }

    public Nutrient getCarbs() {
        return carbs;
    }

    public Nutrient getFiber() {
        return fiber;
    }

    public Nutrient getSugar() {
        return sugar;
    }

    public Nutrient getProtein() {
        return protein;
    }
}
