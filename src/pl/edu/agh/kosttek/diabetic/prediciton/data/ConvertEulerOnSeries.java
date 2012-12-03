package pl.edu.agh.kosttek.diabetic.prediciton.data;

import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries;

public class ConvertEulerOnSeries {
	static public GraphViewSeries convert(Euler euler){
		GraphViewData data []= null ;
		data = new GraphViewData[euler.getTimeArray().length];
		for(int i =0 ; i < euler.getTimeArray().length;i++){
			double valueX = euler.getTimeArray()[i];
			double valueY = euler.getValueArray()[i];
			data[i]= new GraphViewData(valueX,valueY);
		}
		GraphViewSeries series = new GraphViewSeries(data);
//		GlucoseApplication.setGraphViewSeries(series);
		return series;
	}
}
