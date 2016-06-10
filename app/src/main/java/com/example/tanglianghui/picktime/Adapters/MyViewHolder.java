package com.example.tanglianghui.picktime.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tanglianghui.picktime.R;

/**
 * Created by tanglianghui on 16/6/10.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView  emoji_pic;
    TextView date_tv;
    TextView activities_tv;
    TextView emoji_tv;
    TextView descri_tv;

    public MyViewHolder(View itemView) {
        super(itemView);
        emoji_pic = (ImageView) itemView.findViewById(R.id.showImage);
        date_tv = (TextView) itemView.findViewById(R.id.date_tv);
        activities_tv = (TextView) itemView.findViewById(R.id.activities_tv);
        emoji_tv = (TextView)itemView.findViewById(R.id.emoji_tv);
        descri_tv = (TextView) itemView.findViewById(R.id.note_tv);
        itemView.findViewById(R.id.item_container).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });

    }
}
