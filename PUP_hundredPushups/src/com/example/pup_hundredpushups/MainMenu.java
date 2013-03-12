package com.example.pup_hundredpushups;

import java.util.Calendar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainMenu extends Activity {
	
	ViewFlipper flipper;
	ViewFlipper flipper2;
	ViewFlipper flipper3;
	
	TextView time;
	TextView date;
	
	SharedPreferences modes;
	
	Button settings;
	Button start;
	
	String mydate;
	
	float lastX;
	float lastY;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		
		onInit();
		
		start.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				start();
			}
					
		});
		
		settings.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				modes.edit().putString("test", "1").commit();
				modes.edit().putInt("day", 1).commit();
				modes.edit().putInt("week",1).commit();
				Intent restart = new Intent(MainMenu.this,MainMenu.class);
				startActivity(restart);
			}
		});
	}

	private void onInit() {
		// TODO Auto-generated method stub
		flipper = (ViewFlipper) findViewById(R.id.flipper1);
		flipper2= (ViewFlipper) findViewById(R.id.flipper2);
		flipper3 = (ViewFlipper)findViewById(R.id.flipper3);
		time =(TextView)findViewById(R.id.time);
		date = (TextView)findViewById(R.id.date);
		
		flipper.startFlipping();
		flipper2.startFlipping();
		
		
		mydate = java.text.DateFormat.getDateTimeInstance()
				.format(Calendar.getInstance().getTime());
		
		modes = getSharedPreferences("my_shared_pref", 1);
		modes.getString("test", "1");
		
		time.setText(mydate);
		date.setText("DAY" + " "+ String.valueOf(modes.getInt("day", 1))+ 
				" " + "WEEK"+ " " + String.valueOf(modes.getInt("week", 1)));
		
		start = (Button) findViewById(R.id.start);
		settings = (Button)findViewById(R.id.settings);
	}

	private void start() {
		// TODO Auto-generated method stub
		if(modes.getString("test", "1").equals("1"))
			
		{
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(
				MainMenu.this);
		dlgAlert.setMessage("Before you dive in and start " +
				"the Hundred Push Ups Program, you should:"
				+ "\n"
				+ "- Obtain medical advice and clearance from your doctor"
				+ "\n"
				+ "- Take an initial push ups test"
				+ "\n"
				+ "DO YOU WANT TO START?");
		dlgAlert.setTitle("IMPORTANT");
		dlgAlert.setIcon(R.drawable.warn);
		dlgAlert.setPositiveButton("YES",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,
							int which) {
						Intent initialTest = new Intent(MainMenu.this,
								InitialTest.class);
						startActivity(initialTest);
						modes.edit().putString("test", "2").commit();
					}
				});
		dlgAlert.setNegativeButton("NO", null);
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}
	
	else
	{
		Intent main = new Intent(MainMenu.this, MainActivity.class);
		startActivity(main);
	}
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		// TODO Auto-generated method stub
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN: {
			lastX = event.getX();
			lastY = event.getY();
			break;
		}
		case MotionEvent.ACTION_UP: {

			float currentX = event.getX();
			float currentY = event.getY();

			if ((currentX < lastX) && (Math.abs(currentY - lastY) < 20)) {
				flipper3.showNext();
			}

			if ((currentX > lastX) && (Math.abs(currentY - lastY) < 20)) {
				flipper3.showPrevious();
			}
			break;
		}
		}
		return false;
	}
}
