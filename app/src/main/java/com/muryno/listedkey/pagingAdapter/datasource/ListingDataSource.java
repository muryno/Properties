package com.muryno.listedkey.pagingAdapter.datasource;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.ItemKeyedDataSource;
import android.support.annotation.NonNull;
import android.util.Log;



import com.muryno.listedkey.model.MainLst;
import com.muryno.listedkey.pagingAdapter.NetworkState;
import com.muryno.listedkey.pagingAdapter.network.backend.ApiPagingInterface;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class ListingDataSource extends ItemKeyedDataSource<Integer, MainLst> {
    private static final String TAG = "ShowsDataSource";
    private final ApiPagingInterface apiPagingInterface;
    private CompositeDisposable compositeDisposable;
    private int pageNumber = 1;
    private MutableLiveData<NetworkState> paginatedNetworkStateLiveData;
    private MutableLiveData<NetworkState> initialLoadStateLiveData;
    // For Retry
    private LoadParams<Integer> params;
    private LoadCallback<MainLst> callback;
    private Single<List<MainLst>> favoriteShows;

    @Inject
    public ListingDataSource(ApiPagingInterface apiPagingInterface) {
        this.apiPagingInterface = apiPagingInterface;
        compositeDisposable = new CompositeDisposable();
        initialLoadStateLiveData = new MutableLiveData<>();
        paginatedNetworkStateLiveData = new MutableLiveData<>();
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params,
                            @NonNull LoadInitialCallback<MainLst> callback) {
        Log.d(TAG, "Fetching first page: " + pageNumber);
        initialLoadStateLiveData.postValue(NetworkState.builder()
                .status(NetworkState.Status.LOADING).build());
        Disposable showsDisposable = apiPagingInterface.getAllListin("90479b0468b2eaeb0afc867ad754318a","properties","display",
                pageNumber,params.requestedLoadSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(shows -> onShowsFetched(shows.getAllListings(), callback), this::onError);
        compositeDisposable.add(showsDisposable);
    }

    private void onError(Throwable throwable) {
        initialLoadStateLiveData.postValue(NetworkState.builder()
                .status(NetworkState.Status.ERROR)
                .message(throwable.getMessage()).build());
        Log.e(TAG, throwable.getMessage());
    }

    private void onShowsFetched(List<MainLst> shows, LoadInitialCallback<MainLst> callback) {
        initialLoadStateLiveData.postValue(NetworkState.builder()
                .status(NetworkState.Status.SUCCESS).build());
        pageNumber++;
        callback.onResult(shows);
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params,
                          @NonNull LoadCallback<MainLst> callback) {

        this.params = params;
        this.callback = callback;
        Log.d(TAG, "Fetching next page: " + pageNumber);
        paginatedNetworkStateLiveData.postValue(NetworkState.builder()
                .status(NetworkState.Status.LOADING).build());
        Disposable showsDisposable =  apiPagingInterface.getAllListin("90479b0468b2eaeb0afc867ad754318a","properties","display",
                params.key, params.requestedLoadSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(shows -> onMoreShowsFetched(shows.getAllListings(), callback), this::onPaginationError);
        compositeDisposable.add(showsDisposable);
    }

    private void onMoreShowsFetched(List<MainLst> shows, LoadCallback<MainLst> callback) {
        paginatedNetworkStateLiveData.postValue(NetworkState.builder()
                .status(NetworkState.Status.SUCCESS).build());
        pageNumber++;
        if(shows == null){

            paginatedNetworkStateLiveData.postValue(NetworkState.builder()
                    .status(NetworkState.Status.ERROR)
                    .message("No more Listing").build());
        }else{
            callback.onResult(shows);
        }

    }

    private void onPaginationError(Throwable throwable) {
        paginatedNetworkStateLiveData.postValue(NetworkState.builder()
                .status(NetworkState.Status.ERROR)
                .message(throwable.getMessage()).build());
        Log.e(TAG, throwable.getMessage());
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params,
                           @NonNull LoadCallback<MainLst> callback) {
        // Do nothing, since data is loaded from our initial load itself
    }

    @NonNull
    @Override
    public Integer getKey(@NonNull MainLst item) {
        return pageNumber;
    }

    public void clear() {
        compositeDisposable.clear();
        pageNumber = 1;
    }

    public LiveData<NetworkState> getPaginatedNetworkStateLiveData() {
        return paginatedNetworkStateLiveData;
    }

    public LiveData<NetworkState> getInitialLoadStateLiveData() {
        return initialLoadStateLiveData;
    }

    public void retryPagination() {
        loadAfter(params, callback);
    }
}
