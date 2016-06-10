package com.example.tanglianghui.picktime.acitivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.tanglianghui.picktime.R;
import com.example.tanglianghui.picktime.database.DairyDB;
import com.example.tanglianghui.picktime.model.Dairy;

public class add_entries_detail extends AppCompatActivity {
    private CheckBox coding_cb,study_cb,shopping_cb,gaming_cb,party_cb,
    reading_cb,sport_cb,dating_cb,meal_cb,travel_cb;
    private Button saveBtn;
    private EditText  note_et;
    int emoji;  //emoji的图片
    String date;
    StringBuffer activities = new StringBuffer();
    int emoji_text;  //emoji的文字
    private ImageButton imageButton;
    Dairy dairy = new Dairy();
    String note;
    DairyDB db = DairyDB.getInstance(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entries_detail);
        Intent intent = getIntent();
        int emoji = intent.getIntExtra("emoji",0);
        int emoji_text = intent.getIntExtra("emoji_text",0);
        date = intent.getStringExtra("date");
        imageButton= (ImageButton) findViewById(R.id.imageButton);
        imageButton.setBackground(getDrawable(emoji));
        saveBtn =(Button)findViewById(R.id.save_btn);
        coding_cb = (CheckBox) findViewById(R.id.coding_cb);
        shopping_cb = (CheckBox) findViewById(R.id.shopping_cb);
        gaming_cb = (CheckBox) findViewById(R.id.gaming_cb);
        party_cb = (CheckBox) findViewById(R.id.party_cb);
        reading_cb = (CheckBox) findViewById(R.id.reading_cb);
        sport_cb = (CheckBox) findViewById(R.id.sport_cb);
        dating_cb = (CheckBox) findViewById(R.id.dating_cb);
        meal_cb = (CheckBox) findViewById(R.id.good_meal_cb);
        travel_cb = (CheckBox) findViewById(R.id.travel_cb);
        SaveBtnClicked();
    }

    private void SaveBtnClicked() {
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              note = note_et.getText().toString();

                if (coding_cb.isChecked()){
                   activities.append("*coding ");
                }
                if (shopping_cb.isChecked()){
                    activities.append("*shopping ");
                }
                if (gaming_cb.isChecked()){
                    activities.append("*gaming ");
                }
                if (party_cb.isChecked()){
                    activities.append("*party ");
                }
                if (reading_cb.isChecked()){
                    activities.append("*reading ");
                }
                if (sport_cb.isChecked()){
                    activities.append("*sport ");
                }
                if (dating_cb.isChecked()){
                    activities.append("*dating ");
                }
                if (meal_cb.isChecked()){
                    activities.append("*meal ");
                }
                if (travel_cb.isChecked()){
                    activities.append("*travel ");
                }
                dairy.setDate(date);
                dairy.setEmoji_text(emoji_text);
                dairy.setEmoji(emoji);
                dairy.setDescri(note);
                dairy.setActivities(activities.toString());
                db.saveDairy(dairy);
            }

        });
    }

}
