package com.example.messmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity11 extends AppCompatActivity {
    EditText item;
    Button view;
    DBHelper4 DB4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);

        item = (EditText) findViewById(R.id.editTextTextPersonName16);
        view = (Button) findViewById(R.id.button21);

        DB4 = new DBHelper4(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String it = item.getText().toString();


                if(it.equals(""))
                    Toast.makeText(MainActivity11.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else{
                    Cursor c =DB4.getitem(it);


                    if(c.getCount()==0){
                        Toast.makeText(MainActivity11.this, "No such item in stock", Toast.LENGTH_SHORT).show();
                    }
                    else{

                        if(c!= null && c.moveToFirst()) {
                            String p;
                            String q;
                            p = c.getString(1);
                            q = c.getString(2);
                            Toast.makeText(MainActivity11.this, "Quantity = "+p.toString() + "  Price = "+ q.toString(),Toast.LENGTH_SHORT).show();
                        }

                    }
                }

            }
    });
    }
}