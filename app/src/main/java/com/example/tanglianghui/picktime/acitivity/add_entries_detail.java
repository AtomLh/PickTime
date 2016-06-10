package com.example.tanglianghui.picktime.acitivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;

import com.example.tanglianghui.picktime.R;

public class add_entries_detail extends AppCompatActivity {
    int emoji;
    String date;
    private ImageButton imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entries_detail);
        Intent intent = getIntent();
        int emoji = intent.getIntExtra("emoji",0);
        imageButton= (ImageButton) findViewById(R.id.imageButton);
        imageButton.setBackground(getDrawable(emoji));


    }

}
