package com.example.api_in_mvp;


import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter implements Contract.presenter, Contract.Model{



    public  void callmode1(){
        Contract.presenter.Call<Post> call =  Repository.getInstance().getFakeApi().getPost();

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(retrofit2.Call<Post> call, Response<Post> response) {

            }

            @Override
            public void onFailure(retrofit2.Call<Post> call, Throwable t) {

            }


        });
    }
//    Contract.presenter.Call<Post> call =fakeAPIService.getPost();

}
