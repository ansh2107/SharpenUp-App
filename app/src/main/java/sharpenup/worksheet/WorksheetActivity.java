package sharpenup.worksheet;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import sharpenup.customgridview.R;
import sharpenup.customgridview.AlertDialogManager;
import sharpenup.customgridview.ConnectionDetector;
import sharpenup.customgridview.Entry;

public class WorksheetActivity extends Activity {
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worksheet);
        
        getActionBar().hide();
        
        AlertDialogManager alert = new AlertDialogManager();
	     ConnectionDetector    cd = new ConnectionDetector(getApplicationContext());

			// Check if Internet present
			if (!cd.isConnectingToInternet()) {
				// Internet Connection is not present
				alert.showAlertDialog(WorksheetActivity.this,
						"Internet Connection Error",
						"Please connect to working Internet connection", false);
				// stop executing code by return
				return;
			}
        
        b= (Button) findViewById(R.id.button1);
        
        
        
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    
    public void open (View v){
    	
    	Intent i = new Intent(this,Wsubmission.class);
    	startActivity(i);
    }
    
    
    public void adminworkbook (View v){
    	
    	Intent i = new Intent(this,AdminWorksheet.class);
    	startActivity(i);
    }
    
    public void teacherMode(View v)
    {
    	Intent i = new Intent(this,TeacherSelect.class);
    	startActivity(i);
    	
    }
    public void user(View v)
    {
    	Intent i = new Intent(this,User.class);
    	i.putExtra("user","user") ;
    	startActivity(i);
    	
    }
    
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
        	Intent i = new Intent(this,AdminWorksheet.class);
        	startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
