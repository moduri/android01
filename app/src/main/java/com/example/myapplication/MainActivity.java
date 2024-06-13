package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;

import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.example.myapplication.adapter.ContentsPagerAdapter;
import com.example.myapplication.adapter.FirstActivityGridAdapter;
import com.example.myapplication.adapter.MainViewPager2Adapter;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.model.MyCarItemVO;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    InstallReferrerClient referrerClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MainViewPager2Adapter vpAdapter = new MainViewPager2Adapter(getSupportFragmentManager(), getLifecycle());

        ContentsPagerAdapter contentsPagerAdapter = new ContentsPagerAdapter(this, 3);

//        binding.vpPager.setAdapter(vpAdapter);
        binding.vpPager.setAdapter(contentsPagerAdapter);

        //tabLayout-------------------------
//        new TabLayoutMediator(binding.tlTabLayout, binding.vpPager, new TabLayoutMediator.TabConfigurationStrategy() {
//            @Override
//            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
//                String tabText = position == 0 ? "마이카" : position == 1 ? "홈" : "여행";
//                tab.setText(tabText);
//            }
//
//        }).attach();

        binding.dotsIndicator.setViewPager2(binding.vpPager);

        referrerClient = InstallReferrerClient.newBuilder(this).build();
        referrerClient.startConnection(new InstallReferrerStateListener() {

            final ReferrerDetails response;

            {
                try {
                    response = referrerClient.getInstallReferrer();
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }

            final String referrerUrl = response.getInstallReferrer();
            final long referrerClickTime = response.getReferrerClickTimestampSeconds();
            final long appInstallTime = response.getInstallBeginTimestampSeconds();
            final boolean instantExperienceLaunched = response.getGooglePlayInstantParam();

            @Override
            public void onInstallReferrerSetupFinished(int responseCode) {
                switch (responseCode) {
                    case InstallReferrerClient.InstallReferrerResponse.OK:
                        // Connection established.
                        break;
                    case InstallReferrerClient.InstallReferrerResponse.FEATURE_NOT_SUPPORTED:
                        // API not available on the current Play Store app.
                        break;
                    case InstallReferrerClient.InstallReferrerResponse.SERVICE_UNAVAILABLE:
                        // Connection couldn't be established.
                        break;
                }
            }

            @Override
            public void onInstallReferrerServiceDisconnected() {
                // Try to restart the connection on the next request to
                // Google Play by calling the startConnection() method.
            }
        });


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}