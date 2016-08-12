package sharpenup.customgridview;




import java.util.ArrayList;
import java.util.List;
















import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.os.AsyncTask;
import android.os.Build;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import sharpenup.customgridview.R;

@SuppressWarnings("deprecation")
public class upload extends Activity {
	
	String	DATE;
	String	DAY;
	
	String  FACULTY;
	String  SUBJECT;
	Spinner spinner_batch;
	Spinner spinner_class;
	Spinner spinner_center;
	Spinner spinner_fac;
	Spinner spinner_subject;
	TextView date_pend_up;
	TextView date_pend_down;
	List<String> categories_code;
	List<String> categories_pendact;
	List<String> categories_description;
	List<String> categories_batch;
	List<String> categories_class;
	List<String> categories_center;
	List<String> categories_subject;
	List<String> list;
	List<String> categories_faculty;

	//private TextView date_pend_down,date_pend_up,date_log_down,date_log_up;

	int flag,flag_btn_click;
	
	Button submit;
	JSONParser jparser = new JSONParser();
	Dialog dialogReg;
	ListView lv1;
	String send ;
	ArrayList<String> date;
	ArrayList<String> fac;
	ArrayList<String> sub;
	Bundle b;
	EditText id;
//	int flag,flag_btn_click;
	
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	@Override
	
	
	//-----------------------------------------------settting method--------------------------------------------------------------------
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.upload);
		getActionBar().hide();
		
	
	
	id = (EditText)findViewById(R.id.myid);
	
	submit = (Button)findViewById(R.id.mybt);
	
	submit.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
	
			 DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
				    @Override
				    public void onClick(DialogInterface dialog, int which) {
				        switch (which){
				        case DialogInterface.BUTTON_POSITIVE:
				        	//getSelectedItems();
				        	new time().execute(); 
				        	//Yes button clicked
				            break;

				        case DialogInterface.BUTTON_NEGATIVE:
				            //No button clicked
				            break;
				        }
				    }
				};

				AlertDialog.Builder builder = new AlertDialog.Builder(upload.this);
				builder.setMessage("Are you sure you want to download the answer key?").setPositiveButton("Yes", dialogClickListener)
				    .setNegativeButton("No", dialogClickListener).show();}
		
	});
	
	}
	//-----------------------------------------------settting method ends--------------------------------------------------------------------
	 
    private class time extends AsyncTask<String, Void, String> {
    	
    	private ProgressDialog dialog = new ProgressDialog(upload.this);

        /** progress dialog to show user that the backup is processing. */
        /** application context. */

        protected void onPreExecute() {
            this.dialog.setMessage("Miles to go...");
            this.dialog.show();
        }
    	
    	
        @Override
        protected String doInBackground(String... urls) 
        {
        	List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("id", id.getText().toString()));
			
			
			 String url = "http://176.32.230.250/anshuli.com/sharpenup2/download.php";
				
			
         jparser.makeHttpRequest(url, "POST", params);
			
			
	
     		
        	
			return null;
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result)
        {  			
        	
      this.dialog.dismiss();
      	 
     Intent time = new Intent(upload.this,webview.class);
		startActivity(time);
		 
     
            
       }
    
 }
		   
		   
}
