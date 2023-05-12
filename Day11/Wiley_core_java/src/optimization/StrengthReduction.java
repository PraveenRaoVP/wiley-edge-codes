package optimization;

public class StrengthReduction {
	public static void main(String[] args) {
		System.out.println(calcSum(5));
	}
	
	private static int calcSum(int n) {
		int sum=0;
		for(int i=0;i<n;i++) {
			sum+=i+i+i+i+i; //instead of i*5
		}
		return sum;
	}
	
	
}
