package com.example.api_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvUserID = (TextView)findViewById(R.id.userid);

        // baseUrl: 定義 API 網域網址，即是我們剛剛拆出來的前綴共用的部分
// addConverterFactory: 定義要將資料轉成什麼格式
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FakeAPIService fakeAPIService = retrofit.create(FakeAPIService.class);

//宣告 Call 連線服務
        Call<Post> call = fakeAPIService.getPost();

//執行連線服務，透過 Callback 來等待回傳成功或失敗的資料
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                // 連線成功，透過 getter 取得特定欄位資料，並透過Log.Debug顯示
                Post data = response.body();
                Log.e("HKT", "userId: " + response.body().getUserId());
                Log.e("HKT", "id: " + response.body().getId());
                Log.e("HKT", "title: " + response.body().getTitle());
                Log.e("HKT", "body: " + response.body().getBody());
                tvUserID.setText(String.valueOf(data.getUserId()));
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                // 連線失敗，印出錯誤訊息
                Log.e("HKT", "response: " + t.toString());
            }
        });
    }
    public interface FakeAPIService {
        //取得單筆資料()
        @GET("/posts/4") //annotation 註解宣告方式定義 HTTP 連線獲取資料方法與指定API後網址
        Call<Post> getPost();

        //取得多筆資料
        @GET("/posts")
        Call<List<Post>> getListPosts();
    }

}