package com.example.messmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity13 extends AppCompatActivity {

    EditText item;
    Button delete;
    DBHelper4 DB4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);

        item = (EditText) findViewById(R.id.editTextTextPersonName20);
        delete  = (Button) findViewById(R.id.button24);

        DB4 = new DBHelper4(this);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String it = item.getText().toString();



                if(it.equals(""))
                    Toast.makeText(MainActivity13.this, "Please enter the item to delete", Toast.LENGTH_SHORT).show();
                else{

                    Boolean check = DB4.checkitem(it);

                    if(check==false)
                    {
                        Toast.makeText(MainActivity13.this, "Already not in the stock", Toast.LENGTH_SHORT).show();
                    }

                    else{

                        Boolean deleted = DB4.delete(it);

                        if(deleted==true){
                            Toast.makeText(MainActivity13.this, "Item deleted Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity13.this, "Item deletion Failed", Toast.LENGTH_SHORT).show();
                        }
                    }


                }

            }
        });
    }
}