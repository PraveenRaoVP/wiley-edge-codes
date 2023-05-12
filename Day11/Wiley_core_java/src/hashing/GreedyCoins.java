package hashing;

import java.util.ArrayList;

public class GreedyCoins {
	public static void main(String[] args) {
		ArrayList<Integer> solution = new ArrayList<>();
		int arr[] = {5,2,1};
		int target = 18,sum=0;;
		for(int i: arr) {
			while(sum+i<=target) {
				solution.add(i);
				sum+=i;
			}
		}
		System.out.println(solution);
	}
}
