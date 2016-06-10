package com.example.tanglianghui.picktime.model;

/**
 * Created by tanglianghui on 16/6/9.
 */
public class Dairy {
    private int id;
    private String date;
    private int emoji;
    private String descri;

    public String getDate() {
        return date;
    }

    public String getDescri() {
        return descri;
    }

    public int getEmoji() {
        return emoji;
    }

    public int getId() {
        return id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public void setEmoji(int emoji) {
        this.emoji = emoji;
    }

    public void setId(int id) {
        this.id = id;
    }
}
