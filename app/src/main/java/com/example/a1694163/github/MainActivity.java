package com.example.a1694163.github;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CallBackMe  {

    ListView mylistview;
    ImageView img;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=(ImageView)findViewById(R.id.avatar);
        txt=(TextView)findViewById(R.id.login);
        mylistview=(ListView)findViewById(R.id.listview);

        Intent i=getIntent();

        String url=i.getStringExtra("prourl");
        System.out.println("prourl "+url);

        String flw=url+"/followers";
        System.out.println("chk flw url "+flw);
        new userdata().execute(url);
        JsonRetriever.RetrieveFromURL(this, url+"/followers", this);
    }

    @Override
    public void CallThis(String jsonText) {

        try {
            JSONArray jArray = new JSONArray(jsonText);
            Follower[] followers = new Follower[jArray.length()];

            for(int position = 0; position < jArray.length(); position++)
            {
                JSONObject jObj = jArray.getJSONObject(position);
                String name = jObj.getString("login");
                String imageURL = jObj.getString("avatar_url");
                String followerurl = jObj.getString("followers_url");
                String url = jObj.getString("url");

                Follower current = new Follower(imageURL, name, followerurl,url);
                followers[position] = current;
            }

            CustomFollowerAdapater cfa = new CustomFollowerAdapater(MainActivity.this, followers);
            mylistview.setAdapter(cfa);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    public void clicked(View v)
    {
        Toast.makeText(MainActivity.this, "RAWR", Toast.LENGTH_SHORT).show();
    }

    public class userdata extends AsyncTask<String,Void,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {

            String url = strings[0];

            System.out.println("Do in bacck ground "+ url);

            Httpresolver hr = new Httpresolver();

           String jsnpro = hr.makeServiceCall(url);
           System.out.println("do in background "+jsnpro);

            return jsnpro;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            System.out.println("check me "+s);

            if (s!=null){
                try {
                    JSONObject jsonmain=new JSONObject(s);
                    Picasso.with(MainActivity.this).load(jsonmain.getString("avatar_url")).into(img);
                    txt.setText(jsonmain.getString("name"));

                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }
    }

}
