package org.geeksforgeeks.demo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private final List<Filters> items;
    private final OnFilterClickListener listener;

    public Adapter(List<Filters> items, OnFilterClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Filters filterItem = items.get(position);
        holder.effectTitle.setText(filterItem.getTitle());

        holder.effectRootView.setOnClickListener(v -> listener.onFilterClicked(filterItem));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView effectTitle;
        LinearLayout effectRootView;

        public ViewHolder(@NonNull View view) {
            super(view);
            effectTitle = view.findViewById(R.id.effectName);
            effectRootView = view.findViewById(R.id.effectsRootView);
        }
    }
}