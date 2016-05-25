package com.example.atamas.driving01;

import android.os.AsyncTask;

import com.example.atamas.driving01.DAL.BEUser;
import com.example.atamas.driving01.DAL.Users;

import java.util.ArrayList;

/**
 * Created by a.tamas on 23/05/2016.
 */
public class InitializeTask extends AsyncTask<
        Users, // collection of PoliceDistricts to execute
        Void, // to type of progress info
        ArrayList<BEUser>>

{
    MainActivity m_context;

    public InitializeTask(MainActivity context)
    {
        m_context = context;
    }
    @Override
    protected ArrayList<BEUser> doInBackground(Users... ms) {
        // params comes from the execute()

        ms[0].loadAll();
        return ms[0].getAll();
    }
    // onPostExecute displays the results of the AsyncTask.doInBackground().
    // this method is invoked by the GUI thread
    @Override
    protected void onPostExecute(final ArrayList<BEUser> stations) {
        m_context.initializeData(stations);

    }
}
