package com.example.tanglianghui.picktime.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tanglianghui.picktime.R;
import com.example.tanglianghui.picktime.model.Dairy;

import java.util.List;

/**
 * Created by tanglianghui on 16/6/10.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<Dairy>  myDate;
    private int itemLayout;

    public MyRecyclerViewAdapter(int itemLayout, List<Dairy> myDate) {
        this.itemLayout = itemLayout;
        this.myDate = myDate;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
         Dairy dairy = myDate.get(position);
         holder.emoji_pic.setBackgroundResource(dairy.getEmoji());
         holder.date_tv.setText(dairy.getDate());
         holder.descri_tv.setText(dairy.getDescri());
         holder.emoji_tv.setText(dairy.getEmoji_text());

    }

    @Override
    public int getItemCount() {
        return myDate.size();
    }
}
