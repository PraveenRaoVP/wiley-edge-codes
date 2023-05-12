package optimization;

import java.nio.file.spi.FileSystemProvider;
import java.util.Arrays;

public class EnhancedLoops {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis(); 
		int arr[] = new int[100000];
		Arrays.fill(arr,0);
		for(int i=0;i<arr.length;i++) {
			//System.out.print(arr[i]+" ");
			arr[i]=1;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("The time taken: "+(endTime-startTime));
		
		System.out.println();
		startTime = System.currentTimeMillis(); 
		for(int i: arr) {
			i=1;
		}
		endTime = System.currentTimeMillis();
		System.out.println("The time taken: "+(endTime-startTime));
	}
}
