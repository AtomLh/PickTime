package com.example.tanglianghui.picktime.acitivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.tanglianghui.picktime.R;
import java.util.Calendar;
public class add_entries_activity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton rad_btn,good_btn,meh_btn,fugly_btn,awful_btn;
    private TextView date_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entries_activity);
        rad_btn = (ImageButton) findViewById(R.id.rad_btn);
        good_btn = (ImageButton) findViewById(R.id.good_btn);
        meh_btn = (ImageButton)  findViewById(R.id.meh_btn);
        fugly_btn =(ImageButton) findViewById(R.id.fugly_btn);
        awful_btn = (ImageButton) findViewById(R.id.awful_btn);
        date_tv = (TextView) findViewById(R.id.date_tv);
        setDate();
        rad_btn.setOnClickListener(this);
        good_btn.setOnClickListener(this);
        meh_btn.setOnClickListener(this);
        fugly_btn.setOnClickListener(this);
        awful_btn.setOnClickListener(this);
    }

    private void setDate() {

        Calendar today = Calendar.getInstance();
        Integer year = today.get(Calendar.YEAR);
        Integer month = today.get(Calendar.MONTH)+1;
        Integer day = today.get(Calendar.DATE);
        String date =   year.toString()+"-"+month.toString()+"-"+day.toString();
        date_tv.setText(date);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,add_entries_detail.class);
        intent.putExtra("date", date_tv.getText().toString());
        rad_btn.setBackgroundResource(R.drawable.rad_unselect);
        good_btn.setBackgroundResource(R.drawable.good_unselect);
        meh_btn.setBackgroundResource(R.drawable.meh_unselect);
        fugly_btn.setBackgroundResource(R.drawable.fugly_unselect);
        awful_btn.setBackgroundResource(R.drawable.awful_unselect);
        switch (v.getId()){
            case R.id.rad_btn:
                intent.putExtra("emoji_text",R.string.emoji_rad);
                intent.putExtra("emoji", R.drawable.rad_selected);
                v.setBackgroundResource(R.drawable.rad_selected);
                break;
            case R.id.good_btn:
                intent.putExtra("emoji_text",R.string.emoji_good);
                intent.putExtra("emoji", R.drawable.good_selected);
                v.setBackgroundResource(R.drawable.good_selected);
                break;
            case R.id.meh_btn:
                intent.putExtra("emoji_text",R.string.emoji_meh);
                intent.putExtra("emoji", R.drawable.meh_selected);
                v.setBackgroundResource(R.drawable.meh_selected);
                break;
            case R.id.fugly_btn:
                intent.putExtra("emoji_text",R.string.emoji_fugly);
                intent.putExtra("emoji", R.drawable.fugly_selected);
                v.setBackgroundResource(R.drawable.fugly_selected);
                break;
            case R.id.awful_btn:
                intent.putExtra("emoji_text",R.string.emoji_awful);
                intent.putExtra("emoji",R.drawable.awful_selected);
                v.setBackgroundResource(R.drawable.awful_selected);
                break;
            default:
                break;

        }
        startActivity(intent);

    }
}
