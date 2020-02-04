package com.centsol.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Handler;

import android.os.Bundle;

public class splash extends AppCompatActivity {
	Handler handler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		handler=new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent intent=new Intent(splash.this,userType.class);
				startActivity(intent);
				finish();
			}
		},1000);
		
	}
}
