package com.example.messmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity8 extends AppCompatActivity {
    EditText registration,amount;
    private Button b13,b14;
    DBHelper2 DB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        DB2 = new DBHelper2(this);

        registration = (EditText) findViewById(R.id.editTextTextPersonName13);
        amount=(EditText) findViewById(R.id.editTextTextPersonName14);

        b13 = (Button) findViewById(R.id.button13);
        b14 =(Button) findViewById(R.id.button14);

        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String r = registration.getText().toString();

                if(r.equals("")){
                    Toast.makeText(MainActivity8.this, "Please Enter the id", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkregistration = DB2.checkregistration(r);
                    if(checkregistration==true){
                        Toast.makeText(MainActivity8.this, "Penalty already assigned.Update the amount", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        String amount="100";
                       Boolean insert = DB2.insertData(r,amount);

                        if(insert==true){
                            Toast.makeText(MainActivity8.this, "Assigned Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity8.this, "Allotment Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            }
        });

        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String r = registration.getText().toString();
                String amountm =amount.getText().toString();

                if(r.equals("")||amountm.equals("")){
                    Toast.makeText(MainActivity8.this, "Please Enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean update=DB2.update(r,amountm);

                    if(update ==true){
                        Toast.makeText(MainActivity8.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity8.this, "Updation Failed", Toast.LENGTH_SHORT).show();
                    }


                }

            }
        });
    }


}