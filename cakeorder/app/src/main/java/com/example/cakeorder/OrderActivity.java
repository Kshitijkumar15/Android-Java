package com.example.cakeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {
TextView rs;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        rs=findViewById(R.id.result);
        Intent in=getIntent();
        String item=in.getStringExtra("Item");
        String date=in.getStringExtra("Date");
        String time=in.getStringExtra("Time");
        rs.setText("Selected flavour:"+item+"\nDate of Delevery"+date+"\nTime of Delevery"+time);

    }
}