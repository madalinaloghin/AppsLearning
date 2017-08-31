package com.madalinaloghin.thirdpartyhelp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by madalina.loghin on 7/19/2017.
 */

public class Values {

    public static List<Images> getDummyImagesList(){
        List<Images> images = new ArrayList<>();
        images.add(new Images( "Serious Eats", "http://images.media-allrecipes.com/userphotos/560x315/1101499.jpg"));
        images.add(new Images( "Martha Stewart", "http://images.media-allrecipes.com/userphotos/560x315/1009113.jpg"));
        images.add(new Images(  "Epicurious", "http://images.media-allrecipes.com/userphotos/560x315/3943473.jpg"));
        images.add(new Images( "Serious Eats", "http://images.media-allrecipes.com/userphotos/560x315/1411947.jpg"));
        images.add(new Images( "Martha Stewart", "http://images.media-allrecipes.com/userphotos/560x315/566639.jpg"));
        images.add(new Images( "Epicurious", "http://images.media-allrecipes.com/userphotos/560x315/1655056.jpg"));
        images.add(new Images( "Serious Eats", "http://images.media-allrecipes.com/userphotos/560x315/1711439.jpg"));
        images.add(new Images( "Martha Stewart", "http://images.media-allrecipes.com/userphotos/560x315/116544.jpg"));
        images.add(new Images( "Epicurious", "http://images.media-allrecipes.com/userphotos/560x315/185756.jpg"));

        return images;
    }
}
