import java.awt.*;
import java.applet.*;
import java.util.Calendar;
import java.util.Date;

public class SelfTestQ4 extends Applet implements Runnable {

	Thread t;
	boolean stopFlag;
	Calendar rightNow;
	int hour;
	int minute;
	int second;
	String time;
	
	public void init() {
		t = null;
	}
	
	public void start() {
		t = new Thread(this);
		stopFlag = false;
		t.start();
	}
	
	public void run() {
		for( ; ;)
			try {

				repaint();
				Thread.sleep(1000);
				if(stopFlag)
					break;
			} catch(InterruptedException exc) {}
	}
	
	public void stop() {
		stopFlag = true;
		t = null;
	}
	
	public void paint(Graphics g) {
		rightNow = Calendar.getInstance();
		
		time = Integer.toString(rightNow.get(Calendar.HOUR));
		time += " : " + Integer.toString(rightNow.get(Calendar.MINUTE));
		time += " : " + Integer.toString(rightNow.get(Calendar.SECOND));
		g.drawString(time, 10, 50);
	}
	
}
