package com.manish.hellojni;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HelloMainActivity extends Activity {
	
	Button loadSOBtn, exitBtn;
	TextView displayTv;
	private native String print();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello_main);
		
		loadSOBtn = (Button) findViewById(R.id.bLoadObject);
		exitBtn = (Button) findViewById(R.id.bExit);
		displayTv = (TextView) findViewById(R.id.tv);
		
		loadSOBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//load shared object
				try {
					System.loadLibrary("hellojni");
					
				} catch(UnsatisfiedLinkError e) {
					Log.i("Sample", "Exception>>:"+ e.getMessage());
					e.getStackTrace();
					displayTv.setText(e.getMessage());
				} catch(Exception ex) {
					System.out.println("exception:: "+ex.getMessage());
					displayTv.setText(ex.getMessage());
				}
				displayTv.setText(print());
			}
		});
		
		exitBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Close the Application
				finish();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hello_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
