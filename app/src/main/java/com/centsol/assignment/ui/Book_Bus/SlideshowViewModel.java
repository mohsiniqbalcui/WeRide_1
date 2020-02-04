package com.centsol.assignment.ui.Book_Bus;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel extends ViewModel {
	
	private MutableLiveData<String> mText;
	
	public SlideshowViewModel() {
		mText = new MutableLiveData<>();
		mText.setValue("  ");
		mText.setValue("Book Bus fragment");
		
	}
	
	public LiveData<String> getText() {
		return mText;
	}
}