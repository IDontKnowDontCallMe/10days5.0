package gamebutton;

import javax.swing.JButton;

import system.GameFrame;

public class JButtonItems extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GameFrame gameFrame;
	
	
	public JButtonItems(GameFrame gf){
		this.setText("Items");
		gameFrame = gf;
		
	}

}
