package com.muryno.listedkey.Profilefolder;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.github.ybq.android.spinkit.style.ThreeBounce;
import com.muryno.listedkey.Database.userDetails.UpdatUserViewModel;
import com.muryno.listedkey.Database.userDetails.User;
import com.muryno.listedkey.Database.userDetails.getUserViewModel;
import com.muryno.listedkey.R;
import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.enums.EPickType;
import com.vansuita.pickimage.listeners.IPickResult;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Editprofile extends AppCompatActivity implements IPickResult {


    private  String frsnam;
    private String lstnam;
    private String about;
    private String email;

    @BindView(R.id.profile_name)
    TextView profile_name;
    @BindView(R.id.about_mee)
    TextView abt_me;
    @BindView(R.id.gender)
    TextView gender;
    @BindView(R.id.genbut)
    ImageButton genbut;
    @BindView(R.id.mail)
    TextView mail;

    @BindView(R.id.numbr)
    TextView numbr;

    @BindView(R.id.mailbut)
    ImageButton mailbut;
    @BindView(R.id.photo)
    ImageButton profile;
    @BindView(R.id.user_profile)
    ImageView user_profile;

    private User user;
    private UpdatUserViewModel viewModel;

    @BindView(R.id.spin_kitt)
    ProgressBar progressBarr;

    AlertDialog alertDialog1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        getUserViewModel viewMode= ViewModelProviders.of(this).get(getUserViewModel.class);
        user=viewMode.getUserLiveData();
        viewModel=ViewModelProviders.of(this).get(UpdatUserViewModel.class);



        profile.setOnClickListener(v -> imagepicker());

        gettingIntent();


        String image= user.getImageUrl();
        if(image!=null) {
            Glide.with(this)
                    .load(image)
                    .apply(new RequestOptions().centerCrop().dontAnimate().dontTransform()).into(user_profile);
        }
        String fulname=user.fullNam;
        if(fulname!=null) {
            profile_name.setText(fulname);
        }
        String email=user.userEmail;
        if(email!=null) {
            mail.setText(email);
        }
        String num=user.phone_numbr;
        if(num!=null) {
            numbr.setText(num);
        }
    }

    private void gettingIntent() {

        Bundle extra=getIntent().getExtras();
        if(extra!= null) {
            frsnam = extra.getString("First_name");
            lstnam = extra.getString("last_name");
            about= extra.getString("about_me");
            email=extra.getString("Email");


            if(frsnam!=null && lstnam !=null) {
              String  name = frsnam + "  " + lstnam;
                profile_name.setText(name);
            }
            if(about!= null) {
                abt_me.setText(about);
            }
            if(email!=null){
                mail.setText(email);
            }
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

    public void imagepicker() {
        PickSetup setup = new PickSetup()
                .setTitle("Profile Picture")
                .setTitleColor(getResources().getColor(android.R.color.black))
                .setBackgroundColor(getResources().getColor(android.R.color.white))
                .setProgressText("Image Loading")
                .setProgressTextColor(getResources().getColor(android.R.color.black))
                .setCancelText("Cancel")
                .setCancelTextColor(getResources().getColor(android.R.color.black))
                .setButtonTextColor(getResources().getColor(android.R.color.black))
                .setFlip(true)
                .setMaxSize(500)
                .setPickTypes(EPickType.GALLERY, EPickType.CAMERA)
                .setCameraIcon(R.drawable.cameraa)
                .setGalleryIcon(R.drawable.galleryy)
                .setCameraButtonText("Take new image")
                .setGalleryButtonText("Select from galleryy")
                .setIconGravity(Gravity.LEFT)
                .setSystemDialog(false);

        PickImageDialog.build(setup).show(this);
    }

    @Override
    public void onPickResult(PickResult pickResult) {
        if (pickResult.getError() == null) {
            //If you want the Uri.
            //Mandatory to refresh image from Uri.
            //getImageView().setImageURI(null);

            //Setting the real returned image.
            //getImageView().setImageURI(r.getUri());
            Glide.
                    with(this)
                    .load(pickResult.getUri())
                    .into(user_profile);
            //If you want the Bitmap.
            // getImageView().setImageBitmap(r.getBitmap());

            //Image path
            //r.getPath();

        } else {
            //Handle possible errors
            //TODO: do what you have to do with r.getError();
            Toast.makeText(this, pickResult.getError().getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void editName(View view) {
        Intent intent=new Intent(getApplicationContext(),Editname.class);
        startActivity(intent);
    }

    public void editAbout(View view) {
        Intent intent=new Intent(getApplicationContext(),EditAboutMe.class);
        startActivity(intent);
    }

    public void radioButDialog(){
        CharSequence[] values = {" Male "," Female "," Other "};


        AlertDialog.Builder builder = new AlertDialog.Builder(Editprofile.this);

        builder.setTitle("Select Your Gender");

        builder.setSingleChoiceItems(values, -1, (dialog, item) -> {

            switch(item)
            {
                case 0:
                    String mal="Male";
                    gender.setText(mal);
                    genbut.setVisibility(View.GONE);
                    break;
                case 1:
                    String fm="Female";
                    gender.setText(fm);
                    genbut.setVisibility(View.GONE);
                    break;
                case 2:
                    String oth="Other";
                    gender.setText(oth);
                    genbut.setVisibility(View.GONE);
                    break;
            }
            alertDialog1.dismiss();
        });
        alertDialog1 = builder.create();
        alertDialog1.show();
    }


    public void gender(View view) {
        radioButDialog();
    }

    public void getMail(View view) {
        Intent intent=new Intent(getApplicationContext(),Updatemail.class);
        startActivity(intent);
    }

    public void getNumber(View view) {

    }





}
