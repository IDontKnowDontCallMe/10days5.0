package panels;

import java.awt.Graphics;
import gamebutton.*;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import system.GameFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import image.*;
import gamebutton.*;


public class JPanelBattleField extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private GameFrame gameFrame;
	private JPanelGameInfo jpanelGameInfo;
	private JPanelGameOver jPanelGameOver;
	private JPanelField jPanelField;
	private JButtonBackToHome jbuttonBackToHome;
	private JButtonIgnore jbuttonIgnore;
	private JButtonItems jbuttonItems;
	private JButtonSave jbuttonSave;
	private JButtonUndo jbuttonUndo;
	
	
	Image backGround = Cell.second;
	
	
	
	
	public static boolean IgnoreClicked = false;
	

	
	public JPanelBattleField(GameFrame gf) {
		
		gameFrame = gf;
		
		this.setLayout(null);

		jbuttonIgnore = new JButtonIgnore(gf);
		this.add(jbuttonIgnore);
		jbuttonIgnore.setBounds(1200, 100, 80, 80);
		
		jbuttonBackToHome = new JButtonBackToHome(gf);
		this.add(jbuttonBackToHome);
		jbuttonBackToHome.setBounds(1200, 200, 80, 80);
		
		jbuttonUndo = new JButtonUndo(gf);
		this.add(jbuttonUndo);
		jbuttonUndo.setBounds(1200, 300, 80, 80);
		
		jbuttonSave = new JButtonSave(gf);
		this.add(jbuttonSave);
		jbuttonSave.setBounds(1200, 400, 80, 80);
	
		jbuttonItems = new JButtonItems(gf);
		this.add(jbuttonItems);
		jbuttonItems.setBounds(1200, 500, 80, 80);
		
		jpanelGameInfo = new JPanelGameInfo(gf);
		this.add(jpanelGameInfo);
		
		jPanelField = new JPanelField(gameFrame.getController().getMyGroup(),gameFrame.getController().getAiGroup(),gameFrame.getController());
		
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				jPanelField.add(new JPanelTile(gameFrame.getController().getTiles()[i][j],jPanelField));
			}
		}
		this.add(jPanelField);
		jPanelField.setBounds(431, 52, 663, 663);
		//gameFrame.getController().nextTurn();
		
		jPanelGameOver = new JPanelGameOver(gf);
		
		jPanelField.repaint();	
		
		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backGround, 0, 0, 1366, 768, null);
	
	}
	public JPanelField getJpanelField() {
		return jPanelField;
	}
	
	public JPanelGameInfo getJPanelGameInfo(){
		return jpanelGameInfo;
	}
	
	public JPanelGameOver getJPanelGameOver(){
		return jPanelGameOver;
	}


}
