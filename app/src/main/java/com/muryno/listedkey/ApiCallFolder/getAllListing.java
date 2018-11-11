package com.muryno.listedkey.ApiCallFolder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.muryno.listedkey.model.MainLst;

import java.util.List;

/**
 * Created by muraino harbeola on 10/15/2018.
 */

public class getAllListing {
    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("info")
    @Expose
    private String info;

    @SerializedName("code")
    @Expose
    private int code;

    @SerializedName("quota_max")
    @Expose
    public int quota_max;

    public int getQuota_max() {
        return quota_max;
    }

    public void setQuota_max(int quota_max) {
        this.quota_max = quota_max;
    }

    public int getQuota_remaining() {
        return quota_remaining;
    }

    public void setQuota_remaining(int quota_remaining) {
        this.quota_remaining = quota_remaining;
    }

    @SerializedName("quota_remaining")
    @Expose
    public int quota_remaining;
    @SerializedName("property_details")
    @Expose
    private List<MainLst> allListings;

    public boolean isSuccess() {
        return success;
    }



    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List <MainLst> getAllListings() {
        return allListings;
    }

    public void setAllListing(List <MainLst> allListing) {
        this.allListings = allListing;
    }

    public List <Errorr> getError() {
        return error;
    }

    public void setError(List <Errorr> error) {
        this.error = error;
    }

    @SerializedName("error")
    @Expose

    private List<Errorr> error;

}
