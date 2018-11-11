package com.muryno.listedkey.ApiCallFolder.hosttingArray;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.muryno.listedkey.ApiCallFolder.hosttingArray.sub_property_type;

import java.util.ArrayList;
import java.util.Calendar;


/**
 * Created by muraino harbeola on 10/18/2018.
 */

public class prop_detil {
    @SerializedName("id")
    @Expose
    private String id;


    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;


    @SerializedName("bed_number")
    @Expose
    private int bed_number;



    @SerializedName("total_guests")
    @Expose
    private int total_guests;


    @SerializedName("rented_before")
    @Expose
    private String rented_before;

    @SerializedName("minimum_stay")
    @Expose
    private String minimum_stay;



    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("street_address")
    @Expose
    private String street_address;

    @SerializedName("city")
    @Expose
    public cityy city;



    @SerializedName("apartment_number")
    @Expose
    private String apartment_number;

    @SerializedName("property_type")
    @Expose
    public property_type property_type;


    @SerializedName("sub_property_type")
    @Expose
    public sub_property_type sub_property_type;

    @SerializedName("room_type")
    @Expose
    public room_type room_typ;

    @SerializedName("country")
    @Expose
    public Countrys countrys;


    @SerializedName("state")
    @Expose
    public States state;


    @SerializedName("bathroom_number")
    @Expose
    public int bathroom_number;

    @SerializedName("host_name")
    @Expose
    public String host_name;

    @SerializedName("host_avatar")
    @Expose
    public String host_avatar;


    @SerializedName("positions")
    @Expose
    public ArrayList<positn> positions;


    @SerializedName("general_amenities")
    @Expose
    public ArrayList<genrAmeni>general_amenities;

    @SerializedName("home_safety_amenities")
    @Expose
    public ArrayList<homsaf>home_safety_amenities;


    @SerializedName("guest_spaces")
    @Expose
    public ArrayList<gstSpa>guest_spaces;


    @SerializedName("space_details")
    @Expose
    public ArrayList<spcdetl>space_details;


    @SerializedName("house_rules")
    @Expose
    public ArrayList<hosRul>house_rules;

    public void setCalnder(ArrayList <String> calnder) {
        this.calnder = calnder;
    }

    @SerializedName("unavail_days")
    @Expose

    public ArrayList<String> calnder;



    @SerializedName("guests_frequency")
    @Expose
    private String guests_frequency;

    @SerializedName("guests_notice")
    @Expose
    private String guests_notice;


    @SerializedName("advance_booking")
    @Expose

    private String advance_booking;



    @SerializedName("check_in_time")
    @Expose
    private String check_in_time;

    @SerializedName("check_out_time")
    @Expose
    private String check_out_time;

    @SerializedName("min_nights")
    @Expose
    private int min_nights;

    @SerializedName("max_nights")
    @Expose
    private int max_nights;

    @SerializedName("currency")
    @Expose
    private String currency;

    @SerializedName("price")
    @Expose
    private int price;
    @SerializedName("discount")
    @Expose
    private int discount;
    public int getBathroom_number() {
        return bathroom_number;
    }

    public void setBathroom_number(int bathroom_number) {
        this.bathroom_number = bathroom_number;
    }

    public int getToilet_number() {
        return toilet_number;
    }

