package de.derandroidpro.websitesuchetutorial;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	public Button webbutton;
	public Button suchbutton;
	public EditText et1;
	public String eingabe;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		webbutton = (Button) findViewById(R.id.button_web);
		webbutton.setOnClickListener(this);
		suchbutton = (Button) findViewById(R.id.button_search);
		suchbutton.setOnClickListener(this);
		et1 = (EditText) findViewById(R.id.editText1);
		
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		
		case R.id.button_web: {
			
			if (et1.getText().toString().length() >0) {
				
			
				try{
				eingabe = et1.getText().toString();	
				goToUrl(eingabe);
					
					
					
				}
				
				catch (Exception ex){
					
					Toast.makeText(getApplicationContext(), "Fehler!!", Toast.LENGTH_LONG).show();
					
				}
				
				
			}
			
			else {
				Toast.makeText(getApplicationContext(), "Bitte eine Website eingeben!!", Toast.LENGTH_SHORT).show();
				
				
			}
			
			// ACHTUNG CODE-ERGÄNZUNG: Damit nach dem 1. Case nicht automatisch das 2. Case ausgeführt wird, muss man am Ende des Cases "break;" ergänzen!!!
			break;
			
		}
		case R.id.button_search: {
			
			if (et1.getText().toString().length() >0) {
				eingabe = et1.getText().toString();
				
				Intent suchintent = new Intent (Intent.ACTION_WEB_SEARCH);
				suchintent.putExtra(SearchManager.QUERY, eingabe);
				startActivity(suchintent);
				
			
				
			}
			
			else {
				Toast.makeText(getApplicationContext(), "Bitte einen Suchbegriff eingeben!!", Toast.LENGTH_SHORT).show();
				
				
			}
			
			
			
			
		}
		
		
		}
		
	}

	
	public void goToUrl (String url) {
		
		Uri dieuri = Uri.parse(url);
		Intent webintent = new Intent (Intent.ACTION_VIEW, dieuri);
		startActivity(webintent);
		
		
	}
	

}
