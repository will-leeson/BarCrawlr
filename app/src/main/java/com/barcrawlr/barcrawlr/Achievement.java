package com.barcrawlr.barcrawlr;

import android.graphics.Bitmap;

public class Achievement {
    private String name;
    private Bitmap image;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Bitmap getImage() {
        return image;
    }
}