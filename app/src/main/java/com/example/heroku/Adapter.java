package com.example.heroku;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.heroku.retrofit.Films;

import java.io.File;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Films> list =  new ArrayList<>();

    private OnItemClickListener clickListener;

    public void onItemClickListener(OnItemClickListener onItemClickListener){
        this.clickListener = onItemClickListener;
    }

    public void setList(ArrayList<Films> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.OnBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }

        public void OnBind(Films films) {
            textView.setText(films.getTitle());
            itemView.setOnClickListener(v -> {
                clickListener.onClick(films);
            });
        }
    }
    public interface OnItemClickListener{
        void onClick(Films films);
    }
}
