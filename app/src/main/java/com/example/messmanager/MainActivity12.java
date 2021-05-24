package com.example.messmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity12 extends AppCompatActivity {
    EditText item,quantity,price;
    Button insert,update;
    DBHelper4 DB4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);

        item = (EditText) findViewById(R.id.editTextTextPersonName17);
        quantity = (EditText) findViewById(R.id.editTextTextPersonName18);
        price = (EditText) findViewById(R.id.editTextTextPersonName19);
        insert  = (Button) findViewById(R.id.button22);
        update  = (Button) findViewById(R.id.button23);

        DB4 = new DBHelper4(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String it = item.getText().toString();
                String qt = quantity.getText().toString();
                String pr = price.getText().toString();


                if(it.equals("")||qt.equals("")||pr.equals(""))
                    Toast.makeText(MainActivity12.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else{

                    Boolean check = DB4.checkitem(it);

                    if(check==true)
                    {
                        Toast.makeText(MainActivity12.this, "Already in the stock.Please Update", Toast.LENGTH_SHORT).show();
                    }

                    else{

                        float q = Float.parseFloat(qt);
                        float p = Float.parseFloat(pr);

                        Boolean insert = DB4.insertData(it,q,p);

                        if(insert==true){
                            Toast.makeText(MainActivity12.this, "Item inserted Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity12.this, "Item insertion Failed", Toast.LENGTH_SHORT).show();
                        }
                    }


                }

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String it = item.getText().toString();
                String qt = quantity.getText().toString();
                String pr = price.getText().toString();


                if(it.equals("")||qt.equals("")||pr.equals(""))
                    Toast.makeText(MainActivity12.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else{

                    Boolean check = DB4.checkitem(it);

                    if(check==false)
                    {
                        Toast.makeText(MainActivity12.this, "Not in the stock.Please Insert", Toast.LENGTH_SHORT).show();
                    }

                    else{

                        float q = Float.parseFloat(qt);
                        float p = Float.parseFloat(pr);

                        Boolean insert = DB4.update(it,q,p);

                        if(insert==true){
                            Toast.makeText(MainActivity12.this, "Item update Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity12.this, "Item updation Failed", Toast.LENGTH_SHORT).show();
                        }
                    }


                }

            }
        });

    }


}