// Try This 15-1
// A simple banner applet.
// This applet creates a thread that scrolls
// the message contained in msg right to left
// across the applet's window.

import java.awt.*;
import java.applet.*;

/*
<applet code="Banner" width=300 height=50>
<param name=message value=" JAVA rules the web ">
<param name=delay value=500>
</applet>
*/
	
public class SelfTestQ3 extends Applet implements Runnable {
	
//	String msg = " Java Rules the Web ";
	Thread t;
	boolean stopFlag;
	String message;
	int delay;
	
	// Initialize t to null.
	public void init() {
		t = null;
	}
	
	// Start thread
	public void start() {
		t = new Thread(this);
		stopFlag = false;
		
		message = getParameter("message");
		if(message == null) message = " not found ";
		
		
		String temp;
		
		temp = getParameter("time");
		try {
			if(temp != null)
				delay = Integer.parseInt(temp);
			else
				delay = 1000;
		} catch(NumberFormatException exc) {
			delay = -1; //error code
		}
		
		
		/*
		time = getParameter("time");
		if(time == null) time = " not found ";
		*/
		
		t.start();
	}
	
	// Entry point for the thread that runs the banner.
	public void run() {
		// Redisplay banner
		for( ; ; ) {
			try {
				repaint();
				Thread.sleep(delay);
				if(stopFlag)
					break;
			} catch(InterruptedException exc) {}
		}
	}
	
	// Pause the banner.
	public void stop() {
		stopFlag = true;
		t = null;
	}
	
	// Display the banner.
	public void paint(Graphics g) {
		char ch;
		
		ch = message.charAt(0);
		message = message.substring(1, message.length());
		message += ch;
		g.drawString(message, 50, 30);

	}

}







