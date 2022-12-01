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

public class ManageUniFinancialAidDel extends AppCompatActivity {
    private Button bt;
    private University uniobj;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_uni_financialaid_del);

        bt = findViewById(R.id.button_FinancialAid_del);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText f_aidname = findViewById(R.id.FinancialAid_name);

                String F_aidname = f_aidname.getText().toString();

                UniversityManager obj = new UniversityManager();
                obj.connectToDb(ManageUniFinancialAidDel.this);

                currentUserUni cu = currentUserUni.getInstance(uniobj);
                uniobj = cu.getU();

                String CurrentUniname = uniobj.getName();

                //  int depUnique = obj.checkUniquenessAlumni(ManageUniAluminiDel.this,Alumname,CurrentUniname);
                if(!obj.checkUniquenessAid(ManageUniFinancialAidDel.this, CurrentUniname,F_aidname))
                {
                    if(obj.DeleteFAid(ManageUniFinancialAidDel.this,F_aidname,CurrentUniname) == 1)
                    {

                        Toast.makeText(ManageUniFinancialAidDel.this, "Faculty Successfully Deleted",Toast.LENGTH_LONG).show();
                        Intent in = new Intent(ManageUniFinancialAidDel.this, ManageUniMain.class);
                        startActivity(in);

                    }

                    else
                    {
                        Toast.makeText(ManageUniFinancialAidDel.this, "Invalid name",Toast.LENGTH_LONG).show();
                        Intent in = new Intent(ManageUniFinancialAidDel.this, ManageUniFinancialAidDel.class);
                        startActivity(in);
                    }
                }

                else
                {
                    Toast.makeText(ManageUniFinancialAidDel.this, "Please try again",Toast.LENGTH_LONG).show();
                    Intent in = new Intent(ManageUniFinancialAidDel.this, ManageUniFinancialAidDel.class);
                    startActivity(in);
                }

            }
        });


    }


}
