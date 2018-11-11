package com.muryno.listedkey.Database.userDetails;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.muryno.listedkey.Database.AppDataBase;

/**
 * Created by muraino harbeola on 10/12/2018.
 */

public class getUserViewModel extends AndroidViewModel {
    private AppDataBase dataBase;
    private User userLiveData;

    public getUserViewModel(@NonNull Application application) {
        super(application);
        dataBase=AppDataBase.getDataBase(this.getApplication());
        userLiveData=dataBase.userDao().getUserById("1");

    }
    //liveData
    public User getUserLiveData() {
        return userLiveData;
    }
}
