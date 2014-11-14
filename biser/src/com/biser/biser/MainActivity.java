package com.biser.biser;

import android.support.v7.app.ActionBarActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	
	/**
	 * bead finder class. 
	 * 
	 * The reference is made private in order to avoid multiple calls
	 * to that class. Each call invokes a sorting procedure that might 
	 * cause latency.
	 */
	private static BeadFinder _bf;
	
	/**
	 * _bf getter
	 * @return BeadFinder
	 */
	public BeadFinder getFinder(){
		return MainActivity._bf;
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        try {
        	if (this.getFinder() == null){
            	MainActivity._bf = new BeadFinder();
            	MainActivity._bf.insertIntoHash();
        	}
        } catch (Exception e){
        	MainActivity._bf = null;
        }
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
    	Resources res = getResources();
    	TextView colorField = (TextView) findViewById(R.id.pearlColor);
    	String colorString = colorField.getText().toString();
    	if(colorString.matches("\\d*-\\d*")){
    		colorString = colorString.replace('-', '/');
    		
    	};
    	if (colorString.equals("")){
    		return;
    	}
    	
    	colorField.setText("");
    	
        TextView positionField = (TextView) findViewById(R.id.position);
        String positionString = positionField.getText().toString();
        String result = colorString + ": ";
        String[] searchResult;
        BeadFinder finder = this.getFinder();
        
        try {
        	searchResult = finder.getByColor(colorString);
        	if (searchResult == null){
        		result = res.getString(R.string.absent);
        		String[] similar = finder.similar(colorString);
        		String similarAsString = "";
        		if (similar[0] != null){
        			similarAsString = similar[0] + " ";
        		}
        		if (similar[1] != null){
        			similarAsString = similarAsString + similar[1];
        		}
        		if (!similarAsString.equals("")){
        			result = result + " (" + similarAsString + ")";
        		}
        	} else {
        		result = searchResult[0] + " " +
        				res.getString(R.string.column) + " " +
        				searchResult[1] + " " +
        				res.getString(R.string.row) + " " +
        				searchResult[2];
        	}
        } catch (Exception e){
        	result = e.getMessage();
        } finally {
        	positionField.setText(colorString + ": " + result + '\n' + positionString);
        }
        
    }
}
