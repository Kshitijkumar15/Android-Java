package com.example.cakeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button ord;
    TextView dod, tod,t;
    EditText d;
    Spinner fl;
    String c, formattedTime;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        d = findViewById(R.id.Date);
        t = findViewById(R.id.Time);
        ord = findViewById(R.id.orderButton);
        fl = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.flavours, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fl.setAdapter(adapter);
        fl.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                c = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int eyear = c.get(Calendar.YEAR);
                int emonth = c.get(Calendar.MONTH);
                int edate = c.get(Calendar.DATE);
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                        (DatePicker datePicker, int year, int month, int dayOfMonth) -> {
                            String formattedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                            d.setText(formattedDate);
                        }, eyear, emonth, edate);
                dialog.show();
            }
        });

        t.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        t.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, false);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });




        ord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = d.getText().toString();
                String time = t.getText().toString();
                Intent i = new Intent(getApplicationContext(), OrderActivity.class);
                i.putExtra("Item", c);
                i.putExtra("Date", date);
                i.putExtra("Time", time);
                startActivity(i);
            }
        });
    }
}
