package com.example.messmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;


public class MainActivity4 extends AppCompatActivity {


    private Button b3,b4,b5;
    DBHelper1 DB1;
    DBHelper2 DB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());


        Intent intent=getIntent();
        String r = intent.getStringExtra("key");
        DB1 = new DBHelper1(this);
        DB2 = new DBHelper2(this);


       



        b3 = (Button) findViewById(R.id.button8);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String status="Yes";


                Boolean checkregistration = DB1.checkregistration(r,currentDate);

                if(checkregistration==true){
                    Toast.makeText(MainActivity4.this, "Attendance already taken", Toast.LENGTH_SHORT).show();
                }

                else{
                    Boolean insert = DB1.insertData(r,status,currentDate);

                    if(insert==true){
                        Toast.makeText(MainActivity4.this, "Attendance Successfully", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity4.this, "Attendance Failed", Toast.LENGTH_SHORT).show();
                    }
                }








            }



        });

        b4= (Button) findViewById(R.id.button9);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String status="No";

                Boolean checkregistration = DB1.checkregistration(r,currentDate);

                if(checkregistration==true){
                    Toast.makeText(MainActivity4.this, "Attendance already taken", Toast.LENGTH_SHORT).show();
                }

                else{
                    Boolean insert = DB1.insertData(r,status,currentDate);

                    if(insert==true){
                        Toast.makeText(MainActivity4.this, "Attendance Successfully", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity4.this, "Attendance Failed", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


        b5= (Button) findViewById(R.id.button10);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               Cursor c = DB2.getPenalty(r);

                if(c.getCount()==0){
                    Toast.makeText(MainActivity4.this, "No Pending Penalties", Toast.LENGTH_SHORT).show();
                }
                else{

                    if(c!= null && c.moveToFirst()) {
                        String p;
                        p = c.getString(1);
                        Toast.makeText(MainActivity4.this, p.toString(), Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });



    }
}
