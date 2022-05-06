package com.example.room_test003;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public class Dao {
    String tableName = "MyTable01";
    /**=======================================================================================*/
    /**
     * 簡易新增所有資料的方法
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
//預設萬一執行出錯，REPLACE為覆蓋
    void insertData(Entity entity) {

    }

    /**複雜(?)新增所有資料的方法*/
    @Query("INSERT INTO "+tableName+"(name,Age,Hobby,Email) VALUES(:name,:Age,:Hobby,:Email)")
    void insertData(String name,String Age,String Hobby,String Email);

    /**=======================================================================================*/
    /**撈取全部資料*/
    @Query("SELECT * FROM " + tableName)
    List<Entity> displayAll();

    /**撈取某個名字的相關資料*/
    @Query("SELECT * FROM " + tableName +" WHERE name = :name")
    List<Entity> findDataByName(String name);

    /**=======================================================================================*/
    /**
     * 簡易更新資料的方法
     */
    @Update
    void updateData(Entity entity) {

    }

    /**複雜(?)更新資料的方法*/
    @Query("UPDATE "+tableName+" SET name = :name,Age=:Age,Hobby=:Hobby,Email = :Email WHERE id = :id" )
    void updateData(int id,String name,String Age,String Hobby,String Email);

    /**=======================================================================================*/
    /**
     * 簡單刪除資料的方法
     */
    @Delete
    void deleteData(Entity entity) {

    }

    /**複雜(?)刪除資料的方法*/
    @Query("DELETE  FROM " + tableName + " WHERE id = :id")
    void deleteData(int id);


}
