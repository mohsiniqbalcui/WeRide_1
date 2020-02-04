package com.centsol.assignment.ui.Profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.centsol.assignment.R;
import com.centsol.assignment.ui.Profile.GalleryViewModel;

public class GalleryFragment extends Fragment {
	
	private GalleryViewModel galleryViewModel;
	
	public View onCreateView(@NonNull LayoutInflater inflater,
							 ViewGroup container, Bundle savedInstanceState) {
		galleryViewModel =
				ViewModelProviders.of(this).get(GalleryViewModel.class);
		View root = inflater.inflate(R.layout.fragment_gallery, container, false);
		final TextView textView = root.findViewById(R.id.text_gallery);
		galleryViewModel.getText().observe(this, new Observer<String>() {
			@Override
			public void onChanged(@Nullable String s) {
				textView.setText(s);
			}
		});
		return root;
	}
}

