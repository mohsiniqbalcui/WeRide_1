package com.centsol.assignment.ui.History;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SendViewModel extends ViewModel {
	
	private MutableLiveData<String> mText;
	
	public SendViewModel() {
		mText = new MutableLiveData<>();
		
		mText.setValue("History fragment");
	}
	
	public LiveData<String> getText() {
		return mText;
	}
}