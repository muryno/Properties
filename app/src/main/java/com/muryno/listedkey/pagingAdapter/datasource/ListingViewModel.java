package com.muryno.listedkey.pagingAdapter.datasource;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;


import com.muryno.listedkey.model.MainLst;
import com.muryno.listedkey.pagingAdapter.NetworkState;

import javax.inject.Inject;

public class ListingViewModel extends ViewModel {
    private final ListingDataSourceFactory showsDataSourceFactory;
    private LiveData<PagedList<MainLst>> shows;

    @Inject
    public ListingViewModel(ListingDataSourceFactory showsDataSourceFactory) {
        this.showsDataSourceFactory = showsDataSourceFactory;
        onScreenCreated();
    }

    public void onScreenCreated() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setPageSize(4)
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .build();
        shows = new LivePagedListBuilder<>(showsDataSourceFactory, config).build();
    }

    public LiveData<PagedList<MainLst>> getShows() {
        return shows;
    }

    public LiveData<NetworkState> initialLoadState() {

        return showsDataSourceFactory.getShowsDataSource().getInitialLoadStateLiveData();
    }

    public LiveData<NetworkState> paginatedLoadState() {
        return showsDataSourceFactory.getShowsDataSource().getPaginatedNetworkStateLiveData();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        showsDataSourceFactory.getShowsDataSource().clear();
    }

    public void retry() {
        showsDataSourceFactory.getShowsDataSource().retryPagination();
    }
}
