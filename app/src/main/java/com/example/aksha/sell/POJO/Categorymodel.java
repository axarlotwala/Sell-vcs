package com.example.aksha.sell.POJO;

import com.google.gson.annotations.SerializedName;

public class Categorymodel {

    @SerializedName("cat_name")
    private String category_name;


    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
