package com.ustc.quincy.scos.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.ustc.quincy.scos.R;

/**
 * Author: Created by QuincyHu on 2016/5/25 0025 13:43.
 * Email:  zhihuqunxing@163.com
 */
public class ToolbarActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("title");
        toolbar.setSubtitle("subTitle");
        //toolbar.setNavigationIcon(R.drawable.ic_action_setting);

        //设置右上角的填充菜单
        toolbar.inflateMenu(R.menu.toolbar_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.action_search:
                        Toast.makeText(ToolbarActivity.this, "search clicked", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.action_notification:
                        Toast.makeText(ToolbarActivity.this, "notify clicked", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.action_item1:
                        Toast.makeText(ToolbarActivity.this, "action item1 clicked", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.action_item2:
                        Toast.makeText(ToolbarActivity.this, "action item2 clicked", Toast.LENGTH_LONG).show();
                        break;
                }
                return true;
            }
        });
    }
}
