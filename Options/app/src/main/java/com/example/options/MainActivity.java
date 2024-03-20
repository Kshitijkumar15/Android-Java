package com.example.options;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView res;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res=findViewById(R.id.result);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.search){
            res.setText("Search");
            Toast.makeText(this,"Search",Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(item.getItemId()==R.id.setting){
            res.setText("Setting");
            Toast.makeText(this,"Settings",Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(item.getItemId()==R.id.group){
            res.setText("Group");
            Toast.makeText(this,"Group",Toast.LENGTH_SHORT).show();
            return true;
        }else if(item.getItemId()==R.id.camera){
            res.setText("Camera");
            Toast.makeText(this,"Camera",Toast.LENGTH_SHORT).show();
            return true;
        }
        else
            return super.onOptionsItemSelected(item);

    }


}