package eu.ricardocabral.algorithm.pc;

import java.util.List;

public class Producer implements Runnable {

	private List<Integer> sharedQueue;
	private int maxSize = 2;

	public Producer(List<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				produce(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void produce(int i) throws InterruptedException {
		synchronized (sharedQueue) {
			while (sharedQueue.size() == maxSize) {
				System.out.println(
						"Queue is full, producerThread is waiting for consumerThread to consume, sharedQueue's size ="
								+ maxSize);
				sharedQueue.wait();
			}
		}

		synchronized (sharedQueue) {
			System.out.println("Produced : " + i);
			sharedQueue.add(i);
			Thread.sleep(900);
			sharedQueue.notify();
		}
	}

}
