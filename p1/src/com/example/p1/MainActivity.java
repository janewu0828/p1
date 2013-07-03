package com.example.p1;

import org.apache.cordova.*;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends DroidGap {
	public final String MyURL1 = "http://womany.net/debates/12";
	public final String MyURL2 = "http://womany.net/shares/339";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.loadUrl("file:///android_asset/www/index.html");
	}
	
	private void ShowAlertDialog(){
		Builder MyAlertDialog = new AlertDialog.Builder(this);
		MyAlertDialog.setTitle("相關");
		MyAlertDialog.setMessage("關於相關的事情");
		
		DialogInterface.OnClickListener OkClick = new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
			}	
		};
		
		DialogInterface.OnClickListener openURL = new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				loadUrl(MyURL1);
			}	
		};
		
		DialogInterface.OnClickListener openURL2 = new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				loadUrl(MyURL2);
			}	
		};
	
		MyAlertDialog.setPositiveButton("婚姻",openURL);
		MyAlertDialog.setNeutralButton("積極",OkClick);
		MyAlertDialog.setNegativeButton("右邊按鈕",OkClick);
		MyAlertDialog.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		menu.add(0, 0, 0, "說明");
		menu.add(0, 1, 1, "離開");
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
			case 0:
				ShowAlertDialog();
		        break;
		    case 1:
		         finish();
		         break;
		}
		return super.onOptionsItemSelected(item);
	}

}
