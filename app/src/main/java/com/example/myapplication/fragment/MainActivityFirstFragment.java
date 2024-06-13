package com.example.myapplication.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MainActivity;
import com.example.myapplication.MainActivity2;
import com.example.myapplication.R;
import com.example.myapplication.adapter.FirstActivityGridAdapter;
import com.example.myapplication.databinding.MainActivityFirstFragmentBinding;
import com.example.myapplication.databinding.MainActivityFirstGridBinding;
import com.example.myapplication.model.MyCarItemVO;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;

public class MainActivityFirstFragment extends Fragment {

    MainActivityFirstFragmentBinding binding;
    private FirstActivityGridAdapter gridViewAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = MainActivityFirstFragmentBinding.inflate(inflater, container, false);

        gridViewAdapter = new FirstActivityGridAdapter(getActivity());
        gridViewAdapter.addItem(new MyCarItemVO(1, "1번", "https://s3.ap-northeast-2.amazonaws.com/beaunex.net/company_02.png"));
        gridViewAdapter.addItem(new MyCarItemVO(2, "2번", "https://s3.ap-northeast-2.amazonaws.com/beaunex.net/company_02.png"));
        gridViewAdapter.addItem(new MyCarItemVO(3, "3번", "https://s3.ap-northeast-2.amazonaws.com/beaunex.net/company_02.png"));
        gridViewAdapter.addItem(new MyCarItemVO(4, "4번", "https://s3.ap-northeast-2.amazonaws.com/beaunex.net/company_02.png"));
        gridViewAdapter.addItem(new MyCarItemVO(5, "5번", "https://s3.ap-northeast-2.amazonaws.com/beaunex.net/company_02.png"));
        gridViewAdapter.addItem(new MyCarItemVO(6, "6번", "https://s3.ap-northeast-2.amazonaws.com/beaunex.net/company_02.png"));
        gridViewAdapter.addItem(new MyCarItemVO(7, "7번", "https://s3.ap-northeast-2.amazonaws.com/beaunex.net/company_02.png"));
        gridViewAdapter.addItem(new MyCarItemVO(8, "8번", "https://s3.ap-northeast-2.amazonaws.com/beaunex.net/company_02.png"));
        binding.gdGrid.setAdapter(gridViewAdapter);

        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                startActivity(intent);
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.toolbar_menu, menu);
    }
}
