package com.muryno.listedkey.ApiCallFolder.hosttingArray;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by muraino harbeola on 10/18/2018.
 */

 public class ListImages {


    @SerializedName("thumbnail_url")
    @Expose

    private String imagUri;

    public String getImagUri() {
        return imagUri;
    }

    public void setImagUri(String imagUri) {
        this.imagUri = imagUri;
    }
}
