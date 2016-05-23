package com.ustc.quincy.scos.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;

import com.ustc.quincy.scos.R;


/**
 * Author: Created by QuincyHu on 2016/5/23 0023 14:59.
 * Email:  zhihuqunxing@163.com
 */
public class ShowFoodItemDetail extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fooditem_detail);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        View v = findViewById(R.id.main_content);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_fooditem_in_detail);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"添加成功！", Snackbar.LENGTH_SHORT).show();
            }
        });


    }

}
