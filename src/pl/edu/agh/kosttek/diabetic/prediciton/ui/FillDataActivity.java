package pl.edu.agh.kosttek.diabetic.prediciton.ui;

import pl.edu.agh.kosttek.diabetic.prediciton.GlucoseApplication;
import pl.edu.agh.kosttek.diabetic.prediciton.R;
import pl.edu.agh.kosttek.diabetic.prediciton.data.ConvertEulerOnSeries;
import pl.edu.agh.kosttek.diabetic.prediciton.data.Euler;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.jjoe64.graphview.GraphViewSeries;

public class FillDataActivity extends SherlockActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_data);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        Button button = (Button)findViewById(R.id.compute);
        button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				computeAction();
				Intent intent = new Intent(FillDataActivity.this, GraphActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.activity_fill_data, menu);
        return true;
    }

    
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//        
//            case android.R.id.home:
//                NavUtils.navigateUpFromSameTask(this);
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    protected void computeAction(){
    	EditText glucoseEdit = (EditText)findViewById(R.id.glucose_edit);
    	EditText insulinEdit = (EditText)findViewById(R.id.insulin_edit);
    	double insulin = new Double(insulinEdit.getText().toString());
    	double glucose = new Double(glucoseEdit.getText().toString());
    	
    	Euler euler = new Euler();
    	euler.compute(insulin, glucose);
    	
    	GraphViewSeries series = ConvertEulerOnSeries.convert(euler);
    	GlucoseApplication.setGraphViewSeries(series);
    }
}
