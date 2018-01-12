package pong;


import java.awt.AWTException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Pong{
	

	public static void main(String[] args) {
		JFrame window = new JFrame("Java Pong");
		window.setLayout(null);
		window.setSize(810, 622);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		
		
		JLabel screen = new JLabel() {
			@Override
			public void paintComponent(Graphics g) {
				render(g);
			}
		};
		
		
		window.add(screen);
		screen.setBounds(0, 0, 810, 600);
		
		window.setVisible(true);
	
		
		
		
		
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					screen.repaint();
					tick();
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}).start();
		
		
			public static Graphics2D g2d;


			/* 
			 * Use later when rendering moving ball.
			 * 
			public void drawCenteredCircle(Graphics2D g, int x, int y, int r) {
				  x = x-(r/2);
				  y = y-(r/2);
				  g.fillOval(x,y,r,r);
			}
			*/

			public static void render(Graphics g) {
				// Blank screen
				
			    g.setColor(Color.black);
			    g.fillRect(0, 0, 810, 600);
			    
			    
			    g.setColor(Color.white);
			    g.drawLine(405,600,405,0);

			    
			    //Left Paddle
			    g.setColor(Color.white);
			    g.fillRect(20, 250, 10, 100);
			    
			    
			    //Right Paddle
			    g.setColor(Color.white);
			    g.fillRect(790, 250, 10, 100);
			    
			    
			    //Ball

				g.fillOval(395,290,20,20);

			}
	}
}

