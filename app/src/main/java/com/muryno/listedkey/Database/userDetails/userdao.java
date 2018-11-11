package com.muryno.listedkey.Database.userDetails;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by muraino harbeola on 10/12/2018.
 */
@Dao
public interface userdao {
    @Insert(onConflict = REPLACE)
    void addUser(User user);

    @Query("SELECT * FROM user where itemId=:itemId")
    User getUserById(String itemId);

    @Delete
    void deleteUser(User order);


    @Query("UPDATE User SET status=:status WHERE itemId = :itemId")
    void updateStatus(String status, String itemId);

    @Query("UPDATE User SET property_id=:property_id WHERE itemId = :itemId")
    void updateProptyid(String property_id, String itemId);

    @Query("UPDATE User SET phone_numbr=:phone_numbr WHERE itemId = :itemId")
    void updateNumber(String phone_numbr, String itemId);

    @Query("UPDATE User SET fname=:fname , lname=:lname, fullNam=:fullNam, imageUrl=:imageUrl ,userEmail=:userEmail AND status=:status WHERE itemId = :itemId")
    void editProfile(String fname, String lname, String fullNam, String imageUrl ,String userEmail ,String status, String itemId);
}
