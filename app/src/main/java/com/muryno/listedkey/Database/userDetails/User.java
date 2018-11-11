package com.muryno.listedkey.Database.userDetails;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by muraino harbeola on 10/12/2018.
 */
@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private long id;

    public String itemId;
    public String fullNam;
    public String fname;
    public String lname;
    public String property_id;
    public String imageUrl;
    public String userEmail;

    public int userId;

    public String auth_id;
    public String status ;
    public String phone_numbr;
    public String session;


    public User(String itemId, String fullNam, String fname, String lname, String property_id, String imageUrl, String userEmail, int userId, String auth_id, String status, String phone_numbr, String session) {
        this.itemId = itemId;
        this.fullNam = fullNam;
        this.fname = fname;
        this.lname = lname;
        this.property_id = property_id;
        this.imageUrl = imageUrl;
        this.userEmail = userEmail;
        this.userId = userId;
        this.auth_id = auth_id;
        this.status = status;
        this.phone_numbr = phone_numbr;
        this.session = session;
    }

    public long getId() {
        return id;
    }

    public String getItemId() {
        return itemId;
    }

    public String getFullNam() {
        return fullNam;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getProperty_id() {
        return property_id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public int getUserId() {
        return userId;
    }

    public String getAuth_id() {
        return auth_id;
    }

    public String getStatus() {
        return status;
    }

    public String getPhone_numbr() {
        return phone_numbr;
    }

    public String getSession() {
        return session;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setFullNam(String fullNam) {
        this.fullNam = fullNam;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setProperty_id(String property_id) {
        this.property_id = property_id;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setAuth_id(String auth_id) {
        this.auth_id = auth_id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPhone_numbr(String phone_numbr) {
        this.phone_numbr = phone_numbr;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
