package gamebutton;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import system.GameFrame;



public class JButtonIgnore extends JButton implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GameFrame gameFrame;
	
	public JButtonIgnore(GameFrame gf){
		this.setText("Ignore");
		gameFrame = gf;
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		gameFrame.getController().nextTurn();
		gameFrame.getJPanelHome().getJpanelBattleField().repaint();
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
