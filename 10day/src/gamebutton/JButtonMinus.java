package gamebutton;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import system.GameFrame;

public class JButtonMinus extends JButton implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameFrame gameFrame;
	private int number;
	ImageIcon icon = new ImageIcon("-.png");
	public JButtonMinus(GameFrame gf,int i) {
		// TODO Auto-generated constructor stub
		gameFrame = gf;
		number = i;
		this.setIcon(icon);
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		switch (number) {
		case 1:
			if (gameFrame.getJPanelHome().getJPanelSetting().getLength()>10) {
				gameFrame.getJPanelHome().getJPanelSetting().setlength("-");
			}
			break;
		case 2:
			if (gameFrame.getJPanelHome().getJPanelSetting().getMaxPower()>5) {
				gameFrame.getJPanelHome().getJPanelSetting().setMaxPower("-");
			}
			break;
		case 3:
			if (gameFrame.getJPanelHome().getJPanelSetting().getMaxTurns()>12) {
				gameFrame.getJPanelHome().getJPanelSetting().setMaxTurns("-");
			}
			break;
		case 4:
			if (gameFrame.getJPanelHome().getJPanelSetting().getRebirthPeriod()>1) {
				gameFrame.getJPanelHome().getJPanelSetting().setRebirthPeriod("-");
			}
			break;
		default:
			break;
		}
		gameFrame.getJPanelHome().getJPanelSetting().repaint();
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


