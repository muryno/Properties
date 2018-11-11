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
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.github.javiersantos.bottomdialogs.BottomDialog;
import com.github.ybq.android.spinkit.style.ThreeBounce;
import com.muryno.listedkey.Database.userDetails.AddDeletUserViewModel;
import com.muryno.listedkey.Database.userDetails.User;
import com.muryno.listedkey.R;
import com.muryno.listedkey.model.preferencesDtails;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;



public class Signup extends AppCompatActivity implements TextWatcher{

    @BindView(R.id.editTextEmail)
    EditText mEmailView;

    @BindView(R.id.editloginfirstname)
    EditText mFirstnameView;

    @BindView(R.id.editsignuplastname)
    EditText mLastnameView;

    @BindView(R.id.editTextPassword)
    EditText mPasswordView;

    @BindView(R.id.registration)
    Button registration;
    @BindView(R.id.password_strength)
    TextView strengthView;

    @BindView(R.id.show_me)
    TextView Show_me;
    @BindView(R.id.SwitchID)
    Switch aSwitch;



    @BindView(R.id.spin_kit)
    ProgressBar progressBar;

    private AddDeletUserViewModel addDeletUserViewModel;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        Toolbar toolbar = (Toolbar) findViewById(R.id.sign_up);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        addDeletUserViewModel= ViewModelProviders.of(this).get(AddDeletUserViewModel.class);


        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               attemptRegister();

            }
        });


        mPasswordView.addTextChangedListener(this);


    }




    public void dialog(){
        if(Objects.equals(strengthView.getText().toString(), "Weak")){
            new BottomDialog.Builder(this)
                    .setTitle("Attention!!")
                    .setContent("Your password is to weak. For security reasons, Your password must be " +
                            "at least 8 characters e.g A-Z. With at least 1 number e.g 0-9 and 1 special character e.g @#% etc.")
                    .show();
            progressBar.setVisibility(View.GONE);
            return;
        }
    }
    public void progressbar(){
        ThreeBounce doubleBounce = new ThreeBounce();
        progressBar.setIndeterminateDrawable(doubleBounce);
        progressBar.setVisibility(View.VISIBLE);
    }

    private void attemptRegister() {

        // Store values at the time of the newPasrd attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        String frsName=mFirstnameView.getText().toString();
        String lastName=mLastnameView.getText().toString();


        if (TextUtils.isEmpty(frsName) ) {
            mFirstnameView.setError("Please Enter First Name");
            mFirstnameView.requestFocus();
            return ;
        }
        if (TextUtils.isEmpty(lastName)) {
            mLastnameView.setError("Please Enter Last Name");
            mLastnameView.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(email) && !(isEmailValid(email))) {
            mEmailView.setError("Please Enter valid email");
            mEmailView.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            mPasswordView.setError("Please Enter password");
            mPasswordView.requestFocus();
            return;
        }

        if(!aSwitch.isChecked()){
            Toast.makeText(this,"You have to agree to user Agreement",Toast.LENGTH_SHORT).show();
            aSwitch.requestFocus();
            return;
        }

        dialog();
        Signup();

    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }


    @Override
    public void afterTextChanged(Editable s) {
    }
    @Override
    public void beforeTextChanged(
            CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Show_me.setVisibility(View.VISIBLE);
        updatePasswordStrengthView(s.toString());
        registration.setVisibility(View.VISIBLE);
    }

    private void updatePasswordStrengthView(String password) {

//        ProgressBar progressBar = (ProgressBar) findViewById(R.userID.progressBar);

        if (TextView.VISIBLE != strengthView.getVisibility())
            return;

        if (password.isEmpty()) {
            strengthView.setText("");
//            progressBar.setProgress(0);
            return;
        }

        PasswordStrength str = PasswordStrength.calculateStrength(password);
        strengthView.setText(str.getText(this));
        strengthView.setTextColor(str.getColor());

//        progressBar.getProgressDrawable().setColorFilter(str.getColor(), android.graphics.PorterDuff.Mode.SRC_IN);
//        if (str.getText(this).equals("Weak")) {
//            progressBar.setProgress(25);
//        } else if (str.getText(this).equals("Medium")) {
//            progressBar.setProgress(50);
//        } else if (str.getText(this).equals("Strong")) {
//            progressBar.setProgress(75);
//        } else {
//            progressBar.setProgress(100);
//        }
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

    public void switchToggle(View view) {
       if(!(aSwitch.isChecked())){
           aSwitch.setChecked(true);
       }else{
           aSwitch.setChecked(false);
       }
    }

    public void Signup(){
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        String frsName=mFirstnameView.getText().toString();
        String lastName=mLastnameView.getText().toString();

        if((email.length()!=0 ) &&(password.length()!=0) && (frsName.length() !=0) && (lastName.length()!=0)){
            registration.setVisibility(View.GONE);
            progressbar();

        }else {
            Toasty.warning(getApplicationContext(), "Please make sure all the fields are entered", Toast.LENGTH_SHORT, true).show();

            return;
        }


    }
}
