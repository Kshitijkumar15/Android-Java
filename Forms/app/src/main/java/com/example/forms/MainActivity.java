package com.example.forms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button sub;
Button res;
AutoCompleteTextView Places;
RadioGroup rg;
RadioButton rb;
TextView gen;
 TextView heading;
 EditText name;
 EditText fathername;
 ImageView logo;
 TextView rs;

 String[] Locations ={"Bengaluru","Bhopal","Delhi","Pune","Punjab"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    Places=findViewById(R.id.auto);
    sub=findViewById(R.id.submit);
    res=findViewById(R.id.reset);
    rs=findViewById(R.id.result);
    name=findViewById(R.id.Name);
    fathername=findViewById(R.id.Name2);
    logo=findViewById(R.id.imageView);
    ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.select_dialog_item,Locations);
    Places.setThreshold(1);
    Places.setAdapter(adapter);
    rg=findViewById(R.id.radiogroup);
   rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        rb=findViewById(i);
    }
});

sub.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String naam=name.getText().toString();
        String fnaam=fathername.getText().toString();

        rs.setText("Name : "+ naam +"\nFathers name: " +fnaam +"\nGender : "+rb.getText()+"\nBirth : "+ Places.getText());

    }
});

    res.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            name.getText().clear();
            fathername.getText().clear();
            rg.clearCheck();
            rs.setText("");
            Places.getText().clear();
        }
    });

    }
}