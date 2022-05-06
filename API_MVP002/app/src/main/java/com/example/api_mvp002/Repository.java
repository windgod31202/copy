package com.example.api_mvp002;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository implements Contract.Model,FakeAPIService {

    private  Contract.Presenter presenter;
    public Repository(Contract.Presenter presenter){
        this.presenter = presenter;
    }
    
    // baseUrl: 定義 API 網域網址，即是我們剛剛拆出來的前綴共用的部分
    // ddConverterFactory: 定義要將資料轉成什麼格式
    public Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static Repository instance;

    private FakeAPIService.getFakeApi fakeAPIService = retrofit.create(FakeAPIService.getFakeApi.class);

    @Override
    public void getUserInfo(int id, Callback callback) {
        Log.e("www", "getUserInfo");
        fakeAPIService.getPost(id).enqueue(new retrofit2.Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post post = response.body();
                if(post == null) {
                    Log.e("www", "{}{}{}{}{}{}{}");
                    //presenter.onErrorInfo(); 不存在此id
                }else{
                    Log.e("www", String.valueOf(post.getId()));
                    callback.onUserInfo(post);
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e("www", "fail");
            }
        });

    }

//    public static Repository getInstance() {
//        if (instance == null) {
//            instance = new Repository();
//        }
//        return instance;
//    }


    public getFakeApi fakeapi() {
        return fakeAPIService;
    }


    public void getUserInfo() {
    }
}
