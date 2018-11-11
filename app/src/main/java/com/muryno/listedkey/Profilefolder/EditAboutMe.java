package com.muryno.listedkey.Profilefolder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.muryno.listedkey.R;

public class EditAboutMe extends AppCompatActivity {

    private EditText abt_me;

    private String about_me;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_about_me);

        abt_me=(EditText) findViewById(R.id.abt_me);
    }

    public void nextActivity(View view) {
        about_me= abt_me.getText().toString();
        Intent intent=new Intent(getApplicationContext(),Editprofile.class);
        Bundle extras = new Bundle();
        extras.putString("about_me",about_me);
        intent.putExtras(extras);
        startActivity(intent);
    }
}
