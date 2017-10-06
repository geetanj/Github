package com.example.a1694163.github;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FollowerActivity extends AppCompatActivity {

    EditText edt_serch;
    Button btn_serch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follower);

        edt_serch = (EditText) findViewById(R.id.edt_schur);
        btn_serch = (Button) findViewById(R.id.btn_urs);


        btn_serch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FollowerActivity.this,UserList.class);
                i.putExtra("key",edt_serch.getText().toString());
                //System.out.println("Followers Activity "+edt_serch.getText());

                startActivity(i);
            }
        });


    }


    

}
