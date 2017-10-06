package com.example.a1694163.github;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Harsh on 10/3/2017.
 */

public class Userlistadapter extends BaseAdapter {

    ArrayList<Users> usersArrayList = new ArrayList<>();
    Context c;
    LayoutInflater layoutInflater;


    public Userlistadapter(ArrayList<Users> usersArrayList, Context c) {
        this.usersArrayList = usersArrayList;
        this.c = c;
    }

    @Override
    public int getCount() {
        return usersArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return usersArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        if (layoutInflater ==  null)
        {
            layoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (view == null)
        {
            view = layoutInflater.inflate(R.layout.userlst_content,viewGroup,false);
        }


        TextView txt_v  = view.findViewById(R.id.txt_usernm);

        txt_v.setText(usersArrayList.get(i).getName());

        txt_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(c.getApplicationContext(),"user clicked "+usersArrayList.get(i).getName(),Toast.LENGTH_LONG).show();

                System.out.println("user clicked "+usersArrayList.get(i).getName());
                String proirl=usersArrayList.get(i).getProurl();

                Intent i=new Intent(c,MainActivity.class);
                i.putExtra("prourl",proirl);
                c.startActivity(i);

            }
        });


        return view;
    }
}
