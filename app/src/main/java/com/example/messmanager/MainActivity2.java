package com.example.messmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText registration, password;
    private Button log,sign;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        registration = (EditText) findViewById(R.id.editTextTextPersonName);
        password = (EditText) findViewById(R.id.editTextTextPersonName2);
        log = (Button) findViewById(R.id.button3);
        sign = (Button) findViewById(R.id.button4);



        DB = new DBHelper(this);
        
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String r = registration.getText().toString();
               String p = password.getText().toString();

                if(r.equals("")||p.equals("")) {
                    Toast.makeText(MainActivity2.this, "Please Enter All Fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkregistrationpass = DB.checkregistrationpassword(r,p);
                    if(checkregistrationpass==true){
                        openActivity4(r);}
                    else{
                        Toast.makeText(MainActivity2.this, "Not registered", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
            }
        });


    }

    public void openActivity4(String r){
        Intent intent=new Intent(this,MainActivity4.class);
        intent.putExtra("key",r);
        startActivity(intent);
    }

    public void openActivity5(){
        Intent intent=new Intent(this,MainActivity5.class);
        startActivity(intent);
    }
}