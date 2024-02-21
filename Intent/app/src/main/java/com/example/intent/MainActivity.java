package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText na;
TextView hd;
Button nxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        na=findViewById(R.id.name);
        hd=findViewById(R.id.textView);
        nxt=findViewById(R.id.button);

        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=na.getText().toString();
                Intent in=new Intent(MainActivity.this,Page2.class);
                in.putExtra("Name",name);
                startActivity(in);

            }
        });
    }
}