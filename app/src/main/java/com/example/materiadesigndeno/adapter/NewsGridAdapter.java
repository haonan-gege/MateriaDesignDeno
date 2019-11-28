package com.example.materiadesigndeno.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.materiadesigndeno.R;
import com.example.materiadesigndeno.model.News;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsGridAdapter extends RecyclerView.Adapter<NewsGridAdapter.NewsViewHolder> {
    private List<News> newsList;
    private Context context;


    public NewsGridAdapter(List<News> newsList) {
        this.newsList = newsList;
    }
    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_grid, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        final News news = newsList.get(position);

        holder.itemView.setTag(position);
        holder.tvTitle.setText(news.getTitle());
        Glide.with(context).load(news.getPic()).into(holder.ivPic);

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (listener != null) {
//                    listener.onItemClick(v, (Integer) v.getTag());
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        ImageView ivPic;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            ivPic = itemView.findViewById(R.id.iv_news);
        }
//        private OnItemClickListener listener;
//        public void setOnItemClickListener(OnItemClickListener listener) {
//            this.listener = listener;
//        }
//        public interface OnItemClickListener {
//            void onItemClick(View view, int position);
//        }
    }
}
