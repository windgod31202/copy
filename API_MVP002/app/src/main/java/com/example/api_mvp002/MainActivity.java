package com.example.api_mvp002;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/**只需要顯示畫面資訊**/
public class MainActivity extends AppCompatActivity implements Contract.View {

    private Contract.View view;
    private Presenter presenter = new Presenter(this);
    private Button button;
    private TextView userid;
    private TextView id;
    private TextView title;
    private TextView body;


    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //定義輸出資料的地方
        userid = (TextView)findViewById(R.id.useridinfo);
        id = (TextView)findViewById(R.id.idnumberinfo);
        title = (TextView)findViewById(R.id.titleinfo);
        body = (TextView)findViewById(R.id.bodyinfo);

        EditText index = (EditText)findViewById(R.id.inputnumber);

        //輸入數字的值在按下Button後傳到Presenter判斷該抓哪一個id
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //輸入數字指定id
                //將輸入的數值轉成字串型態再轉成整數型態
                //
                presenter.getUser(Integer.valueOf(String.valueOf(index.getText())));
            }
        });
    }

    @Override
    public void showUserInfo(Post post) {
        Log.e("www", "showUserInfo");
        // 顯示使用者資訊
        userid.setText(String.valueOf(post.getUserId()));
        id.setText(String.valueOf(post.getId()));
        title.setText(post.getTitle());
        body.setText(post.getBody());
    }
}