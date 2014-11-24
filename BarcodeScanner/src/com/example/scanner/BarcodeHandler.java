package com.example.scanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class BarcodeHandler extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		scanCode();
	}

	protected void scanCode() {
		Intent intent = new Intent("com.vinscan.barcode.SCAN");
		intent.putExtra("SCAN_MODE", "PRODUCT_MODE");
		
		if (intent.resolveActivity(getPackageManager()) != null) {
			startActivityForResult(intent, 0);
		} else {
		    Toast.makeText(this, "Restricted!", Toast.LENGTH_LONG).show();
		}
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);

		if (intent != null) {
			Log.i("", "kkk intent : " + intent);
			Log.i("", "kkk intent batch: " + intent.getStringExtra("batchid"));

			Toast toast = Toast.makeText(
					getApplicationContext(),
					"your scaned data received!" + " "
							+ intent.getStringExtra("batchid"),
					Toast.LENGTH_SHORT);

			toast.show();
		}

	}

}
