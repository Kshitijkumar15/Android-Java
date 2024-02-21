package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView heading,rs;
    ImageView img;
    Spinner sp,sp2;
    Button sub,clr;
    EditText n,r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img=findViewById(R.id.logo);
        n=findViewById(R.id.name);
        r=findViewById(R.id.roll);
        sub=findViewById(R.id.button);
        heading=findViewById(R.id.textView);
        sp=findViewById(R.id.spinner);
        sp2=findViewById(R.id.spinner2);
        rs=findViewById(R.id.result);
        clr=findViewById(R.id.clear);

        ArrayAdapter adapter=ArrayAdapter.createFromResource(this,R.array.options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        sp.setAdapter(adapter);

        ArrayAdapter adapter2=ArrayAdapter.createFromResource(this,R.array.elective, android.R.layout.simple_selectable_list_item);
        adapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
        sp2.setAdapter(adapter2);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=sp.getSelectedItem().toString();
                String j=sp2.getSelectedItem().toString();
                String naam=n.getText().toString();
                String rno=r.getText().toString();

              rs.setText("Name :" +naam +"\nRoll No :"+rno+"\nDepartment :" +s+ "\nElective :" +j);

            }
        });
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.setSelection(0);
                sp2.setSelection(0);
                n.getText().clear();
                r.getText().clear();
                rs.setText("");
            }
        });
    }
}