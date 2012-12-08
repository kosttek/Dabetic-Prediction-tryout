package pl.edu.agh.kosttek.diabetic.prediciton.ui;

import java.util.Calendar;
import java.util.Date;

import pl.edu.agh.kosttek.diabetic.prediciton.GlucoseApplication;
import pl.edu.agh.kosttek.diabetic.prediciton.R;
import pl.edu.agh.kosttek.diabetic.prediciton.ui.GraphActivity.OnFillClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuItem.OnMenuItemClickListener;

public class MeasureDataActivity extends SherlockFragmentActivity {
	TimePicker timeEdit ; 
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_measure_data);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		Button button = (Button) findViewById(R.id.show);
		button.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				computeAction();
				Intent intent = new Intent(MeasureDataActivity.this, GraphActivity.class);
				startActivity(intent);
			}
		});
		Button buttonNext = (Button) findViewById(R.id.next);
		buttonNext.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				computeAction();

			}
		});
		Calendar c = Calendar.getInstance(); 
		timeEdit = (TimePicker) findViewById(R.id.time_edit);
		timeEdit.setIs24HourView(true);
		timeEdit.setCurrentHour(c.get(Calendar.HOUR_OF_DAY));
		timeEdit.setCurrentMinute(c.get(Calendar.MINUTE));
		timeEdit.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				showAction(v);

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.add("Fill data").setIcon(R.drawable.abs__ic_go)
				.setOnMenuItemClickListener(new OnNextClickListener())
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		return true;
		}



	protected void showAction(View v) {
	    
	}
	class OnNextClickListener implements OnMenuItemClickListener {

		public boolean onMenuItemClick(MenuItem item) {
			computeAction();
			return false;
		}
	}
	
	protected void computeAction() {
		Calendar c = Calendar.getInstance(); 
		c.setTime(new Date(System.currentTimeMillis()));
		c.set(Calendar.HOUR_OF_DAY, timeEdit.getCurrentHour());
		c.set(Calendar.MINUTE, timeEdit.getCurrentMinute());
	    Toast.makeText(this, "added", Toast.LENGTH_SHORT).show();
	    EditText glucose = (EditText) findViewById(R.id.glucose_edit);
	    Double time = new Double(c.getTime().getTime()/1000);
	    Double gluValue = new Double(glucose.getEditableText().toString());
	    GlucoseApplication.getMeasureSeries().add(time, gluValue);
	}
	
}

