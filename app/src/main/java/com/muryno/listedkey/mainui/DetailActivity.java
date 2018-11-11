package com.muryno.listedkey.mainui;

import android.app.DatePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ybq.android.spinkit.style.ThreeBounce;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.muryno.listedkey.Database.userDetails.UpdatUserViewModel;
import com.muryno.listedkey.Database.userDetails.User;
import com.muryno.listedkey.Database.userDetails.getUserViewModel;
import com.muryno.listedkey.R;
import com.muryno.listedkey.settings.SharePreManager;
import com.viewpagerindicator.CirclePageIndicator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class DetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    AppBarLayout appBarLayout;
    CollapsingToolbarLayout collapsingToolbar;
    Menu collapsedMenu;
    boolean appBarExpanded;

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;

    public static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 0;



    private GoogleMap googleMap;

    private Circle mCircle;
    private Marker mMarker;

    public  @BindView(R.id.chk_avail)
    Button chk_avail;
    Double mLatitude;
    Double mLongitude;

    @BindView(R.id.titl_pro)
    TextView titl_pro;

    @BindView(R.id.contry)
    TextView contry;

    @BindView(R.id.gust_nm)
    TextView gust_nm;

    @BindView(R.id.bed_rom)
    TextView bed_rom;

    @BindView(R.id.batrm)
    TextView batrm;

    @BindView(R.id.bed_nm)
    TextView bed_nm;

    @BindView(R.id.descrip)
    TextView descrip;
//dg
    @BindView(R.id.Essentials)
    TextView Essentials;

    @BindView(R.id.Shampoo)
    TextView Shampoo;

    @BindView(R.id.TV)
    TextView TV;

    @BindView(R.id.Conditioning)
    TextView Conditioning;

    @BindView(R.id.Closet)
    TextView Closet;


    @BindView(R.id.hairDryer)
    TextView Dryer;

    @BindView(R.id.Entrances)
    TextView Entrance;

    @BindView(R.id.Wireless)
    TextView Wireless;

    @BindView(R.id.Hanger)
    TextView Hanger;

    @BindView(R.id.Heater)
    TextView Heater;

    @BindView(R.id.Desk)
    TextView Desk;

    @BindView(R.id.Iron)
    TextView Iron;

    @BindView(R.id.Pet)
    TextView Pet;

    @BindView(R.id.Extinguisher)
    TextView Extinguisher;

    @BindView(R.id.Smoke)
    TextView Smoke;

    @BindView(R.id.Lock)
    TextView Lock;

    @BindView(R.id.Aid)
    TextView Aid;

    @BindView(R.id.Card)
    TextView Card;

    @BindView(R.id.monoxide)
    TextView monoxide;

    @BindView(R.id.beach)
    TextView beach;

    @BindView(R.id.Isolated)
    TextView Isolated;

    @BindView(R.id.town)
    TextView town;

    @BindView(R.id.ski)
    TextView ski;

    @BindView(R.id.Near)
    TextView forest;

    @BindView(R.id.Private)
    TextView Island;

    @BindView(R.id.Pool)
    TextView Pool;

    @BindView(R.id.Washer)
    TextView Washer;

    @BindView(R.id.Room)
    TextView Rooms;

    @BindView(R.id.tub)
    TextView tub;

    @BindView(R.id.elevto)
    TextView Elevator;

    @BindView(R.id.Gym)
    TextView Gym;

    @BindView(R.id.Kitchen)
    TextView Kitchen;


    @BindView(R.id.Laundry)
    TextView Laundry;

    @BindView(R.id.Parking)
    TextView Parking;

    @BindView(R.id.no_parking)
    TextView no_parking;

    @BindView(R.id.Stairs)
    TextView Stairs;


    @BindView(R.id.Petss)
    TextView Petss;

    @BindView(R.id.animal)
    TextView animal;
