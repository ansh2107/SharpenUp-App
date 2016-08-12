package sharpenup.customgridview;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;




import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import sharpenup.customgridview.R;


public class Entry extends Activity {

	EditText name;
	EditText username;
	EditText school;
	EditText comment;
	EditText Prev_res;
	EditText van;
	EditText admts;
	EditText pwd;
	Spinner batch;
	Spinner cls;
	Spinner parents;
	Spinner centre;
	TextView date_1;
	List<String> batch_;
	List<String> parent_;
	List<String> cls_;
	List<String> centre_;
	String date_view;
	String autoGenPass;
	private Calendar calendar;
	private int year, month, day;
	Button doj;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
  

        setContentView(R.layout.entry);
        getActionBar().hide();
        AlertDialogManager alert = new AlertDialogManager();
	     ConnectionDetector    cd = new ConnectionDetector(getApplicationContext());

			// Check if Internet present
			if (!cd.isConnectingToInternet()) {
				// Internet Connection is not present
				alert.showAlertDialog(Entry.this,
						"Internet Connection Error",
						"Please connect to working Internet connection", false);
				// stop executing code by return
				return;
			}
		 
    	 name = (EditText)findViewById(R.id.name);
    	 username = (EditText)findViewById(R.id.username);
    	 school = (EditText)findViewById(R.id.school);
    	 comment = (EditText)findViewById(R.id.comment);
    	 Prev_res = (EditText)findViewById(R.id.Prev_res);
    	 van = (EditText)findViewById(R.id.van);
    	 admts = (EditText)findViewById(R.id.admts);
    	 batch =(Spinner) findViewById(R.id.batchreg);
    	 cls =(Spinner) findViewById(R.id.cls);
    	 centre =(Spinner) findViewById(R.id.centre);
    	 parents =(Spinner) findViewById(R.id.parent);
    	 date_1=(TextView)findViewById(R.id.date_1);
    	// pwd=(EditText) findViewById(R.id.passwordassign);
    	
    	 
    	 
    	
    	 batch_= new ArrayList<String>();
    	 parent_= new ArrayList<String>();
    	 cls_= new ArrayList<String>();
    	 centre_= new ArrayList<String>();
    	  calendar = Calendar.getInstance();
          year = calendar.get(Calendar.YEAR);
          doj=(Button)findViewById(R.id.date_of_join);
          
