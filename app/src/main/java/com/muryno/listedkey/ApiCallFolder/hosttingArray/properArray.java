package com.muryno.listedkey.ApiCallFolder.hosttingArray;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by muraino harbeola on 9/24/2018.
 */

public class properArray {
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    @SerializedName("name")
    @Expose
    private String name;


    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("number")
    @Expose
    private String number;

    @SerializedName("title")
    @Expose
    private String title;

    public String getTitle() {
        return title;
    }
}