//,jsvjka

    @BindView(R.id.Shared)
    TextView Shared;

    @BindView(R.id.noise)
    TextView noise;


    @BindView(R.id.Surveillance)
    TextView Surveillance;

    @BindView(R.id.Weapon)
    TextView Weapon;


    @BindView(R.id.FirePlace)
    TextView FirePlace;

    @BindView(R.id.Breakfast)
    TextView Breakfast;



    //d,flksdjf
    @BindView(R.id.children)
    TextView children;

    @BindView(R.id.fr_pets)
    TextView fr_pets;

    @BindView(R.id.parties)
    TextView parties;

    @BindView(R.id.infants)
    TextView infants;

    @BindView(R.id.Smoking)
    TextView Smoking;

    @BindView(R.id.Check_in)
    TextView Check_in;

    @BindView(R.id.Check_out)
    TextView Check_out;

    @BindView(R.id.Arrival)
    TextView Arrival;

    @BindView(R.id.Advance)
    TextView Advance;

    @BindView(R.id.min)
    TextView Minimum;

    @BindView(R.id.max)
    TextView Maximun;


    @BindView(R.id.Cancellation)
    TextView Cancellation;


    @BindView(R.id.image_of_view_user)
    ImageView image_of_view_user;

    private String[] url = new String[] {"https://q.bstatic.com/images/hotel/max1024x768/980/98013159.jpg", "https://r.bstatic.com/images/hotel/max1024x768/980/98013163.jpg", "https://q.bstatic.com/images/hotel/max1024x768/980/98013165.jpg",
            "https://r.bstatic.com/images/hotel/max1024x768/980/98013176.jpg","https://q.bstatic.com/images/hotel/max1024x768/976/97658569.jpg","https://r.bstatic.com/images/hotel/max1024x768/976/97658565.jpg", "https://r.bstatic.com/images/hotel/max1024x768/980/98013174.jpg", "https://r.bstatic.com/images/hotel/max1024x768/980/98013170.jpg"};

    int like=0;

    private String[] urls;
    EditText chec_in;
    EditText chec_out;
    TextView gust_number;
    TextView pric;
    ProgressBar progressBar;
    int total_gust=0;
    Button bknow;
    Button gust_increase;
    Button gst_decrease;
    Calendar myCalendar;
    Calendar checkin;
    DatePickerDialog.OnDateSetListener date;
    DatePickerDialog datePickerDialog;
    String date_in;
    String date_out;

    String symbol;
    private User user;
    int prop_id;
    String currency;
    int price ;
    Map<Currency, Locale> map;
    Locale NGN;
    Locale USD;

    String date_i;
    String date_o;

    String dolnaira;

    int min_nights;
    int max_nights;
    private UpdatUserViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Strikline();

        final Toolbar toolbar = findViewById(R.id.anim_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        appBarLayout = findViewById(R.id.appbar);

        collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("");



        getUserViewModel viewMode= ViewModelProviders.of(this).get(getUserViewModel.class);
        user=viewMode.getUserLiveData();
        viewModel=ViewModelProviders.of(this).get(UpdatUserViewModel.class);


        map = getCurrencyLocaleMap();
        NGN = new Locale("EN","NG");
        USD= new Locale("EN","US");

        init(url);



    }


    private void init(String[] url) {

        mPager = findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImage_Adapter(getApplicationContext(),url));

        CirclePageIndicator indicator = findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES = url.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = () -> {
            if (currentPage == NUM_PAGES) {
                currentPage = 0;
            }
            mPager.setCurrentItem(currentPage++, true);
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }



    public void bokinDialg(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
// ...Irrelevant code for customizing the buttons and title
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.checking_dialog, null);
        dialogBuilder.setView(dialogView);

        chec_in = dialogView.findViewById(R.id.chec_in);
        chec_out = dialogView.findViewById(R.id.chec_out);
        bknow=dialogView.findViewById(R.id.chk_avail);
        gst_decrease=dialogView.findViewById(R.id.gst_decrease);
        gust_increase=dialogView.findViewById(R.id.gust_increase);
        pric=dialogView.findViewById(R.id.pric);
        gust_number = dialogView.findViewById(R.id.gust_number);
         progressBar=dialogView.findViewById(R.id.spin_kit);
       int price= SharePreManager.getmInstance(this).RetrieveSignin().prices;

       pric.setText(dolnaira + price);

        gust_increase.setOnClickListener(v -> {
            total_gust = total_gust + 1;
            gust_number.setText(total_gust +"");
        });
        gst_decrease.setOnClickListener(v -> {
            if (total_gust > 0) {

                total_gust = total_gust - 1;
                gust_number.setText(total_gust +"");
            }
        });
        bknow.setOnClickListener(v -> {


        });


        chec_in.setOnClickListener(v -> {
            // TODO Auto-generated method stub
            myCalendar = Calendar.getInstance();
            date = (view, year, monthOfYear, dayOfMonth) -> {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                chekin();
            };

            datePickerDialog = new DatePickerDialog(this, date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
            if(max_nights!=0){
            }else{
                if(min_nights!=0){


                }
            }
            datePickerDialog.show();



        });

        chec_out.setOnClickListener(v -> {
            myCalendar = Calendar.getInstance();
            date = (view, year, monthOfYear, dayOfMonth) -> {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                chekout();
            };

            datePickerDialog = new DatePickerDialog(this, date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
            if(max_nights!=0){
            }else{
                if(min_nights!=0){

                }
            }
            datePickerDialog.show();

        });






        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();


    }
    public  void  chekout(){
        String myForma = "MM/dd/yyyy"; //In which you need put here
        SimpleDateFormat sd = new SimpleDateFormat(myForma, Locale.US);
       date_out= sd.format(myCalendar.getTime());
        chec_out.setText(date_out);

        SimpleDateFormat sdff = new SimpleDateFormat("EEE, d MMM yyyy", Locale.US);
        date_o=sdff.format(myCalendar.getTime());

    }

    private void chekin() {
        String myFormat = "MM/dd/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        date_in= sdf.format(myCalendar.getTime());
        chec_in.setText(date_in);
        SimpleDateFormat sd = new SimpleDateFormat("EEE, d MMM yyyy", Locale.US);
        date_i=sd.format(myCalendar.getTime());
    }

    public  void compareDates(String d1,String d2) {
        try{
            // If you already have date objects then skip 1

            //1
            // Create 2 dates starts
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
            Date date1 = sdf.parse(d1);
            Date date2 = sdf.parse(d2);


            // Create 2 dates ends
            //1

            // Date object is having 3 methods namely after,before and equals for comparing
            // after() will return true if and only if date1 is after date 2
            if(date1.after(date2)){
                date_i= date_o;
                date_o=date_i;
                chec_out.setText(date_in);
                chec_in.setText(date_out);            }
            // before() will return true if and only if date1 is before date2
            if(date1.before(date2)){


            }

            //equals() returns true if both the dates are equal
            if(date1.equals(date2)){

            }


        }
        catch(ParseException ex){
            ex.printStackTrace();
        }
    }



    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (collapsedMenu != null
                && (!appBarExpanded || collapsedMenu.size() != 1)) {
            //collapsed
//            collapsedMenu.add("Add")
//                    .setIcon(R.drawable.ic_share)
//                    .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        } else {
            //expanded
        }
        return super.onPrepareOptionsMenu(collapsedMenu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_details, menu);
        collapsedMenu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.share:
                Toasty.success(getApplicationContext(), "Share "  , Toast.LENGTH_SHORT,true).show();

                return true;
            case R.id.like:
                item.setOnMenuItemClickListener(menuItem -> {

                    boolean favorit = true;
                    if (favorit) {
                        item.setIcon(R.drawable.favorite);

                        Toasty.success(getApplicationContext(), "Likes"  , Toast.LENGTH_SHORT,false).show();

                    } else {
                        item.setIcon(R.drawable.favorite_border);
                        Toasty.success(getApplicationContext(), "Unlikes"  , Toast.LENGTH_SHORT,false).show();

                    }
                    return true;
                });


                return true;
        }


        return super.onOptionsItemSelected(item);
    }



    private void showMaps() {
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void drawMarkerWithCircle(LatLng position) {
        double radiusInMeters = 200.0;  // increase decrease this distancce as per your requirements
        int strokeColor = 0xffff0000; //red outline
        int shadeColor = 0x44ff0000; //opaque red fill

        CircleOptions circleOptions = new CircleOptions()
                .center(position)
                .radius(radiusInMeters)
                .fillColor(shadeColor)
                .strokeColor(strokeColor)
                .strokeWidth(8);
        mCircle = googleMap.addCircle(circleOptions);

        MarkerOptions markerOptions = new MarkerOptions().position(position);
        mMarker = googleMap.addMarker(markerOptions);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));




        // Changing map type
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Showing / hiding your current location
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        googleMap.setMyLocationEnabled(true);

        // Enable / Disable zooming controls
        googleMap.getUiSettings().setZoomControlsEnabled(true);

        // Enable / Disable my location button
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);

        // Enable / Disable Compass icon
        googleMap.getUiSettings().setCompassEnabled(true);

        // Enable / Disable Rotate gesture
        googleMap.getUiSettings().setRotateGesturesEnabled(true);

        // Enable / Disable zooming functionality
        googleMap.getUiSettings().setZoomGesturesEnabled(true);

        // Bundle extra = getIntent().getBundleExtra("extra");
        //ArrayList<Escolas> objects = (ArrayList<Escolas>) extra.getSerializable("array");


        try {


            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mLatitude, mLongitude), 16));

            MarkerOptions options = new MarkerOptions();

            // Setting the position of the marker

            options.position(new LatLng(mLatitude, mLongitude));

            //googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();

            LatLng latLng = new LatLng(mLatitude, mLongitude);
            drawMarkerWithCircle(latLng);


            googleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
                @Override
                public void onMyLocationChange(Location location) {
                    float[] distance = new float[2];

                        /*
                        Location.distanceBetween( mMarker.getPosition().latitude, mMarker.getPosition().longitude,
                                mCircle.getCenter().latitude, mCircle.getCenter().longitude, distance);
                                */

                    Location.distanceBetween( location.getLatitude(), location.getLongitude(),
                            mCircle.getCenter().latitude, mCircle.getCenter().longitude, distance);

                    float radius =  Float.parseFloat(mCircle.getRadius()+"");
                    float distanceInMeter = Float.parseFloat(distance[0]+"");
                    if( distanceInMeter > radius )
                    {
                        Toast.makeText(getBaseContext(), "You are Outside of the circle, Distance from center: " + distance[0] + " Radius: " + mCircle.getRadius(), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getBaseContext(), "Your are Inside the circle, Distance from center: " + distance[0] + " Radius: " + mCircle.getRadius() , Toast.LENGTH_LONG).show();
                    }

                }
            });




        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
