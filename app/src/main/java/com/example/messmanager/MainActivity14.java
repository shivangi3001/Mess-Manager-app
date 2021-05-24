package com.example.messmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity14 extends AppCompatActivity {

    EditText item,quantity,price;
    Button budget;
    DBHelper4 DB4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main15);

        item = (EditText) findViewById(R.id.editTextTextPersonName21);
        quantity = (EditText) findViewById(R.id.editTextTextPersonName22);
        price = (EditText) findViewById(R.id.editTextTextPersonName23);
        budget  = (Button) findViewById(R.id.button26);

        DB4 = new DBHelper4(this);

        budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String it = item.getText().toString();
                String qt = quantity.getText().toString();
                String pr = price.getText().toString();


                if(it.equals("")||qt.equals("")||pr.equals(""))
                    Toast.makeText(MainActivity14.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else{

                    Boolean check = DB4.checkitem(it);

                    if(check==true)
                    {
                        float q = Float.parseFloat(qt);
                        float p = Float.parseFloat(pr);

                        Cursor c =DB4.getitem(it);

                        if(c!= null && c.moveToFirst()) {
                            String prt;
                            prt = c.getString(1);

                            float qty =Float.parseFloat(prt);

                            float qtbuy = q-qty;

                            if(qtbuy<=0)
                            {
                                Toast.makeText(MainActivity14.this, "Sufficient in stock", Toast.LENGTH_SHORT).show();
                            }

                            else{
                                float budget = qty*p;
                                String fbuy;
                                fbuy = Float.toString(budget);

                                Toast.makeText(MainActivity14.this, "Some in stock.Budget ="+fbuy.toString(), Toast.LENGTH_SHORT).show();
                            }


                        }
                    }

                    else{

                        float q = Float.parseFloat(qt);
                        float p = Float.parseFloat(pr);

                        float budget = q*p;

                        String fbuy;
                        fbuy = Float.toString(budget);

                        Toast.makeText(MainActivity14.this, "Not in stock.Budget ="+fbuy.toString(), Toast.LENGTH_SHORT).show();

                    }


                }

            }
        });
    }
}