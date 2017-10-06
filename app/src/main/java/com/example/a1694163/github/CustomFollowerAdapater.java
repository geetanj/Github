package com.example.a1694163.github;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 1694163 on 9/9/2017.
 */

public class CustomFollowerAdapater extends ArrayAdapter<Follower> {

    Context c;



    public CustomFollowerAdapater(Context context, Follower... objects) {
        super(context, R.layout.follower, objects);
        //Context is the context we are in... For our example it will be within a listview.
        //Layout: we are going to make a layout with feed in mind.
        //Objects: This will be whatever else we need to pass to it.
        c = context;


    }

    //This fun
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater myInflator = LayoutInflater.from(getContext());  //Instantiates a layout XML file into its corresponding object
        //In our test case it would our ListView object. Context will change where you use.
        //Think of it as prepare data.

        View customFeedView = myInflator.inflate(R.layout.follower, parent, false);

        /***Think of the inflator part as in it converts the xml layout into a widget!*****/
        ////In our case, it is adding that feed to the listview

        //Get our widgets

        TextView avatarName = (TextView)customFeedView.findViewById(R.id.followerName);
        ImageView myImage = (ImageView)customFeedView.findViewById(R.id.followerAvatar);


        //Get our values from Json
        String name = getItem(position).getName(); //GetItem gets the current item within the array.
        String pic = getItem(position).getImageurl();//As that item is a custom object we made.
       // String follower=getItem(position).getFollowerurl();    //We have access to message and picture.


        //Set our values
        avatarName.setText(name);

        new DownloadImageTask(myImage)
                .execute(pic);


        avatarName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(c,"Clicked On "+getItem(position).getName(),Toast.LENGTH_LONG).show();

                System.out.println("Follower link "+ getItem(position).getProurl());
            }
        });


        return customFeedView;  //Sending the view back, in this case as a row.
    }

}
