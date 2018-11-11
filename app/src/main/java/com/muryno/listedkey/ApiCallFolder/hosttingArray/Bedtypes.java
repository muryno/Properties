package com.muryno.listedkey.ApiCallFolder.hosttingArray;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bedtypes {

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
