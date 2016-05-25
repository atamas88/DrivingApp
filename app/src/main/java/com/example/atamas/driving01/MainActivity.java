package com.example.atamas.driving01;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.atamas.driving01.DAL.BEUser;
import com.example.atamas.driving01.DAL.Users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/****
public class MainActivity extends ListActivity {

    String TAG = "USER";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitializeTask t = new InitializeTask(this);
        t.execute(new Users());

    }


    private List<Map<String, String>> asListMap(List<BEUser> src) {
        List<Map<String, String>> res = new ArrayList<Map<String, String>>();
        for (BEUser s : src) {
            Map<String, String> e = new HashMap<String, String>();
            e.put("id", "" + s.getId());
            e.put("name", s.getName());
            res.add(e);
        }
        return res;
    }


    public SimpleAdapter createAdapter(ArrayList<BEUser> ms) {
        SimpleAdapter adapter = new SimpleAdapter(this,
                asListMap(ms),
                R.layout.cell,
                new String[]{"id", "name"},
                new int[]{R.id.txtNumber, R.id.txtName});

        return adapter;
    }
/*
    public SimpleAdapter createAdapter(ArrayList<BEUser> ms) {
        SimpleAdapter adapter = new SimpleAdapter(this,
                asListMap(ms),
                R.layout.prof,
                new String[]{"name"},
                new int[]{R.id.txtName});

        return adapter;
    }
/*
    public SimpleAdapter createAdapter(ArrayList<BEUser> ms) {
        SimpleAdapter adapter = new SimpleAdapter(this,
                asListMap(ms),
                R.layout.cell,
                new String[]{"name"},
                new int[]{R.id.txtName});

        return adapter;
    }


    public void initializeData(final ArrayList<BEUser> pd) {
        ListAdapter adapter = createAdapter(pd);

                setListAdapter(adapter);
        Log.d(TAG, "Adapter attached");

        ///hh

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                BEUser s = pd.get(position);

                String msg = s.getName();

                Toast.makeText(getApplicationContext(),
                        msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
*/