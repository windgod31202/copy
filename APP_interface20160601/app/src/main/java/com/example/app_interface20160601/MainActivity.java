package com.example.app_interface20160601.;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity<adapter> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.spinner2); //指定要操作的spinner ID
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this,       //對應的Context
                        R.array.CountryName,                        //資料選項內容
                        android.R.layout.simple_spinner_item);      //預設Spinner未展開時的View

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectesListener(spnOnItemSelected);
    }
}