package com.example.atamas.driving01;

import android.os.AsyncTask;
import android.util.Log;

import com.example.atamas.driving01.DAL.BEUser;
import com.example.atamas.driving01.DAL.Users;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by a.tamas on 26/05/2016.
 */
public class PutUser extends AsyncTask<String, String, String> {

    String TAG = "KOLBI";
    EditProfile m_context;

    public PutUser(EditProfile context) {
        m_context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        String JsonResponse = null;
        String JsonDATA = params[0];
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        int start = JsonDATA.indexOf("_") + 6;
        String id = JsonDATA.substring(start, start + 24);
        try {
            URL url = new URL("http://finalproject-mistah.rhcloud.com/api/users/" + id);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            // is output buffer writter
            urlConnection.setRequestMethod("PUT");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("Accept", "application/json");
//set headers and method

            Writer writer = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8"));
            writer.write(JsonDATA);

// json datas
            writer.close();

            InputStream inputStream = urlConnection.getInputStream();
//input stream
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Nothing to do.
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String inputLine;
            while ((inputLine = reader.readLine()) != null)
                buffer.append(inputLine + "\n");
            if (buffer.length() == 0) {
                // Stream was empty. No point in parsing.
                return null;
            }
            JsonResponse = buffer.toString();
//response data

            //send to post execute
            return JsonResponse;




        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e(TAG, "Error closing stream", e);
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {

    }

}