          month = calendar.get(Calendar.MONTH);
          day = calendar.get(Calendar.DAY_OF_MONTH);
          showDate(year, month+1, day);
          
          
          batch_.add("SELECT BATCH");
         batch_.add("A");
         batch_.add("B");
         batch_.add("C");
          // Creating adapter for spinner
          ArrayAdapter<String> dataAdapterbatch = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, batch_);
          
          // Drop down layout style - list view with radio button
          dataAdapterbatch.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
          
          // attaching data adapter to spinner
          batch.setAdapter(dataAdapterbatch);
          
          parent_.add("SELECT PARENT");
          parent_.add("MOTHER");
          parent_.add("FATHER");
          parent_.add("OTHER");
           // Creating adapter for spinner
           ArrayAdapter<String> dataAdapterparent = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, parent_);
           
           // Drop down layout style - list view with radio button
           dataAdapterparent.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
           
           // attaching data adapter to spinner
           parents.setAdapter(dataAdapterparent);
          
          
          //----------------------------------------------------------------


		cls_.add("SELECT CLASS");
		cls_.add("Junior");
		cls_.add("6th");
          cls_.add("7th");
          cls_.add("8th");
          cls_.add("9th");
          cls_.add("10th");
           // Creating adapter for spinner
           ArrayAdapter<String> dataAdapterclass = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cls_);
           
           // Drop down layout style - list view with radio button
           dataAdapterclass.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
           
           // attaching data adapter to spinner
           cls.setAdapter(dataAdapterclass);
          
          
          
         //-----------------------------------------------------------------------------------------
           
           
           
           
           centre_.add("SELECT CENTRE");
           centre_.add("DDN");
           centre_.add("RT");
           centre_.add("CC");
           centre_.add("PB");
         
            // Creating adapter for spinner
            ArrayAdapter<String> dataAdaptercentre = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, centre_);
            
            // Drop down layout style - list view with radio button
            dataAdaptercentre.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            
            // attaching data adapter to spinner
            centre.setAdapter(dataAdaptercentre);
           
           
           
           
           
           
           
           
           
           
           //---------------------------------------------------------
          
          
          
          

   
}
protected boolean entryChecker(){
	
	boolean flag=true;
	
	if( name.getText().toString().equals(""))
		flag=false;
	if( username.getText().toString().equals(""))
		flag=false;
	if( school.getText().toString().equals(""))
		flag=false;
	if( comment.getText().toString().equals(""))
		flag=false;
	if( Prev_res.getText().toString().equals(""))
		flag=false;
	if( van.getText().toString().equals(""))
		flag=false;
	if( admts.getText().toString().equals(""))
		flag=false;
	if( batch.getSelectedItem().toString().equals("SELECT BATCH"))
		flag=false;
	if( cls.getSelectedItem().toString().equals("SELEC CLASS"))
		flag=false;
	if( centre.getSelectedItem().toString().equals("SELECT CENTRE"))
		flag=false;
	if( parents.getSelectedItem().toString().equals("SELECT PARENT"))
		flag=false;

	
	return flag;
	
}
	
	
	
	 @SuppressWarnings("deprecation")
	    public void join_date(View view) {
	       showDialog(999);
	      // Toast.makeText(getApplicationContext(), "ca", Toast.LENG .show();
	    }

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
	          // TODO Auto-generated method stub
	          // arg1 = year
	          // arg2 = month
	          // arg3 = day
	          showDate(arg1, arg2+1, arg3);
	       }
	    };
	
	 private void showDate(int year, int month, int day) {
	       date_1.setText(new StringBuilder().append(year).append("-")
	       .append(month).append("-").append(day));
	       date_view =""+String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(day);
	      // Toast.makeText(this, "date_view:" + date_view, 1).show();
	    }

	 public void submit(View view) {
		 if(entryChecker()){
			 DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
				    @Override
				    public void onClick(DialogInterface dialog, int which) {
				        switch (which){
				        case DialogInterface.BUTTON_POSITIVE:
				       	 autoGenPass= name.getText().toString().replaceAll("\\s+","")+"123";
				 		@SuppressWarnings("unused")
				 		String n= name.getText().toString();
				 		 try{

				 				complainparser userinfo = new complainparser(getBaseContext(),
				 						name.getText().toString(),
				 						username.getText().toString(),
				 						parents.getSelectedItem().toString(),
				 						school.getText().toString(),
				 						comment.getText().toString(),
				 						Prev_res.getText().toString(),
				 						van.getText().toString(),
				 						admts.getText().toString(),
				 						batch.getSelectedItem().toString(),
				 						cls.getSelectedItem().toString(),
				 						centre.getSelectedItem().toString(),
				 				           date_view,autoGenPass);
				 				
				 				
				 		        	userinfo.execute();
				 				
				 		        	/*Toast.makeText(getApplicationContext(), "Student details has been submitted been sucessfully l",
				 		        			   Toast.LENGTH_LONG).show();*/
				 				}
				 				catch(Exception e)
				 				{
				 					
				 					
				 				}
				            break;

				        case DialogInterface.BUTTON_NEGATIVE:
				            //No button clicked
				            break;
				        }
				    }
				};

				AlertDialog.Builder builder = new AlertDialog.Builder(Entry.this);
				builder.setMessage("Are you sure you want to schedule this deadline for this faculty?").setPositiveButton("Yes", dialogClickListener)
				    .setNegativeButton("No", dialogClickListener).show();}
			 
			 
			 
			 
			 
	
		 
		 
		 
		 else{
			 Toast.makeText(Entry.this, "Please Select all fields!!!", Toast.LENGTH_SHORT).show();
		 }
		   }
	
	
	
	
	
	
}
