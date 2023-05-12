package optimization;

public class DeadCodeOptimization {
	public int getAbs(int a) {
		
		if(a<0) {
			return -1;
		} else {
			return 1;
		}
		
		return -2;
	}
}
