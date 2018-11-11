package com.muryno.listedkey.pagingAdapter.network;


import android.content.Context;

import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;
import com.muryno.listedkey.pagingAdapter.network.backend.ListingBackendModule;

import java.io.File;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


@Module(includes = ListingBackendModule.class)
public class NetworkModule {
    private static final int TIMEOUT_IN_MS = 30000;
    public static final String LISTING_BASE_URL = "listed_base_url";
    private static final String BASE_URL = "https://Listedkeys.com/api/";

    @Provides
    @Named(LISTING_BASE_URL)
    String provideBaseUrlString() {
        return BASE_URL;
    }

    @Provides
    @Singleton
    CookieManager provideCookieManager() {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cookieManager);
        return cookieManager;
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(CookieJar cookieJar, HttpLoggingInterceptor loggingInterceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(TIMEOUT_IN_MS, TimeUnit.MILLISECONDS)
                .cookieJar(cookieJar)
                .cache(cache)
                .build();
    }

    @Provides
    @Singleton
    Gson provideGson(TypeAdapterFactory tvMazeTypeAdaptorFactory) {
        return new GsonBuilder()
                .registerTypeAdapterFactory(tvMazeTypeAdaptorFactory)
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    @Provides
    @Singleton
    CookieJar provideCookieJar(Context context) {
        return new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));
    }

    @Provides
    @Singleton
    Cache provideCache(Context context) {
        final int cacheSize = 5 * 1024 * 1024; // 5 MB
        File cacheDir = context.getCacheDir();
        return new Cache(cacheDir, cacheSize);
    }

    @Provides
    @Singleton
    RxJava2CallAdapterFactory provideRxJavaCallAdapterFactory() {
        return RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io());
    }

    @Provides
    @Singleton
    TypeAdapterFactory provideTypeAdapterFactory() {
        return ListingTypeAdaptorFactory.create();
    }
}
