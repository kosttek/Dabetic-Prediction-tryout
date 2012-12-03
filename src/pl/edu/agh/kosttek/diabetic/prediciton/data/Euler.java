package pl.edu.agh.kosttek.diabetic.prediciton.data;

import java.util.ArrayList;
import java.util.List;

public class Euler {
	private long startTime;
	private double total_time = 60*4;
	private int N = 300;
	
	private List<Double> time = new ArrayList<Double>();
	private List<Double> value = new ArrayList<Double>();
	
	private double p1,p2,p3,n,V1;
	private double gB,iB;
	
	public void initVariables(){
		gB = 4.5;
		iB = 4.5;
		V1 = 12;
		p1 = 0;
		p2 = 0.025;
		p3 = 0.0000013;
		n = 5/54;
	}
	
	public void compute(double insulin,double glucose){
		setStartTime(System.currentTimeMillis());
		
		double[] G = new double[N+1];
		double[] X = new double[N+1];
		double[] I = new double[N+1];

		G[0] = 80;
		X[0] = 0;
		I[0] = 0;

		double dt = total_time / N;
		initVariables();
		
		for (int i = 0; i < N; ++i)
		{
		   double t = i*dt;
		   double u = computeU(t, insulin);
		   double gMeal = computeG(t,glucose);

		   /* calculate derivatives */
		   double dSdt = - p1 * G[i] - X[i]*(G[i] - gB) + gMeal/V1;
		   double dIdt = - p2 * X[i] + p3*I[i];
		   double dRdt = - n  * (I[i]+ iB) + u/V1;

		   /* now integrate using Euler */
		   G[i+1] = G[i] + dSdt * dt;
		   X[i+1] = X[i] + dIdt * dt;
		   I[i+1] = I[i] + dRdt * dt;
		   
		   getTime().add(t);
		   getValue().add(G[i+1]);
		}
	}
	private double computeU(double t,double insulin){

		return MockInsulinFunction.computeU(t, insulin);
	}
	
	private double computeG(double t, double glucose){
		double A = glucose;
		double result =  A * Math.exp(-0.05*t);
		return result;
	}
	
	public double [] getTimeArray(){
		double [] result = new double[N];
		for(int i = 0 ; i< getTime().size(); i++){
			result[i] = getTime().get(i); 
		}
		return result;
	}
	
	public double [] getValueArray(){
		double [] result = new double[N];
		for(int i = 0 ; i< getValue().size(); i++){
			result[i] = getValue().get(i); 
		}
		return result;
	}

	public List<Double> getTime() {
		return time;
	}

	public void setTime(List<Double> time) {
		this.time = time;
	}

	public List<Double> getValue() {
		return value;
	}

	public void setValue(List<Double> value) {
		this.value = value;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

}
