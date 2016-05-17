package panels;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;

import javax.swing.JButton;
import javax.swing.JPanel;
import image.*;
import music.AudioPlayer;
import system.GameFrame;
import sun.audio.*;
import java.io.*;


public class JPanelHome extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public boolean VSPlayerClicked = false;
	
	private GameFrame gameFrame;
	private JPanelBattleField jPanelBattleField;

	JButton VScomputer = new JButton("VS Computer");
	JButton VSPlayer = new JButton("VS Player");
	JButton Option = new JButton("Option");
	JButton BackToLastGame = new JButton("Back");
	
	Image backGround = Cell.first;
	
	private MouseListener VComputerListener = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			gameFrame.musicThread.stop();
			gameFrame.getController().setVsPlayer(false);
			jPanelBattleField = new JPanelBattleField(gameFrame);
			gameFrame.musicThread.creatMT("³ß°Ë", 2);
			gameFrame.setContentPane(jPanelBattleField);
			gameFrame.remove(gameFrame.getJPanelHome());
			gameFrame.revalidate();
		}
	};
	private MouseListener BackToLastGameListener = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	private MouseListener VPlayerListener = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			gameFrame.getController().setVsPlayer(true);
			jPanelBattleField = new JPanelBattleField(gameFrame);
			gameFrame.setContentPane(jPanelBattleField);
			gameFrame.remove(gameFrame.getJPanelHome());
			gameFrame.revalidate();
		}
	};
	
	public JPanelHome(GameFrame gf) {
		gameFrame = gf;
		
		this.setLayout(null);
		this.add(VScomputer);
		VScomputer.setBounds(600,100, 100, 100);
		VScomputer.setVisible(true);
		VScomputer.setVerticalTextPosition(JButton.CENTER);
	    VScomputer.setHorizontalTextPosition(JButton.LEADING);
		VScomputer.addMouseListener(VComputerListener);
		this.add(BackToLastGame);
		BackToLastGame.setBounds(800, 300, 100, 100);
		BackToLastGame.addMouseListener(BackToLastGameListener);
		this.add(VSPlayer);
		VSPlayer.addMouseListener(VPlayerListener);
		VSPlayer.setBounds(600, 200, 100, 100);
		VSPlayer.addMouseListener(VPlayerListener);
		
	}

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backGround, 0, 0, null);
		
	
	}
	

	public JPanelBattleField getJpanelBattleField() {
		return jPanelBattleField;
	}
	
	public void setJpanelBattleField(JPanelBattleField jBattleField) {
		jPanelBattleField = jBattleField;
	}
	
	
	
	
	
	
	
	

}
