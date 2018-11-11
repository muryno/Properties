package com.muryno.listedkey.pagingAdapter;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.muryno.listedkey.model.MainLst;

@AutoValue
public abstract  class Main  {
    public static Main fromFavoriteShow(MainLst mainLst) {
        return Main.builder()
                .id(mainLst.getId())
                .rating(mainLst.getRating())
                .getBdNumbr(mainLst.getBdNumbr())
//                .image(mainLst.getImages().get(0).getImaguri())
                .getProperty_nam(mainLst.getProperty_nam())
                .country(mainLst.getCountry())
                .getProperty_typ(mainLst.getProperty_typ())
                .build();
    }

    public static TypeAdapter<Main> typeAdapter(Gson gson) {
        return new AutoValue_Main.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new AutoValue_Main.Builder();
    }

    @SerializedName("id")
    public abstract int id();

    @SerializedName("bed_number")
    public abstract int getBdNumbr();

    @Nullable
    @SerializedName("title")
    public abstract String getProperty_typ();


    @Nullable
    @SerializedName("property_type")
    public abstract String getProperty_nam();

    @Nullable
    @SerializedName("country_name")
    public abstract String country();

    @SerializedName("rating")
    public abstract int rating();

//    @Nullable
//    @SerializedName("images")
//    public abstract  String image();

    public abstract Builder toBuilder();

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract Builder id(int id);

        public abstract Builder country(String country);

        public abstract Builder getProperty_typ(String getProperty_typ);

        public abstract Builder getProperty_nam(String getProperty_nam);

        public abstract Builder rating(int rating);

        public abstract Builder getBdNumbr(int getBdNumbr);

//        public abstract Builder image(String image);

        public abstract Main build();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Main && id() == ((Main) obj).id();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
