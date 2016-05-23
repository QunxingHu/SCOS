package com.ustc.quincy.scos.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Describe: Help to create database
 * Author: Created by QuincyHu on 2016/5/23 0023 13:01.
 * Email:  zhihuqunxing@163.com
 */
public class SCOSDBOpenHelper extends SQLiteOpenHelper{

    /*
    * FoodItem 建表语句
    * 包含字段：菜品ID, 菜品名，菜品描述, 菜品口味，菜品类别，菜品材料，菜品价格，菜品库存，菜品图片
     */
    public static final String CREATE_FOODITEM = "create table FoodItem ("
            + "foodItem_id integer primary key autoincrement,"
            + "foodItem_name text,"
            + "foodItem_describe text,"
            + "foodItem_taste text,"
            + "foodItem_category text,"
            + "foodItem_material text,"
            + "foodItem_price double,"
            + "foodItem_count integer,"
            + "foodItem_image BLOB)";

    public SCOSDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建菜品项表
        db.execSQL(CREATE_FOODITEM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
