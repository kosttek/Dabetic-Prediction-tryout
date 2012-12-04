package pl.edu.agh.kosttek.diabetic.prediciton;

import pl.edu.agh.kosttek.diabetic.prediciton.data.MeasureSeries;
import pl.edu.agh.kosttek.diabetic.prediciton.data.PredictionSeries;
import pl.edu.agh.kosttek.diabetic.prediciton.ui.MeasureDataActivity;
import android.app.Application;

import com.jjoe64.graphview.GraphViewSeries;

public class GlucoseApplication extends Application {
	
//	private static GraphViewSeries graphViewSeries;

	private static PredictionSeries predictionSeries;
	private static MeasureSeries measureSeries;

	public static PredictionSeries getPredictionSeries() {
		return predictionSeries;
	}

	public static void setPredictionSeries(PredictionSeries predictionSeries) {
		GlucoseApplication.predictionSeries = predictionSeries;
	}

	public static MeasureSeries getMeasureSeries() {
		if(measureSeries == null)
			measureSeries = new MeasureSeries();
		return measureSeries;
	}

	public static void setMeasureSeries(MeasureSeries measureSeries) {
		GlucoseApplication.measureSeries = measureSeries;
	}
	


}
