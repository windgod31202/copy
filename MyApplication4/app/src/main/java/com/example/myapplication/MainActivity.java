package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    EditText h;                //宣告全域變數
    EditText w;                //宣告全域變數
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        h = (EditText)findViewById(R.id.et1);                           // 取得身高物件
        w = (EditText)findViewById(R.id.et2);                           // 取得體重物件
        Button submit = (Button)findViewById(R.id.sentbutton);             // 取得按鈕物件 如果ID有誤請回到res->Layout查看預設Button是多少
        Button jumpbutton = (Button)findViewById(R.id.jumpbutton);
        Intent intent;
        jumpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,BMI_test02.class);
                Bundle bundle = new Bundle();   //實例化一個Bundle物件
                bundle.putString("height",h.getText().toString());
                bundle.putString("width",w.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
        // 按下按鈕 觸發事件
        submit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                //判斷條件 身高 跟 體重 都有輸入值才執行
                if ( !("".equals(h.getText().toString())
                        || "".equals(w.getText().toString())) )
                {
                    float fh = Float.parseFloat(h.getEditableText().toString());      // 取得 身高輸入值
                    float fw = Float.parseFloat(w.getEditableText().toString());     // 取得 體重輸入值
                    float fresult;                                     // BMI值 計算結果
                    TextView result = (TextView)findViewById(R.id.tv3);// 取得 顯示結果 物件
                    fh = fh/100; // 計算BMI
                    fh = fh*fh;  // 計算BMI

                    NumberFormat nf = NumberFormat.getInstance();   // 數字格式
                    nf.setMaximumFractionDigits(2);                 // 限制小數第二位
                    fresult = fw/fh;                                // 計算BMI
                    result.setText(nf.format(fw/fh) +"");           // 顯示BMI計算結果
                    TextView dia = (TextView)findViewById(R.id.tv4);// 取得 顯示診斷 物件

                    // 診斷結果 顯示
                    if (fresult<18.5)
                        dia.setText("體重過輕");
                    else if (18.5 <= fresult && fresult< 24)
                        dia.setText("正常範圍");
                    else if (24 <=fresult && fresult < 27)
                        dia.setText("過   重");
                    else if (27 <=fresult && fresult < 30)
                        dia.setText("輕度肥胖");
                    else if (30 <= fresult && fresult < 35)
                        dia.setText("中度肥胖");
                    else if (fresult >= 35)
                        dia.setText("重度肥胖");
                }
            }
        });
    }
}