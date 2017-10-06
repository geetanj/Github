package com.example.a1694163.github;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UserList extends AppCompatActivity {


    ArrayList<Users> usersarray;

    ListView userlst ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        userlst = (ListView) findViewById(R.id.lst_usr);

        Intent  i = getIntent();

        String key = i.getStringExtra("key");

        key  = key.replace(" ","+");

        String sch_url = "https://api.github.com/search/users?q="+key;


        System.out.println("Url  "+sch_url);

        new Getusername().execute(sch_url);

    }


    public class Getusername extends AsyncTask<String,Void,String>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Toast.makeText(getApplicationContext(),"Searching Users",Toast.LENGTH_LONG).show();
        }

        @Override
        protected String doInBackground(String... strings) {
            String url = strings[0];

            Httpresolver hr = new Httpresolver();

            String jsnstr = hr.makeServiceCall(url);


            return jsnstr;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            usersarray = new ArrayList<>();

            if(s!=null)
            {
                try
                {
                    JSONObject maijsn = new JSONObject(s);

                    JSONArray itmarray = maijsn.getJSONArray("items");

                   // System.out.println("JSON Array  "+itmarray.toString());


                    for (int i=0; i<itmarray.length(); i++)
                    {
                            JSONObject userobj = itmarray.getJSONObject(i);

                            usersarray.add(new Users(userobj.getString("login"),userobj.getString("url")));
                    }

                    Userlistadapter userlistadapter = new Userlistadapter(usersarray,UserList.this);

                    userlst.setAdapter(userlistadapter);

                }catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

}
