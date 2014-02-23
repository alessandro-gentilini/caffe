package com.example.caffe;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
    	Integer credit = sharedPref.getInt("credit", 0);
		TextView tv = (TextView) findViewById(R.id.textView_credito_residuo);
		tv.setText(credit.toString());		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void recharge(View view) {
		EditText editText = (EditText) findViewById(R.id.edit_charge_amount);
	    Integer charge;
		try {
			charge = Integer.parseInt(editText.getText().toString());
		    TextView tv = (TextView) findViewById(R.id.textView_credito_residuo);
			Integer current = Integer.parseInt(tv.getText().toString());
			Integer future = current+charge;
			tv.setText(future.toString());			
		} catch (NumberFormatException e) {
			Context context = getApplicationContext();
			CharSequence text = "Errore nel formato dei dati";
			int duration = Toast.LENGTH_SHORT;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
		}
		editText.setText("");
	}

	public void consume(View view) {
		TextView tv = (TextView) findViewById(R.id.textView_credito_residuo);

		Integer number = Integer.parseInt(tv.getText().toString());
		number = number - 30;
		tv.setText(number.toString());
	}	

}
