
package sharpenup.customgridview;

import android.os.AsyncTask;






import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.widget.Toast;
import android.content.Context;
@SuppressWarnings("deprecation")
public class complainparser extends AsyncTask<String, String, String> {

	JSONParser jParser = new JSONParser();
	// url to get all products list
	private static String url = "http://176.32.230.250/anshuli.com/sharpenup2/stud_details.php";	// JSON Node names, 2 for counter, add data
	
	//String TAG_NAME = "name";

	// products JSONArray
	
	private Context parent;

	JSONArray user = null;
	JSONObject json;
	String output;
	int i = 0;
	String name;
	String parents;
	String school;
	String comment;
	String Prev_res;
	String van;
	String admts;
	String batch;
	String cls;
	String centre;
	String date_view;
	String pwd1;
	private String username;
	public complainparser(Context parent,String name,
			String username,
	String parents,	String school,
	String comment,
	String Prev_res,
	String van,
	String admts,
	String batch,
	String cls,
	String centre,
	String date_view,String pwd
			) {
				this.parent = parent;
				this.name=name;
				this.username=username;
				this.parents=parents;
				this.school=school;
				this.comment=comment;
				this.Prev_res=Prev_res;
				this.van=van;
				this.admts=admts;
				this.batch=batch;
				this.cls=cls;
				this.centre=centre;
				this.date_view=date_view;
				this.pwd1=pwd;
		
	}

			
			

			
			@Override
			protected void onPreExecute() {
				
			}

			/**
			 * getting All products from url
			 * */
			protected String doInBackground(String... args) {
				// Building Parameters
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("name",this.name));
				params.add(new BasicNameValuePair("username",this.username));
						params.add(new BasicNameValuePair("parents",this.parents));
						params.add(new BasicNameValuePair("school",this.school));
						params.add(new BasicNameValuePair("comment",this.comment));
						params.add(new BasicNameValuePair("Prev_res",this.Prev_res));
						params.add(new BasicNameValuePair("van",this.van));
						params.add(new BasicNameValuePair("admts",this.admts));
						params.add(new BasicNameValuePair("batch",this.batch));
						params.add(new BasicNameValuePair("cls",this.cls));
						params.add(new BasicNameValuePair("centre",this.centre));
						params.add(new BasicNameValuePair("date_view",this.date_view));
						params.add(new BasicNameValuePair("pwd",this.pwd1));
				
				
				json = jParser.makeHttpRequest(url, "POST", params);
				
				
				
	         return null;
			}
			
			
		/*	public HashMap<String,String> getUserInfo()
			{
				while(i==0);
				return userInfo;
				
			}
		*/
		/*	public HashMap<String,String> getUserInfo3()
			{
				while(i==0);
				return userInfo3;
				
			}
			public HashMap<String,String> getUserInfo4()
			{
				while(i==0);
				return userInfo4;
				
			}
			*/
			/**
			 * After completing background task Dismiss the progress dialog
			 * **/
			
			
			protected void onPostExecute(String file_url) {
				
				
				 try {
					String account= json.getString("pendings");
					
					if(account.equals("SUCCESS"))
					Toast.makeText(this.parent, "Student is successfully registered", Toast.LENGTH_SHORT).show();
					else
						Toast.makeText(this.parent, "Username already exits..", Toast.LENGTH_SHORT).show();
				} catch (JSONException e) {
					
					e.printStackTrace();
				}

			}

		//	public HashMap<String, String> getUserInfo1() {
			//	// TODO Auto-generated method stub
		//		while(i==0);
			//	return userInfo1;
		//	}

		

		

	
		
	

}
