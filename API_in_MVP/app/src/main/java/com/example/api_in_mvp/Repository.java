package com.example.api_in_mvp;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Repository {
    // baseUrl: 定義 API 網域網址，即是我們剛剛拆出來的前綴共用的部分
    // ddConverterFactory: 定義要將資料轉成什麼格式
    public Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static Repository instance;

    private Contract.FakeAPIService fakeAPIService = retrofit.create(Contract.FakeAPIService.class);

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }


    public Contract.FakeAPIService getFakeApi() {
        return fakeAPIService;
    }

    //放在presenter
    //宣告 Call 連線服務
//    Call<Post> call = fakeAPIService.getPost();


//    public interface FakeAPIService {
//        //單獨創立
//        //取得單筆資料()
//        @GET("/posts/4")
//        //annotation 註解宣告方式定義 HTTP 連線獲取資料方法與指定API後網址
//        Call<Post> getPost();
//
//        //取得多筆資料
//        @GET("/posts")
//        Call<List<Post>> getListPosts();
//    }


}
