package sharpenup.worksheet;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sharpenup.customgridview.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UserLogin extends Activity {
EditText user;
EditText pass;
String flag;
String roll;
String center;
String batch;
String cls;
String name;
JSONParser jparser = new JSONParser();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.studentlogin);
		flag="";
		
		user=(EditText) findViewById(R.id.studet);
		pass=(EditText) findViewById(R.id.passet);
		
	}

	
	
	
	public void enter(View v){
		
new studentsview1().execute();

	
		
	}
	
	
	
	 private class studentsview1 extends AsyncTask<String, Void, String> {
	    	JSONObject json;
	    	 String parts[];
	    	private ProgressDialog dialog = new ProgressDialog(UserLogin.this);

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
				//params.add(new BasicNameValuePair("datelow", date_pend_down.getText().toString()));
				params.add(new BasicNameValuePair("username", user.getText().toString()));
				//params.add(new BasicNameValuePair("center", spinner_center.getSelectedItem().toString()));
				params.add(new BasicNameValuePair("password", pass.getText().toString()));
			
				 String url = "http://176.32.230.250/anshuli.com/sharpenup3/studDetails.php";
					
				 
				
	         json = jparser.makeHttpRequest(url, "POST", params);
				
				
				//JSONArray jsonArray;
	     		
	        	
				return null;
	        }
	        // onPostExecute displays the results of the AsyncTask.
	        @Override
	        protected void onPostExecute(String result)
	        {  			
	        	
	      this.dialog.dismiss();
	      	 
	    //JSONArray jsonArray;
			
	  	try {
				// Checking for SUCCESS TAG
				
	  		//forjson.clear();
				
				
				//Toast.makeText(MainActivity.this, (CharSequence) json, 1).show();
			
					 JSONArray account= json.getJSONArray("pendings");
				        for(int i = 0; i < account.length(); i++)
				        {
				        	json =account.getJSONObject(i);
				        	flag=json.getString("NAME");
				        	roll=json.getString("ROLL");
				        	name=json.getString("NAME");
				        	cls=json.getString("CLASS");
				        	batch=json.getString("BATCH");
				        	center=json.getString("CENTRE");
				        
				        	 	
				        }
				       
				      
				        
	  	}
	  	catch (JSONException e) 
	  	{
				e.printStackTrace();
			}

if(flag.equals("")){
	Toast.makeText(UserLogin.this, "Check Your Credentials", 1).show();

	       }
else{
	
	Intent intent =new Intent(UserLogin.this,User.class);
	
	Bundle extras = new Bundle();
	extras.putString("EXTRA_USERNAME",user.getText().toString());
	extras.putString("EXTRA_PASSWORD",pass.getText().toString());
	extras.putString("name",name);
	extras.putString("roll",roll);
	extras.putString("batch",batch);
	extras.putString("center",center);
	extras.putString("class",cls);
	intent.putExtras(extras);
	startActivity(intent); 

	
}
	    
	 }	 
	
	
	
	 }
}
