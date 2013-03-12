package com.example.pup_hundredpushups;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView una;
	TextView una2;
	TextView pangalawa;
	TextView pangatlo;
	TextView pangapat;
	TextView panglima;
	TextView timer;
	TextView pushup;
	
	Button done;

	int i = 0;
	int day;
	int set;
	int week;
	
	List<String> numlist;
	
	String setD1W1_1[]={"2","3","2","2","3+"};
	String setD2W1_1[]={"3","4","2","3","4+"};
	String setD3W1_1[]={"4","5","4","4","5+"};
	String setD1W2_1[]={"4","6","4","4","6+"};
	String setD2W2_1[]={"5","6","4","4","7+"};
	String setD3W2_1[]={"5","7","5","5","8+"};
	String setD1W3_1[]={"10","12","7","7","9+"};
	String setD2W3_1[]={"10","12","8","8","12+"};
	String setD3W3_1[]={"11","13","9","9","13+"};
	String setD1W4_1[]={"12","14","11","10","16+"};
	String setD2W4_1[]={"14","16","12","12","18+"};
	String setD3W4_1[]={"16","18","13","13","20+"};
	String setD1W5_1[]={"17","19","15","15","20+"};
	String setD2W5_1[]={"10x2","13x2","10x2","9","25+"};
	String setD3W5_1[]={"13x2","15x2","12x2","10","30+"};
	String setD1W6_1[]={"25","30","20","15","40+"};
	String setD2W6_1[]={"14x2","15x2","14x2","10x2","44+"};
	String setD3W6_1[]={"13x2","17x2","16x2","14x2","50+"};
	
	String setD1W1_2[]={"6","6","4","4","5+"};
	String setD2W1_2[]={"6","8","6","6","7+"};
	String setD3W1_2[]={"8","10","7","7","10+"};
	String setD1W2_2[]={"9","11","8","8","11+"};
	String setD2W2_2[]={"10","12","9","9","13+"};
	String setD3W2_2[]={"12","13","10","10","15+"};
	String setD1W3_2[]={"12","17","13","13","17+"};
	String setD2W3_2[]={"14","19","14","14","19+"};
	String setD3W3_2[]={"16","21","15","15","21+"};
	String setD1W4_2[]={"18","22","16","16","25+"};
	String setD2W4_2[]={"20","25","20","20","28+"};
	String setD3W4_2[]={"23","28","23","23","33+"};
	String setD1W5_2[]={"28","35","25","22","35+"};
	String setD2W5_2[]={"18x2","20x2","14x2","16","40+"};
	String setD3W5_2[]={"18x2","20x2","17x2","20x2","45+"};
	String setD1W6_2[]={"40","50","25","25","50+"};
	String setD2W6_2[]={"20x2","23x2","20x2","18x2","53+"};
	String setD3W6_2[]={"22x2","30x2","25x2","18","55+"};
	
	String setD1W1_3[]={"10","12","7","7","9+"};
	String setD2W1_3[]={"10","12","8","8","12+"};
	String setD3W1_3[]={"11","15","9","9","13+"};
	String setD1W2_3[]={"14","14","10","10","15+"};
	String setD2W2_3[]={"14","16","12","12","17+"};
	String setD3W2_3[]={"16","17","14","14","20+"};
	String setD1W3_3[]={"14","18","14","14","20+"};
	String setD2W3_3[]={"20","25","15","15","25+"};
	String setD3W3_3[]={"22","30","20","20","28+"};
	String setD1W4_3[]={"21","25","21","21","32+"};
	String setD2W4_3[]={"25","29","25","25","36+"};
	String setD3W4_3[]={"29","33","29","29","40+"};
	String setD1W5_3[]={"36","40","30","24","40+"};
	String setD2W5_3[]={"19x2","22x2","18x2","22x2","45+"};
	String setD3W5_3[]={"20x2","24x2","20x2","22","50+"};
	String setD1W6_3[]={"45","55","35","30","55+"};
	String setD2W6_3[]={"22x2","30x2","24x2","18x2","58+"};
	String setD3W6_3[]={"26x2","33x2","26x2","22x2","60+"};
	
	
	SharedPreferences modes;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		onInit();
		setColor();		 
		setProgram();
			 
		done.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				una.setVisibility(View.GONE);
				done.setVisibility(View.GONE);
				timer.setVisibility(View.VISIBLE);
				pushup.setText("REST");
				
             CountDownTimer timer1 = new CountDownTimer(60000,1000){

                   @Override
                   public void onFinish() {
                	   pushup.setText("PUSH-UPS TO MAKE");
                	   if(i>3)
                	   {                 		  
                		   Intent done = new Intent(MainActivity.this,MainMenu.class);
                		   startActivity(done);
                		   modes.edit().putInt("day",day+1 ).commit();
                		   if(day>=3)
                			   {
                			   modes.edit().putInt("week",week+1 ).commit();
                			   modes.edit().putInt("day",1 ).commit();
                			   }   
                	   }
                	   else{
                	una.setVisibility(View.VISIBLE);
       				done.setVisibility(View.VISIBLE);
       				timer.setVisibility(View.GONE);
       				i++;
       				una.setText(numlist.get(i));
       				setColor();
                	   }
       				
                   }

                   @Override
                   public void onTick(long millisUntilFinished) {                               
                        
                         int seconds = (int) (millisUntilFinished / 1000);
                         seconds = seconds % 60;               
                         timer.setText(String.valueOf(seconds));               
                   }          
             }.start();
            
       }
   });
						
	}
	
	private void setProgram() {
	// TODO Auto-generated method stub
	switch(week)
	{
	case 1:
		week1();
		break;
	case 2:
		week2();
		break;
	case 3:
		week3();
		break;
	case 4:
		week4();
		break;
	case 5:
		week5();
		break;
	case 6:
		week6();
		break;
	default:
		week6();
		break;
	}
	}
	
	private void setColor() {
		// TODO Auto-generated method stub
			switch(i)
			{
			case 0:
				una2.setBackgroundColor(Color.GREEN);
				pangalawa.setBackgroundColor(Color.GRAY);
				pangatlo.setBackgroundColor(Color.GRAY);
				pangapat.setBackgroundColor(Color.GRAY);
				panglima.setBackgroundColor(Color.GRAY);
				break;
			
			case 1:
				una2.setBackgroundColor(Color.GRAY);
				pangalawa.setBackgroundColor(Color.GREEN);
				pangatlo.setBackgroundColor(Color.GRAY);
				pangapat.setBackgroundColor(Color.GRAY);
				panglima.setBackgroundColor(Color.GRAY);
				break;

			case 2:
				una2.setBackgroundColor(Color.GRAY);
				pangalawa.setBackgroundColor(Color.GRAY);
				pangatlo.setBackgroundColor(Color.GREEN);
				pangapat.setBackgroundColor(Color.GRAY);
				panglima.setBackgroundColor(Color.GRAY);
				break;

			case 3:
				una2.setBackgroundColor(Color.GRAY);
				pangalawa.setBackgroundColor(Color.GRAY);
				pangatlo.setBackgroundColor(Color.GRAY);
				pangapat.setBackgroundColor(Color.GREEN);
				panglima.setBackgroundColor(Color.GRAY);
				break;

			case 4:
				una2.setBackgroundColor(Color.GRAY);
				pangalawa.setBackgroundColor(Color.GRAY);
				pangatlo.setBackgroundColor(Color.GRAY);
				pangapat.setBackgroundColor(Color.GRAY);
				panglima.setBackgroundColor(Color.GREEN);
				break;

			default:
				break;
			}
	}
	
	private void onInit() {
		// TODO Auto-generated method stub
		 pushup=(TextView)findViewById(R.id.pushup);
		 una = (TextView)findViewById(R.id.una);
		 una2 = (TextView)findViewById(R.id.una2);
		 timer = (TextView)findViewById(R.id.timer);
		 pangalawa = (TextView)findViewById(R.id.pangalawa);
		 pangatlo = (TextView)findViewById(R.id.pangatlo);
		 pangapat = (TextView)findViewById(R.id.pangapat);
		 panglima = (TextView)findViewById(R.id.panglima);
		 
		 done = (Button)findViewById(R.id.done);
		 
		 modes = getSharedPreferences("my_shared_pref", 1);
		 day = modes.getInt("day", 1);
		 week = modes.getInt("week", 1);
		 set = modes.getInt("initial", 0);
		 
		 numlist = new ArrayList<String>();
		 timer.setVisibility(View.GONE);
	}
	private void setNumber(String _una, String _pangalawa, 
			String _pangatlo, String _pangapat, String _panglima)
	{
		una.setText(_una);
		una2.setText(_una);
		pangalawa.setText(_pangalawa);
		pangatlo.setText(_pangatlo);
		pangapat.setText(_pangapat);
		panglima.setText(_panglima);

	}
	private void d1w1() {
		// TODO Auto-generated method stub
		switch(set)
		{
		case 1:
			setNumber(setD1W1_1[0],setD1W1_1[1],setD1W1_1[2],setD1W1_1[3],setD1W1_1[4]);
		for(int sets =0; sets <=4;sets++)
		{					
			numlist.add(setD1W1_1[sets]);			
		}
			break;
		
		case 2:
			setNumber(setD1W1_2[0],setD1W1_2[1],setD1W1_2[2],setD1W1_2[3],setD1W1_2[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD1W1_2[sets]);			
			}	
		break;
		
		case 3:
			setNumber(setD1W1_3[0],setD1W1_3[1],setD1W1_3[2],setD1W1_3[3],setD1W1_3[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD1W1_3[sets]);			
			}	
		break;
		
		case 4:
			break;
		default:
			break;
		
		}
	}

	private void d2w1() {
		// TODO Auto-generated method stub
		switch(set)
		{
		case 1:
			setNumber(setD2W1_1[0],setD2W1_1[1],setD2W1_1[2],setD2W1_1[3],setD2W1_1[4]);
		for(int sets =0; sets <=4;sets++)
		{					
			numlist.add(setD2W1_1[sets]);			
		}
			break;
		
		case 2:
			setNumber(setD2W1_2[0],setD2W1_2[1],setD2W1_2[2],setD2W1_2[3],setD2W1_2[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD2W1_2[sets]);			
			}	
		break;
		
		case 3:
			setNumber(setD2W1_3[0],setD2W1_3[1],setD2W1_3[2],setD2W1_3[3],setD2W1_3[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD2W1_3[sets]);			
			}	
		break;
		
		case 4:
			break;
		default:
			break;
		
		}

	}
	private void d3w1() {
		// TODO Auto-generated method stub
		switch(set)
		{
		case 1:
			setNumber(setD3W1_1[0],setD3W1_1[1],setD3W1_1[2],setD3W1_1[3],setD3W1_1[4]);
		for(int sets =0; sets <=4;sets++)
		{					
			numlist.add(setD3W1_1[sets]);			
		}
			break;
		
		case 2:
			setNumber(setD3W1_2[0],setD3W1_2[1],setD3W1_2[2],setD3W1_2[3],setD3W1_2[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD3W1_2[sets]);			
			}	
		break;
		
		case 3:
			setNumber(setD3W1_3[0],setD3W1_3[1],setD3W1_3[2],setD3W1_3[3],setD3W1_3[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD3W1_3[sets]);			
			}	
		break;
		
		case 4:
			break;
		default:
			break;
		
		}		
	}
	
	private void d1w2() {
		// TODO Auto-generated method stub
		switch(set)
		{
		case 1:
			setNumber(setD1W2_1[0],setD1W2_1[1],setD1W2_1[2],setD1W2_1[3],setD1W2_1[4]);
		for(int sets =0; sets <=4;sets++)
		{					
			numlist.add(setD1W2_1[sets]);			
		}
			break;
		
		case 2:
			setNumber(setD1W2_2[0],setD1W2_2[1],setD1W2_2[2],setD1W2_2[3],setD1W2_2[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD1W2_2[sets]);			
			}	
		break;
		
		case 3:
			setNumber(setD1W2_3[0],setD1W2_3[1],setD1W2_3[2],setD1W2_3[3],setD1W2_3[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD1W2_3[sets]);			
			}	
		break;
		
		case 4:
			break;
		default:
			break;
		
		}
	}

	private void d2w2() {
		// TODO Auto-generated method stub
		switch(set)
		{
		case 1:
			setNumber(setD2W2_1[0],setD2W2_1[1],setD2W2_1[2],setD2W2_1[3],setD2W2_1[4]);
		for(int sets =0; sets <=4;sets++)
		{					
			numlist.add(setD2W2_1[sets]);			
		}
			break;
		
		case 2:
			setNumber(setD2W2_2[0],setD2W2_2[1],setD2W2_2[2],setD2W2_2[3],setD2W2_2[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD2W2_2[sets]);			
			}	
		break;
		
		case 3:
			setNumber(setD2W2_3[0],setD2W2_3[1],setD2W2_3[2],setD2W2_3[3],setD2W2_3[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD2W2_3[sets]);			
			}	
		break;
		
		case 4:
			break;
		default:
			break;
		
		}

	}
	private void d3w2() {
		// TODO Auto-generated method stub
		switch(set)
		{
		case 1:
			setNumber(setD3W2_1[0],setD3W2_1[1],setD3W2_1[2],setD3W2_1[3],setD3W2_1[4]);
		for(int sets =0; sets <=4;sets++)
		{					
			numlist.add(setD3W2_1[sets]);			
		}
			break;
		
		case 2:
			setNumber(setD3W2_2[0],setD3W2_2[1],setD3W2_2[2],setD3W2_2[3],setD3W2_2[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD3W2_2[sets]);			
			}	
		break;
		
		case 3:
			setNumber(setD3W2_3[0],setD3W2_3[1],setD3W2_3[2],setD3W2_3[3],setD3W2_3[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD3W2_3[sets]);			
			}	
		break;
		
		case 4:
			break;
		default:
			break;
		
		}		
	}
	private void d1w3() {
		// TODO Auto-generated method stub
		switch(set)
		{
		case 1:
			setNumber(setD1W3_1[0],setD1W3_1[1],setD1W3_1[2],setD1W3_1[3],setD1W3_1[4]);
		for(int sets =0; sets <=4;sets++)
		{					
			numlist.add(setD1W3_1[sets]);			
		}
			break;
		
		case 2:
			setNumber(setD1W3_2[0],setD1W3_2[1],setD1W3_2[2],setD1W3_2[3],setD1W3_2[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD1W3_2[sets]);			
			}	
		break;
		
		case 3:
			setNumber(setD1W3_3[0],setD1W3_3[1],setD1W3_3[2],setD1W3_3[3],setD1W3_3[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD1W3_3[sets]);			
			}	
		break;
		
		case 4:
			break;
		default:
			break;
		
		}
	}

	private void d2w3() {
		// TODO Auto-generated method stub
		switch(set)
		{
		case 1:
			setNumber(setD2W3_1[0],setD2W3_1[1],setD2W3_1[2],setD2W3_1[3],setD2W3_1[4]);
		for(int sets =0; sets <=4;sets++)
		{					
			numlist.add(setD2W3_1[sets]);			
		}
			break;
		
		case 2:
			setNumber(setD2W3_2[0],setD2W3_2[1],setD2W3_2[2],setD2W3_2[3],setD2W3_2[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD2W3_2[sets]);			
			}	
		break;
		
		case 3:
			setNumber(setD2W3_3[0],setD2W3_3[1],setD2W3_3[2],setD2W3_3[3],setD2W3_3[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD2W3_3[sets]);			
			}	
		break;
		
		case 4:
			break;
		default:
			break;
		
		}

	}
	private void d3w3() {
		// TODO Auto-generated method stub
		switch(set)
		{
		case 1:
			setNumber(setD3W3_1[0],setD3W3_1[1],setD3W3_1[2],setD3W3_1[3],setD3W3_1[4]);
		for(int sets =0; sets <=4;sets++)
		{					
			numlist.add(setD3W3_1[sets]);			
		}
			break;
		
		case 2:
			setNumber(setD3W3_2[0],setD3W3_2[1],setD3W3_2[2],setD3W3_2[3],setD3W3_2[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD3W3_2[sets]);			
			}	
		break;
		
		case 3:
			setNumber(setD3W3_3[0],setD3W3_3[1],setD3W3_3[2],setD3W3_3[3],setD3W3_3[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD3W3_3[sets]);			
			}	
		break;
		
		case 4:
			break;
		default:
			break;
		
		}		
	}
	private void d1w4() {
		// TODO Auto-generated method stub
		switch(set)
		{
		case 1:
			setNumber(setD1W4_1[0],setD1W4_1[1],setD1W4_1[2],setD1W4_1[3],setD1W4_1[4]);
		for(int sets =0; sets <=4;sets++)
		{					
			numlist.add(setD1W4_1[sets]);			
		}
			break;
		
		case 2:
			setNumber(setD1W4_2[0],setD1W4_2[1],setD1W4_2[2],setD1W4_2[3],setD1W4_2[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD1W4_2[sets]);			
			}	
		break;
		
		case 3:
			setNumber(setD1W4_3[0],setD1W4_3[1],setD1W4_3[2],setD1W4_3[3],setD1W4_3[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD1W4_3[sets]);			
			}	
		break;
		
		case 4:
			break;
		default:
			break;
		
		}
	}

	private void d2w4() {
		// TODO Auto-generated method stub
		switch(set)
		{
		case 1:
			setNumber(setD2W4_1[0],setD2W4_1[1],setD2W4_1[2],setD2W4_1[3],setD2W4_1[4]);
		for(int sets =0; sets <=4;sets++)
		{					
			numlist.add(setD2W4_1[sets]);			
		}
			break;
		
		case 2:
			setNumber(setD2W4_2[0],setD2W4_2[1],setD2W4_2[2],setD2W4_2[3],setD2W4_2[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD2W4_2[sets]);			
			}	
		break;
		
		case 3:
			setNumber(setD2W4_3[0],setD2W4_3[1],setD2W4_3[2],setD2W4_3[3],setD2W4_3[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD2W4_3[sets]);			
			}	
		break;
		
		case 4:
			break;
		default:
			break;
		
		}

	}
	private void d3w4() {
		// TODO Auto-generated method stub
		switch(set)
		{
		case 1:
			setNumber(setD3W4_1[0],setD3W4_1[1],setD3W4_1[2],setD3W4_1[3],setD3W4_1[4]);
		for(int sets =0; sets <=4;sets++)
		{					
			numlist.add(setD3W4_1[sets]);			
		}
			break;
		
		case 2:
			setNumber(setD3W4_2[0],setD3W4_2[1],setD3W4_2[2],setD3W4_2[3],setD3W4_2[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD3W4_2[sets]);			
			}	
		break;
		
		case 3:
			setNumber(setD3W4_3[0],setD3W4_3[1],setD3W4_3[2],setD3W4_3[3],setD3W4_3[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD3W4_3[sets]);			
			}	
		break;
		
		case 4:
			break;
		default:
			break;
		
		}		
	}
	private void d1w5() {
		// TODO Auto-generated method stub
		switch(set)
		{
		case 1:
			setNumber(setD1W5_1[0],setD1W5_1[1],setD1W5_1[2],setD1W5_1[3],setD1W5_1[4]);
		for(int sets =0; sets <=4;sets++)
		{					
			numlist.add(setD1W5_1[sets]);			
		}
			break;
		
		case 2:
			setNumber(setD1W5_2[0],setD1W5_2[1],setD1W5_2[2],setD1W5_2[3],setD1W5_2[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD1W5_2[sets]);			
			}	
		break;
		
		case 3:
			setNumber(setD1W5_3[0],setD1W5_3[1],setD1W5_3[2],setD1W5_3[3],setD1W5_3[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD1W5_3[sets]);			
			}	
		break;
		
		case 4:
			break;
		default:
			break;
		
		}
	}

	private void d2w5() {
		// TODO Auto-generated method stub
		switch(set)
		{
		case 1:
			setNumber(setD2W5_1[0],setD2W5_1[1],setD2W5_1[2],setD2W5_1[3],setD2W5_1[4]);
		for(int sets =0; sets <=4;sets++)
		{					
			numlist.add(setD2W5_1[sets]);			
		}
			break;
		
		case 2:
			setNumber(setD2W5_2[0],setD2W5_2[1],setD2W5_2[2],setD2W5_2[3],setD2W5_2[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD2W5_2[sets]);			
			}	
		break;
		
		case 3:
			setNumber(setD2W5_3[0],setD2W5_3[1],setD2W5_3[2],setD2W5_3[3],setD2W5_3[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD2W5_3[sets]);			
			}	
		break;
		
		case 4:
			break;
		default:
			break;
		
		}

	}
	private void d3w5() {
		// TODO Auto-generated method stub
		switch(set)
		{
		case 1:
			setNumber(setD3W5_1[0],setD3W5_1[1],setD3W5_1[2],setD3W5_1[3],setD3W5_1[4]);
		for(int sets =0; sets <=4;sets++)
		{					
			numlist.add(setD3W5_1[sets]);			
		}
			break;
		
		case 2:
			setNumber(setD3W5_2[0],setD3W5_2[1],setD3W5_2[2],setD3W5_2[3],setD3W5_2[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD3W5_2[sets]);			
			}	
		break;
		
		case 3:
			setNumber(setD3W5_3[0],setD3W5_3[1],setD3W5_3[2],setD3W5_3[3],setD3W5_3[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD3W5_3[sets]);			
			}	
		break;
		
		case 4:
			break;
		default:
			break;
		
		}		
	}
	private void d1w6() {
		// TODO Auto-generated method stub
		switch(set)
		{
		case 1:
			setNumber(setD1W6_1[0],setD1W6_1[1],setD1W6_1[2],setD1W6_1[3],setD1W6_1[4]);
		for(int sets =0; sets <=4;sets++)
		{					
			numlist.add(setD1W6_1[sets]);			
		}
			break;
		
		case 2:
			setNumber(setD1W6_2[0],setD1W6_2[1],setD1W6_2[2],setD1W6_2[3],setD1W6_2[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD1W6_2[sets]);			
			}	
		break;
		
		case 3:
			setNumber(setD1W6_3[0],setD1W6_3[1],setD1W6_3[2],setD1W6_3[3],setD1W6_3[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD1W6_3[sets]);			
			}	
		break;
		
		case 4:
			break;
		default:
			break;
		
		}
	}

	private void d2w6() {
		// TODO Auto-generated method stub
		switch(set)
		{
		case 1:
			setNumber(setD2W6_1[0],setD2W6_1[1],setD2W6_1[2],setD2W6_1[3],setD2W6_1[4]);
		for(int sets =0; sets <=4;sets++)
		{					
			numlist.add(setD2W6_1[sets]);			
		}
			break;
		
		case 2:
			setNumber(setD2W6_2[0],setD2W6_2[1],setD2W6_2[2],setD2W6_2[3],setD2W6_2[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD2W6_2[sets]);			
			}	
		break;
		
		case 3:
			setNumber(setD2W6_3[0],setD2W6_3[1],setD2W6_3[2],setD2W6_3[3],setD2W6_3[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD2W6_3[sets]);			
			}	
		break;
		
		case 4:
			break;
		default:
			break;
		
		}

	}
	private void d3w6() {
		// TODO Auto-generated method stub
		switch(set)
		{
		case 1:
			setNumber(setD3W6_1[0],setD3W6_1[1],setD3W6_1[2],setD3W6_1[3],setD3W6_1[4]);
		for(int sets =0; sets <=4;sets++)
		{					
			numlist.add(setD3W6_1[sets]);			
		}
			break;
		
		case 2:
			setNumber(setD3W6_2[0],setD3W6_2[1],setD3W6_2[2],setD3W6_2[3],setD3W6_2[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD3W6_2[sets]);			
			}	
		break;
		
		case 3:
			setNumber(setD3W6_3[0],setD3W6_3[1],setD3W6_3[2],setD3W6_3[3],setD3W6_3[4]);
			for(int sets =0; sets<=4;sets++)
			{					
				numlist.add(setD3W6_3[sets]);			
			}	
		break;
		
		case 4:
			break;
		default:
			break;
		
		}		
	}

	private void week1() {
		// TODO Auto-generated method stub
		switch(day)
		{
		case 1 :
			d1w1();
			break;		
		case 2 :
			d2w1();
			break;
		case 3:
			d3w1();
			break;
		default:
			break;
			}
		}
	
	private void week2() {
		// TODO Auto-generated method stub
		switch(day)
		{
		case 1 :
			d1w2();
			break;		
		case 2 :
			d2w2();
			break;
		case 3:
			d3w2();
			break;
		default:
			break;
			}
		}
	
	private void week3() {
		// TODO Auto-generated method stub
		switch(day)
		{
		case 1 :
			d1w3();
			break;		
		case 2 :
			d2w3();
			break;
		case 3:
			d3w3();
			break;
		default:
			break;
			}
		}

	private void week4() {
		// TODO Auto-generated method stub
		switch(day)
		{
		case 1 :
			d1w4();
			break;		
		case 2 :
			d2w4();
			break;
		case 3:
			d3w4();
			break;
		default:
			break;
			}
		}

	private void week5() {
		// TODO Auto-generated method stub
		switch(day)
		{
		case 1 :
			d1w5();
			break;		
		case 2 :
			d2w5();
			break;
		case 3:
			d3w5();
			break;
		default:
			break;
			}
		}

	private void week6() {
		// TODO Auto-generated method stub
		switch(day)
		{
		case 1 :
			d1w6();
			break;		
		case 2 :
			d2w6();
			break;
		case 3:
			d3w6();
			break;
		default:
			break;
			}

	}
	@Override
	public void onBackPressed() {
	}
}

