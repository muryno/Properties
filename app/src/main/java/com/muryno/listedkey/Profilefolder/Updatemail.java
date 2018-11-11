package com.muryno.listedkey.Profilefolder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.muryno.listedkey.R;

public class Updatemail extends AppCompatActivity {


    private EditText email;
    private EditText password;
    private String emal;
    private String paswrd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatemail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        email= findViewById(R.id.updat_mail);
        password= findViewById(R.id.paswrd);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void updated(View view) {
        emal=email.getText().toString();
        paswrd =password.getText().toString();
        Intent intent=new Intent(getApplicationContext(),Editprofile.class);
        Bundle extras = new Bundle();
        extras.putString("Email",emal);
        intent.putExtras(extras);
        startActivity(intent);
    }
}
