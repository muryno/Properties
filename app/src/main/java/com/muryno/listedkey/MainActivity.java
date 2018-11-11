package com.muryno.listedkey;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.github.ybq.android.spinkit.style.ThreeBounce;
import com.muryno.listedkey.AuthAtivities.AuthActivity;
import com.muryno.listedkey.Database.userDetails.AddDeletUserViewModel;
import com.muryno.listedkey.Database.userDetails.UpdatUserViewModel;
import com.muryno.listedkey.Database.userDetails.User;
import com.muryno.listedkey.Database.userDetails.getUserViewModel;
import com.muryno.listedkey.Profilefolder.ProfileActivity;
import com.muryno.listedkey.Wallet.ChosePaidType;
import com.muryno.listedkey.inbox.InboxActivity;
import com.muryno.listedkey.mainui.DetailActivity;
import com.muryno.listedkey.model.MainLst;
import com.muryno.listedkey.pagingAdapter.NetworkState;
import com.muryno.listedkey.pagingAdapter.adater.ListItemClickListener;
import com.muryno.listedkey.pagingAdapter.adater.ListingDiffUtilItemCallback;
import com.muryno.listedkey.pagingAdapter.adater.PageAdapter;
import com.muryno.listedkey.pagingAdapter.datasource.ListingViewModel;
import com.muryno.listedkey.pagingAdapter.di.BaseActivity;
import com.muryno.listedkey.search.customdialogs.models.UserModel;
import com.muryno.listedkey.search.customdialogs.services.UsersService;
import com.muryno.listedkey.settings.SharePreManager;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;

