package panels;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import image.Cell;
import system.GameFrame;

public class JPanelGameOver extends JPanel{
	
	private GameFrame gameFrame;
	private Image backGround;
	private Image redwin;
	private Image bluewin;
	private Image drawn ;
	private Image winner;
	
	

	public JPanelGameOver(GameFrame gf){
		
		gameFrame = gf;
		backGround = Cell.gameover;
		redwin = Cell.redwin;
		bluewin = Cell.bluewin;
		drawn = Cell.drawn;
		
		this.setVisible(true);
		this.setBounds(0, 0 , 322 , 768);
		this.setLayout(null);
		
	}
	
	@Override
	public void paint(Graphics g){
		if(gameFrame.getController().getMyScores()>gameFrame.getController().getAiScores()){
			winner = redwin;
		}
		else{
			if(gameFrame.getController().getMyScores()<gameFrame.getController().getAiScores()){
				winner = bluewin;
			}
			else{
				winner = drawn;
			}
		}
		g.drawImage(backGround, 0, 0, null);
		g.drawImage(winner, 90, 255, 200,100,null);
	}

}
