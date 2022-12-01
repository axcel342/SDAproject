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

public class ManageUniFacultyDel extends AppCompatActivity {
    private Button bt;
    private University uniobj;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_uni_faculty_del);

        bt = findViewById(R.id.button_Faculty_del);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText facultyname = findViewById(R.id.Faculty_name);
                EditText email = findViewById(R.id.FacultyEmail);

                String Facultyname = facultyname.getText().toString();
                String Facultyemail = email.getText().toString();

                UniversityManager obj = new UniversityManager();
                obj.connectToDb(ManageUniFacultyDel.this);

                currentUserUni cu = currentUserUni.getInstance(uniobj);
                uniobj = cu.getU();

                String CurrentUniname = uniobj.getName();

                //  int depUnique = obj.checkUniquenessAlumni(ManageUniAluminiDel.this,Alumname,CurrentUniname);
                if(obj.checkUniquenessFaculty(ManageUniFacultyDel.this, Facultyname,Facultyemail))
                {
                    if(obj.DeleteFaculty(ManageUniFacultyDel.this,Facultyemail,CurrentUniname) == 1)
                    {

                        Toast.makeText(ManageUniFacultyDel.this, "Faculty Successfully Deleted",Toast.LENGTH_LONG).show();
                        Intent in = new Intent(ManageUniFacultyDel.this, ManageUniMain.class);
                        startActivity(in);

                    }

                    else
                    {
                        Toast.makeText(ManageUniFacultyDel.this, "Invalid Faculty name",Toast.LENGTH_LONG).show();
                        Intent in = new Intent(ManageUniFacultyDel.this, ManageUniFacultyDel.class);
                        startActivity(in);
                    }
                }

                else
                {
                    Toast.makeText(ManageUniFacultyDel.this, "Please try again",Toast.LENGTH_LONG).show();
                    Intent in = new Intent(ManageUniFacultyDel.this, ManageUniFacultyDel.class);
                    startActivity(in);
                }

            }
        });


    }


}
