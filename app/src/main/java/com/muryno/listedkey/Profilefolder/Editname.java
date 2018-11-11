package com.muryno.listedkey.Profilefolder;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.style.ThreeBounce;
import com.muryno.listedkey.Database.userDetails.User;
import com.muryno.listedkey.Database.userDetails.getUserViewModel;
import com.muryno.listedkey.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Editname extends AppCompatActivity {


    private String firstnm;
    private String lastnm;

    @BindView(R.id.first_name)
    EditText first_name;
    @BindView(R.id.last_name)
    EditText last_name;

    @BindView(R.id.spin_kit)
    ProgressBar progressBar;

    @BindView(R.id.updt_name)
    Button updt_name;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editname);
        ButterKnife.bind(this);

        getUserViewModel viewMode= ViewModelProviders.of(this).get(getUserViewModel.class);
        user=viewMode.getUserLiveData();

        updt_name.setOnClickListener(view -> {
            editname();
        });
    }

    public  void editname(){
        showprogressbar();
        updt_name.setVisibility(View.GONE);

        String authId =user.getAuth_id();
        String sessn=user.getSession();
        int userId =user.getUserId();
        firstnm=first_name.getText().toString();
        lastnm =last_name.getText().toString();


        Intent intent=new Intent(getApplicationContext(),Editprofile.class);
        startActivity(intent);

    }
    public void showprogressbar() {
        ThreeBounce doubleBounce = new ThreeBounce();
        progressBar.setIndeterminateDrawable(doubleBounce);
        progressBar.setVisibility(View.VISIBLE);
    }
}
