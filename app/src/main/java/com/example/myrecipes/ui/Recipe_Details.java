package com.example.myrecipes.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myrecipes.R;
import com.example.myrecipes.util.AppUtil;

public class Recipe_Details extends AppCompatActivity {

    private int currentPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe__details);
        currentPosition=getIntent().getIntExtra(AppUtil.CURRENT_RECIPE,0);

    }
}