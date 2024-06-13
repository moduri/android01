package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.databinding.MainActivityFirstFragmentBinding;
import com.example.myapplication.databinding.MainActivityFirstGridBinding;
import com.example.myapplication.model.MyCarItemVO;

import java.util.ArrayList;
import java.util.logging.Logger;

public class FirstActivityGridAdapter extends BaseAdapter {

    ArrayList<MyCarItemVO> items = new ArrayList<MyCarItemVO>();
    GridViewHolder viewHolder;

    private MainActivityFirstGridBinding gdBinding;
    private LayoutInflater inflater;

    private Activity activity;

    public FirstActivityGridAdapter(Activity activity) {
        inflater = LayoutInflater.from(activity);
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public void addItem(MyCarItemVO item) {
        items.add(item);
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ResourceType")
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        if (convertView == null) {
            gdBinding = MainActivityFirstGridBinding.inflate(inflater, viewGroup, false);
            convertView = gdBinding.getRoot();
            viewHolder = new GridViewHolder(gdBinding);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (GridViewHolder) convertView.getTag();
        }

        viewHolder.binding.tvName.setText(items.get(position).getName());

        Glide
                .with(activity)
                .load(items.get(position).getUrl())
                .centerCrop()
                .into(viewHolder.binding.ivIcon);

        return convertView;
    }

    private static class GridViewHolder {
        protected MainActivityFirstGridBinding binding;
        public GridViewHolder(MainActivityFirstGridBinding binding) {
            this.binding = binding;
        }
    }
}