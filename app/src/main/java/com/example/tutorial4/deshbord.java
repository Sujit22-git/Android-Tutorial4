package com.example.tutorial4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class deshbord extends AppCompatActivity {

    EditText user,pass;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deshbord);

        user = findViewById(R.id.edtxtuser);
        pass = findViewById(R.id.edtxtpass);
        save = findViewById(R.id.btnsave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = user.getText().toString();
                String p = pass.getText().toString();
                if(!ValidateEmail() | !ValidatePass())
                {
                    if(u.equals("admin@gmail.com") && p.equals("Admin@123")){
                        Intent i = new Intent(getApplicationContext(),MainActivity2.class);
                        i.putExtra("username",u);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Username And Password Wrong...", Toast.LENGTH_LONG).show();
                    }
                    return;
                }
            }

            private boolean ValidatePass() {
                String Val = pass.getText().toString();
                String passwordval = "(?=.[a-zA-Z])"+"(?=.[0-9])" + "(?=.*[@#$%^&+=])";


                if(Val.isEmpty()){
                    pass.setError("Field cannot be empty");
                    return true;
                }else if(!Val.matches(passwordval)){
                    pass.setError("Password is too weak");
                    return false;
                } else {
                    pass.setError(null);
                    return false;
                }
            }

            private boolean ValidateEmail() {
                String Val = user.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if(Val.isEmpty()){
                    user.setError("Field cannot be empty");
                    return false;
                }
                else if(!Val.matches(emailPattern)){
                    user.setError("Invalid Email Address");
                    return false;
                }
                else {
                    user.setError(null);
                    return true;
                }
            }
        });
    }
}