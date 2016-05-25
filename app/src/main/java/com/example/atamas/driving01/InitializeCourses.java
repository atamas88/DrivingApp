package com.example.atamas.driving01;

import android.os.AsyncTask;

import com.example.atamas.driving01.DAL.BECourse;
import com.example.atamas.driving01.DAL.BEUser;
import com.example.atamas.driving01.DAL.Courses;
import com.example.atamas.driving01.DAL.Users;

import java.util.ArrayList;

/**
 * Created by a.tamas on 25/05/2016.
 */
public class InitializeCourses  extends AsyncTask<
        Courses, // collection of PoliceDistricts to execute
        Void, // to type of progress info
        ArrayList<BECourse>>

{
    Profile m_context;

    public InitializeCourses(Profile context)
    {
        m_context = context;
    }
    @Override
    protected ArrayList<BECourse> doInBackground(Courses... ms) {
        // params comes from the execute()

        ms[0].loadAll();
        return ms[0].getAll();
    }
    // onPostExecute displays the results of the AsyncTask.doInBackground().
    // this method is invoked by the GUI thread\

    @Override
    protected void onPostExecute(final ArrayList<BECourse> courses)
    {
        m_context.initializeCourseData(courses);
    }


}