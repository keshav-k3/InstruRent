package com.example.instrurent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    Button calldash,reggy;
    TextInputLayout user,pass;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        calldash=findViewById(R.id.enter_screen);
        reggy=findViewById(R.id.reggy);
        user=(TextInputLayout)findViewById(R.id.username1);
        pass=(TextInputLayout)findViewById(R.id.password1);
        DB=new DBHelper(this);

        calldash.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String user1=user.getEditText().getText().toString();
                String pass1= pass.getEditText().getText().toString();

                if(user1.equals("")||pass1.equals("")){
                    Toast.makeText(Login.this,"Please enter required fields",Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkuserpass=DB.checkusernamepassword(user1,pass1);
                    if(checkuserpass==true){
                        Toast.makeText(Login.this,"Sign in Successful",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),Dashboard.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(Login.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
        reggy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Login.this,sign.class);
                startActivity(intent1);
            }
        });
    }
}
/*String userr=user.getEditText().getText().toString();
                String passs= pass.getEditText().getText().toString();
                if(userr.equals("keshav@gmail.com") && passs.equals("keshavkk")){
                    Intent intent = new Intent(Login.this,Dashboard.class);
                    startActivity(intent);
                }*/