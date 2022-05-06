package com.example.room_test003;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        MyAdapter myAdapter;
        MyData nowSelectedData;
        RecyclerView recyclerView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Stetho.initializeWithDefaults(this);    //Facebook開發的調適工具Stetho

            myAdapter = new MyAdapter(this);

            Button btCreate = findViewById(R.id.create_text);
            Button btClear = findViewById(R.id.clear_text);
            Button btModify = findViewById(R.id.modify_text);
            Button btRefresh = findViewById(R.id.refrash_text);
            EditText editName = findViewById(R.id.editname);
            EditText editAge = findViewById(R.id.editage);
            EditText editHobby = findViewById(R.id.edithobby);
            EditText editEmail = findViewById(R.id.editemail);
            recyclerView = findViewById(R.id.recyclerviewinfo);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));//設置分隔線


            //先檢查順序Adapter、有沒有放錯，有沒有拿到。

            setRecyclerFunction(recyclerView);//設置RecyclerView左滑刪除
            //設定更改資料的事件
            btModify.setOnClickListener((view) ->{
                new Thread(() -> {
                    if (nowSelectedData ==null) return;
                    String name = editName.getText().toString();
                    String Age = editAge.getText().toString();
                    String Hobby = editHobby.getText().toString();
                    String Email = editEmail.getText().toString();
                    MyData data = new MyData(nowSelectedData.getId(),name,Age,Hobby,Email);
                    DataBase.getInstance(this).getDataUao().updateData(data);
                    runOnUiThread(()->{
                        editName.setText("");
                        editAge.setText("");
                        editEmail.setText("");
                        editHobby.setText("");
                        nowSelectedData = null;
                        myAdapter.refreshView();
                        Toast.makeText(this,"已更新資訊!",Toast.LENGTH_LONG).show();
                    });
                }).start();
            });

            //清空資料事件按鈕
            btClear.setOnClickListener((view -> {
                editName.setText("");
                editAge.setText("");
                editHobby.setText("");
                editEmail.setText("");
                nowSelectedData = null;
            }));

            //========================================//
            /**新增資料**/
            //問題:無法更新RecyclerView
            btCreate.setOnClickListener((view -> {
                new Thread(() -> {
                    String name = editName.getText().toString();
                    String Age = editAge.getText().toString();
                    String Hobby = editHobby.getText().toString();
                    String Email = editEmail.getText().toString();
                    if (name.length() == 0) return;
                    MyData data = new MyData(name,Age,Hobby,Email);
                    DataBase.getInstance(this).getDataUao().insertData(data);
                    runOnUiThread(()->{
                        myAdapter.refreshView();
                        editName.setText("");
                        editAge.setText("");
                        editHobby.setText("");
                        editEmail.setText("");
                        refrashed();
                    });
                }).start();
            }));
            btRefresh.setOnClickListener(View -> {
                refrashed();
            });

        }
}