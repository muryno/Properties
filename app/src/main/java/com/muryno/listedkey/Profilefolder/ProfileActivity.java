package com.muryno.listedkey.Profilefolder;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.muryno.listedkey.Database.userDetails.User;
import com.muryno.listedkey.Database.userDetails.getUserViewModel;
import com.muryno.listedkey.R;
import com.muryno.listedkey.settings.SharePreManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {

    @BindView(R.id.user_profile)
    ImageView profilepics;

    @BindView(R.id.profile_name)
    TextView profileNam;


    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ButterKnife.bind(this);

        getUserViewModel viewMode= ViewModelProviders.of(this).get(getUserViewModel.class);
        user=viewMode.getUserLiveData();
        String displayName= user.getFullNam();
        profileNam.setText(displayName);

        String image= user.getImageUrl();

        if(image!=null) {
            Glide.with(this)
                    .load(image)
                    .apply(new RequestOptions().centerCrop().dontAnimate().dontTransform()).into(profilepics);
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

    public void editProfile(View view) {
        Intent intent=new Intent(getApplicationContext(),Editprofile.class);
        startActivity(intent);
    }

    public void verify(View view) {
        Intent intent=new Intent(getApplicationContext(),VerificatonsActivity.class);
        startActivity(intent);
    }
}
