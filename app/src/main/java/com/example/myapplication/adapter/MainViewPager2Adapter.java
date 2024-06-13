package com.example.myapplication.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.fragment.MainActivityFirstFragment;
import com.example.myapplication.fragment.MainActivitySecondFragment;
import com.example.myapplication.fragment.MainActivityThirdFragment;

public class MainViewPager2Adapter extends FragmentStateAdapter {

    public MainViewPager2Adapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
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
    public int getItemCount() {
        return 3;
    }
}
