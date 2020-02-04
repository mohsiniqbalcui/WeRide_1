package com.centsol.assignment;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class userType extends AppCompatActivity {
	
	Button btn1;
	Button btn2;
	Intent intent;
	Editor editor;
	
	SharedPreferences mSharedPreferences;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_type);
		
		btn1 = findViewById(R.id.driverUser);
		btn2 = findViewById(R.id.riderUser);
		
		mSharedPreferences  = this.getSharedPreferences("MyPref", 0); // 0 - for private mode
		editor = mSharedPreferences.edit();
		editor.commit(); // commit changes
		
	}
	
	public void driverClick(View view) {
		Log.i("user type", "driverClick: ");
		editor.putString("usertype", "driver"); // Storing string
		editor.apply();
		intent = new Intent(this,singin_activity.class);
		finish();
		Log.i("user type","before sign in");
	}
	
	public void riderclick(View view) {
		Log.i("user type", "RiderClick: ");
		editor.putString("usertype", "rider"); // Storing string
		editor.apply();
		intent = new Intent(this,singin_activity.class);
		finish();
		Log.i("user type","before sign in");
		
	}
	
}