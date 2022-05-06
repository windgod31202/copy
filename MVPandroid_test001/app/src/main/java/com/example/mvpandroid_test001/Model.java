package com.example.mvpandroid_test001;

import android.os.Handler;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Model implements  Contract.Model
{
    // array list of strings from which
    // random strings will be selected
    // to display in the activity
    // 設定假資料陣列作為虛擬的資料庫與Presenter進行互動
    private List<String> arrayList = Arrays.asList(
            "DSA Self Paced: Master the basics of Data Structures and Algorithms to solve complex problems efficiently. ",
            "Placement 100: This course will guide you for placement with theory,lecture videos, weekly assignments " +
                    "contests and doubt assistance.",
            "Amazon SDE Test Series: Test your skill & give the final touch to your preparation before applying for " +
                    "product based against like Amazon, Microsoft, etc.",
            "Complete Interview Preparation: Cover all the important concepts and topics required for the interviews. " +
                    "Get placement ready before the interviews begin",
            "Low Level Design for SDE 1 Interview: Learn Object-oriented Analysis and Design to prepare for " +
                    "SDE 1 Interviews in top companies"
    );

    @Override
    // this method will invoke when
    // user clicks on the button
    // and it will take a delay of
    // 1200 milliseconds to display next course detail
    public void getNextCourse(final Contract.Model.OnFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          listener.onFinished(getRandomString());
                                      }
                                  }, 1200);
    }

                // 亂數隨機選擇List<String>中的字串。
        private String getRandomString() {
            Random random = new Random();
            int index = random.nextInt(arrayList.size());
            return arrayList.get(index);
    }
}
