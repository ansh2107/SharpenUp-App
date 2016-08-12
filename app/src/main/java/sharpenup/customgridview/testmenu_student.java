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

public class testmenu_student extends Activity {
	
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.testmenu_student);
		getActionBar().hide();
		
     Button    create = (Button) findViewById(R.id.viewtt_student);

     create.setOnClickListener(new View.OnClickListener() {
        			
        			@Override
        			public void onClick(View v) {
        				
        				//pref.logout();
        				Intent intent = new Intent(testmenu_student.this, testview_student.class);
        				
        				startActivity(intent);
        				 
        				
        			}
        		});
        
  
Button upload = (Button) findViewById(R.id.upload_student);
		
        upload.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//pref.logout();
				Intent intent = new Intent(testmenu_student.this, webview_student.class);
				
				startActivity(intent);
				 
				
			}
		});
        

Button stud = (Button) findViewById(R.id.stud_view_student);
		
        stud.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//pref.logout();
				Intent intent = new Intent(testmenu_student.this, viewscores_student.class);
				
				startActivity(intent);
				 
				
			}
		});
        
		
	}


}
