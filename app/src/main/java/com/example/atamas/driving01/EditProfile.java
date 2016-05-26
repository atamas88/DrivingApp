package com.example.atamas.driving01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.atamas.driving01.DAL.BEUser;
import com.example.atamas.driving01.DAL.Users;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class EditProfile extends AppCompatActivity {


    private BEUser user;

    TextView firstName;
    TextView lastName;
    TextView email;
    TextView telNum;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Bundle extras = getIntent().getExtras();
        user = (BEUser) extras.getSerializable("user");



        firstName = (TextView) findViewById(R.id.txtEditFirstName);
        lastName = (TextView) findViewById(R.id.txtEditLastName);
        email = (TextView) findViewById(R.id.txtEditEmail);
        telNum = (TextView) findViewById(R.id.txtEditTel);

        firstName.setText(user.getFirstName());
        lastName.setText(user.getLastName());
        email.setText(user.getEmail());
        telNum.setText(user.getTelNum());

        btnUpdate = (Button)findViewById(R.id.btnUpdate);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setFirstName(firstName.getText().toString());
                user.setLastName(lastName.getText().toString());
                user.setEmail(email.getText().toString());
                user.setTelNum(telNum.getText().toString());
                EditProfile.this.onClickUpdate(user);
            }
        });




    }

    private void onClickUpdate(BEUser user) {
        JSONObject post_dict = new JSONObject();

        try {


            post_dict.put("firstName", user.getFirstName());
            post_dict.put("lastName", user.getLastName());
            post_dict.put("email", user.getEmail());
            post_dict.put("telNum", user.getTelNum());
            post_dict.put("_id", user.getId());

        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (post_dict.length() > 0) {
            new PutUser(this).execute(String.valueOf(post_dict));

        }

    }
}
