package com.muryno.listedkey.pagingAdapter.adater;

import android.support.v7.util.DiffUtil;


import com.muryno.listedkey.model.MainLst;

import java.util.Objects;

public class ListingDiffUtilItemCallback extends DiffUtil.ItemCallback<MainLst> {
    @Override
    public boolean areItemsTheSame(MainLst oldItem, MainLst newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(MainLst oldItem, MainLst newItem) {
        return Objects.equals(oldItem, newItem);
    }
}
