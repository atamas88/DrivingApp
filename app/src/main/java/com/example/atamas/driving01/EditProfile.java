package com.example.atamas.driving01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.atamas.driving01.DAL.BEUser;
import com.example.atamas.driving01.DAL.Users;

import java.util.ArrayList;
import java.util.Objects;

public class EditProfile extends AppCompatActivity {


    private BEUser user;

    TextView firstName;
    TextView lastName;
    TextView email;
    TextView telNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Bundle extras = getIntent().getExtras();
        user = (BEUser) extras.getSerializable("user");


        firstName = (TextView)findViewById(R.id.txtEditFirstName);
        lastName = (TextView)findViewById(R.id.txtEditLastName);
        email = (TextView)findViewById(R.id.txtEditEmail);
        telNum = (TextView)findViewById(R.id.txtEditTel);

        firstName.setText(user.getFirstName());
        lastName.setText(user.getLastName());
        email.setText(user.getEmail());
        telNum.setText(user.getTelNum());
    }


}
