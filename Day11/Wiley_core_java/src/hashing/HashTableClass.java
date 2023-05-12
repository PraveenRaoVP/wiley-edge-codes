package hashing;

import java.util.Hashtable;

public class HashTableClass {
	public static void main(String[] args) {
		Hashtable<Integer, Integer> ht = new Hashtable<>();
		ht.put(123, 456);
		ht.put(21, 124);
		ht.put(4523, 60782);
		//ht.put(null, 1);
		ht.remove(21);
		
		System.out.println(ht);
	}
}
