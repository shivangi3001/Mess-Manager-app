package com.example.messmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity9 extends AppCompatActivity {

    EditText date;
    private Button b16;

    DBHelper1 DB1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        DB1 = new DBHelper1(this);

        date = (EditText) findViewById(R.id.editTextTextPersonName15);

        b16 = (Button) findViewById(R.id.button16);

        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String d = date.getText().toString();

                if(d.equals("")){

                    Toast.makeText(MainActivity9.this, "Please Enter the date", Toast.LENGTH_SHORT).show();

                }

                else{

                    Cursor c = DB1.getPlateCount(d);
                    String count = Integer.toString(c.getCount());

                    Toast.makeText(MainActivity9.this, count.toString(), Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}