// If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the task you need to do.
                    // Obtain the SupportMapFragment and get notified when the map is ready to be used.
                    showMaps();


                } else {


                    // permission denied, boo! Disable the functionality that depends on this permission.
                }
                return;
            }
        }
    }
    public void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
    }


    public void progressbar() {
        ThreeBounce doubleBounce = new ThreeBounce();
        progressBar.setIndeterminateDrawable(doubleBounce);
        progressBar.setVisibility(View.VISIBLE);
    }




    public void Strikline(){

        Rooms.setPaintFlags(Rooms.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Washer.setPaintFlags(Washer.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Pool.setPaintFlags(Pool.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Island.setPaintFlags(Island.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        forest.setPaintFlags(forest.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        ski.setPaintFlags(ski.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        town.setPaintFlags(town.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Isolated.setPaintFlags(Isolated.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        beach.setPaintFlags(beach.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        monoxide.setPaintFlags(monoxide.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Card.setPaintFlags(Card.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Aid.setPaintFlags(Aid.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Lock.setPaintFlags(Lock.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Smoke.setPaintFlags(Smoke.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Extinguisher.setPaintFlags(Extinguisher.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Pet.setPaintFlags(Pet.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Iron.setPaintFlags(Iron.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Desk.setPaintFlags(Desk.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Heater.setPaintFlags(Heater.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Hanger.setPaintFlags(Hanger.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Entrance.setPaintFlags(Entrance.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Dryer.setPaintFlags(Dryer.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Closet.setPaintFlags(Closet.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Conditioning.setPaintFlags(Conditioning.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        TV.setPaintFlags(TV.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Shampoo.setPaintFlags(Shampoo.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Essentials.setPaintFlags(Essentials.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        tub.setPaintFlags(tub.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Gym.setPaintFlags(Gym.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Kitchen.setPaintFlags(Kitchen.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        no_parking.setPaintFlags(no_parking.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Stairs.setPaintFlags(Stairs.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Parking.setPaintFlags(Parking.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Petss.setPaintFlags(Petss.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        animal.setPaintFlags(animal.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        children.setPaintFlags(children.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        fr_pets.setPaintFlags(fr_pets.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        parties.setPaintFlags(parties.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        infants.setPaintFlags(infants.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Smoking.setPaintFlags(Smoking.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Laundry.setPaintFlags(Laundry.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        Shared.setPaintFlags(Shared.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        noise.setPaintFlags(noise .getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Surveillance.setPaintFlags(Surveillance.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        FirePlace.setPaintFlags(FirePlace.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Breakfast.setPaintFlags(Breakfast.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Elevator.setPaintFlags(Breakfast.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Weapon.setPaintFlags(Breakfast.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }


    public static Map<Currency, Locale> getCurrencyLocaleMap() {
        Map<Currency, Locale> map = new HashMap<>();
        for (Locale locale : Locale.getAvailableLocales()) {
            try {
                Currency currency = Currency.getInstance(locale);
                map.put(currency, locale);
            }
            catch (Exception e){
                // skip strange locale
            }
        }
        return map;
    }
}
