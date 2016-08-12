package sharpenup.previous.sharpenup;
   	




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import sharpenup.customgridview.R;





import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


@SuppressWarnings("deprecation")
public class buttons extends Activity {
	
	Button pendings;
	Button feed;
	Button search;
    private PrefManager pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttons);
        getActionBar().hide();
        pref = new PrefManager(getApplicationContext());
        
        //String pending_status =  DataHolderClass.getInstance().getDistributor_id();
        
        if(pref.getEvent() != null)
        {
        	 Notify();
        	
        	
        }
        
        
    /*Button    logout = (Button) findViewById(R.id.logout1);




        
        
        logout.setOnClickListener(new View.OnClickListener() {
        			
        			@Override
        			public void onClick(View v) {
        				
        				pref.logout();
        				Intent intent = new Intent(buttons.this, LoginData.class);
        				
        				startActivity(intent);
        			
        				
        			}
        		});
        */
        
pendings = (Button) findViewById(R.id.pendings);




        
        
pendings.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				Intent intent = new Intent(buttons.this, Pendings.class);
				intent.putExtra("back", "button");
				startActivity(intent);
				finish();
				
			}
		});
        

feed = (Button) findViewById(R.id.feed);


feed.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				Intent intent = new Intent(buttons.this, MainData.class);
				
				startActivity(intent);
				finish();		
			}
		});   
        
        
search = (Button) findViewById(R.id.search);






search.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				Intent intent = new Intent(buttons.this, SearchActivity.class);
				intent.putExtra("back", "button");
				startActivity(intent);
				finish();
				
			}
		});
        
        
        
        
        
        
    }
    
    
    
    @SuppressLint("NewApi") private void Notify(){
       /* NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        @SuppressWarnings("deprecation")
        
        Notification notification = new Notification(R.drawable.ic_launcher,"New Message", System.currentTimeMillis());
        Intent notificationIntent = new Intent(this,Pendings.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,notificationIntent, 0);
        
        notification.setLatestEventInfo(buttons.this, notificationTitle,notificationMessage, pendingIntent);
        notificationManager.notify(9999, notification);
        notification.defaults |= Notification.DEFAULT_SOUND;
        notification.defaults |= Notification.DEFAULT_VIBRATE;*/
    	
    	 // define sound URI, the sound to be played when there's a notification
        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        // intent triggered, you can add other intent for other actions
        Intent intent = new Intent(buttons.this, Pendings.class);
        PendingIntent pIntent = PendingIntent.getActivity(buttons.this, 0, intent, 0);

        // this is it, we'll build the notification!
        // in the addAction method, if you don't want any icon, just set the first param to 0
        Notification mNotification = new Notification.Builder(this)

            .setContentTitle("Pendings")
            .setContentText("You have pending list to complete.")
            .setSmallIcon(R.drawable.ic_launcher)
            .setContentIntent(pIntent)
            .setSound(soundUri)

            .addAction(R.drawable.ic_launcher, "View", pIntent)
           

            .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // If you want to hide the notification after it was selected, do the code below
        // myNotification.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0, mNotification);
    }

    public void cancelNotification(int notificationId){

        if (Context.NOTIFICATION_SERVICE!=null) {
            String ns = Context.NOTIFICATION_SERVICE;
            NotificationManager nMgr = (NotificationManager) getApplicationContext().getSystemService(ns);
            nMgr.cancel(notificationId);
        }
    }
    	
    	
    	
    
     
    

}
