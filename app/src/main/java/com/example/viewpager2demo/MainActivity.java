package com.example.viewpager2demo;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.viewpager2demo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private static final int NUM_PAGES = 2;

    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        pagerAdapter = new PagerAdapter(this);
        binding.pager.setAdapter(pagerAdapter);
    }

    private static class PagerAdapter extends FragmentStateAdapter {

        public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position){
                case 0:
                    return new FirstFragment();
                case 1:
                    return new SecondFragment();
            }
            return new FirstFragment();
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }
}