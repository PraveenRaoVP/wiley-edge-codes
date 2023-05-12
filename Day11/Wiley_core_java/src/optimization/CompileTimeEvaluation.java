package optimization;

public class CompileTimeEvaluation {
	public static final int MAX_SIZE = 100;
	public static final int SUM = 10+20;
	
	public static void main(String[] args) {
		int[] arr = new int[MAX_SIZE];
		System.out.println(SUM); //sum is known at compile time;
	}
}
