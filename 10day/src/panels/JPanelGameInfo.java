package panels;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import image.Cell;
import system.GameFrame;


public class JPanelGameInfo extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private GameFrame gameFrame;
	private Image backGround;
	private int numberSize = 30;
	
	private JLabelTurns turns;
	private JLabelLeftTurns leftTurns;
	private JLabelScores scores;
	private JPanelPlayerInfo playerInfo;

	public JPanelGameInfo(GameFrame gf) {
		gameFrame = gf;
		backGround = Cell.stateBackGround1;
		this.setVisible(true);
		this.setBounds(0, 0 , 322 , 768);
		this.setLayout(null);
		
		turns = new JLabelTurns(gf, numberSize);
		turns.setBounds(160, 80, 3*numberSize, numberSize);
		leftTurns = new JLabelLeftTurns(gf, numberSize);
		leftTurns.setBounds(160, 80+numberSize*2, 3*numberSize, numberSize);
		scores  =new JLabelScores(gf, numberSize);
		scores.setBounds(160, 80+numberSize*4, 3*numberSize, numberSize);
		
		playerInfo = new JPanelPlayerInfo(gf);
		playerInfo.setBounds(25,308,250,400);
		
		add(turns);
		add(leftTurns);
		add(scores);
		add(playerInfo);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(backGround, 0, 0, null);

	}


}
