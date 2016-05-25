package com.example.atamas.driving01.DAL;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by a.tamas on 23/05/2016.
 */
public class Users {

    private final String URL = "http://finalproject-mistah.rhcloud.com/api/users";

    private final String TAG = "USER";

    ArrayList<BEUser> m_users;

    public Users(){
        m_users = new ArrayList<BEUser>();
    }

    public void loadFake()
    {
        /*
        m_users.add(new BEUser("1", "a", "a", "a", "a"));
        m_users.add(new BEUser("2", "b", "a", "a", "a"));
        m_users.add(new BEUser("3", "c", "a", "a", "a"));
        */

        m_users.add(new BEUser("5464asd", "feri"));
    }

    public void loadAll()
    {
        try {
            String result = getContent(URL);

            if (result == null) return;


            JSONArray array = new JSONArray(result);

            for (int i = 0; i < array.length(); i++) {
                JSONObject d = array.getJSONObject(i);

                BEUser s = new BEUser(d.getString("_id"), d.getString("name"));

             //   BEUser s = new BEUser(d.getString("_id"), d.getString("name"), d.getString("firstName"), d.getString("lastName"), d.getString("email"));
                m_users.add(s);
            }

        } catch (JSONException e) {
            Log.e(TAG,
                    "There was an error parsing the JSON", e);
        } catch (Exception e)
        {  Log.d(TAG, "General exception in loadAll " + e.getMessage());
        }
    }

    public ArrayList<BEUser> getAll()
    { return m_users; }

    private String getContent(String urlString)
    {
        StringBuilder sb = new StringBuilder();
        try {


            java.net.URL url = new URL(urlString);
            Scanner s = new Scanner(url.openStream());

            while (s.hasNextLine()) {
                String line = s.nextLine();
                sb.append(line);
            }
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return sb.toString();
    }

    private String fromUrlToString(String urlParam)
    {
        BufferedReader reader=null;
        try
        {
            java.net.URL url = new URL(urlParam);
            URLConnection conn = url.openConnection();
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while((line = reader.readLine()) != null)
                sb.append(line + "\n");
            return sb.toString();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            Log.d(TAG, "URL malformed", e);
        }
        catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, "IO error", e);
        }
        return null;

    }
}
