package com.centsol.assignment.ui.Profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {
	
	private MutableLiveData<String> mText;
	
	public GalleryViewModel() {
		mText = new MutableLiveData<>();
		mText.setValue("  ");
		
		mText.setValue("Profile fragment");
	}
	
	public LiveData<String> getText() {
		return mText;
	}
}
