package com.madalinaloghin.scrollandrecycler.recycler_view;


import com.madalinaloghin.scrollandrecycler.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by madalina.loghin on 7/17/2017.
 */

public class Cat {

    private String name;
    private int img;

    public Cat() {
    }

    public Cat(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public static List<Cat> createCatsList() {
        List<Cat> cats = new ArrayList<>();

        for (int i = 0; i <= 100; i++) {
            cats.add(new Cat("Cat " + i, R.drawable.cat));
        }

        return cats;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }
}
