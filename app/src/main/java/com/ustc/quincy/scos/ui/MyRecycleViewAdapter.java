package com.ustc.quincy.scos.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ustc.quincy.scos.R;
import com.ustc.quincy.scos.activity.ShowFoodItemDetail;
import com.ustc.quincy.scos.model.FoodItem;

import java.util.List;

/**
 * Author: Created by QuincyHu on 2016/5/25 0025 21:28.
 * Email:  zhihuqunxing@163.com
 */
public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.FoodItemsViewHolder> {
    //要显示的数据
    private List<FoodItem> foodItems;
    private Context context;
    private int number;
    //构造函数
    public MyRecycleViewAdapter(List<FoodItem> foodItems, Context context){
        this.foodItems = foodItems;
        this.context = context;
    }


    /**
     * 渲染具体的ViewHolder
     * @param parent 父容器
     * @param viewType 类型
     * @return
     */
    @Override
    public FoodItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.fooditem_simple, parent, false);
        FoodItemsViewHolder foodItemsViewHolder = new FoodItemsViewHolder(v);
       //可进行属性设置
        return foodItemsViewHolder;
    }

    /**
     * 绑定数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final FoodItemsViewHolder holder, int position) {

        //设置图片
        //holder.foodItem_img.setImageResource(foodItems.get(position).getImage());
        holder.foodItem_img.setImageResource(R.drawable.food_item_2);
        holder.foodItem_name.setText(foodItems.get(position).getName());
        holder.foodItem_taste.setText(foodItems.get(position).getTaste());
        holder.foodItem_price.setText(String.valueOf(foodItems.get(position).getPrice()));
        holder.foodItem_number.setText(String.valueOf(number));


        //设置按钮的点击事件
        holder.btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                holder.foodItem_number.setText(String.valueOf(number));

            }

        });

        holder.btn_dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number--;
                holder.foodItem_number.setText(String.valueOf(number));
            }
        });


        //设置卡片的点击事件
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, ShowFoodItemDetail.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodItems.size();
    }

    //自定义ViewHolder类，持有每个Item的所有界面元素
    static class FoodItemsViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView foodItem_img;
        TextView foodItem_name;
        TextView foodItem_taste;
        TextView foodItem_price;
        TextView foodItem_number;
        ImageButton btn_add;
        ImageButton btn_dec;

        public FoodItemsViewHolder(View itemView){
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.foodItem_card);
            foodItem_img = (ImageView) itemView.findViewById(R.id.foodItem_img);
            foodItem_name = (TextView) itemView.findViewById(R.id.foodItem_name);
            foodItem_taste = (TextView) itemView.findViewById(R.id.foodItem_taste);
            foodItem_price = (TextView) itemView.findViewById(R.id.foodItem_price);
            foodItem_number = (TextView) itemView.findViewById(R.id.foodItem_number);
            btn_add = (ImageButton) itemView.findViewById(R.id.add_one);
            btn_dec = (ImageButton) itemView.findViewById(R.id.dec_one);

        }
    }
}
