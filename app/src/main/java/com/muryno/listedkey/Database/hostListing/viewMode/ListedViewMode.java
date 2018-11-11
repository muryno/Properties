package com.muryno.listedkey.Database.hostListing.viewMode;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.muryno.listedkey.Database.AppDataBase;
import com.muryno.listedkey.Database.hostListing.dao.ListDao;
import com.muryno.listedkey.Database.hostListing.datamodel.Listed;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by muraino harbeola on 9/17/2018.
 */

public class ListedViewMode extends AndroidViewModel {

    private ExecutorService executorService;
    private ListDao listDao;

    public ListedViewMode(@NonNull Application application) {
        super(application);
        listDao=AppDataBase.getDataBase(application).listDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public  LiveData<List<Listed>> getAllListedProp() {
        return   listDao.findAll();
    }

    public  Listed getListedPro(int id){
        return listDao.getListById(id);
    }

    public void savePost(Listed listed) {
        executorService.execute(() -> listDao.save(listed));
    }

    public void update(Listed listed){
        executorService.execute(() -> listDao.update(listed));
    }

    public void deletePost(Listed listed) {
        executorService.execute(() -> listDao.delete(listed));
    }


}
