package com.centsol.assignment;

import android.content.Intent;
import android.os.Bundle;

import com.centsol.assignment.ui.Book_Bus.SlideshowFragment;
import com.centsol.assignment.ui.Help.ShareFragment;
import com.centsol.assignment.ui.History.SendFragment;
import com.centsol.assignment.ui.Home.ToolsFragment;
import com.centsol.assignment.ui.Profile.GalleryFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity1 extends AppCompatActivity implements OnMapReadyCallback {
	
	private AppBarConfiguration mAppBarConfiguration;
	Fragment newFragment;
	FragmentTransaction transaction ;
	FirebaseAuth mAuth;
	FirebaseAuth.AuthStateListener mAuthListner;
	private GoogleMap mMap;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main1);
		
		
		// Obtain the SupportMapFragment and get notified when the map is ready to be used.
		SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
		
		mapFragment.getMapAsync(this);
		mAuth = FirebaseAuth.getInstance();
		
		
		mAuthListner = new FirebaseAuth.AuthStateListener() {
			@Override
			public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
				if (firebaseAuth.getCurrentUser()==null)
				{
					startActivity(new Intent(MainActivity1.this, singin_activity.class));
				}
			}
		};
		
		
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		FloatingActionButton fab = findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Book new Ride", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
				
			}
		});
		
		DrawerLayout drawer = findViewById(R.id.drawer_layout);
		NavigationView navigationView = findViewById(R.id.nav_view);
		
		// Passing each menu ID as a set of Ids because each
		// menu should be considered as top level destinations.
		
		mAppBarConfiguration = new AppBarConfiguration.Builder(
				R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
				R.id.nav_tools, R.id.nav_share, R.id.nav_send)
				.setDrawerLayout(drawer)
				.build();
		
		
		NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
		NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
		NavigationUI.setupWithNavController(navigationView, navController);
		
		
		navigationView.setNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem pMenuItem) {
				
				switch (pMenuItem.getItemId()){
					case R.id.nav_gallery:
						
						Toast.makeText(MainActivity1.this, "user Profile", Toast.LENGTH_LONG).show();
						
						newFragment  =  new GalleryFragment();
						transaction = getSupportFragmentManager().beginTransaction();
						transaction.replace(R.id.nav_host_fragment,newFragment);
						transaction.addToBackStack(null);
						commit();
						break;
						
					case R.id.nav_home:
						Toast.makeText(MainActivity1.this, "FAQ Screen", Toast.LENGTH_LONG).show();
						newFragment  =  new ToolsFragment();
						transaction = getSupportFragmentManager().beginTransaction();
						transaction.replace(R.id.nav_host_fragment,newFragment);
						transaction.addToBackStack(null);
						commit();
						break;
					
					case R.id.nav_send:
						Toast.makeText(MainActivity1.this, "Ride history", Toast.LENGTH_LONG).show();
						newFragment  =  new SendFragment();
						transaction = getSupportFragmentManager().beginTransaction();
						transaction.replace(R.id.nav_host_fragment,newFragment);
						transaction.addToBackStack(null);
						commit();
						break;
					
					case R.id.nav_share:
						Toast.makeText(MainActivity1.this, "Help screen", Toast.LENGTH_LONG).show();
						newFragment  =  new ShareFragment();
						transaction = getSupportFragmentManager().beginTransaction();
						transaction.replace(R.id.nav_host_fragment,newFragment);
						transaction.addToBackStack(null);
						commit();
						break;
					
					case R.id.nav_slideshow:
						Toast.makeText(MainActivity1.this, "Bus booking Details", Toast.LENGTH_LONG).show();
						newFragment  =  new SlideshowFragment();
						transaction = getSupportFragmentManager().beginTransaction();
						transaction.replace(R.id.nav_host_fragment,newFragment);
						transaction.addToBackStack(null);
						commit();
						break;
						
					case R.id.nav_tools:
						Toast.makeText(MainActivity1.this, "Rides Available", Toast.LENGTH_LONG).show();
						newFragment  =  new ToolsFragment();
						transaction = getSupportFragmentManager().beginTransaction();
						transaction.replace(R.id.nav_host_fragment,newFragment);
						transaction.addToBackStack(null);
						commit();
						break;
					
				}
				return false;
			}
			
			int lock=0;
			private void commit() {
				if (lock==0) {
					transaction.commit();
				lock =0;
				}
				}
		});
		
	}
	
	
	@Override
	public boolean onSupportNavigateUp() {
		NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
		return NavigationUI.navigateUp(navController, mAppBarConfiguration)
				|| super.onSupportNavigateUp();
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main_activity1, menu);
		return true;
		
	}
	
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
	
	
	/**
	 * Called when pointer capture is enabled or disabled for the current window.
	 *
	 * @param hasCapture True if the window has pointer capture.
	 */
	@Override
	public void onPointerCaptureChanged(boolean hasCapture) {
	
	}
}

