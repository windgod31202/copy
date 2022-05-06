package com.example.room_test003;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

public class DataBase {
    //抽象類別
    /**
     透過Database類別中的entities陣列來飲用MyData的實體類別
     資料綁定的Getter-Setter,資料庫版本,是否將資料導出至文件
     **/
    @Database(entities = {Entity.class},version = 1,exportSchema = true)

    public abstract class DataBase extends RoomDatabase {

        public static final String DB_NAME = "RecordData.db";   //資料庫名稱
        private static volatile DataBase instance;

        public static synchronized DataBase     getInstance(Context context){
            if(instance == null){
                instance = create(context); //創立新的資料庫
            }
            return instance;
        }

        private static DataBase create(final Context context){
            return Room.databaseBuilder(context,DataBase.class,DB_NAME).build();
        }
        public abstract Dao getDataUao();   //設置對外接口
    }

}
