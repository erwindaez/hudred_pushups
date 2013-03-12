package com.example.pup_hundredpushups;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.WindowManager;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle icicle) {
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(icicle);
		setContentView(R.layout.activity_splash);
		//splash screen method
		 int secondsDelayed = 1;
	        new Handler().postDelayed(new Runnable() {
	                public void run() {
	                        startActivity(new Intent(Splash.this, MainMenu.class));
	                        finish();
	                }
	        }, secondsDelayed * 2500);
	    }

}
