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

public class ChooseClassOrTest extends Activity {
	
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choosett);
		getActionBar().hide();
		
     Button    create = (Button) findViewById(R.id.create1);

     create.setOnClickListener(new View.OnClickListener() {
        			
        			@Override
        			public void onClick(View v) {
        				
        				//pref.logout();
        				Intent intent = new Intent(ChooseClassOrTest.this, ScheduleClass.class);
        				
        				startActivity(intent);
        				 
        				
        			}
        		});
        
        
   Button view = (Button) findViewById(R.id.view1);




        
        
        view.setOnClickListener(new View.OnClickListener() {
        			
        			@Override
        			public void onClick(View v) {
        				
        				//pref.logout();
        				Intent intent = new Intent(ChooseClassOrTest.this, testSchedule.class);
        				
        				startActivity(intent);
        				 
        				
        			}
        		});
		
		
	}


}
