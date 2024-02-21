package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Page2 extends AppCompatActivity {
 TextView res;
Button bck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        res = findViewById(R.id.textView3);
        bck=findViewById(R.id.button2);
        Intent intent = getIntent();
        String naam = intent.getStringExtra("Name");
        String Upper=naam.toUpperCase();
        res.setText("Name: " + Upper);



        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in2 = new Intent(Page2.this, MainActivity.class);
                startActivity(in2);

            }
        });
    }

}