package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Classes.accountCreator;

public class signupUni_Alumni extends AppCompatActivity {

    Button b1;
    Button b2;
    EditText e1;
    EditText e2;
    EditText e3;
    TextView error;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_uni_alumni);
        String uname=getIntent().getExtras().getString("name");
        b1 = findViewById(R.id.button2);
        //b2 = findViewById(R.id.button3);
        accountCreator obj = new accountCreator();
        obj.connectToDb(signupUni_Alumni.this);

        e1 = findViewById(R.id.username);
        e2 = findViewById(R.id.email);
        e3 = findViewById(R.id.editBatch);
        error = findViewById(R.id.error);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(e1.length()!=0 && e2.length()!=0 && e3.length()!=0)
                {
                    Toast.makeText(signupUni_Alumni.this, "aagya", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(signupUni_Alumni.this, ManageUniMain.class);
                    obj.insertAlumniDetails(signupUni_Alumni.this,e1.getText().toString(),e2.getText().toString(),Integer.valueOf(e3.getText().toString()),uname);
                    in.putExtra("name",uname);
                    startActivity(in);
                }
                else
                {
                    error.setText("All fields should be filled correctly");

                    CountDownTimer timer = new CountDownTimer(3000,1000) {
                        @Override
                        public void onTick(long l) {
                            error.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onFinish() {
                            error.setVisibility(View.INVISIBLE);
                        }
                    }.start();
                }

            }
        });

//        b2.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view) {
//                if(e1.length()!=0 && e2.length()!=0 && e3.length()!=0)
//                {
//                    Toast.makeText(signupUni_Alumni.this, "aagya", Toast.LENGTH_SHORT).show();
//                    obj.insertAlumniDetails(signupUni_Alumni.this,e1.getText().toString(),e2.getText().toString(),Integer.valueOf(e3.getText().toString()),uname);
//                    Intent in = new Intent(signupUni_Alumni.this, signupUni_Alumni.class);
//                    in.putExtra("name",uname);
//                    startActivity(in);
//                }
//                else
//                {
//                    error.setText("All fields should be filled correctly");
//
//                    CountDownTimer timer = new CountDownTimer(3000,1000) {
//                        @Override
//                        public void onTick(long l) {
//                            error.setVisibility(View.VISIBLE);
//                        }
//
//                        @Override
//                        public void onFinish() {
//                            error.setVisibility(View.INVISIBLE);
//                        }
//                    }.start();
//                }
//            }
//        });

    }


}