    public void setToilet_number(int toilet_number) {
        this.toilet_number = toilet_number;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    @SerializedName("toilet_number")
    @Expose

    public int toilet_number;

    @SerializedName("longitude")
    @Expose
    public Double lng;


    @SerializedName("latitude")
    @Expose
    public Double lat;


    @SerializedName("images")
    @Expose
    public ArrayList<ListImages> images;

    public ArrayList <Bedtypes> getBed_types() {
        return bed_types;
    }

    public void setBed_types(ArrayList <Bedtypes> bed_types) {
        this.bed_types = bed_types;
    }

    @SerializedName("bed_types")
    @Expose
    public ArrayList<Bedtypes> bed_types;

    public ArrayList <ListImages> getImages() {
        return images;
    }

    public void setImages(ArrayList <ListImages> images) {
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBed_number() {
        return bed_number;
    }

    public void setBed_number(int bed_number) {
        this.bed_number = bed_number;
    }


    public String getRented_before() {
        return rented_before;
    }

    public void setRented_before(String rented_before) {
        this.rented_before = rented_before;
    }

    public String getMinimum_stay() {
        return minimum_stay;
    }

    public void setMinimum_stay(String minimum_stay) {
        this.minimum_stay = minimum_stay;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getApartment_number() {
        return apartment_number;
    }

    public void setApartment_number(String apartment_number) {
        this.apartment_number = apartment_number;
    }

    public com.muryno.listedkey.ApiCallFolder.hosttingArray.property_type getProperty_type() {
        return property_type;
    }

    public void setProperty_type(com.muryno.listedkey.ApiCallFolder.hosttingArray.property_type property_type) {
        this.property_type = property_type;
    }

    public com.muryno.listedkey.ApiCallFolder.hosttingArray.sub_property_type getSub_property_type() {
        return sub_property_type;
    }

    public void setSub_property_type(com.muryno.listedkey.ApiCallFolder.hosttingArray.sub_property_type sub_property_type) {
        this.sub_property_type = sub_property_type;
    }

    public room_type getRoom_typ() {
        return room_typ;
    }

    public void setRoom_typ(room_type room_typ) {
        this.room_typ = room_typ;
    }

    public Countrys getCountrys() {
        return countrys;
    }

    public void setCountrys(Countrys countrys) {
        this.countrys = countrys;
    }

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }


    public String getHost_name() {
        return host_name;
    }

    public void setHost_name(String host_name) {
        this.host_name = host_name;
    }

    public String getHost_avatar() {
        return host_avatar;
    }

    public void setHost_avatar(String host_avatar) {
        this.host_avatar = host_avatar;
    }

    public ArrayList <positn> getPositions() {
        return positions;
    }

    public void setPositions(ArrayList <positn> positions) {
        this.positions = positions;
    }

    public ArrayList <genrAmeni> getGeneral_amenities() {
        return general_amenities;
    }

    public void setGeneral_amenities(ArrayList <genrAmeni> general_amenities) {
        this.general_amenities = general_amenities;
    }

    public ArrayList <homsaf> getHome_safety_amenities() {
        return home_safety_amenities;
    }

    public void setHome_safety_amenities(ArrayList <homsaf> home_safety_amenities) {
        this.home_safety_amenities = home_safety_amenities;
    }

    public ArrayList <gstSpa> getGuest_spaces() {
        return guest_spaces;
    }

    public void setGuest_spaces(ArrayList <gstSpa> guest_spaces) {
        this.guest_spaces = guest_spaces;
    }

    public ArrayList <spcdetl> getSpace_details() {
        return space_details;
    }

    public void setSpace_details(ArrayList <spcdetl> space_details) {
        this.space_details = space_details;
    }

    public ArrayList <hosRul> getHouse_rules() {
        return house_rules;
    }

    public void setHouse_rules(ArrayList <hosRul> house_rules) {
        this.house_rules = house_rules;
    }


    public String getGuests_frequency() {
        return guests_frequency;
    }

    public void setGuests_frequency(String guests_frequency) {
        this.guests_frequency = guests_frequency;
    }

    public String getGuests_notice() {
        return guests_notice;
    }

    public void setGuests_notice(String guests_notice) {
        this.guests_notice = guests_notice;
    }



    public String getCheck_in_time() {
        return check_in_time;
    }

    public void setCheck_in_time(String check_in_time) {
        this.check_in_time = check_in_time;
    }

    public String getCheck_out_time() {
        return check_out_time;
    }

    public void setCheck_out_time(String check_out_time) {
        this.check_out_time = check_out_time;
    }

    public int getMin_nights() {
        return min_nights;
    }

    public void setMin_nights(int min_nights) {
        this.min_nights = min_nights;
    }

    public int getMax_nights() {
        return max_nights;
    }

    public void setMax_nights(int max_nights) {
        this.max_nights = max_nights;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
    public int getTotal_guests() {
        return total_guests;
    }

    public void setTotal_guests(int total_guests) {
        this.total_guests = total_guests;
    }
    public cityy getCity() {
        return city;
    }

    public void setCity(cityy city) {
        this.city = city;
    }


    public String getAdvance_booking() {
        return advance_booking;
    }

    public void setAdvance_booking(String advance_booking) {
        this.advance_booking = advance_booking;
    }
}
