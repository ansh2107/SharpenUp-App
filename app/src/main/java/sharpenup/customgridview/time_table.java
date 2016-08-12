package sharpenup.customgridview;



import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import sharpenup.customgridview.R;

public class time_table extends Activity {
	
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timetable);
		getActionBar().hide();
		  AlertDialogManager alert = new AlertDialogManager();
		     ConnectionDetector    cd = new ConnectionDetector(getApplicationContext());

				// Check if Internet present
				if (!cd.isConnectingToInternet()) {
					// Internet Connection is not present
					alert.showAlertDialog(time_table.this,
							"Internet Connection Error",
							"Please connect to working Internet connection", false);
					// stop executing code by return
					return;
				}
			  
     Button    create = (Button) findViewById(R.id.create);

     create.setOnClickListener(new View.OnClickListener() {
        			
        			@Override
        			public void onClick(View v) {
        				
        				//pref.logout();
        				Intent intent = new Intent(time_table.this, ChooseClassOrTest.class);
        				
        				startActivity(intent);
        				 
        				
        			}
        		});
        
        
   Button view = (Button) findViewById(R.id.view);




        
        
        view.setOnClickListener(new View.OnClickListener() {
        			
        			@Override
        			public void onClick(View v) {
        				
        				//pref.logout();
        				Intent intent = new Intent(time_table.this, view.class);
        				
        				startActivity(intent);
        				 
        				
        			}
        		});
		
		
	}


}
