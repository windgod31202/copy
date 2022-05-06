package com.example.rxjava_test001;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //建立被觀察者
        io.reactivex.Observable observable = Observable.create((ObservableOnSubscribe<String>) e -> {   //ObservableEmitter為信號發送器，此發送String型態資料，也可發送別的

            //向觀察者(Observer)發送信號
            e.onNext("This");
            e.onNext("is");
            e.onNext("a");
            e.onComplete();
            e.onNext("Observable"); //已onComplete，不會發送此行信號
        });
        //建立觀察者
        Observer<String> observer = new Observer<String>() {    //傳入String型態資料
            //Disposable可用以解除訂閱(d.dispose())、或查詢是否解除訂閱(d.isDisposed())
            @Override
            public void onSubscribe(Disposable d) {

            }

            //改為String型態
            @Override
            public void onNext(String value) {
                Log.e("observer","onNext:"+value);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("observer","onError"+e);
            }

            @Override
            public void onComplete() {
                Log.e("observer","onComplete!");
            }
        };
        //產生訂閱(subscribe)以結合，Observable->Observer
        observable.subscribe(observer);

    }
}