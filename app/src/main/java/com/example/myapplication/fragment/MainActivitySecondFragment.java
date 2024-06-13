package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.databinding.MainActivityFirstFragmentBinding;
import com.example.myapplication.databinding.MainActivitySecondFragmentBinding;

public class MainActivitySecondFragment extends Fragment {

    private MainActivitySecondFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = MainActivitySecondFragmentBinding.inflate(inflater, container, false);

        Glide
                .with(this)
                .load("https://s3.ap-northeast-2.amazonaws.com/beaunex.net/company_02.png")
                .into(binding.ivTestImv);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}