package gamebutton;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import panels.JPanelHome;
import system.Controller;
import system.GameFrame;

public class JButtonBackToHome extends JButton implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GameFrame gameFrame;
	
	public JButtonBackToHome(GameFrame gf){
		this.setText("Back");
		gameFrame = gf;
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		gameFrame.musicThread.stop();
		gameFrame.getContentPane().removeAll();
		gameFrame.setController(new Controller(gameFrame));
		gameFrame.setContentPane(gameFrame.getJPanelHome());
		gameFrame.repaint();
		gameFrame.musicThread.creatMT("ºùÂ«Ë¿", 2);
		gameFrame.musicThread.start();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
