package pl.edu.agh.kosttek.diabetic.prediciton.ui;

import pl.edu.agh.kosttek.diabetic.prediciton.GlucoseApplication;
import pl.edu.agh.kosttek.diabetic.prediciton.R;
import pl.edu.agh.kosttek.diabetic.prediciton.ui.widget.TimeGraphView;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuItem.OnMenuItemClickListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries;

public class GraphActivity extends SherlockActivity {
	GraphView graphView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		graphView = createGraph();
		LinearLayout layout = (LinearLayout) findViewById(R.id.graph);
		layout.addView(graphView);

	}

	private GraphView createGraph() {
		// init example series data
	
		GraphViewSeries exampleSeries = getGraphSeriesData();
		TimeGraphView graphView = new TimeGraphView(this // context
				, "Glucose" // heading
		);

		graphView.addSeries(exampleSeries);
		setMeasure(graphView);
		return graphView;
	}
	
	void setMeasure(GraphView graphView){
		if(GlucoseApplication.getMeasureSeries().getGraphViewSeries()!=null){
			graphView.addSeries(GlucoseApplication.getMeasureSeries().getGraphViewSeries());
		}
	}

	private GraphViewSeries getGraphSeriesData() {
		
		GraphViewSeries exampleSeries;
		exampleSeries = GlucoseApplication.getPredictionSeries().getGraphViewSeries();
		
		if (exampleSeries == null) {
			exampleSeries = new GraphViewSeries(new GraphViewData[] {
					new GraphViewData(1, 2.0d), new GraphViewData(2, 1.5d),
					new GraphViewData(3, 2.5d), new GraphViewData(4, 1.0d) });
			GlucoseApplication.getPredictionSeries().setGraphViewSeries(exampleSeries);
		}
		
		return exampleSeries;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.add("Fill data").setIcon(R.drawable.ic_compose)
				.setOnMenuItemClickListener(new OnFillClickListener())
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		menu.add("Fill measure data").setIcon(android.R.drawable.ic_input_add)
			.setOnMenuItemClickListener(new OnMeasureClickListener())
			.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

		menu.add("Refresh")
				.setIcon(R.drawable.ic_refresh)
				.setOnMenuItemClickListener(new OnRefreshClickListener())
				.setShowAsAction(
						MenuItem.SHOW_AS_ACTION_IF_ROOM
								| MenuItem.SHOW_AS_ACTION_WITH_TEXT);

		return true;
	}

	class OnFillClickListener implements OnMenuItemClickListener {

		public boolean onMenuItemClick(MenuItem item) {
			Intent intent = new Intent(GraphActivity.this,
					FillDataActivity.class);
			startActivity(intent);
			return false;
		}
	}
	
	class OnMeasureClickListener implements OnMenuItemClickListener {

		public boolean onMenuItemClick(MenuItem item) {
			Intent intent = new Intent(GraphActivity.this,
					MeasureDataActivity.class);
			startActivity(intent);
			return false;
		}
	}

	class OnRefreshClickListener implements OnMenuItemClickListener {

		public boolean onMenuItemClick(MenuItem item) {
			Intent intent = new Intent(GraphActivity.this, GraphActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			//TODO do not work on 4.0 works on 2.2 
//			GlucoseApplication.getGraphViewSeries().resetData(new GraphViewData[] {
//					new GraphViewData(1, 1.2d), new GraphViewData(2, 1.5d),
//					new GraphViewData(3, 2.5d), new GraphViewData(4, 1.0d) });
//			GlucoseApplication.getGraphViewSeries().appendData(new GraphViewData(5, 1.2d), false);
//			GraphActivity.this.recreate();
//			GraphActivity.this.findViewById(R.id.graph).invalidate();
//			graphView.removeSeries(getGraphSeriesData());
//			GlucoseApplication.setGraphViewSeries(new GraphViewSeries(new GraphViewData[] {
//					new GraphViewData(1, 1.2d), new GraphViewData(2, 1.5d),
//					new GraphViewData(3, 2.5d), new GraphViewData(4, 1.0d) }));
//			graphView.addSeries(getGraphSeriesData());
//			graphView.invalidate();
//			GraphActivity.this.findViewById(R.id.graph).invalidate();
			
			
			return false;
		}
	}
}
