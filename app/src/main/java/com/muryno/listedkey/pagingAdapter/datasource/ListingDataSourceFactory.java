package com.muryno.listedkey.pagingAdapter.datasource;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;

import com.muryno.listedkey.model.MainLst;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ListingDataSourceFactory extends DataSource.Factory<Integer, MainLst> {
    private final ListingDataSource showsDataSource;
    private MutableLiveData<ListingDataSource> showsDataSourceLiveData;

    @Inject
    public ListingDataSourceFactory(ListingDataSource showsDataSource) {
        this.showsDataSource = showsDataSource;
        showsDataSourceLiveData = new MutableLiveData<>();
    }

    @Override
    public DataSource<Integer, MainLst> create() {
        showsDataSourceLiveData.postValue(showsDataSource);
        return showsDataSource;
    }

    public ListingDataSource getShowsDataSource() {
        return showsDataSource;
    }
}
