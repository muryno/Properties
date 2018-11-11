package com.muryno.listedkey.settings;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.muryno.listedkey.model.preferencesDtails;

/**
 * Created by muraino harbeola on 7/23/2018.
 */

public class SharePreManager {

    //Check if the preferencesDtails is logged in

    public static final String LOGGED_IN_SHARED_PREF = "loggedin";
    public static final String USER_NAME = "muraino";


    private static SharePreManager mInstance;
    private Context mContext;

    private SharePreManager(Context ctx){
        mContext=ctx;
    }

    public static synchronized SharePreManager getmInstance(Context mctx){
        if(mInstance==null){
            mInstance=new SharePreManager(mctx);
        }
        return mInstance;
    }


    public  void saveUser(String user){
        SharedPreferences mpref=mContext.getSharedPreferences(USER_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor  editors=mpref.edit();
        preferencesDtails preferencesDtailsLogin = new preferencesDtails();

                editors.putInt("userID", preferencesDtailsLogin.userID);
                editors.putString(USER_NAME,user)
                .apply();
   }

    public boolean isLoggedIn(){
        SharedPreferences islogged=mContext.getSharedPreferences(USER_NAME,Context.MODE_PRIVATE);
        return islogged.getInt("userID",-1)!= -1;}

    public void  clear(){
        SharedPreferences clrpref=mContext.getSharedPreferences(USER_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor  editor=clrpref.edit();
        editor.clear();
        editor.apply();

    }

        public preferencesDtails RetrieveSignin(){
        SharedPreferences mpref=mContext.getSharedPreferences(USER_NAME,Context.MODE_PRIVATE);
            Gson gson = new Gson();
            String jsonText = mpref.getString(USER_NAME, null);
            preferencesDtails text = gson.fromJson(jsonText, preferencesDtails.class);
           return text;

        }
}

