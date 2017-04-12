package eu.ricardocabral.algorithm.thread;

/**
 * Threads as heavy weight process : In the below program we will create
 * Thread-1 and Thread-2 on different processes i.e. on MyRunnable1 and
 * MyRunnable2
 * 
 * @author Ricardo
 *
 */
public class HeavyProcess {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new MyRunnable1(), "Thread-1");
		Thread thread2 = new Thread(new MyRunnable2(), "Thread-2");
		thread1.start();
		thread2.start();
	}
}

class MyRunnable1 implements Runnable {
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("i=" + i + ", ThreadName" + Thread.currentThread().getName());
		}
	}
}

class MyRunnable2 implements Runnable {
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("i=" + i + ", ThreadName" + Thread.currentThread().getName());
		}
	}
}
