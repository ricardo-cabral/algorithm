package eu.ricardocabral.algorithm;

/**
 * VolatileExample Instance is declared as volatile variable to ensure every
 * thread see updated value for instance.
 * 
 * Volatile always happen before
 * 
 * @author cabralr
 *
 */
public class VolatileExample {

	private static volatile VolatileExample instance;

	public static VolatileExample getInstance() {
		System.out.println("getInstance()");
		if (instance == null) {
			synchronized (VolatileExample.class) {
				if (instance == null)
					System.out.println("new VolatileExample()");
					instance = new VolatileExample();
			}
		}
		return instance;
	}

	 private static int count = 0;
	    public static void main(String[] argv){
	        for(;;){
	            new Thread(new Runnable(){
	                    public void run(){
	                        	VolatileExample.getInstance();
	                            count += 1;
	                            System.err.println("New thread #"+count);
	                        
	                        for(;;){
	                            try {
	                                Thread.sleep(1000);
	                            } catch (Exception e){
	                                System.err.println(e);
	                            }
	                        }
	                    }
	                }).start();
	        }
	    }

}
