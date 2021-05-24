package com.example.messmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {
    EditText newregistration,newpassword,newrepassword;
    Button submit;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        newregistration = (EditText) findViewById(R.id.editTextTextPersonName3);
        newpassword = (EditText) findViewById(R.id.editTextTextPersonName4);
        newrepassword = (EditText) findViewById(R.id.editTextTextPersonName5);
        submit = (Button) findViewById(R.id.button7);

        DB = new DBHelper(this);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String u = newregistration.getText().toString();
                String p = newpassword.getText().toString();
                String c = newrepassword.getText().toString();

                if(u.equals("")||p.equals("")||c.equals(""))
                    Toast.makeText(MainActivity5.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else{
                    if(p.equals(c)){
                        Boolean check = DB.checkregistration(u);
                        if(check==false){
                            Boolean insert = DB.insertData(u,p);
                            if(insert==true){
                                Toast.makeText(MainActivity5.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(MainActivity5.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity5.this, "Already Registered", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(MainActivity5.this, "Password Mismatch", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}