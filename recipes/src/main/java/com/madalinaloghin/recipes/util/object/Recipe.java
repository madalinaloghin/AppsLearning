package com.madalinaloghin.recipes.util.object;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;



public class Recipe implements Serializable {

    @SerializedName("label")
    private String name;

    @SerializedName("source")
    private String from;

    @SerializedName("image")
    private String imageUrl;

    @SerializedName("dietLabels")
    private ArrayList<String> dietLabels;

    @SerializedName("healthLabels")
    private ArrayList<String> healthLabels;

    @SerializedName("ingredientLines")
    private ArrayList<String> ingredientLines;

    @SerializedName("totalNutrients")
    private TotalNutrients totalNutrients;



    public Recipe(final String name, final String from, final String imageUrl) {
        this.name = name;
        this.from = from;
        this.imageUrl = imageUrl;
    }

    public String getFrom() {
        return from;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getDietLabels() {
        return dietLabels;
    }

    public void setDietLabels(ArrayList<String> dietLabels) {
        this.dietLabels = dietLabels;
    }

    public ArrayList<String> getHealthLabels() {
        return healthLabels;
    }

    public void setHealthLabels(ArrayList<String> healthLabels) {
        this.healthLabels = healthLabels;
    }

    public ArrayList<String> getIngredientLines() {
        return ingredientLines;
    }

    public void setIngredientLines(ArrayList<String> ingredientLines) {
        this.ingredientLines = ingredientLines;
    }


    public TotalNutrients getTotalNutrients() {
        return totalNutrients;
    }

    public void setTotalNutrients(TotalNutrients totalNutrients) {
        this.totalNutrients = totalNutrients;
    }
}
