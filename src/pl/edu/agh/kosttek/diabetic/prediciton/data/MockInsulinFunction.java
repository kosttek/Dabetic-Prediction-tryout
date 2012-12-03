package pl.edu.agh.kosttek.diabetic.prediciton.data;

public class MockInsulinFunction {
	public static double computeU(double t, double insulin) {
		double A = insulin;
		double result = A * Math.exp(-0.05 * t);
		return result;
	}
}
