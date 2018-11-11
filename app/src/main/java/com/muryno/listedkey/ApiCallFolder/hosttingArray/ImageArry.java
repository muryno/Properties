package com.muryno.listedkey.ApiCallFolder.hosttingArray;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by muraino harbeola on 10/16/2018.
 */

public class ImageArry {
    @SerializedName("id")
    @Expose
    private String id;



    @SerializedName("url")
    @Expose
    private String imaguri;


    public String getImaguri() {
        return imaguri;
    }

}
