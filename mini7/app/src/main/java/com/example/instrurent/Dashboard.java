package com.example.instrurent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Dashboard extends AppCompatActivity {
    ImageButton b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        b1=findViewById(R.id.guitar);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent1 = new Intent(Dashboard.this,Guitars.class);
                startActivity(intent1);
            }
        });

        b2=findViewById(R.id.micro);
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent2 = new Intent(Dashboard.this,Microphone.class);
                startActivity(intent2);
            }
        });

        b3=findViewById(R.id.drum);
        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent3 = new Intent(Dashboard.this,Drums.class);
                startActivity(intent3);
            }
        });

        b4=findViewById(R.id.keys);
        b4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent4 = new Intent(Dashboard.this,Keys.class);
                startActivity(intent4);
            }
        });
    }
}