package com.example.part_b;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface{
    @GET
    Call<List<ImagesResponse>> getAllImages();
}
