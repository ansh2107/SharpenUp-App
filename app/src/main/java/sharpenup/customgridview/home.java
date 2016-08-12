package sharpenup.customgridview;



import android.os.Build;
import android.os.Bundle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import sharpenup.customgridview.R;

public class home extends Activity {
	
	private PrefManager pref;
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		getActionBar().hide();
		  pref = new PrefManager(getApplicationContext());
		if(pref.getLogin() != null)
	       {
	    	   /*Intent reload = new Intent(LoginActivity.this, LoginActivity.class);
				startActivity(reload);
				finish();*/
	    	   
	    	   if( pref.getLogin().equals("child") )
	           {
	           	
	           	
	   	        // Toast.makeText(getApplicationContext(), "You are succesfully logged in as ADMIN.",Toast.LENGTH_SHORT).show();
	   				
	   			Intent admin = new Intent(home.this, MainActivityNew.class);
	   			startActivity(admin);
	   			finish();
	           	
	           }
	    	   
	    	   if( pref.getLogin().equals("admin") )
	           {
	           	
	           	
	   	        // Toast.makeText(getApplicationContext(), "You are succesfully logged in as ADMIN.",Toast.LENGTH_SHORT).show();
	   				
	   			Intent admin = new Intent(home.this, MainActivity.class);
	   			startActivity(admin);
	   			finish();
	           	
	           }
	            else if(pref.getLogin().equals("teacher"))
	           {
	           	Intent zebra = new Intent(home.this, MainActivityTeacher.class);
	   			
	   			startActivity(zebra);
	   			finish();
	           	
	           }
	           
	    	   
	       }
     ImageButton    create = (ImageButton) findViewById(R.id.studentlogin);

     create.setOnClickListener(new View.OnClickListener() {
        			
        			@Override
        			public void onClick(View v) {
        				
        				//pref.logout();
        				Intent intent = new Intent(home.this, LoginActivity2.class);
        				
        				startActivity(intent);
        				 
        				
        			}
        		});
        
        
     ImageButton view = (ImageButton) findViewById(R.id.proflogin);




        
        
        view.setOnClickListener(new View.OnClickListener() {
        			
        			@Override
        			public void onClick(View v) {
        				
        				//pref.logout();
        				Intent intent = new Intent(home.this, LoginActivity.class);
        				
        				startActivity(intent);
        				 
        				
        			}
        		});
		
		
	}


}
