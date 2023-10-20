package com.example.part_b;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIs {
    String BASE_URL="https://fakestoreapi.com/";
    @GET("products")
    Call<List<ImageResult>> getImages();

}
