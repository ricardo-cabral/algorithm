package eu.ricardocabral.algorithm.pc;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumerWaitNotify {
	
	public static void main(String[] args) {
		
	
	List<Integer> sharedQueue = new LinkedList<>();
	
	Producer producer = new Producer(sharedQueue);
	Consumer consumer = new Consumer(sharedQueue);
	
	Thread producerThreads = new Thread(producer,  "ProducerThread");
	Thread consumerThread = new Thread(consumer, "ConsumerThread");
	
	producerThreads.start();
	consumerThread.start();
	}
}
