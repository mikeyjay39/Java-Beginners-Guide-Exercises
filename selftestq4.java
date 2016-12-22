// An enumeration of the colors of a traffic light.
enum TrafficLightColor {
	RED(12000), GREEN(10000), YELLOW(2000);
	
	private int delay;
	
	TrafficLightColor(int time) {
		delay = time;
	}
	
	int getDelay() {
		return delay;
	}
}

// A computerized traffic light.
class TrafficLightSimulator implements Runnable {
	private Thread thrd; // holds the thread that runs the simulation
	private TrafficLightColor tlc; // holds the traffic light color
	boolean stop = false; // set to true to stop the simulation
	boolean changed = false; // true when the light has changed
	
	TrafficLightSimulator(TrafficLightColor init) {
		tlc = init;
		
		thrd = new Thread(this);
		thrd.start();
	}
	
	TrafficLightSimulator() {
		tlc = TrafficLightColor.RED;
		thrd = new Thread(this);
		thrd.start();
	}
	
	// Start up the light.
	public void run() {
		while(!stop) {
			try {
				if(tlc.ordinal() == 1)
						Thread.sleep(tlc.getDelay()); // green for 10 seconds

				if(tlc.ordinal() == 2)
						Thread.sleep(tlc.getDelay()); // yellow for 2 seconds
						
				if(tlc.ordinal() == 0)
						Thread.sleep(tlc.getDelay()); // red for 12 seconds
						
				
			} catch(InterruptedException exc) {
				System.out.println(exc);
			}
			changeColor();
		}
		
	}
	
	// Change color.
	synchronized void changeColor() {
		switch(tlc) {
			case RED:
				tlc = TrafficLightColor.GREEN;
				break;
			case YELLOW:
				tlc = TrafficLightColor.RED;
				break;
			case GREEN:
				tlc = TrafficLightColor.YELLOW;
		}
		
		changed = true;
		notify(); // signal that the light has changed
	}
	
	// Wait until a light change occurs.
	synchronized void waitForChange() {
		try {
			while(!changed)
				wait(); // wait for light to change
			changed = false;
		} catch(InterruptedException exc) {
			System.out.println(exc);
		}
	}
	
	// Return current color.
	synchronized TrafficLightColor getColor() {
		return tlc;
	}
	
	// Stop the traffic light.
	synchronized void cancel() {
		stop = true;
	}
}
public class selftestq4 {

	public static void main(String[] args) {
		TrafficLightSimulator t1 = new TrafficLightSimulator(TrafficLightColor.GREEN);
		
		for(int i=0; i < 9; i++) {
			System.out.println(t1.getColor());
			t1.waitForChange();
		}
		t1.cancel();
	}

}
