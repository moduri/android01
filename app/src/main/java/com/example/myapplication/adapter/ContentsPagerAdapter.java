package com.example.myapplication.adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.fragment.MainActivityFirstFragment;
import com.example.myapplication.fragment.MainActivitySecondFragment;
import com.example.myapplication.fragment.MainActivityThirdFragment;

public class ContentsPagerAdapter extends FragmentStateAdapter {
    private int mPageCount;


    public ContentsPagerAdapter(AppCompatActivity fm, int page) {
        super(fm);
        this.mPageCount = page;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new MainActivitySecondFragment();
            case 2:
                return new MainActivityThirdFragment();
            default:
                return new MainActivityFirstFragment();
        }
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return mPageCount;
    }
}