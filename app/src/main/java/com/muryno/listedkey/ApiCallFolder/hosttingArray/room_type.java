package com.muryno.listedkey.ApiCallFolder.hosttingArray;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by muraino harbeola on 10/18/2018.
 */

public class room_type {

    @SerializedName("name")
    @Expose
    private String name;


    @SerializedName("number")
    @Expose
    private int number;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
