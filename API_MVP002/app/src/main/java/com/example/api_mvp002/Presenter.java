package com.example.api_mvp002;

//負責邏輯判斷傳遞訊息

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter implements Contract.Presenter {

    private Contract.View view;

    public Presenter(Contract.View view){
        this.view = view;
    }

    private Repository model = new Repository(this);

    private FakeAPIService fakeAPIService;

    @Override
    public void getUser(int id) {
        // 判斷id是否在範圍內
        // view.errorInfo();

        model.getUserInfo(id, new Contract.Model.Callback() {
            @Override
            public void onUserInfo(Post post) {
                view.showUserInfo(post);
            }
        });
    }
}
