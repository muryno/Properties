package com.muryno.listedkey.Database.userDetails;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.muryno.listedkey.Database.AppDataBase;


public class AddDeletUserViewModel extends AndroidViewModel {

    private AppDataBase appDataBase;
    public AddDeletUserViewModel(@NonNull Application application) {
        super(application);

        appDataBase=AppDataBase.getDataBase(this.getApplication());

    }

    /** add user**/
    public void addUser(final User user){
        new addAsyncTask(appDataBase).execute(user);
    }

    private static class addAsyncTask extends AsyncTask<User,Void,Void> {

        addAsyncTask(AppDataBase appDataBase){db=appDataBase;}

        private AppDataBase db;
        @Override
        protected Void doInBackground(final User... users) {
            db.userDao().addUser(users[0]);
            return null;
        }
    }


    /** Delete user**/
    public void deletUser(final User user){
        new deletAsyncTask(appDataBase).execute(user);
    }

    private static class deletAsyncTask extends AsyncTask<User,Void,Void> {

        deletAsyncTask(AppDataBase appDataBase){db=appDataBase;}

        private AppDataBase db;
        @Override
        protected Void doInBackground(final User... users) {
            db.userDao().deleteUser(users[0]);
            return null;
        }
    }
}
