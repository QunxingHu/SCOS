package com.ustc.quincy.scos.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.ustc.quincy.scos.model.FoodItem;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Describe: 封装常用的数据库操作
 * Author: Created by QuincyHu on 2016/5/23 0023 13:27.
 * Email:  zhihuqunxing@163.com
 */

public class SCOSDB {

    public static final String TAG = "SCOSDB";
    public static final String DB_NAME = "SCOS_DB";  //数据库名
    public static final int DB_VERSION = 1;         //数据库版本号
    private static SCOSDB scos_db;                  //数据库实例
    private SQLiteDatabase db;

    //构造方法私有化
    private SCOSDB(Context context){
        SCOSDBOpenHelper dbHelper = new SCOSDBOpenHelper(context, DB_NAME, null, DB_VERSION);
        db = dbHelper.getWritableDatabase();
    }

    //获取SCOSDB实例
    public synchronized static SCOSDB getInstance(Context context){
        if (scos_db == null) {
            scos_db = new SCOSDB(context);
        }
        return scos_db;
    }

    /**
     * 将菜品实例存储到数据库
     * @param foodItem
     * "foodItem_id int"
     * "foodItem_name text,"
     * "foodItem_describe text,"
     * "foodItem_taste text,"
     * "foodItem_category text,"
     * "foodItem_material text,"
     * "foodItem_price double,"
     * "foodItem_count integer,"
     * "foodItem_image BLOB";
     * table Name: FoodItem
     */
    public void saveFoodItem(FoodItem foodItem){
        if (foodItem != null) {
            ContentValues values = new ContentValues();
            values.put("foodItem_id", foodItem.getId());
            values.put("foodItem_name",foodItem.getName());
            values.put("foodItem_describe", foodItem.getDescribe());
            values.put("foodItem_taste",foodItem.getTaste());
            values.put("foodItem_category", foodItem.getCategory());
            values.put("foodItem_material", foodItem.getMaterial());
            values.put("foodItem_price", foodItem.getPrice());
            values.put("foodItem_count", foodItem.getCount());

            //存储图片
            final ByteArrayOutputStream out = new ByteArrayOutputStream();
            foodItem.getImage().compress(Bitmap.CompressFormat.PNG, 100, out);
            values.put("foodItem_image", out.toByteArray());

            db.insert("FoodItem",null,values);
        } else
            Log.d(TAG, "saveFoodItem() called with: " + "foodItem = [" + "null" + "]");
    }

    /**
     * 从数据库读取所有菜品信息
     * @return 返回菜品列表
     */
    public List<FoodItem> loadFoodItems(){
        List<FoodItem> foodItemList = new ArrayList<>();
        Cursor cursor = db.query("FoodItem",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                FoodItem foodItem = new FoodItem();
                foodItem.setId(cursor.getInt(cursor.getColumnIndex("foodItem_id")));
                foodItem.setName(cursor.getString(cursor.getColumnIndex("foodItem_name")));
                foodItem.setCategory(cursor.getString(cursor.getColumnIndex("foodItem_category")));
                foodItem.setCount(cursor.getInt(cursor.getColumnIndex("foodItem_count")));
                foodItem.setDescribe(cursor.getString(cursor.getColumnIndex("foodItem_describe")));
                foodItem.setMaterial(cursor.getString(cursor.getColumnIndex("foodItem_material")));
                foodItem.setTaste(cursor.getString(cursor.getColumnIndex("foodItem_taste")));
                foodItem.setPrice(cursor.getDouble(cursor.getColumnIndex("foodItem_price")));

                //将图片取出
                byte[] in = cursor.getBlob(cursor.getColumnIndex("foodItem_image"));
                foodItem.setImage(BitmapFactory.decodeByteArray(in,0,in.length));

                foodItemList.add(foodItem);

            } while(cursor.moveToNext());
            if (cursor != null)
                cursor.close();
        }
        return foodItemList;
    }
}
