package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class serviceModel {
    @SerializedName("DateCreated")
    private String DateCreated;

    @SerializedName("Id")
    private String Id;

    @SerializedName("Image")
    private String Image;

    @SerializedName("Title")
    private String Title;


    public String getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(String dateCreated) {
        DateCreated = dateCreated;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
