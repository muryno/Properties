package com.muryno.listedkey.model;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.muryno.listedkey.ApiCallFolder.Errorr;
import com.muryno.listedkey.ApiCallFolder.hosttingArray.ImageArry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by muraino harbeola on 10/12/2018.
 */

public class MainLst {



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("title")
    @Expose
    private String property_typ;

    @SerializedName("bed_number")
    @Expose
    private int bdNumbr;

    @SerializedName("rating")
    @Expose
    private int rating;

    @SerializedName("country_name")
    @Expose
    private String country;

    @SerializedName("property_type")
    @Expose
    private String property_nam;

    @SerializedName("images")
    @Expose
    private ArrayList<ImageArry> images;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getProperty_nam() {
        return property_nam;
    }

    public void setProperty_nam(String property_nam) {
        this.property_nam = property_nam;
    }


    public ArrayList <ImageArry> getImages() {
        return images;
    }

    public void setImages(ArrayList <ImageArry> images) {
        this.images = images;
    }



    public int getBdNumbr() {
        return bdNumbr;
    }

    public void setBdNumbr(int bdNumbr) {
        this.bdNumbr = bdNumbr;
    }


    public String getProperty_typ() {
        return property_typ;
    }

    public void setProperty_typ(String property_typ) {
        this.property_typ = property_typ;
    }





    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public static DiffUtil.ItemCallback<MainLst> DIFF_CALLBACK = new DiffUtil.ItemCallback<MainLst>() {
        @Override
        public boolean areItemsTheSame(@NonNull MainLst oldItem, @NonNull MainLst newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull MainLst oldItem, @NonNull MainLst newItem) {
            return oldItem.equals(newItem);
        }
    };


    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        MainLst listing = (MainLst) obj;
        return listing.id == this.id;
    }
}
