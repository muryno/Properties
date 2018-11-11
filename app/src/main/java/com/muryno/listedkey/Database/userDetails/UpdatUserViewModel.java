package com.muryno.listedkey.Database.userDetails;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.muryno.listedkey.Database.AppDataBase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by muraino harbeola on 10/12/2018.
 */

public class UpdatUserViewModel extends AndroidViewModel {

    private ExecutorService executorService;
    private userdao listDao;

    public UpdatUserViewModel(@NonNull Application application) {
        super(application);
        listDao= AppDataBase.getDataBase(application).userDao();
        executorService = Executors.newSingleThreadExecutor();
    }
  public void updateStatus(String status,String itemId){
      executorService.execute(() ->listDao.updateStatus(status,itemId));
  }

  public void updateNumber(String numbr,String itemId){
      executorService.execute(() ->listDao.updateNumber(numbr,itemId));
  }

  public void updatePropertyId(String property,String itemId){
      executorService.execute(() ->listDao.updateProptyid(property,itemId));
  }
    public void editProfile(String fname,String lname,String fulname,String image ,String email,String status,String itemId){
        executorService.execute(() ->listDao.editProfile(fname,lname,fulname,image,email,status,itemId));
    }
}
