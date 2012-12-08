package pl.edu.agh.kosttek.diabetic.prediciton.ui.widget;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.graphics.Canvas;

import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.LineGraphView;

public class TimeGraphView extends LineGraphView {

	public TimeGraphView(Context context, String title) {
		super(context, title);
		// TODO Auto-generated constructor stub
	}


	
	
	@Override
	protected String formatLabel(double value, boolean isValueX) {
		if(isValueX){
			return new SimpleDateFormat("H:mm").format(new Date((long) value*1000));
		
		}else{
			return super.formatLabel(value, isValueX);
		}
	}

}
