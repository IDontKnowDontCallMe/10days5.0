package panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import image.Cell;
import system.GameFrame;

public class JPanelPlayerInfo extends JPanel{
	
	private GameFrame gameFrame;
	private int x;
	private int y;
	private int width;
	private int height;
	private Image backGround;
	private Image present;
	private Image next;
	
	
	
	public JPanelPlayerInfo(GameFrame gf){
		gameFrame = gf;
		backGround = Cell.stateBackGround2;
		setOpaque(false);
		
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		updateImage();
		g.drawImage(backGround, 0, 0, this.getWidth(), this.getHeight(),null);
		g.drawImage(present, 32, 106, 188, 200, null);
		g.drawImage(next,140, 330, 100, 50,  null);
	}
	
	public void updateImage(){
		
		int presentPlayer = gameFrame.getController().getPresentPlayer().getNumber();
		int nextPlayer = gameFrame.getController().getNextPlayer().getNumber();
		
		switch(presentPlayer){
		case 0:
			present = Cell.present_redsword;
			break;
		case 1:
			present = Cell.present_redspear;
			break;
		case 2:
			present = Cell.present_redaxe;
		break;
		case 3:
			present = Cell.present_bluesword;
			break;
		case 4:
			present  =Cell.present_bluespear;
			break;
		case 5:
			present  =Cell.present_blueaxe;
			break;
			
		}
		
		switch(nextPlayer){
		case 0:
			next = Cell.next_redsword;
			break;
		case 1:
			next = Cell.next_redspear;
			break;
		case 2:
			next = Cell.next_redaxe;
		break;
		case 3:
			next = Cell.next_bluesword;
			break;
		case 4:
			next = Cell.next_bluespear;
			break;
		case 5:
			next = Cell.next_blueaxe;
			break;
			
		}
		
	}

}
