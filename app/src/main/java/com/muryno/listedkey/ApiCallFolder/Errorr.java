package com.muryno.listedkey.ApiCallFolder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by muraino harbeola on 9/2/2018.
 */

public class Errorr {
    @SerializedName("code")
    @Expose
    private int code;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("info")
    @Expose
    private String info;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
