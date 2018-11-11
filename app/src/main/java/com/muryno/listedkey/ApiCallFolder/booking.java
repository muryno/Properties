package com.muryno.listedkey.ApiCallFolder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class booking {
    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("info")
    @Expose
    private String info;

    @SerializedName("code")
    @Expose
    private int code;

    @SerializedName("status")
    @Expose
    private String status;


    @SerializedName("price")
    @Expose
    private String price;

    @SerializedName("cost")
    @Expose
    private String cost;

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    @SerializedName("nights")
    @Expose

    private int nights;


    @SerializedName("service_fee")
    @Expose
    private String service_fee;

    @SerializedName("cleaning_fee")
    @Expose
    private int cleaning_fee;

    public List <Errorr> getError() {
        return error;
    }

    public void setCleaning_fee(int cleaning_fee) {
        this.cleaning_fee = cleaning_fee;
    }

    public void setError(List <Errorr> error) {
        this.error = error;
    }

    @SerializedName("error")
    @Expose

    private List<Errorr> error;


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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getService_fee() {
        return service_fee;
    }

    public void setService_fee(String service_fee) {
        this.service_fee = service_fee;
    }

    public int getCleaning_fee() {
        return cleaning_fee;
    }


    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @SerializedName("total")
    @Expose

    private String total;

}
