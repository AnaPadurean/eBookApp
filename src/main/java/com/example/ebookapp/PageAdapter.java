package com.example.ebookapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PageAdapter extends RecyclerView.Adapter<PageAdapter.PageViewHolder> {
    private List<String> pages;

    public PageAdapter(List<String> pages) {
        this.pages = pages;
    }

    @NonNull
    @Override
    public PageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_page_adaptor, parent, false);
        return new PageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PageViewHolder holder, int position) {
        String pageContent = pages.get(position);
        holder.pageTextView.setText(pageContent);

        // Log the content length for debugging
        Log.d("PageAdapter", "Page " + position + " content length: " + pageContent.length());
    }

    @Override
    public int getItemCount() {
        return pages.size();
    }

    static class PageViewHolder extends RecyclerView.ViewHolder {
        TextView pageTextView;

        public PageViewHolder(@NonNull View itemView) {
            super(itemView);
            pageTextView = itemView.findViewById(R.id.pageTextView);
        }
    }
}