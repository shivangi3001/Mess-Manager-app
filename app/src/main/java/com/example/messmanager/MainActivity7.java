package com.example.messmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity7 extends AppCompatActivity {

    EditText newname,newpassword,newrepassword;
    Button submit;
    DBHelper3 DB3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        newname = (EditText) findViewById(R.id.editTextTextPersonName10);
        newpassword = (EditText) findViewById(R.id.editTextTextPersonName11);
        newrepassword = (EditText) findViewById(R.id.editTextTextPersonName12);
        submit = (Button) findViewById(R.id.button11);

        DB3 = new DBHelper3(this);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String u = newname.getText().toString();
                String p = newpassword.getText().toString();
                String c = newrepassword.getText().toString();

                if(u.equals("")||p.equals("")||c.equals(""))
                    Toast.makeText(MainActivity7.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else{
                    if(p.equals(c)){
                        Boolean check = DB3.checkname(u);
                        if(check==false){
                            Boolean insert = DB3.insertData(u,p);
                            if(insert==true){
                                Toast.makeText(MainActivity7.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(MainActivity7.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity7.this, "Already Registered", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(MainActivity7.this, "Password Mismatch", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}