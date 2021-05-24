package com.example.messmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    EditText name, password;
    private Button log,sign;
    DBHelper3 DB3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        name = (EditText) findViewById(R.id.editTextTextPersonName8);
        password = (EditText) findViewById(R.id.editTextTextPersonName9);
        log = (Button) findViewById(R.id.button5);
        sign = (Button) findViewById(R.id.button6);


        DB3 = new DBHelper3(this);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String r = name.getText().toString();
                String p = password.getText().toString();

                if(r.equals("")||p.equals("")) {
                    Toast.makeText(MainActivity3.this, "Please Enter All Fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checknamepass = DB3.checknamepassword(r,p);
                    if(checknamepass==true){
                        openActivity6(r);}
                    else{
                        Toast.makeText(MainActivity3.this, "Not registered", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity7();
            }
        });





    }

    public void openActivity6(String r){
        Intent intent=new Intent(this,MainActivity6.class);
        intent.putExtra("key",r);
        startActivity(intent);
    }

    public void openActivity7(){
        Intent intent=new Intent(this,MainActivity7.class);
        startActivity(intent);
    }




}