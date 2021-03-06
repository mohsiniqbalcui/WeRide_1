/*
package com.centsol.assignment;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

	private GoogleMap mMap;
	
	FirebaseAuth mAuth;
	FirebaseAuth.AuthStateListener mAuthListner;
	
	@Override
	protected void onStart() {
		super.onStart();
		mAuth.addAuthStateListener(mAuthListner);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maps);
		// Obtain the SupportMapFragment and get notified when the map is ready to be used.
		
		SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map);
		mapFragment.getMapAsync(this);
		
		mAuth = FirebaseAuth.getInstance();
		
		mAuthListner = new FirebaseAuth.AuthStateListener() {
			@Override
			public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
				if (firebaseAuth.getCurrentUser()==null)
				{
					startActivity(new Intent(MapsActivity.this, singin_activity.class));
				}
			}
		};
	}


	*/
/**
	 * Manipulates the map once available.
	 * This callback is triggered when the map is ready to be used.
	 * This is where we can add markers or lines, add listeners or move the camera. In this case,
	 * we just add a marker near Sydney, Australia.
	 * If Google Play services is not installed on the device, the user will be prompted to install
	 * it inside the SupportMapFragment. This method will only be triggered once the user has
	 * installed Google Play services and returned to the app.
	 *//*

	
	@Override
	public void onMapReady(GoogleMap googleMap) {
		mMap = googleMap;

		// Add a marker in Sydney and move the camera
		LatLng sydney = new LatLng(31, 74);
		mMap.addMarker(new MarkerOptions().position(sydney).title("Temporary Marker in Lahore"));
		mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
	}
	
	
	// button listerner for signout bttton
	
	//beacuse sue ris sign out fromt eh screen so the action will ove tto the firebase state change
	
	public void signoutButtonAction(View view) {
		mAuth.signOut();
		
	}
}
*/
