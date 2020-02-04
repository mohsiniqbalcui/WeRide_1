package com.centsol.assignment.ui.Home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {
	
	private MutableLiveData<String> mText;
	
	public ToolsViewModel() {
		mText = new MutableLiveData<>();
		mText.setValue("  ");
		
		mText.setValue("Home fragment");
	}
	
	public LiveData<String> getText() {
		return mText;
	}
}
