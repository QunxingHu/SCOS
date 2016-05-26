package com.ustc.quincy.scos.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ustc.quincy.scos.R;
import com.ustc.quincy.scos.model.FoodItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Created by QuincyHu on 2016/5/25 0025 19:25.
 * Email:  zhihuqunxing@163.com
 */
public class Fragment_foodItem_list extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView= (RecyclerView) inflater.inflate(R.layout.fooditem_list, container, false);

        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new MyRecycleViewAdapter( getSublist(30), getActivity()));

        return recyclerView;
    }

    //获取数据
    private List<FoodItem> getSublist(int amount) {
        ArrayList<FoodItem> list = new ArrayList<>(amount);
        FoodItem foodItem = new FoodItem();
        foodItem.setName("扬州炒饭");
        foodItem.setPrice(10);
        foodItem.setTaste("不辣");
        while (list.size() < amount) {
            list.add(foodItem);
        }
        return list;
    }

}
