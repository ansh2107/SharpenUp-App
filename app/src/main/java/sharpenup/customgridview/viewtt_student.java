package sharpenup.customgridview;




import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;
import android.os.AsyncTask;
import android.os.Build;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import sharpenup.customgridview.R;

@SuppressWarnings("deprecation")
public class viewtt_student extends Activity {
	
	
	int crashPreventer;
	String	DATE;
	String	DAY;
	String  FACULTY;
	String  SUBJECT;
	String  TOPIC;
	Spinner spinner_batch;
	Spinner spinner_class;
	Spinner spinner_center;
	Spinner spinner_fac;
	Spinner spinner_subject;
	TextView date_pend_up;
	TextView date_pend_down;
	List<String> categories_code;
	
	List<String> categories_description;
	List<String> categories_batch;
	List<String> categories_class;
	List<String> categories_center;
	List<String> categories_subject;
	List<String> categories_faculty;
	List<String[]> dataContainer;
	private Calendar calendar;
	UniversalTableLayout utl;
	//private TextView date_pend_down,date_pend_up,date_log_down,date_log_up;
	private int year, month, day;
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
	private PrefManager pref;
//	int flag,flag_btn_click;
	
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	@Override
	
	
	//-----------------------------------------------settting method--------------------------------------------------------------------
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewtt_student);
	dataContainer = new ArrayList<String[]>();
		getActionBar().hide();
		categories_code =new ArrayList<String>();
		//send =new ArrayList<String>();
		send = "";
		 categories_description =new ArrayList<String>();
		 calendar = Calendar.getInstance();
	      year = calendar.get(Calendar.YEAR);
	      crashPreventer=0;
	      month = calendar.get(Calendar.MONTH);
	      day = calendar.get(Calendar.DAY_OF_MONTH);
	      
		
		
		date_pend_up = (TextView) findViewById(R.id.pdh_student);
		date_pend_down = (TextView) findViewById(R.id.pdl_student);
		
		  showDate0(year, appending0(month+1),appending0( day));
	      showDate1(year,appending0(month+1),appending0( day));
	      /*showDate2(year, appending0(month+1),appending0( day));
	      showDate3(year, appending0(month+1),appending0( day));
	      */
	     
	      
	      
	      
	      pref = new PrefManager(getApplicationContext());
	  	
	      
	      
	      
	      
	      
	      
	      
	   /* spinner_fac = (Spinner) findViewById(R.id.faculty_student);
     
	        */
	        
	
	submit = (Button)findViewById(R.id.sub_cal_student);
	        
	submit.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			 AlertDialogManager alert = new AlertDialogManager();
		     ConnectionDetector    cd = new ConnectionDetector(getApplicationContext());

				// Check if Internet present
				if (!cd.isConnectingToInternet()) {
					// Internet Connection is not present
					alert.showAlertDialog(viewtt_student.this,
							"Internet Connection Error",
							"Please connect to working Internet connection", false);
					// stop executing code by return
					return;
				}
			new studentsview().execute();
			 
			
			
			
		}
	});
	

	
	
	
	
	
	
	}
	//-----------------------------------------------settting method ends--------------------------------------------------------------------
	
	 
    private class studentsview extends AsyncTask<String, Void, String> {
    	JSONObject json;
    	private ProgressDialog dialog = new ProgressDialog(viewtt_student.this);

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
			params.add(new BasicNameValuePair("datelow", date_pend_down.getText().toString()));
			params.add(new BasicNameValuePair("batch", pref.getBatch()));
			params.add(new BasicNameValuePair("datehigh", date_pend_up.getText().toString()));
			params.add(new BasicNameValuePair("class", pref.getclass()));
			params.add(new BasicNameValuePair("center", pref.getCenter()));

			//params.add(new BasicNameValuePair("subject", spinner_subject.getSelectedItem().toString()));
			//params.add(new BasicNameValuePair("faculty", spinner_fac.getSelectedItem().toString()));
			//params.add(new BasicNameValuePair("send", send));
			
			 String url = "http://176.32.230.250/anshuli.com/sharpenup2/view.php";
				
			
         json = jparser.makeHttpRequest(url, "POST", params);
			
			
		
     		
        	
			return null;
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result)
        {  			
        	
      this.dialog.dismiss();
      	 
    
		
  	try {
			// Checking for SUCCESS TAG
			
			
			
			
  		//categories_code.clear();
  		 ArrayList<String> arrayList = new ArrayList<String>();
  		ArrayList<String> arrayList1 = new ArrayList<String>();
			//Toast.makeText(MainActivity.this, (CharSequence) json, 1).show();
  		ArrayList<String> arrayList2 = new ArrayList<String>();
  		ArrayList<String> arrayList3 = new ArrayList<String>();
  		ArrayList<String> arrayList4 = new ArrayList<String>();
		
  		
  		 arrayList.add("DATE");
   	  
   	  
   	  arrayList1.add("FACULTY");
   	  
   	  
   	  arrayList2.add("SUBJECT");
   	  
   	  arrayList3.add("DAY");
   	  arrayList4.add("TOPIC");
				 JSONArray account= json.getJSONArray("pendings");
			        for(int i = 0; i < account.length(); i++)
			        {crashPreventer=1;
			        	json =account.getJSONObject(i);
			        	
	               // int day = 	myCal.get(Calendar.DAY_OF_MONTH);
			        		DATE=json.getString("DATE_HIGH");
			        	//	Date theDate = new Date(day);
			        	 //theDate = (Date) format.parse(DATE);
			        		DAY = json.getString("DAY");
			              FACULTY= json.getString("FACULTY");
			        	  SUBJECT= json.getString("SUBJECT");
			        	  TOPIC= json.getString("TOPIC");
			        				        	 	// categories_code.add(Roll+"-"+ NAME);
			        	 	//categories_description.add(description);
			        	/* date = new ArrayList<String>();
			        	 Collection l = Arrays.asList(date);
			        	date.add(DATE);
			        	 fac = new ArrayList<String>();
			        	 Collection m = Arrays.asList(fac);
				        	
			        	fac.add(FACULTY);
			        	 sub = new ArrayList<String>();
			        	 Collection n = Arrays.asList(sub);
				        	
			        	sub.add(SUBJECT);
			        	 	*/
			        	/*  String[] arr = null;
			        	  arr[i] = DATE;
			        	  String[] arr1 = null;
			        	  arr1[i] = FACULTY;
			        	  String[] arr2 = null;
			        	  arr2[i] = SUBJECT;*/
			        	  
			        	 
			        	  arrayList.add(DATE);
			        	  
			        	  
			        	  arrayList1.add(FACULTY);
			        	  
			        	  
			        	  arrayList2.add(SUBJECT);
			        	  
			        	  arrayList3.add(DAY);
			        	  arrayList4.add(TOPIC);
			        	    b=new Bundle();
					        b.putStringArrayList("date", arrayList);
					        b.putStringArrayList("faculty", arrayList1);
					        b.putStringArrayList("subject", arrayList2);
					        b.putStringArrayList("day", arrayList3);
					        b.putStringArrayList("topic", arrayList4);
						      
					         	
			        }
			        
			        dataContainer.clear();
			       dataContainer.add(arrayList.toArray( new String[arrayList.size()] ));
			       dataContainer.add(arrayList3.toArray( new String[arrayList3.size()] ));
			       dataContainer.add(arrayList2.toArray( new String[arrayList2.size()] ));
			       dataContainer.add(arrayList4.toArray( new String[arrayList4.size()] ));
			        // Intent i=new Intent(context, Class);
			        
			      if(crashPreventer==1) {
			    	  crashPreventer=0;
			    	  
			  utl=new UniversalTableLayout (dataContainer,viewtt_student.this );
			      }
			      else{
						Toast.makeText(viewtt_student.this, "Data empty!!!", Toast.LENGTH_SHORT).show();
					}
						
					     
			        
  	}
  	catch (Exception e) 
  	{
			e.printStackTrace();
			Toast.makeText(viewtt_student.this, "Internet connection error!!!", Toast.LENGTH_SHORT).show();
		} 

   //  setlist();
            
       }
    
 }
	
	
 
 
	
	
	
	
	
	
	
	
	
	
	
	

	
	//--------------------------------------------Date Time ranges-------------------------------------------
	
		   public void date_pend_low_range(View view) {
		      showDialog(999);
		   //   Toast.makeText(getApplicationContext(), "You Rock DUde!!", Toast.LENGTH_SHORT).show();
		      flag=0;
		   }
		
		
		  public void date_pend_high_range(View view) {
		      showDialog(999);
		    //  Toast.makeText(getApplicationContext(), "You Rock DUde!!", Toast.LENGTH_SHORT) .show();
		      flag=1;
		   }
		  
		/*@SuppressWarnings("deprecation")
		  public void date_logged_low(View view) {
		      showDialog(999);
		      //Toast.makeText(getApplicationContext(), "You Rock DUde!!", Toast.LENGTH_SHORT) .show();
		      flag=2;
		   }
		@SuppressWarnings("deprecation")
		  public void date_logged_high(View view) {
		      showDialog(999);
		     // Toast.makeText(getApplicationContext(), "You Rock DUde!!", Toast.LENGTH_SHORT) .show();
		      flag=3;
		   }
*/
		   @Override
		   protected Dialog onCreateDialog(int id) {
		      // TODO Auto-generated method stub
		      if (id == 999) {
		         return new DatePickerDialog(this, myDateListener, year, month, day);
		      }
		      return null;
		   }

		   private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
		      @Override
		      public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
		    	  
		    	  arg2=arg2+1;
		         // TODO Auto-generated method stub
		         // arg1 = year
		         // arg2 = month
		         // arg3 = day
		    	  String strm="";
		    	  String strd="";

	         strm =appending0(arg2);
	         strd  =appending0(arg3);  	  
		    	  if (flag==0)
		         showDate0(arg1, strm, strd);
		    	  else if  (flag==1)
		 	         showDate1(arg1, strm, strd);
		    	  /*else  if (flag==2)
		 	         showDate2(arg1, strm, strd);
		    	  else if (flag==3)
		 	         showDate3(arg1, strm, strd);*/
		      }
		   };
         private void showDate0(int year, String month, String day) {
			   date_pend_down.setText(new StringBuilder().append(year).append("-")
		      .append(month).append("-").append(day));
		   }
		   
		      public String appending0(int argument)
		      {String s;
		    	  
		    	  if (argument<10){
		    		  StringBuilder sb = new StringBuilder();
		    	  sb.append("0");
		    	  sb.append(argument);
		    	  s = sb.toString();
		    	  }
		    	  
		    	  else{
		    		  StringBuilder sb = new StringBuilder();
			    	 
			    	  sb.append(argument);
			    	  s = sb.toString();
		    	  }
		    	  
		    	  
		    	  return s;
		      }
		   
		   private void showDate1(int year, String month, String day) {
			   date_pend_up.setText(new StringBuilder().append(year).append("-")
					      .append(month).append("-").append(day));
		   }
		   /*private void showDate2(int year, String month, String day) {
			   date_log_down.setText(new StringBuilder().append(year).append("-")
					      .append(month).append("-").append(day));
		   }
		   private void showDate3(int year, String month, String day) {
			   date_log_up.setText(new StringBuilder().append(year).append("-")
					      .append(month).append("-").append(day));
		   }*/
		//-----------------------------------------------------------------------------------------------
		   

	
	
	
	
		   protected void setlist() {
		        // TODO Auto-generated method stub
				
		        dialogReg = new Dialog(viewtt_student.this);
		        dialogReg.requestWindowFeature(Window.FEATURE_NO_TITLE);
		        dialogReg.setContentView(R.layout.students);
		        
		        
		         lv1 = (ListView)dialogReg.findViewById(R.id.listView1);
		         lv1.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
		         lv1.setTextFilterEnabled(true);
		        viewall();
		               
				dialogReg.show();
		    }

		
	
	
	
		   public void onListItemClick(ListView parent, View v,int position,long id){
		
			}
	
		   private void viewall() {
				
			   ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(viewtt_student.this, android.R.layout.simple_list_item_checked, categories_code);
		   	   
		        lv1.setTextFilterEnabled(true);
		        lv1.setAdapter(dataAdapter); 
		        
			     // ListView Item Click Listener
			     lv1.setOnItemClickListener(new OnItemClickListener() {

			           @Override
			           public void onItemClick(AdapterView<?> parent, View view,
			              int position, long id) {
			             
			        	   CheckedTextView item = (CheckedTextView) view;
			            // ListView Clicked item index
			            int itemPosition     = position;
			            
			            // ListView Clicked item value
			            String  itemValue    = (String) lv1.getItemAtPosition(position);
			            
			            if(item.isChecked())
			            {
			            	
			            	/*send.add(itemValue);*/
			            	
			            	send = send + itemValue + "," ;
			            }
			            Toast.makeText(getApplicationContext(), itemValue + " checked : " +
			            		item.isChecked(), Toast.LENGTH_SHORT).show();
			            
			             Toast.makeText(getApplicationContext(),
			               "Position :"+itemPosition+"  ListItem : " +Toast.LENGTH_SHORT, itemPosition)
			               .show();
			          
			           }

			      }); 
				 
					}

}
