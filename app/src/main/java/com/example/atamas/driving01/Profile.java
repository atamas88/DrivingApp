package com.example.atamas.driving01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.atamas.driving01.DAL.BECourse;
import com.example.atamas.driving01.DAL.BEUser;
import com.example.atamas.driving01.DAL.Courses;
import com.example.atamas.driving01.DAL.Users;

import java.util.ArrayList;
import java.util.Objects;

public class Profile extends AppCompatActivity {

    TextView username;
    Users dbUsers = new Users();
    ArrayList<BEUser> users = new ArrayList<>();
    ArrayList<BECourse> courses = new ArrayList<>();
    String user;
    TextView courseid;
    TextView coursename;
    TextView firstName;
    TextView lastName;
    TextView email;
    TextView telNum;
    BECourse course;
    TextView endDate;
    TextView startDate;


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
        endDate = (TextView)findViewById(R.id.lblEndDate);
        startDate = (TextView)findViewById(R.id.lblStartDate);

        firstName = (TextView)findViewById(R.id.lblFirstName);
        lastName = (TextView)findViewById(R.id.lblLastName);
        email = (TextView)findViewById(R.id.lblEmail);
        telNum = (TextView)findViewById(R.id.lblTel);
        Bundle extras = getIntent().getExtras();
        user = extras.getString("user");

        Log.d("profile", user);


        // load();

        Log.d("LO!!!!!!!!!!!!!!!!", "LOADEDEDEDD!!!!!!!!!");
        BEUser foundUser = findByName(user);

        Log.d("USER", foundUser.getName());

        username.setText(foundUser.getName());
        courseid.setText(foundUser.getCourse().toString());
        course = findCourseById(foundUser.getCourse());
        coursename.setText(course.getDescription());
       // endDate.setText(course.getEndDate());
        //startDate.setText(course.getStartDate());

        String[] date = course.getDate().split(",");

        String start = date[0].split(":")[1];

        String end = date[1].split(":")[1];

        start = start.substring(1, 11);

        end = end.substring(1, 11);

        startDate.setText(start);
        endDate.setText(end);

        firstName.setText(foundUser.getFirstName());
        lastName.setText(foundUser.getLastName());
        email.setText(foundUser.getEmail());
        telNum.setText(foundUser.getTelNum());


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
