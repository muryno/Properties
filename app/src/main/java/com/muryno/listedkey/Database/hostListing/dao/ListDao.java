package com.muryno.listedkey.Database.hostListing.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import android.arch.persistence.room.Update;

import com.muryno.listedkey.Database.hostListing.datamodel.Listed;

import java.util.List;

/**
 * Created by muraino harbeola on 9/17/2018.
 */

@Dao
public interface ListDao {
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveAll(List<Listed> posts);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(Listed listed);

    @Update
    void update(Listed listed);

    @Delete
    void delete(Listed listed);

    @Query("SELECT * FROM Listed")
    LiveData<List<Listed>> findAll();

    @Query("SELECT * FROM Listed where listId=:id")
    Listed getListById(int id);
}
