package com.example.aksha.sell.POJO;

import com.google.gson.annotations.SerializedName;

public class ImageBanner {

        @SerializedName("image_name")
        private String image_name;

        @SerializedName("image_url")
        private String image_url;

    public ImageBanner(String image_name, String image_url) {
        this.image_name = image_name;
        this.image_url = image_url;
    }

    public String getImage_name() {
        return image_name;
    }

    public String getImage_url() {
        return image_url;
    }


}
