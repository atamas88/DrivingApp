package com.example.atamas.driving01.DAL;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
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
        m_courses.add(new BEUser("1", "a", "a", "a", "a"));
        m_courses.add(new BEUser("2", "b", "a", "a", "a"));
        m_courses.add(new BEUser("3", "c", "a", "a", "a"));
        */

        m_users.add(new BEUser("5464asd", "feri" , "5742fd8966fd7180489f6f43"));
    }

    public void loadAll()
    {
        m_users.add(new BEUser("00","proba", "5742fd8966fd7180489f6f43"));
        try {
            String result = getContent(URL);

            if (result == null) return;


            JSONArray array = new JSONArray(result);

            for (int i = 0; i < array.length(); i++) {
                JSONObject d = array.getJSONObject(i);

                BEUser s = new BEUser(d.getString("_id"), d.getString("name"), d.getString("course"), d.getString("firstName"), d.getString("lastName"), d.getString("email"), d.getString("telNum"));

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

    public void update(BEUser user)
    {
        InputStream inputStream = null;
        String result = "";

        try {
            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
            // 2. make POST request to the given URL
            HttpPut httpPUT = new
                    HttpPut("http://xxx.xx.x.xxx:xxxx/xxxxxxxy/webresources/net.xxxxxx.users/3");
            String json = "";
            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("idUser","3");
            jsonObject.put("name","Mark");
            jsonObject.put("pass","1234");
            jsonObject.put("rol","554");
            jsonObject.put("usuario","mark");




            // 4. convert JSONObject to JSON to String
            json = jsonObject.toString();

            // 5. set json to StringEntity
            StringEntity se = new StringEntity(json);
            // 6. set httpPost Entity
            httpPUT.setEntity(se);
            // 7. Set some headers to inform server about the type of the content
            httpPUT.setHeader("Accept", "application/json");
            httpPUT.setHeader("Content-type", "application/json");
            // 8. Execute POST request to the given URL
            HttpResponse httpResponse = httpclient.execute(httpPUT);
            // 9. receive response as inputStream
            //                  inputStream = httpResponse.getEntity().getContent();
            //                  // 10. convert inputstream to string
            //                  if(inputStream != null)
            //                      result = convertInputStreamToString(inputStream);
            //                  else
            //                      result = "Did not work!";
        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }
    }
}
