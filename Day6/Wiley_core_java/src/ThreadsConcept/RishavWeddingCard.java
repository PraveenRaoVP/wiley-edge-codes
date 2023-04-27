package ThreadsConcept;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WeddingCardWrap extends Thread{
	@Override
	public void run() {
		System.out.println("Thread Name: "+Thread.currentThread().getName());
	}
}

public class RishavWeddingCard {
	public static void main(String[] args) {
		//ExecutorService executor = Executors.newFixedThreadPool(4);
		ExecutorService executor = Executors.newCachedThreadPool();
		for(int i=1;i<=100;i++) {
			executor.execute(new WeddingCardWrap());
		}
	}
}
