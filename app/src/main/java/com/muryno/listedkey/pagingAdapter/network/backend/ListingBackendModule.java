package com.muryno.listedkey.pagingAdapter.network.backend;


import com.google.gson.Gson;
import com.muryno.listedkey.pagingAdapter.network.NetworkModule;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ListingBackendModule {

    @Provides
    @Singleton
    public ApiPagingInterface provideTvMazeApi(OkHttpClient okHttpClient,
                                         @Named(NetworkModule.LISTING_BASE_URL) String baseUrl,
                                         RxJava2CallAdapterFactory rxJava2CallAdapterFactory,
                                         Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .client(okHttpClient)
                .build().create(ApiPagingInterface.class);
    }
}
