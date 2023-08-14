package com.example.instrurent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sign extends AppCompatActivity {

    TextInputLayout userr,passwordd;
    Button reggy1;
    private FirebaseAuth mAuth;
    FirebaseDatabase rootNode;
    DatabaseReference ref;
    DBHelper DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        mAuth = FirebaseAuth.getInstance();

        userr=(TextInputLayout)findViewById(R.id.userr);
        passwordd=(TextInputLayout)findViewById(R.id.passwordd);
        reggy1=(Button)findViewById(R.id.reggy1);
        DB=new DBHelper(this);

        reggy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String user=userr.getEditText().getText().toString();
                String password= passwordd.getEditText().getText().toString();

                if(user.equals("")||password.equals(""))
                    Toast.makeText(sign.this,"Please enter required fields",Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuser = DB.checkUsername(user);
                    if(checkuser==false){
                        Boolean insert=DB.insertData(user,password);
                        if(insert==true){
                            Toast.makeText(sign.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),Login.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(sign.this,"Registered Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(sign.this,"User Already Exists",Toast.LENGTH_SHORT).show();
                    }
                }
;            }
        });
    }

    /*public void onClick(View view) {
                reggymone();
            }

    private void reggymone() {
        String email=emaill.getEditText().getText().toString();
        String password= passwordd.getEditText().getText().toString();

        if (email.isEmpty()) {
            emaill.setError("Email is required");
            emaill.requestFocus();
            return;
        }

        if (password.isEmpty()) {

            passwordd.setError("Password is required");
            passwordd.requestFocus();
            return;
        }
        if(password.length()<6){
            passwordd.setError("Length of password should be greater than 6");
            passwordd.requestFocus();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            User user=new User(email);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(sign.this,"User has been registered successfully",Toast.LENGTH_LONG).show();
                                                //
                                            }
                                            else{
                                                Toast.makeText(sign.this,"Failed to register user",Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });
                        }
                        else{
                            Toast.makeText(sign.this,"Failed to register user",Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }*/

}