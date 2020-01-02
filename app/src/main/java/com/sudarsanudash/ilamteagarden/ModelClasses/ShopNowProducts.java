package com.sudarsanudash.ilamteagarden.ModelClasses;

public class ShopNowProducts {
    private String tvName, tvPrice;
    private int ivImage;

    public ShopNowProducts(String tvName, String tvPrice, int ivImage) {
        this.tvName = tvName;
        this.tvPrice = tvPrice;
        this.ivImage = ivImage;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public String getTvPrice() {
        return tvPrice;
    }

    public void setTvPrice(String tvPrice) {
        this.tvPrice = tvPrice;
    }

    public int getIvImage() {
        return ivImage;
    }

    public void setIvImage(int ivImage) {
        this.ivImage = ivImage;
    }
}
