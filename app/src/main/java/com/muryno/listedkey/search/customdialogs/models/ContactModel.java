package com.muryno.listedkey.search.customdialogs.models;

import ir.mirrajabi.searchdialog.core.Searchable;



public class ContactModel implements Searchable {
	private String mName;
	private String mImageUrl;
	
	public ContactModel(String name, String imageUrl) {
		mName = name;
		mImageUrl = imageUrl;
	}
	
	@Override
	public String getTitle() {
		return mName;
	}
	
	public String getName() {
		return mName;
	}
	
	public ContactModel setName(String name) {
		mName = name;
		return this;
	}
	
	public String getImageUrl() {
		return mImageUrl;
	}
	
	public ContactModel setImageUrl(String imageUrl) {
		mImageUrl = imageUrl;
		return this;
	}
}
