package com.example.part_b;

import com.google.gson.annotations.SerializedName;

public class ImageResult {
    @SerializedName("id")
    int id;
    @SerializedName("title")
    String title;
    @SerializedName("image")
    String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTags(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String imageURL) {
        this.image = imageURL;
    }
}
