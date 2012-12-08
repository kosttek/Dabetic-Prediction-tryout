package pl.edu.agh.kosttek.diabetic.prediciton.data;

import pl.edu.agh.kosttek.diabetic.prediciton.GlucoseApplication;

import android.graphics.Color;

import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.GraphViewSeries.GraphViewStyle;

public class MeasureSeries {

	private long startTime;
	
	private static GraphViewSeries graphViewSeries;

	public static GraphViewSeries getGraphViewSeries() {
		return graphViewSeries;
	}

	public static void setGraphViewSeries(GraphViewSeries graphViewSeriesArg) {
		graphViewSeries = graphViewSeriesArg;
	}
	
	public void add(Double time , Double yValue){
		GraphViewData value = new GraphViewData(time, yValue);
		if(graphViewSeries != null){
			graphViewSeries.appendData(value, false);

		}else{
			GraphViewStyle style = new GraphViewStyle(Color.rgb(120, 200, 40), 3);
			graphViewSeries = new GraphViewSeries("measure",style,new GraphViewData[] {value});
		}
	}
}
