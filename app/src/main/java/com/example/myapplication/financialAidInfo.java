package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Classes.University;
import com.example.myapplication.Classes.accountCreator;


public class financialAidInfo extends AppCompatActivity{

    private EditText name;
    private EditText detail;
    String uname;
    Button b;


    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial_aid_info);


        accountCreator obj = new accountCreator();
        obj.connectToDb(financialAidInfo.this);

//        uname=getIntent().getExtras().getString("name");
        uname = "fast";
        b = findViewById(R.id.NextUniSignUp);
        name=findViewById(R.id.nameAid);
        detail=findViewById(R.id.detailAid);

        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(name.length()!=0 && detail.length()!=0)
                {
                    if(obj.checkUniquenessAid(financialAidInfo.this, uname, name.getText().toString()))
                    {
                        //Intent in = new Intent(financialAidInfo.this, signupUni_Alumni.class);
                        Toast.makeText(financialAidInfo.this, "aagya", Toast.LENGTH_SHORT).show();
                        obj.insertAidDetails(financialAidInfo.this,name.getText().toString(),detail.getText().toString(),uname);
                        Intent in = new Intent(financialAidInfo.this, ManageUniMain.class);
                        startActivity(in);
                    }
                    else
                    {
                        Toast.makeText(financialAidInfo.this, "Financial Aid with this name Already Exists ", Toast.LENGTH_SHORT).show();

                    }

                }
                else
                {
                    Toast.makeText(financialAidInfo.this, "All fields should be filled correctly", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


}
