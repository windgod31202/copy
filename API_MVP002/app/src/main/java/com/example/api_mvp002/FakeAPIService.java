package com.example.api_mvp002;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeAPIService {
    FakeAPIService.getFakeApi fakeapi();


    interface getFakeApi{
        @GET("/posts/{id}")     //用{}表示路徑參數，@Path會將參數傳入該位置。
        Call<Post> getPost(@Path("id") int id);
    };
}
