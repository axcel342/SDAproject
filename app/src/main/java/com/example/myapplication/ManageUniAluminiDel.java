package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Classes.University;
import com.example.myapplication.Classes.UniversityManager;
import com.example.myapplication.Classes.currentUserUni;

public class ManageUniAluminiDel extends AppCompatActivity {

    private Button bt;
    private University uniobj;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_uni_alumini_del);

        bt = findViewById(R.id.button_alumini_del);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText alumname = findViewById(R.id.Alumini_name);

                String Alumname = alumname.getText().toString();

                UniversityManager obj = new UniversityManager();
                obj.connectToDb(ManageUniAluminiDel.this);

                currentUserUni cu = currentUserUni.getInstance(uniobj);
                uniobj = cu.getU();

                String CurrentUniname = uniobj.getName();

              //  int depUnique = obj.checkUniquenessAlumni(ManageUniAluminiDel.this,Alumname,CurrentUniname);
                if(obj.checkUniquenessAlumni(ManageUniAluminiDel.this,Alumname,CurrentUniname))
                {
                    if(obj.DeleteAlumini(ManageUniAluminiDel.this,Alumname,CurrentUniname) == 1)
                    {

                        Toast.makeText(ManageUniAluminiDel.this, "Alumini Successfully Deleted",Toast.LENGTH_LONG).show();
                        Intent in = new Intent(ManageUniAluminiDel.this, ManageUniMain.class);
                        startActivity(in);

                    }

                    else
                    {
                        Toast.makeText(ManageUniAluminiDel.this, "Invalid Alumini name",Toast.LENGTH_LONG).show();
                        Intent in = new Intent(ManageUniAluminiDel.this, ManageUniAluminiDel.class);
                        startActivity(in);
                    }
                }

                else
                {
                    Toast.makeText(ManageUniAluminiDel.this, "Please try again",Toast.LENGTH_LONG).show();
                    Intent in = new Intent(ManageUniAluminiDel.this, ManageUniAluminiDel.class);
                    startActivity(in);
                }

            }
        });


    }
}
