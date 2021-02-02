package e_oop;

public class hellow {
	int sum(int a, int b, int c, int d){
		return a + b + c + d;
	}
	
	double avg(int a, int b, int c, int d){
		return Math.round((double)a+b+c+d /2  *100)/100.0;
	}
	
	double[] sumAndAvg(int a, int b, int c, int d){
		double[] sumAndAvg = new double[2];
		sumAndAvg[0]= a + b + c + d;
		sumAndAvg[1] = Math.round((double)a + b + c + d /2  *100)/100.0;
		return sumAndAvg;
	}
}
