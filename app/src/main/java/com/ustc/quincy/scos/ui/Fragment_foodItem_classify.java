package com.ustc.quincy.scos.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ustc.quincy.scos.R;

/**
 * Author: Created by QuincyHu on 2016/5/25 0025 19:26.
 * Email:  zhihuqunxing@163.com
 */
public class Fragment_foodItem_classify extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fooditem_classify, container, false);
        return view;
    }
}
