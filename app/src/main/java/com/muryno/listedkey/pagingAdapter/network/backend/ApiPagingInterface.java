package com.muryno.listedkey.pagingAdapter.network.backend;



import com.muryno.listedkey.ApiCallFolder.getAllListing;

import io.reactivex.Single;


import retrofit2.http.GET;

import retrofit2.http.Query;

/**
 * Created by muraino harbeola on 8/30/2018.
 */

public interface ApiPagingInterface {

    @GET("property")
    Single<getAllListing> getAllListin(@Query("auth_id") String auth_id, @Query("fetch") String fetch, @Query("type") String type, @Query("offset") int offset, @Query("limit") int perLimit);



}
