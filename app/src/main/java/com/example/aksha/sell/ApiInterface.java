package com.example.aksha.sell;

import com.example.aksha.sell.POJO.Categorymodel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("category.php")
   Call<List<Categorymodel>> categoryview();


}
