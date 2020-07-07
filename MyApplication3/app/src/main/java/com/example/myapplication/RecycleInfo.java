package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import com.example.myapplication.R;

import com.example.myapplication.RecycleInfo;
import androidx.appcompat.app.AppCompatActivity;
public class RecycleInfo extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_in);
        TextView t;
        t = findViewById(R.id.in_tx_1);
        Intent in = getIntent();
        int i;
        i = in.getIntExtra("xvhao",0);
        String n = String.valueOf(i);
        t.setText("This is the "+n+"th item");
    }
}
