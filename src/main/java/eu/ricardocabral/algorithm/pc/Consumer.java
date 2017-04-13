package eu.ricardocabral.algorithm.pc;

import java.util.List;

public class Consumer implements Runnable {

	private List<Integer> sharedQueue;

	public Consumer(List<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {

		while (true) {
			try {
				consume();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void consume() throws InterruptedException {
		synchronized (sharedQueue) {
			while (sharedQueue.size() == 0) {
				System.out.println(
						"Queue is empty, consumerThread is wating for producerThread to produce, sharedQueue's size =0");
				sharedQueue.wait();
			}
		}

		synchronized (sharedQueue) {
			Thread.sleep(900);
			System.out.println("Consumed: " + sharedQueue.remove(0));
			sharedQueue.notify();
		}
	}

}
