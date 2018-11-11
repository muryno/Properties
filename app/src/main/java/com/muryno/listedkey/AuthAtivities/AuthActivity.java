package com.muryno.listedkey.AuthAtivities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.muryno.listedkey.Database.userDetails.AddDeletUserViewModel;
import com.muryno.listedkey.Database.userDetails.User;
import com.muryno.listedkey.Database.userDetails.getUserViewModel;
import com.muryno.listedkey.MainActivity;
import com.muryno.listedkey.R;
import com.muryno.listedkey.model.preferencesDtails;
import com.muryno.listedkey.settings.SharePreManager;

import org.json.JSONException;

import java.util.Arrays;
import java.util.Objects;

import es.dmoral.toasty.Toasty;


public class AuthActivity extends AppCompatActivity  implements GoogleApiClient.OnConnectionFailedListener {


    private static final String TAG=AuthActivity.class.getSimpleName();
    private CallbackManager mCallbackManager;
    private GoogleApiClient googleApiClient;
    private static final int ReqCode = 80;
    private Button mFacebook;
    private static final String EMAIL = "email";
    private static final String ProfilePics = "public_profile";

    String fbid;




    private AddDeletUserViewModel addDeletUserViewModel;
    User user;

    private AccessToken mAccessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        mFacebook=(Button) findViewById(R.id.facebooklogin);



        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail().build();

        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,
                this).addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions).build();

        addDeletUserViewModel= ViewModelProviders.of(this).get(AddDeletUserViewModel.class);



        //facebook signin

        FacebookSdk.sdkInitialize(this.getApplicationContext());

        FacebookSdk.sdkInitialize(getApplicationContext());
        Log.d("AppLog", "key:" + FacebookSdk.getApplicationSignature(this));

        mCallbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(mCallbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.d("Success", "Login");
                        fbid=loginResult.getAccessToken().getUserId();

                        mAccessToken = loginResult.getAccessToken();
                        getUserProfile(mAccessToken);

                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(AuthActivity.this, "Login Cancel", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Toast.makeText(AuthActivity.this, exception.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        mFacebook.setOnClickListener(view -> LoginManager.getInstance().logInWithReadPermissions(
                AuthActivity.this, Arrays.asList(EMAIL,ProfilePics)));
        underling();
        secUnderling();
        thirUnderling();
        forUnderling();

    }

    @Override
    public void onStart() {
        super.onStart();


        if (SharePreManager.getmInstance(this).isLoggedIn()) {
            if(!Objects.equals(SharePreManager.getmInstance(this).RetrieveSignin().session, "")){

                getUserViewModel viewMode= ViewModelProviders.of(this).get(getUserViewModel.class);
                user=viewMode.getUserLiveData();
                String status = user.getStatus();
                String session=user.getSession();
                int uset_id=user.getUserId();
                if (uset_id >0) {


                    if (session != null) {
                        if (status != null) {
                            switch (status) {
                                case "0": {
                                    //has account but not verify

                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                    break;
                                }
                                case "1": {
                                    //has verify mail to phone number
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                    break;
                                }
                                case "2": {
                                    //has verify mail and phone number to picture- just kyc
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                    break;
                                }
                                case "2+": {
                                    //has verify mail and phone number to picture- just kyc
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                    break;
                                }
                                case "3": {
                                    //has verify mail and phone number to picture- just kyc
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                    break;
                                }
                                case "3+": {
                                    //has verify mail and phone number to picture- just kyc
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                    break;
                                }
                                case "4": {
                                    //has verify mail and phone number to picture- just kyc
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                    break;
                                }
                            }
                        }

                    }
                }
            }
        }
    }



    public void googleSinIn(View view) {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(signInIntent, ReqCode);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ReqCode){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleGoogleResult(result);
        }
        if(mCallbackManager.onActivityResult(requestCode, resultCode, data)) {

        }
    }

    public void signIn(View view) {
        Intent login=new Intent(AuthActivity.this, Login.class);
        startActivity(login);
    }

    public void signup(View view) {
        Intent signup=new Intent(AuthActivity.this, Signup.class);
        startActivity(signup);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


    public void handleGoogleResult(GoogleSignInResult result){

        //TODO 2
        if (result.isSuccess()) {
            GoogleSignInAccount userAccount = result.getSignInAccount();


            assert userAccount != null;
            String pictur= Objects.requireNonNull(userAccount.getPhotoUrl()).toString();
            String fullname= userAccount.getDisplayName();
            String goglId=  userAccount.getId();
            assert fullname != null;
            String firstname = fullname.split(" (?!.* )")[0];
            String lastname = fullname.split(" (?!.* )")[1];
            String email=  userAccount.getEmail();

            Toasty.success(getApplicationContext(), "Success!", Toast.LENGTH_SHORT, true).show();


            addDeletUserViewModel.addUser(new User(
                    "1",
                    fullname,firstname,lastname,
                    "1",pictur,email,
                    100,null,"4",null,"abcd"));



        }
    }


    private void getUserProfile(AccessToken currentAccessToken) {
        GraphRequest request = GraphRequest.newMeRequest(
                currentAccessToken, (object, response) -> {
                    try {
                        //You can fetch user info like this…


                        String pictur=object.getJSONObject("picture").getJSONObject("data").getString("url");
                        String fullname=object.getString("name");
                        String fbId=  object.getString("id");
                        String firstname = fullname.split(" (?!.* )")[0];
                        String lastname = fullname.split(" (?!.* )")[1];
                        String email= object.getString("email");



                        addDeletUserViewModel.addUser(new User(
                                "1",
                                fullname,firstname,lastname,
                                "1",pictur,email,
                                100,null,"4",null,"abcd"));




                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                });
        Bundle parameters = new Bundle();
        parameters.putString("fields","id,name,email,picture.width(200)");
        request.setParameters(parameters);
        request.executeAsync();

    }


    public void user_agreem(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/muryno"));
        startActivity(browserIntent);
    }

    public void term_servic(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/muryno"));
        startActivity(browserIntent);
    }

    public void payment(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/muryno"));
        startActivity(browserIntent);
    }

    public void priv_policy(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/muryno"));
        startActivity(browserIntent);
    }
    public void underling(){
        TextView textView = findViewById(R.id.term_three);
        SpannableString content = new SpannableString("User Agreement,");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView.setText(content);
    }
    public void secUnderling(){
        TextView textView = findViewById(R.id.term_four);
        SpannableString content = new SpannableString("Terms of Service,");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView.setText(content);
    }
    public void thirUnderling(){
        TextView textView = findViewById(R.id.term_fiv);
        SpannableString content = new SpannableString("Payment,");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView.setText(content);
    }
    public void forUnderling(){
        TextView textView = findViewById(R.id.term_sevn);
        SpannableString content = new SpannableString("Privacy Policy.");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView.setText(content);
    }
}
