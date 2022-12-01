package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.Classes.Admin;
import com.example.myapplication.Classes.currentUser;
import com.example.myapplication.Classes.currentUserAdmin;

public class homePageAdmin extends AppCompatActivity {
    private Button feedbackBtn;
    private Admin obj;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_admin);

        currentUserAdmin ca  = currentUserAdmin.getInstance(obj);
        obj = ca.getA();
        Toast.makeText(this, "username:"+obj.getName(), Toast.LENGTH_SHORT).show();

        feedbackBtn = findViewById(R.id.fb);

        feedbackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(homePageAdmin.this, feedbackShowAdmin.class);
                startActivity(in);
            }
        });
    }
}