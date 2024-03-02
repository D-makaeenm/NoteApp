package com.example.myapplication.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "notes")
public class Notes implements Serializable {
    @PrimaryKey(autoGenerate = true)//Tạo khóa tự động mỗi khi thêm 1 ghi chus
    int ID = 0;

    @ColumnInfo(name = "title")//Tiêu đề ghi chú
    String title = "";

    @ColumnInfo(name = "notes")//Nội dung
    String notes = "";

    @ColumnInfo(name = "date")//Ngày tháng
    String date = "";

    @ColumnInfo(name = "pinned")//Ghim
    boolean pinned = false;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }
}
