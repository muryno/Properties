package com.muryno.listedkey.pagingAdapter.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.muryno.listedkey.pagingAdapter.datasource.ListingViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ListingViewModel.class)
    abstract ViewModel bindHomeViewModel(ListingViewModel homeViewModel);


    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ListingViewModelFactory factory);
}
