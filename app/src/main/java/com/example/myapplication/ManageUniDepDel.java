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

public class ManageUniDepDel extends AppCompatActivity {

    private Button bt;
    private University uniobj;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_uni_department_info);

        bt = findViewById(R.id.button_next_to_program);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText depname = findViewById(R.id.Department_name);

                String Depname = depname.getText().toString();

                UniversityManager obj = new UniversityManager();
                obj.connectToDb(ManageUniDepDel.this);

                currentUserUni cu = currentUserUni.getInstance(uniobj);
                uniobj = cu.getU();

                String CurrentUniname = uniobj.getName();

                int depUnique = obj.UniqueDepartment(ManageUniDepDel.this,Depname,CurrentUniname);
                if(depUnique == 0)
                {
                    if(obj.DeleteDepartment(ManageUniDepDel.this,Depname,CurrentUniname) == 1)
                    {

                        Toast.makeText(ManageUniDepDel.this, "Department Successfully Deleted",Toast.LENGTH_LONG).show();
                        Intent in = new Intent(ManageUniDepDel.this, ManageUniMain.class);
                        startActivity(in);

                    }

                    else
                    {
                        Toast.makeText(ManageUniDepDel.this, "Please try again",Toast.LENGTH_LONG).show();
                        Intent in = new Intent(ManageUniDepDel.this, ManageUniDepDel.class);
                        startActivity(in);
                    }
                }

                else if( depUnique == 2)
                {
                    Toast.makeText(ManageUniDepDel.this, "Invalid University id",Toast.LENGTH_LONG).show();
                    Intent in = new Intent(ManageUniDepDel.this, ManageUniDepDel.class);
                    startActivity(in);
                }

                else if(depUnique == 1)
                {
                    Toast.makeText(ManageUniDepDel.this, "Invalid Department name",Toast.LENGTH_LONG).show();
                    Intent in = new Intent(ManageUniDepDel.this, ManageUniDepDel.class);
                    startActivity(in);
                }

                else
                {
                    Toast.makeText(ManageUniDepDel.this, "Error",Toast.LENGTH_LONG).show();
                    Intent in = new Intent(ManageUniDepDel.this, ManageUniMain.class);
                    startActivity(in);
                }

            }
        });


    }
}
