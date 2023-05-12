package optimization;

//concatenation using StringBuilder, no need to create new Strings while using +

public class StringOptimize {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		String result = "";
		for(int i=0;i<10000;i++) {
			result+=i;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken: "+(endTime-startTime));
		System.out.println();
		startTime = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<10000;i++) {
			sb.append(i);
		}
		endTime = System.currentTimeMillis();
		System.out.println("Time taken: "+(endTime-startTime));
		
	}
}
