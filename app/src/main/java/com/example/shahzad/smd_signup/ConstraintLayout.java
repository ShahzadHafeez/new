package com.example.shahzad.smd_signup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ConstraintLayout extends AppCompatActivity {

    private String userEmail,userPassword,error;

    private EditText email;
    private EditText password;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private CheckBox check;
    private Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);

        initial();

    }


    private void initial() {

        signUp=(Button)findViewById(R.id.c_signup_btn);

        email=(EditText)findViewById(R.id.c_email);
        password=(EditText)findViewById(R.id.c_password);
        radioGroup=(RadioGroup)findViewById(R.id.c_radio_gender);
        check=(CheckBox)findViewById(R.id.c_chk_box);





        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);


                userEmail=email.getText().toString().trim();
                userPassword=password.getText().toString().trim();


                if (validation()) {


                    if (check.isChecked()) {
                        Toast.makeText(ConstraintLayout.this, "email : "
                                        + email.getText().toString() + " \n password : " + password.getText().toString() + " \n gender : "
                                        + radioButton.getText().toString() + " \n check status : checked ",
                                Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(ConstraintLayout.this, " please accept terms and conditions", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });





    }

    private boolean validation()
    {
        userEmail = email.getText().toString().trim();
        userPassword = password.getText().toString().trim();

        if(userEmail.isEmpty())
        {
            error = getResources().getString(R.string.erroremail);
            email.setError(error);
            return false;
        }
        if(userPassword.isEmpty())
        {
            error = getResources().getString(R.string.errorpassword);
            password.setError(error);
            return false;
        }
        return true;

    }

}
