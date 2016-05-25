package com.example.atamas.driving01;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.atamas.driving01.DAL.BEUser;
import com.example.atamas.driving01.DAL.Users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Profile extends AppCompatActivity {

    TextView username;
    Users dbUsers = new Users();
    ArrayList<BEUser> users = new ArrayList<>();
    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        InitializeTask t = new InitializeTask(this);
        t.execute(new Users());

        username = (TextView)findViewById(R.id.txtUserName);


        Bundle extras = getIntent().getExtras();
        user = extras.getString("user");

        Log.d("profile", user);


        load();

        Log.d("LO!!!!!!!!!!!!!!!!", "LOADEDEDEDD!!!!!!!!!");
        BEUser foundUser = findByName(user);

        Log.d("USER",foundUser.getName());

        username.setText(foundUser.getName());



    }

    public void load()
    {
        dbUsers.loadAll();
        users = dbUsers.getAll();

    }

    public BEUser findByName(String user)
    {
        BEUser foundUser;
        if(users.size() != 0)
        {
            foundUser = new BEUser("00", "nem ures");
        }
        else
        {
            foundUser = new BEUser("00", "ures");
        }

        for(int i = 0; i < users.size(); ++i)
        {
            if(Objects.equals(users.get(i).getName(), user))
            {
                foundUser = users.get(i);
            }
        }

        return foundUser;
    }


}
