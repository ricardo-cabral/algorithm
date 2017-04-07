package eu.ricardocabral.algorithm.pc;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;

public class MyConsumer<T> {
	
	private BlockingQueue<T> queue;
	
	public MyConsumer(BlockingQueue<T> queue){
		this.queue = queue;
	}
	
	
	public void consume(Consumer<T> consumer){
		try{
			consumer.accept(queue.take());
			//simulate long process
			MILLISECONDS.sleep(1250);
			
		}catch(InterruptedException e){
			throw new RuntimeException(e);
		}
	}

}
