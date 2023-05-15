package greedy_algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class CoinsProblem {
	
	private static void calcCoins(int target) {
		int[] coins = {20,10,5};
		ArrayList<Integer> solution = new ArrayList<>();
		int sum = 0;
		for(int i: coins) {
			while(sum+i<=target) {
				solution.add(i);
				sum+=i;
			}
		}
		
		System.out.println("The coins in greedy approach: "+solution);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the target money: ");
		int n = sc.nextInt();
		calcCoins(n);
	}
}
