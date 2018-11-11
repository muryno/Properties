package com.muryno.listedkey.search.customdialogs.services;

import com.muryno.listedkey.search.customdialogs.models.UserModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface UsersService {
	@POST("api/users")
    Call<ArrayList<UserModel>> getFakeUsersBasedOnASearchTag(@Body String tag);
}
