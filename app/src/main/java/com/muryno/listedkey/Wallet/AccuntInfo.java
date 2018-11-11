package com.muryno.listedkey.Wallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.muryno.listedkey.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AccuntInfo extends AppCompatActivity {

    @BindView(R.id.bank)
    Spinner bank;

    @BindView(R.id.acc_nm)
    EditText acc_nm;

    @BindView(R.id.accunt_num)
    EditText accunt_num;

    @BindView(R.id.cmf_accnt)
    EditText cmf_accnt;

    @BindView(R.id.next_pg)
    Button acc_nxttt;

    String accnt_typ;
    String bnk_nm;
    String accnt_nam;
    String accnt_numb;
    String cmfAccunNumb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accunt_info);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        setUpSpaceSpinner();

        Bundle extras=getIntent().getExtras();

        accnt_typ = extras.getString("Account");




        acc_nxttt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendAccntInfo();


            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void sendAccntInfo() {

        // Store values at the time of the login attempt.

        cmfAccunNumb=cmf_accnt.getText().toString();
        accnt_nam = acc_nm.getText().toString();
        accnt_numb = accunt_num.getText().toString();
        bnk_nm = bank.getSelectedItem().toString();

        if (TextUtils.isEmpty(accnt_nam) ) {
            acc_nm.setError("Please enter account holder name");
            acc_nm.requestFocus();
            return ;
        }
        if (TextUtils.isEmpty(accnt_numb)) {
            accunt_num.setError("Please enter account number");
            accunt_num.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(cmfAccunNumb)) {
            accunt_num.setError("Please enter account number");
            accunt_num.requestFocus();
            return;
        }

        if(accnt_numb.length() < 10 || accnt_numb.length() >10  ){
            accunt_num.setError("The account number must 10 digits");
            accunt_num.requestFocus();
            return;
        }

        if (!Objects.equals(cmfAccunNumb, accnt_numb)) {
            cmf_accnt.setError("The account number does not match");
            accunt_num.setError("The account number does not match");
            cmf_accnt.requestFocus();
            accunt_num.requestFocus();

            return;
        }
        senddata();
    }

    private void setUpSpaceSpinner() {


        // Create an ArrayAdapter using the string array and a default mSizeSpinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.bank, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the mSizeSpinner
        bank.setAdapter(adapter);

    }

    public void senddata(){

        accnt_nam = acc_nm.getText().toString();
        accnt_numb = accunt_num.getText().toString();
        bnk_nm = bank.getSelectedItem().toString();

        Intent intent=new Intent(getApplicationContext(),ReviwAccunt.class);
        Bundle extras = new Bundle();
        extras.putString("accnt_typ",accnt_typ);
        extras.putString("bnk_nm",bnk_nm);
        extras.putString("accnt_nam",accnt_nam);
        extras.putString("accnt_numb",accnt_numb);
        intent.putExtras(extras);
        startActivity(intent);
    }

}
