package com.muryno.listedkey.pagingAdapter.di;


import com.muryno.listedkey.HelpSystem;
import com.muryno.listedkey.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBuildersModule {
    @ContributesAndroidInjector
    abstract MainActivity bindHomeActivity();

    @ContributesAndroidInjector
    abstract HelpSystem bindAllShowsActivity();


}
