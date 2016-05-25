package com.example.atamas.driving01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {


    EditText txtLogin;
    Button btnOk;
    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtLogin = (EditText)findViewById(R.id.txtUser);
        btnOk = (Button)findViewById(R.id.btnUser);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login.this.onClickLogin();
            }
        });

    }

    private void onClickLogin() {

        user = txtLogin.getText().toString();

        Intent intent = new Intent(Login.this,Profile.class);

        intent.putExtra("user", user);


        startActivity(intent);



    }
}
