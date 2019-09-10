package com.example.taxipot_android.presenter.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taxipot_android.databinding.ItemContentSettingBinding;
import com.example.taxipot_android.databinding.ItemTitleSettingBinding;

import java.util.List;

public class SettingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public SettingAdapter(List<Object> list) {
        items = list;
    }

    List<Object> items;
    private final static int TITLEITEM = 0;
    private final static int CONTENTITEM = 1;

    @Override
    public int getItemViewType(int position) {
        if(items.get(position) instanceof String) {
            return TITLEITEM;
        } else {
            return CONTENTITEM;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding;
        if(viewType==TITLEITEM) {
            binding = ItemTitleSettingBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
            return new TitleViewHolder(binding);
        } else if(viewType==CONTENTITEM) {
            binding = ItemContentSettingBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
            return new ContentViewHolder(binding);
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof TitleViewHolder) {
            ((TitleViewHolder)holder).setData((String)items.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class TitleViewHolder extends RecyclerView.ViewHolder {
        public String title;
        TitleViewHolder(ViewDataBinding binding){
            super(binding.getRoot());
            ((ItemTitleSettingBinding)binding).setAdapter(this);
        }
        public void setData(String title) {
            this.title = title;
        }
    }

    private class ContentViewHolder extends RecyclerView.ViewHolder {
        ContentViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
        }
    }
}
