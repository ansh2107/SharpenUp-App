package sharpenup.customgridview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ObserveTool extends Activity{
	Button performEntry,viewEntry;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.atten);
		
	performEntry= (Button) findViewById(R.id.createatten);
	viewEntry= (Button) findViewById(R.id.viewatten);
	performEntry.setText("New Entry");
	viewEntry.setText("View All");
	performEntry.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(ObserveTool.this, ObserveToolEntry.class);
			
			startActivity(intent);
		}
	});
	
	
	}
	@Override
	  public void onBackPressed()
	   {
	     Intent i = new Intent(ObserveTool.this,MainActivity.class);
	     startActivity(i);
	     ObserveTool.this.finish();
	   }
}
