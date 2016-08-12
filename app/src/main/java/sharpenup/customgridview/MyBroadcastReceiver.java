package sharpenup.customgridview;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class MyBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive( Context context, Intent intent) {
		try {
		
			 Intent ll24Service = new Intent(context, MyService.class);
			 context.startService(ll24Service);
			 
			 
			 
				Intent intent1 = new Intent(context, MyBroadcastReceiver.class);
				intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				PendingIntent pendingIntent = PendingIntent.getBroadcast(
						context, 234324243, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
				 AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
				alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+ (30 * 1000), pendingIntent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
		}
			
		}
		
		
		

	
	}
	

