package com.example.tanglianghui.picktime.model;

/**
 * Created by tanglianghui on 16/6/9.
 */
public class activities {
    private int id;
    private int activity_code;
    private int dairy_id;

    public int getActivity_code() {
        return activity_code;
    }

    public int getDairy_id() {
        return dairy_id;
    }

    public int getId() {
        return id;
    }

    public void setActivity_code(int activity_code) {
        this.activity_code = activity_code;
    }

    public void setDairy_id(int dairy_id) {
        this.dairy_id = dairy_id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
