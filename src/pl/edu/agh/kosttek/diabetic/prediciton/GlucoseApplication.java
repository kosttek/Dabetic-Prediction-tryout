package pl.edu.agh.kosttek.diabetic.prediciton;

import android.app.Application;

import com.jjoe64.graphview.GraphViewSeries;

public class GlucoseApplication extends Application {

	//TODO
	private long startTime;
//	private double time[];
//	private double value[];
	
	private static GraphViewSeries graphViewSeries;

	public static GraphViewSeries getGraphViewSeries() {
		return graphViewSeries;
	}

	public static void setGraphViewSeries(GraphViewSeries graphViewSeries) {
		GlucoseApplication.graphViewSeries = graphViewSeries;
	}

}
