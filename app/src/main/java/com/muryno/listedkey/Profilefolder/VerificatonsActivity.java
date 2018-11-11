package com.muryno.listedkey.Profilefolder;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;


import com.muryno.listedkey.Database.userDetails.User;
import com.muryno.listedkey.Database.userDetails.getUserViewModel;
import com.muryno.listedkey.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VerificatonsActivity extends AppCompatActivity {

    //status 1
    @BindView(R.id.eml_addr)
    ImageView eml_addr;

    //status 2
    @BindView(R.id.phn_num)
    ImageView phn_numm;

    //status 3
    @BindView(R.id.slfcap)
    ImageView slfcapp;
    //status 3
    @BindView(R.id.gvmt_id)
    ImageView govmt_id;

    //status 4
    @BindView(R.id.bnk_vrf)
    ImageView bnk_vrfn;

    //status 4
    @BindView(R.id.driv_id)
    ImageView driv_id;




    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificatons);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);


        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getUserViewModel viewMode= ViewModelProviders.of(this).get(getUserViewModel.class);
        user=viewMode.getUserLiveData();
        String status=user.getStatus();
        switch (status){
            case "0":
                eml_addr.setImageResource(R.drawable.no);
                phn_numm.setImageResource(R.drawable.no);
                slfcapp.setImageResource(R.drawable.no);
                govmt_id.setImageResource(R.drawable.no);
                bnk_vrfn.setImageResource(R.drawable.no);
                driv_id.setImageResource(R.drawable.no);
                break;
            case "1":
                eml_addr.setImageResource(R.drawable.yes);
                phn_numm.setImageResource(R.drawable.no);
                slfcapp.setImageResource(R.drawable.no);
                govmt_id.setImageResource(R.drawable.no);
                bnk_vrfn.setImageResource(R.drawable.no);
                driv_id.setImageResource(R.drawable.no);
                break;
            case "2":
                eml_addr.setImageResource(R.drawable.yes);
                phn_numm.setImageResource(R.drawable.yes);
                slfcapp.setImageResource(R.drawable.no);
                govmt_id.setImageResource(R.drawable.no);
                bnk_vrfn.setImageResource(R.drawable.no);
                driv_id.setImageResource(R.drawable.no);
                break;
            case "2+":
                eml_addr.setImageResource(R.drawable.yes);
                phn_numm.setImageResource(R.drawable.yes);
                slfcapp.setImageResource(R.drawable.no);
                govmt_id.setImageResource(R.drawable.no);
                bnk_vrfn.setImageResource(R.drawable.no);
                driv_id.setImageResource(R.drawable.no);
                break;

            case "3":
                eml_addr.setImageResource(R.drawable.yes);
                phn_numm.setImageResource(R.drawable.yes);
                slfcapp.setImageResource(R.drawable.yes);
                govmt_id.setImageResource(R.drawable.yes);
                bnk_vrfn.setImageResource(R.drawable.no);
                driv_id.setImageResource(R.drawable.no);
                break;
            case "3+":
                eml_addr.setImageResource(R.drawable.yes);
                phn_numm.setImageResource(R.drawable.yes);
                slfcapp.setImageResource(R.drawable.yes);
                govmt_id.setImageResource(R.drawable.yes);
                bnk_vrfn.setImageResource(R.drawable.no);
                driv_id.setImageResource(R.drawable.no);
                break;
            case "4":
                eml_addr.setImageResource(R.drawable.yes);
                phn_numm.setImageResource(R.drawable.yes);
                slfcapp.setImageResource(R.drawable.yes);
                govmt_id.setImageResource(R.drawable.yes);
                bnk_vrfn.setImageResource(R.drawable.no);
                driv_id.setImageResource(R.drawable.yes);
                break;


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

