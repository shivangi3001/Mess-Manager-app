package com.example.messmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity10 extends AppCompatActivity {
    private Button b18,b19,b20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        b18 = (Button) findViewById(R.id.button18);
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity11();
            }
        });

        b19 = (Button) findViewById(R.id.button19);
        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity12();
            }
        });

        b20= (Button) findViewById(R.id.button20);
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity13();
            }
        });




    }

    public void openActivity11(){
        Intent intent=new Intent(this,MainActivity11.class);
        startActivity(intent);
    }

    public void openActivity12(){
        Intent intent=new Intent(this,MainActivity12.class);
        startActivity(intent);
    }

    public void openActivity13(){
        Intent intent=new Intent(this,MainActivity13.class);
        startActivity(intent);
    }


}