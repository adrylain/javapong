package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Pong{
	
	public static int w = 0;
	public static int s = 0;
	public static int p = 0;
	public static int l = 0;
	
	public static int left = 0;
	public static int right = 0;
	
	
	public static int paddleA = 250;
	
	public static int paddleB = 250;
	
	
	
	public static int ballX = 395;
	public static int ballY = 290;
	public static int moveX = 2;
	public static int moveY = 2;

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
						Thread.sleep(4);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}).start();
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
                synchronized (Pong.class) {
                    switch (ke.getID()) {
                    case KeyEvent.KEY_PRESSED:
                        if (ke.getKeyCode() == KeyEvent.VK_W) {
                        	w = 1;
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_O) {
                        	p = 1;
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_S) {
                        	s = 1;
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_L) {
                        	l = 1;
                        }
                        break;

                    case KeyEvent.KEY_RELEASED:
                    	if (ke.getKeyCode() == KeyEvent.VK_W) {
                        	w = 0;
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_O) {
                        	p = 0;
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_S) {
                        	s = 0;
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_L) {
                        	l = 0;
                        }
                        break;
                    }
                    return false;
                }
            }
        });
	}
	
	public static Shape lol;
	
	public static void tick() {
		
		
		ballX = ballX + moveX;
		ballY = ballY + moveY;
		
		
		
		if (w == 1) {
			if (paddleA - 4 >= 0) {
				paddleA-=4;
			}
		}
		if (s == 1) {
			if (paddleA + 4 <= 500) {
				paddleA+=4;
			}
		}
		
		if (p == 1) {
			if (paddleB - 4 >= 0) {
				paddleB-=4;
			}
		}
		if (l == 1) {
			if (paddleB + 4 <= 500) {
				paddleB+=4;
			}
		}
	    
	    
	    if(ballY <= 0){
	    	moveY = moveY*-1;
	    }
	    
	    if(ballY >= 600 ){
	    	moveY = moveY*-1;
	    }
	    
	    if(ballX <= 25 && ballX >= 10 && ballY >= paddleA && ballY <= paddleA+100){
	    	moveX = moveX*-1;
	    }
	    
	    if(ballX >= 790 && ballX <= 800 && ballY >= paddleB && ballY <= paddleB+100){
	    	moveX = moveX*-1;
	    }
	    
	    if(ballX > 810){
	    	right = right+1;
	    	ballX = 405;
	    	ballY = 300;
	    }
	    
	    if(ballX < 0){
	    	left = left+1;
	    	ballX = 405;
	    	ballY = 300;
	    }
	    
	    
	    
	}
	
	public static Graphics2D g2d;



	public static void render(Graphics g) {
		// Blank screen
		
	    g.setColor(Color.black);
	    g.fillRect(0, 0, 810, 600);
	    
	    
	    g.setColor(Color.white);
	    g.drawLine(405,600,405,0);
    
	    //Left Paddle
	    g.setColor(Color.white);
	    g.fillRect(20, paddleA, 10, 100);
	    
	    //Right Paddle
	    g.setColor(Color.white);
	    g.fillRect(790, paddleB, 10, 100);
	    
	    
	    //Left Score
	    g.drawString(""+left,375, 30);
	    
	    //Right Score
	    g.drawString(""+right, 435, 30);
	   
	    //Ball
		g.fillOval(ballX-10,ballY-10,20,20);

	}
	
	
	

	
	public static int rInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
}

