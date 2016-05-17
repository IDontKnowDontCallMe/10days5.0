package panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import gemelogic.Player;
import system.Controller;


public class JPanelField extends JPanel implements KeyListener{
	
	private Controller god;
	
	private Player[] myGroup;
	private Player[] aiGroup;
	
	private JPanelPlayer[] allPlayer;
	
	
	
	public JPanelField(Player[] my, Player[] ai ,  Controller con){
		god = con;
		myGroup = my;
		aiGroup = ai;
		allPlayer = new JPanelPlayer[6];
		allPlayer[0] = new JPanelPlayer(myGroup[0]);
		allPlayer[1] = new JPanelPlayer(myGroup[1]);
		allPlayer[2] = new JPanelPlayer(myGroup[2]);
		allPlayer[3] = new JPanelPlayer(aiGroup[0]);
		allPlayer[4] = new JPanelPlayer(aiGroup[1]);
		allPlayer[5] = new JPanelPlayer(aiGroup[2]);
		
		this.setBounds(0, 0, 800, 800);
		//this.setOpaque(false);
		this.setBackground(Color.BLACK);
		this.setLayout(null);
		
		for(int i=0; i<6; i++){
			add(allPlayer[i]);
		}		
		//new Thread(new PaintThread()).start();
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		for(int i=0; i<6; i++){
			allPlayer[i].updateLocation();
			int x = allPlayer[i].getTheX();
			int y = allPlayer[i].getTheY();
			int length = allPlayer[i].getLength();
			
			allPlayer[i].setBounds(x*length, y*length, length, length);
			allPlayer[i].repaint();
			
		}
		
	}
	
	private class PaintThread implements Runnable {
		@Override
		public void run() {
			while (true) {
				repaint();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
