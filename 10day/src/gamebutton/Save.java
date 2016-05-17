package gamebutton;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;

import system.GameFrame;

public class Save extends JButton implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameFrame gameFrame;
	public Save(GameFrame gf){
		gameFrame =gf;
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
        try {
			ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("JPanelBattleField.txt")));
			oo.writeObject(gameFrame.getJPanelHome().getJpanelBattleField());
	        System.out.println("Dog对象序列化成功！");
			oo.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
