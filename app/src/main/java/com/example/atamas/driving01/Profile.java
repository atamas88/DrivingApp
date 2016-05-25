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

import com.example.atamas.driving01.DAL.BECourse;
import com.example.atamas.driving01.DAL.BEUser;
import com.example.atamas.driving01.DAL.Courses;
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
    ArrayList<BECourse> courses = new ArrayList<>();
    String user;
    TextView courseid;
    TextView coursename;
    BECourse course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        InitializeTask t = new InitializeTask(this);
        t.execute(new Users());

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
            foundUser = new BEUser("00", "nem ures", "00");
        }
        else
        {
            foundUser = new BEUser("00", "ures", "01");
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

    public void _continue()
    {

        username = (TextView)findViewById(R.id.txtUserName);
        courseid = (TextView)findViewById(R.id.txtCourseId);
        coursename = (TextView)findViewById(R.id.txtCourseName);
        Bundle extras = getIntent().getExtras();
        user = extras.getString("user");

        Log.d("profile", user);


        // load();

        Log.d("LO!!!!!!!!!!!!!!!!", "LOADEDEDEDD!!!!!!!!!");
        BEUser foundUser = findByName(user);

        Log.d("USER",foundUser.getName());

        username.setText(foundUser.getName());
        courseid.setText(foundUser.getCourse().toString());
        course = findCourseById(foundUser.getCourse());
        coursename.setText(course.getDescription());


    }

    public void initializeData(final ArrayList<BEUser> pd) {
        users.clear();
        for(int i = 0; i < pd.size(); ++i)
        {
            users.add(pd.get(i));
        }

        InitializeCourses c = new InitializeCourses(this);
        c.execute(new Courses());


    }

    public void initializeCourseData(final ArrayList<BECourse> co)
    {
        courses.clear();
        for(int i = 0; i < co.size(); ++i)
        {
            courses.add(co.get(i));
        }

        _continue();
    }


    public BECourse findCourseById(String id)
    {
        BECourse course = new BECourse("00", "course not found", 0);

        for(int i = 0; i < courses.size(); ++i)
        {
            if(Objects.equals(courses.get(i).getId(), id))
            {
                course = courses.get(i);
            }
        }
        return course;
    }




}
