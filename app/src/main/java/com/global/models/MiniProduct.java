package com.global.models;

import android.graphics.Bitmap;

/**
 * Created by sourin on 04/08/15.
 */
public class MiniProduct {

    private Bitmap miniProductImage;
    private String miniProductName;
    private String miniProductPrice;

    public MiniProduct(Bitmap miniProductImage, String miniProductName, String miniProductPrice) {
        this.miniProductImage = miniProductImage;
        this.miniProductName = miniProductName;
        this.miniProductPrice = miniProductPrice;
    }

    public Bitmap getMiniProductImage() {
        return miniProductImage;
    }

    public void setMiniProductImage(Bitmap miniProductImage) {
        this.miniProductImage = miniProductImage;
    }

    public String getMiniProductName() {
        return miniProductName;
    }

    public void setMiniProductName(String miniProductName) {
        this.miniProductName = miniProductName;
    }

    public String getMiniProductPrice() {
        return miniProductPrice;
    }

    public void setMiniProductPrice(String miniProductPrice) {
        this.miniProductPrice = miniProductPrice;
    }
}
