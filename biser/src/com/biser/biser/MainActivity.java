package com.biser.biser;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    
    public void findPearl(View view){
    	TextView colorField = (TextView) findViewById(R.id.pearlColor);
    	String colorString = colorField.getText().toString();
    	if(colorString.matches("\\d+-\\d+")){
    		colorString = colorString.replace('-', '/');
    		
    	};
    	colorField.setText("");
    	
        TextView positionField = (TextView) findViewById(R.id.position);
        String positionString = positionField.getText().toString();
        String result = colorString + ": ";
        String searchResult = "";
        BeadFinder finder = new BeadFinder();
        try {
        	finder.insertIntoHash();
        	searchResult = finder.getByColor(colorString);
        	if (searchResult == null){
        		searchResult = "відсутній";
        	}
        } catch (Exception e){
        	searchResult = e.getMessage();
        } finally {
        	result = colorString + ": " + searchResult + '\n';
        	positionField.setText(result + positionString);
        }
        
    }
}
