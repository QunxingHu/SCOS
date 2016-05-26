package com.ustc.quincy.scos;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.Toast;

import com.ustc.quincy.scos.activity.ShowFoodItemDetail;
import com.ustc.quincy.scos.ui.Fragment_foodItem_classify;
import com.ustc.quincy.scos.ui.Fragment_foodItem_list;
import com.ustc.quincy.scos.ui.Fragment_orders_manage;
import com.ustc.quincy.scos.ui.MyFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    //定义tabLayout, viewPager, drawerLayout
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private DrawerLayout drawerLayout;

    //定义toolbar
    private Toolbar toolbar;

    //定义floating action button
    private FloatingActionButton floatingActionButton;

    //定义抽屉菜单视图
    private NavigationView navigationView;

    //定义FragementAdapter
    private MyFragmentAdapter myFragmentAdapter;

    //定义Fragment列表， 标题列表
    private List<Fragment> fragmentList;
    private List<String> titleList;

    //定义fragment
    private Fragment_foodItem_list fragment_foodItem_list;
    private Fragment_foodItem_classify fragment_foodItem_classify;
    private Fragment_orders_manage fragment_orders_manage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_layout);
        initControls();

        /*
        Button btn = (Button) findViewById(R.id.test_detail);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowFoodItemDetail.class);
                startActivity(intent);
            }
        });
        */

    }


    //初始化控件
    private  void initControls(){
        //初始化UI控件
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        drawerLayout = (DrawerLayout) findViewById(R.id.main_drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);


        //初始化导航抽屉的布局
        navigationView.setBackgroundColor(Color.rgb(255,255,255));
        //设置导航抽屉的点击事件
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_personProfile:
                        Toast.makeText(MainActivity.this, "person profile clicked", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.item_about:
                        Toast.makeText(MainActivity.this, "about item clicked", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });


        //设置toolbar的菜单布局
        toolbar.inflateMenu(R.menu.toolbar_menu);
        //设置toolbar的点击事件
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_search:
                        Toast.makeText(MainActivity.this, "search clicked", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.action_notification:
                        Toast.makeText(MainActivity.this, "notify clicked", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.action_item1:
                        Toast.makeText(MainActivity.this, "action item1 clicked", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.action_item2:
                        Toast.makeText(MainActivity.this, "action item2 clicked", Toast.LENGTH_LONG).show();
                        break;
                }
                return true;
            }
        });
        //设置toolbar的导航按钮的点击事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        //设置floating action bar的点击事件
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Ok", Snackbar.LENGTH_SHORT).show();
            }
        });

        //初始化各个Fragment
        fragment_foodItem_list = new Fragment_foodItem_list();
        fragment_foodItem_classify = new Fragment_foodItem_classify();
        fragment_orders_manage = new Fragment_orders_manage();

        //将Fragment装进列表
        fragmentList = new ArrayList<>();
        fragmentList.add(fragment_foodItem_list);
        fragmentList.add(fragment_foodItem_classify);
        fragmentList.add(fragment_orders_manage);

        //初始化tab名字，并添加进titleList
        titleList = new ArrayList<>();
        titleList.add("菜品展示");
        titleList.add("菜品分类");
        titleList.add("订单管理");

        //设置tablayout模式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        //为tablayout添加tab名称
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(2)));

        //初始化适配器
        myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), fragmentList, titleList);

        //为viewpager加载adapter
        viewPager.setAdapter(myFragmentAdapter);

        //tabLayout加载Viewpager
        tabLayout.setupWithViewPager(viewPager);

    }
}
