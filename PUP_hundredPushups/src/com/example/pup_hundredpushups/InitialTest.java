package com.example.pup_hundredpushups;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InitialTest extends Activity {
	
	Button set1;
	Button set2;
	Button set3;
	Button set4;
	SharedPreferences modes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_initial_test);
	
		onInit();
		
		 set1.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				set(1);	
			}
		});
		

		set2.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				set(2);
			}
		});
		

		set3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				set(3);	
			}
		});
		

		set4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				set(4);
			}
		});
	}
	private void onInit() {
		// TODO Auto-generated method stub
		 set1 = (Button)findViewById(R.id.pushupSet1);
		 set2 = (Button)findViewById(R.id.pushupSet2);
		 set3 = (Button)findViewById(R.id.pushupSet3);
		 set4 = (Button)findViewById(R.id.pushupSet4);
		 
		 modes = getSharedPreferences("my_shared_pref", 1);
		 modes.getInt("initial", 0);
		
	}
	
	private void set(int set)
	{
		Intent newSet = new Intent(getApplicationContext(), MainActivity.class);
		modes.edit().putInt("initial", set).commit();
		startActivity(newSet);
	}
	@Override
	public void onBackPressed() {
	}
	
}
