package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.Notes;
import com.example.myapplication.NotesClickListener;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NotesListAdapter extends RecyclerView.Adapter<NotesViewHolder>{
    Context context;
    List<Notes> list;
    NotesClickListener listener;

    public NotesListAdapter(Context context, List<Notes> list, NotesClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.notes_list, parent, false));

    }

    @Override
    //liên kết tất cả dữ liệu với chế độ xem
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        //Xem văn bản tiêu đề
        holder.textView_title.setText(list.get(position).getTitle());
        holder.textView_title.setSelected(true);
        //Xem văn bản ghi chú
        holder.textView_notes.setText(list.get(position).getNotes());
        //Xem ngày thansg
        holder.textView_date.setText(list.get(position).getDate());
        holder.textView_date.setSelected(true);
        //Show pin
        if(list.get(position).isPinned()){
            holder.imageView_pin.setImageResource(R.drawable.ic_pin_32);
        }
        else{
            holder.imageView_pin.setImageResource(0);
        }

        int color_code = getRandomColor();
        holder.notes_container.setCardBackgroundColor(holder.itemView.getResources().getColor(color_code, null));

        holder.notes_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(list.get(holder.getAdapterPosition()));
            }
        });

        holder.notes_container.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onLongClick(list.get(holder.getAdapterPosition()), holder.notes_container);
                return true;
            }
        });
    }

    private int getRandomColor(){
        //Random background color nội dung ghi chú
        List<Integer> colorCode = new ArrayList<>();
        colorCode.add(R.color.light_green);
        colorCode.add(R.color.light_yellow);
        colorCode.add(R.color.light_blue);
        colorCode.add(R.color.light_purple);
        colorCode.add(R.color.light_cyan);

        Random random = new Random();
        int random_color = random.nextInt(colorCode.size());
        return random_color;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class NotesViewHolder extends RecyclerView.ViewHolder{
    CardView notes_container;
    TextView textView_title, textView_notes, textView_date;
    ImageView imageView_pin;
    public NotesViewHolder(@NonNull View itemView){
        super(itemView);
        notes_container = itemView.findViewById(R.id.notes_container);
        textView_title = itemView.findViewById(R.id.textView_title);
        textView_notes = itemView.findViewById(R.id.textView_notes);
        textView_date = itemView.findViewById(R.id.textView_date);
        imageView_pin = itemView.findViewById(R.id.imageView_pin);

    }
}
