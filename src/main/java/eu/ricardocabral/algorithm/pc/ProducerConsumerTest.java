package eu.ricardocabral.algorithm.pc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ProducerConsumerTest {

	
	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
		int SIZE = 10;
		
		MyProducer<String> producer = new MyProducer<>(queue);
		Supplier<String> supplier = () -> "Hello World!";
		
		new Thread(() -> {
			for (int i = 0; i < SIZE; i++) {
				producer.produce(supplier);
			}
		}).start();
		
		
		MyConsumer<String> consumer = new MyConsumer<>(queue);
		Consumer<String> consumed = (s) -> System.out.println("Consumed message: " + s);
		
		new Thread(() -> {
			for (int i = 0; i <SIZE; i++) {
				consumer.consume(consumed);
			}
		}).start();
		
		
	}
	
	
	
	
	
}
