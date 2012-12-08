package pl.edu.agh.kosttek.diabetic.prediciton.data;

import pl.edu.agh.kosttek.diabetic.prediciton.GlucoseApplication;

import com.jjoe64.graphview.GraphViewSeries;

public class PredictionSeries {

	private long startTime;
	
	private static GraphViewSeries graphViewSeries;

	public static GraphViewSeries getGraphViewSeries() {
		return graphViewSeries;
	}

	public static void setGraphViewSeries(GraphViewSeries graphViewSeriesArg) {
		graphViewSeries = graphViewSeriesArg;
	}
}
