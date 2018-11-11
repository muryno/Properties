package com.muryno.listedkey.AuthAtivities;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.ybq.android.spinkit.style.ThreeBounce;
import com.muryno.listedkey.Database.userDetails.AddDeletUserViewModel;
import com.muryno.listedkey.Database.userDetails.User;
import com.muryno.listedkey.R;
import com.muryno.listedkey.model.preferencesDtails;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;


public class Login extends AppCompatActivity  implements TextWatcher {
    @BindView(R.id.editTextPassword)
    EditText mPasswordView;

    @BindView(R.id.loginEmail)
    EditText mEmailView;

    @BindView(R.id.spin_kit)
    ProgressBar progressBar;


    @BindView(R.id.login)
    Button login;
    User user;
    private AddDeletUserViewModel addDeletUserViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = (Toolbar) findViewById(R.id.log_in);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayShowTitleEnabled(false);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ButterKnife.bind(this);



        mPasswordView.addTextChangedListener(this);


        addDeletUserViewModel= ViewModelProviders.of(this).get(AddDeletUserViewModel.class);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
                Login();
            }
        });

    }




    public void progressbar() {
        ThreeBounce doubleBounce = new ThreeBounce();
        progressBar.setIndeterminateDrawable(doubleBounce);
        progressBar.setVisibility(View.VISIBLE);
    }

    private void attemptLogin() {

        // Store values at the time of the newPasrd attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();


        if (TextUtils.isEmpty(email) && (!isEmailValid(email))) {
            mEmailView.setError("Please Enter valid email");
            mEmailView.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            mPasswordView.setError("Please Enter password");
            mPasswordView.requestFocus();
            return;
        }




    }


    @Override
    public void afterTextChanged(Editable s) {
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        login.setVisibility(View.VISIBLE);
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
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



    public void Login() {
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();



        if ((email.length() != 0) && (password.length() != 0)) {
            login.setVisibility(View.GONE);
            progressbar();

        } else {
            Toasty.warning(getApplicationContext(), "Please make sure all the fields are entered", Toast.LENGTH_SHORT, true).show();

            return;
        }


    }

    public void forgtPaswrd(View view) {

    }
}
