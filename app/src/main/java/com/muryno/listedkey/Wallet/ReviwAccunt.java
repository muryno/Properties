package com.muryno.listedkey.Wallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.muryno.listedkey.MainActivity;
import com.muryno.listedkey.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReviwAccunt extends AppCompatActivity {

    @BindView(R.id.bnk)
    TextView bnk;

    @BindView(R.id.accnt_nm)
    TextView accnt_nm;

    @BindView(R.id.accnt_num)
    TextView accnt_num;

    @BindView(R.id.acnt_typ)
    TextView acnt_typ;

    @BindView(R.id.cnf_accnt)
    Button accunt;

    String accnt_typ;
    String bnk_nm;
    String accnt_nam;
    String accnt_numb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviw_accunt);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras=getIntent().getExtras();
        accnt_typ = extras.getString("accnt_typ");
        bnk_nm = extras.getString("bnk_nm");
        accnt_nam = extras.getString("accnt_nam");
        accnt_numb = extras.getString("accnt_numb");

        bnk.setText(bnk_nm);
        accnt_nm.setText(accnt_nam);
        accnt_num.setText(accnt_numb);
        acnt_typ.setText(accnt_typ);

        accunt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mIntent);
                finish();
            }
        });
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
