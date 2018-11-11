package com.muryno.listedkey.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.muryno.listedkey.Database.hostListing.dao.ListDao;
import com.muryno.listedkey.Database.hostListing.datamodel.Converters;
import com.muryno.listedkey.Database.hostListing.datamodel.Listed;
import com.muryno.listedkey.Database.userDetails.User;
import com.muryno.listedkey.Database.userDetails.userdao;


/**
 * Created by muraino harbeola on 9/17/2018.
 */

@Database(entities = {Listed.class,User.class},version = 2,exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase INSTANCE;

    public static AppDataBase getDataBase(Context context){
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class,"listedkeys_db")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;

    }
    public abstract userdao userDao();

    public abstract ListDao listDao();
}
