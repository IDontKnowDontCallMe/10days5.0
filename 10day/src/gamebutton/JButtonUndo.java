package gamebutton;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import system.GameFrame;

public class JButtonUndo extends JButton implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameFrame gameFrame;
	
	public JButtonUndo(GameFrame gf) {
		this.setText("Undo");
		this.addMouseListener(this);
		gameFrame = gf;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (gameFrame.getController().arrayList.size()>0) {
			
			int act = gameFrame.getController().arrayList.get(gameFrame.getController().arrayList.size()-1);
			switch(act){
			case 0:
				break;
			case 1:
			case 2:
			case 3:
			case 4:
				gameFrame.getController().getPresentPlayer().setActivated(false);
				gameFrame.getController().getPresentPlayer().setSurrounding(false);
				gameFrame.getController().getPresentPlayer().setPower(gameFrame.getController().getPresentPlayer().getPresentPower()+2);
				gameFrame.getController().getPresentPlayer().move(act);
				gameFrame.getController().getPresentPlayer().setActivated(true);
				gameFrame.getController().getPresentPlayer().setSurrounding(true);
			
				break;
			case 5:
			case 6:
			case 7:
			case 8:
				
				gameFrame.getController().getPresentPlayer().setPower(gameFrame.getController().getPresentPlayer().getPresentPower()+4);
				gameFrame.getController().getPresentPlayer().reOccupy(gameFrame.getController().getField(), act-4);
				for(int i=0; i<6; i++){
					gameFrame.getController().getAllPlayer()[i].returnLastTile();
				}
				break;
			case 9:
				gameFrame.getController().getPresentPlayer().setPower(gameFrame.getController().getPresentPlayer().getPresentPower()+2);
				gameFrame.getController().getPresentPlayer().changeState();
				break;
			}
			
			gameFrame.getController().arrayList.remove(gameFrame.getController().arrayList.size()-1);
			gameFrame.getController().getField().updateHorizon();
			gameFrame.getJPanelHome().getJpanelBattleField().repaint();
			
		}

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
