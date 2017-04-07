package eu.ricardocabral.algorithm.pc;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.util.concurrent.BlockingQueue;
import java.util.function.Supplier;

public class MyProducer<T> {
	
	private BlockingQueue<T> queue;
	
	public MyProducer(BlockingQueue<T> queue){
		this.queue = queue;
	}
	
	public void produce(Supplier<T> supplier ){
		final T msg = supplier.get();
		
		try{
			queue.put(msg);
			System.out.println("Message added: " + msg);
			MILLISECONDS.sleep(900);
		}catch (InterruptedException e){
			throw new RuntimeException(e);
		}
	}

}
