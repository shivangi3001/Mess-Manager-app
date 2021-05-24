package com.example.messmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity6 extends AppCompatActivity {
    private Button b12,b15,b17,b25;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        b12 = (Button) findViewById(R.id.button12);
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity8();
            }
        });

        b15 = (Button) findViewById(R.id.button15);
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity9();
            }
        });

        b17= (Button) findViewById(R.id.button17);
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity10();
            }
        });

        b25= (Button) findViewById(R.id.button25);
        b25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity14();
            }
        });

    }

    public void openActivity8(){
        Intent intent=new Intent(this,MainActivity8.class);
        startActivity(intent);
    }

    public void openActivity9(){
        Intent intent=new Intent(this,MainActivity9.class);
        startActivity(intent);
    }

    public void openActivity10(){
        Intent intent=new Intent(this,MainActivity10.class);
        startActivity(intent);
    }

    public void openActivity14(){
        Intent intent=new Intent(this,MainActivity14.class);
        startActivity(intent);
    }

}