package com.example.myapplication;

import androidx.cardview.widget.CardView;

import com.example.myapplication.Models.Notes;

public interface NotesClickListener {
    void onClick(Notes notes);
    void onLongClick(Notes notes, CardView cardView);//Note_list có đối tượng xem là cardview nên chuyển vào

}
