package com.example.socialshout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.socialshout.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding_am;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding_am = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding_am.getRoot());
    }
}