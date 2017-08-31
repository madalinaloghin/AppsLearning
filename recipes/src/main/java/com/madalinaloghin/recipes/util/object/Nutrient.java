package com.madalinaloghin.recipes.util.object;

import java.io.Serializable;

/**
 * Created by madalina.loghin on 7/20/2017.
 */

public class Nutrient implements Serializable {

    private String label;
    private double quantity;
    private String unit;


    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public Nutrient(String label, double quantity, String unit) {
        this.label = label;
        this.quantity = quantity;
        this.unit = unit;
    }

    public Nutrient() {

    }
}
