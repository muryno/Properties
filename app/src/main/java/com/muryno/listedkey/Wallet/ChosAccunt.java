package com.muryno.listedkey.Wallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.muryno.listedkey.R;

public class ChosAccunt extends AppCompatActivity {

    private RadioGroup radiogrp;
    private RadioButton savings;
    private RadioButton currnt;

    private boolean isChecking = true;
    private int mCheckedId = R.id.rbtn1;
    String Account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chos_accunt);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        radiogrp=(RadioGroup) findViewById(R.id.currency_rbtn);
        currnt=(RadioButton) findViewById(R.id.currnt);
        savings=(RadioButton) findViewById(R.id.savns);
        radiogrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mCheckedId = checkedId;
                }
                isChecking = true;

                clickedValue();
                savAccunTyp();
            }

        });

    }

    public void clickedValue() {

        switch (mCheckedId) {
            case R.id.currnt:
                Account = "Current";


                break;
            case R.id.savns:
                Account = "Savings";

                break;
        }

    }

    private void savAccunTyp(){
        if(Account != null) {
            Intent intent = new Intent(getApplicationContext(), AccuntInfo.class);
            Bundle extras = new Bundle();
            extras.putString("Account", Account);
            intent.putExtras(extras);
            startActivity(intent);
        }

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
}