import ir.mirrajabi.searchdialog.SimpleSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.BaseFilter;
import ir.mirrajabi.searchdialog.core.SearchResultListener;
import ir.mirrajabi.searchdialog.core.Searchable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class  MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener,
         PageAdapter.Callback, ListItemClickListener {
    private static final String TAG=MainActivity.class.getSimpleName();
    private ImageView profileImag;
    private TextView username;
    private TextView userEmail;

    private ProgressBar progressBar;

    private AddDeletUserViewModel addDeletUserViewModel;
    private User user;
    private UpdatUserViewModel viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private ListingViewModel showsViewModel;
    private PageAdapter showsPagedAdaptor;

    RecyclerView recyclerView;

    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        getSupportActionBar().setDisplayUseLogoEnabled(true);

        getUserViewModel viewMode= ViewModelProviders.of(this).get(getUserViewModel.class);
        user=viewMode.getUserLiveData();

        addDeletUserViewModel= ViewModelProviders.of(this).get(AddDeletUserViewModel.class);
        viewModel=ViewModelProviders.of(this).get(UpdatUserViewModel.class);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        View hView =  navigationView.getHeaderView(0);
        profileImag= hView.findViewById(R.id.image_of_view_user);
        username= hView.findViewById(R.id.text_view_name);
        userEmail= hView.findViewById(R.id.text_view_email);



        progressBar= findViewById(R.id.spin_ki);

        String displayName=user.getFullNam();

       username.setText(displayName);


        String userMail= user.getUserEmail();
       userEmail.setText(userMail);

        String image= user.getImageUrl();

        if(image!=null) {
            Glide.with(this)
                    .load(image)
                    .apply(new RequestOptions().centerCrop().dontAnimate().dontTransform()).into(profileImag);
        }

        recyclerView = findViewById(R.id.shows);
        progress=findViewById(R.id.progress);




        initAdapter();

        showsViewModel.initialLoadState().observe(this, this::setProgress);


    }
    private void initAdapter() {
        showsViewModel = ViewModelProviders.of(this, viewModelFactory).get(ListingViewModel.class);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        showsPagedAdaptor = new PageAdapter(new ListingDiffUtilItemCallback(), this,this);
       recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(showsPagedAdaptor);
        showsViewModel.getShows().observe(this, this::showAllShows);
        showsViewModel.paginatedLoadState().observe(this, this::setAdapterState);
    }

    private void setProgress(NetworkState initialLoadState) {
        switch (initialLoadState.status()) {
            case NetworkState.Status.SUCCESS:
                progressBar.setVisibility(View.GONE);
                break;
            case NetworkState.Status.ERROR:
                progressBar.setVisibility(View.GONE);
                Toast.makeText(this, initialLoadState.message(), Toast.LENGTH_SHORT).show();
                break;
            case NetworkState.Status.LOADING:
            default:
                progressbarr();
                break;
        }
    }
    private void showAllShows(PagedList<MainLst> shows) {
        showsPagedAdaptor.submitList(shows);
        recyclerView.setVisibility(View.VISIBLE);
    }

    private void setAdapterState(NetworkState networkState) {
        showsPagedAdaptor.setNetworkState(networkState);
    }


    @Override
    public void onStart() {
        super.onStart();
        if (!SharePreManager.getmInstance(this).isLoggedIn()) {
            Intent intent = new Intent(getApplicationContext(), AuthActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else  if(SharePreManager.getmInstance(this).isLoggedIn()){
            logOutDiaog();
        }
        else {
            super.onBackPressed();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_search) {
            searchable();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Profile) {
            Intent i=new Intent(MainActivity.this,ProfileActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_notif) {

        } else if (id == R.id.nav_listing) {


        } else if (id == R.id.nav_payment) {
            Intent intent=new Intent(getApplicationContext(),ChosePaidType.class);
            startActivity(intent);
        } else if (id == R.id.nav_gethelp) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://aegecae.mybako.com/help"));
            startActivity(browserIntent);
        } else if (id == R.id.nav_logout) {
            logOutDiaog();
        } else if(id==R.id.nav_inbox){
            Intent i=new Intent(MainActivity.this,InboxActivity.class);
            startActivity(i);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }





    public void progressbarr() {
        ThreeBounce doubleBounce = new ThreeBounce();
        progressBar.setIndeterminateDrawable(doubleBounce);
        progressBar.setVisibility(View.VISIBLE);
    }


    private void logOutDiaog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
        builder.setTitle("Really Sign Out?");

        builder.setMessage("Are you sure you want to sign out?");
        builder.setPositiveButton("Yes", (dialog, which) -> {

            addDeletUserViewModel.deletUser(user);
            SharePreManager.getmInstance(getApplicationContext()).clear();
            Intent intent = new Intent(getApplicationContext(), AuthActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        });
        builder.setNegativeButton("No", (dialog, which) -> dialog.cancel());

        builder.show();
    }



    @Override
    public void onRetryClicked() {
        showsViewModel.retry();
    }

    @Override
    public void onItemClick(View view, MainLst position) {
        int prop=position.getId();
        Intent intent=new Intent(getApplicationContext(),DetailActivity.class);
        String prop_id=String.valueOf(prop);
        viewModel.updatePropertyId(prop_id,"1");
        startActivity(intent);
    }


    private  void searchable(){
        Retrofit mRetrofit;
       UsersService mUsersService;

        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://example.com")
                .build();
        mUsersService = mRetrofit.create(UsersService.class);

        final SimpleSearchDialogCompat<UserModel> searchDialog =
                new SimpleSearchDialogCompat(MainActivity.this, "Search...",
                        "What are you looking for...?", null, new ArrayList(), (SearchResultListener <Searchable>) (dialog, item, position) -> {
                            Toast.makeText(MainActivity.this, item.getTitle(),
                                    Toast.LENGTH_SHORT
                            ).show();
                            dialog.dismiss();
                        });
        BaseFilter apiFilter = new BaseFilter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                doBeforeFiltering();
                FilterResults results = new FilterResults();
                results.values = new ArrayList<UserModel>();
                results.count = 0;
                try {
                    ArrayList<UserModel> users = mUsersService
                            .getFakeUsersBasedOnASearchTag(charSequence.toString())
                            .execute()
                            .body();
                    if (users != null) {
                        results.values = users;
                        results.count = users.size();
                    }
                    return results;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                if (filterResults != null) {
                    ArrayList<UserModel> filtered = (ArrayList<UserModel>) filterResults.values;
                    if (filtered != null) {
                        searchDialog.getFilterResultListener().onFilter(filtered);
                    }
                    doAfterFiltering();
                }
            }
        };
        searchDialog.setFilter(apiFilter);
        searchDialog.show();
    }
}
