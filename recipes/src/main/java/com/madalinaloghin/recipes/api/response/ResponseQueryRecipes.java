package com.madalinaloghin.recipes.api.response;

import com.google.gson.annotations.SerializedName;
import com.madalinaloghin.recipes.util.object.Hit;

import java.util.List;

/**
 * Created by Daniel on 4/1/2017.
 */

public class ResponseQueryRecipes {

    @SerializedName("hits")
    private List<Hit> hits;

    public List<Hit> getHits() {
        return hits;
    }
}
