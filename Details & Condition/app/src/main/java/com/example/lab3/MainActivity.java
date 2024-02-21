package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView places;
    RadioGroup rg;
    RadioButton rb;
    Button reset;
    TextView heading;
    EditText age;
    TextView result;
    EditText name;
    Button btn;
    String[] Locations={"Bengaluru","Delhi","Mumbai",
    "Pune","Punjab"};

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result=findViewById(R.id.Result);
        reset=findViewById(R.id.Reset);
        name=findViewById(R.id.name);
        heading=findViewById(R.id.Heading);
        age=findViewById(R.id.Enterage);
        places=findViewById(R.id.autoCompleteTextView2);
        btn=findViewById(R.id.button);
        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.select_dialog_item,Locations);
        places.setThreshold(1);
        places.setAdapter(adapter);
        rg=findViewById(R.id.radio);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGr2oup, int i) {
                rb=findViewById(i);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
//                String res="\n Gender: "+ rb.getText()+"\n Place of Birth"+ places.getText().toString();
//                Toast.makeText(MainActivity.this,res,Toast.LENGTH_LONG).show();
                String naam=name.getText().toString();
                 int eage=Integer.parseInt(age.getText().toString());
                if(eage < 18){
                   result.setText("Name: "+ naam +"\nFrom City: "+ places.getText().toString()+"\nGender: "+rb.getText()+"\nYou are not eligible to vote!" );
                }
                else if (eage >= 18) {
                    result.setText("Name: "+ naam +"\nFrom City: "+ places.getText().toString()+"\nGender: "+rb.getText()+"\nYou are eligible to vote!");
                }
                else {
                    result.setText("Enter valid number");
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.getText().clear();
                places.getText().clear();
                age.getText().clear();
                rg.clearCheck();
                result.setText("");
            }
        });
    }
}