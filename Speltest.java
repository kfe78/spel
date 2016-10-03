import java.io.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;


public class Speltest extends Applet implements KeyListener
{
	
	long currentTime;
	int dimx = 600;
	int dimy = 400;
	Graphics bufferGraphics;
	Image offscreen;  
	Fyrkant player = new Fyrkant();
	boolean up, left, right, down = false;
	public void init()
	{
	setSize(dimx,dimy);
	offscreen = createImage(dimx,dimy); 
	bufferGraphics = offscreen.getGraphics(); 
	addKeyListener( this );
	Thread t = new Thread(new MainLoop());
    t.start();
	}

	public void paint(Graphics page)
	{
	bufferGraphics.clearRect(0,0,dimx,dimy); 
	bufferGraphics.fillRect (player.get_x(), player.get_y(), 15, 15);
	page.drawImage(offscreen,0,0,this);
	}
	
	public void update(Graphics page)
    {
    	paint(page);
    } 
	
	public void keyPressed( KeyEvent e ) 
	{ 
	char c = e.getKeyChar();
	
		if(c == 'w')
		{
		up = true;
		}
		
		if(c == 's')
		{
		down = true;
		}
		
		if(c == 'a')
		{
		left = true;
		}
		
		if(c == 'd')
		{
		right = true;
		}

	}
	public void keyReleased(KeyEvent e) {
	
	char c = e.getKeyChar();
	
		if(c == 'w')
		{
		up = false;
		}
		
		if(c == 's')
		{
		down = false;
		}
		
		if(c == 'a')
		{
		left = false;
		}
		
		if(c == 'd')
		{
		right = false;
		}
	}
	
	public void movementCheck()
	{
	if(up == true) {player.set_y(player.get_y()-2); System.out.println("Up!");}
	
	if(down == true) {player.set_y(player.get_y()+2); System.out.println("Down!");}
	
	if(right == true) {player.set_x(player.get_x()+2); System.out.println("Right!");}
	
	if(left == true) {player.set_x(player.get_x()-2); System.out.println("Left!");}
	
	}
	
	public void keyTyped(KeyEvent e) {}
	
		public class MainLoop implements Runnable {
			public void MainLoop() {}
			public void run()
			{
			while(true)
			{
			movementCheck();
			repaint();
				try
				{
				Thread.sleep(15);
				}
				catch(InterruptedException e)
				{
				}			
			}
			
		}
		}
	
}

