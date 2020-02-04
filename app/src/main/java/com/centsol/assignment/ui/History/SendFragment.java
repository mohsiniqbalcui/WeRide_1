package com.centsol.assignment.ui.History;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.centsol.assignment.R;

public class SendFragment extends Fragment {
	
	private SendViewModel sendViewModel;
	
	public View onCreateView(@NonNull LayoutInflater inflater,
							 ViewGroup container, Bundle savedInstanceState) {
	// linking to view model class SendViewModel
		sendViewModel = ViewModelProviders.of(this).get(SendViewModel.class);
		// linking to fragmebt
		View root = inflater.inflate(R.layout.fragment_send, container, false);
		
		final TextView textView = root.findViewById(R.id.text_send);
		sendViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
			@Override
			public void onChanged(@Nullable String s) {
				textView.setText(s);
			}
		});
		return root;
	}
}