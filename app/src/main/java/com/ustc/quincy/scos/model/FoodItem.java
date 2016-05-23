package com.ustc.quincy.scos.model;

/**
 * Describe: FoodItem 实体类
 * Author: Created by QuincyHu on 2016/5/23 0023 13:18.
 * Email:  zhihuqunxing@163.com
 */

import android.graphics.Bitmap;

/**
 *菜品包含九个属性字段：
 * 菜品ID, 菜品名，菜品描述, 菜品口味，菜品类别，菜品材料，菜品价格，菜品库存，菜品图片
 */
public class FoodItem {
    private int id;
    private String name;
    private String describe;
    private String taste;
    private String category;
    private String material;
    private double price;
    private int count;
    private Bitmap image;

    public void setId(int id) {
        this.id = id;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public Bitmap getImage() {
        return image;
    }

    public int getCount() {
        return count;
    }

    public String getCategory() {
        return category;
    }

    public String getDescribe() {
        return describe;
    }

    public String getMaterial() {
        return material;
    }

    public String getName() {
        return name;
    }

    public String getTaste() {
        return taste;
    }
}
