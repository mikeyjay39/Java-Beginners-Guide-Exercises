import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<applet code="MouseEvents" width=300 height 100>
</applet>
*/

public class SelfTestQ7 extends Applet implements MouseListener, MouseMotionListener {

	int mouseX1, mouseY1, mouseX2, mouseY2 = 0;
	boolean draw;
	
	public void init() {
		addMouseListener(this);
		addMouseMotionListener(this);
		draw = false;
	}
	
	public void mousePressed(MouseEvent me) {
		mouseX1 = me.getX();
		mouseY1 = me.getY();
		draw = true;
	}
	
	public void mouseReleased(MouseEvent me) {
		draw = false;
	}

	
	
	public void mouseDragged(MouseEvent me) {
		mouseX2 = me.getX();
		mouseY2 = me.getY();
		repaint();
	}

	
	public void mouseMoved(MouseEvent me) {
		showStatus("Moving mouse at " + me.getX() + ", " + me.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	
	public void paint(Graphics g) {
		if(draw)
			g.drawLine(mouseX1, mouseY1, mouseX2, mouseY2);

	}


	
}
