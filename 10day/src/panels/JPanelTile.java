package panels;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import image.*;

import javax.swing.JPanel;

import gemelogic.Tile;

public class JPanelTile extends JPanel implements MouseListener, KeyListener{
	
	private Tile tile ;
	private JPanelField jpanelField;
	private int length; //表示画在屏幕上的tile的长度
	private int x;
	private int y;  // x y表示此tile的坐标值
	private Image presentImage;
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		updatePresentImage();
		g.drawImage(presentImage, length/20, length/20,length-length/20-length/20,length-length/20-length/20, null);
	}
	
	public JPanelTile(Tile t, JPanelField f){
		jpanelField = f;
		tile = t;
		init();
		this.setOpaque(false);
		this.addMouseListener(this);
		this.addKeyListener(this);
		this.setBounds(length*x, length*y, length, length);
	}
	
	
	public void init(){
		length = 663/(tile.getField().getController().getLength());
		x =  tile.getLocation().x;
		y =  tile.getLocation().y;
		updatePresentImage();
	}
	
	public void updatePresentImage(){
		
		if(!tile.getHasHorizon()){
			presentImage = Cell.arrowleft_common;
		}
		else{
			if(tile.getIsActivated()){
				if(tile.getHome()<0){
					switch(tile.getOccupyState()){
						case 0:
							presentImage = Cell.see_operate;
							break;
						case 1:
							presentImage = Cell.red_operate;
							break;
						case 2:
							presentImage = Cell.blue_operate;
							break;
					}
				}
				else{
					
					switch(tile.getHome()){
					case 0:
						presentImage = Cell.redsword_home_act;
						break;
					case 1:
						presentImage = Cell.redspear_home_act;
						break;
					case 2:
						presentImage = Cell.redaxe_home_act;
						break;
					case 3:
						presentImage = Cell.bluesword_home_act;
						break;
					case 4:
						presentImage = Cell.bluespear_home_act;
						break;
					case 5:
						presentImage = Cell.blueaxe_home_act;
						break;
						
					}
					
				}
			}
			else{
				if(tile.getHome()<0){
					switch(tile.getOccupyState()){
						case 0:
							presentImage = Cell.arrowright_click;
							break;
						case 1:
							presentImage = Cell.arrowdown_common;
							break;
						case 2:
							presentImage = Cell.arrowdown_click;
							break;
					}
				}
				else{
					switch(tile.getHome()){
					case 0:
						presentImage = Cell.redsword_home;
						break;
					case 1:
						presentImage = Cell.redspear_home;
						break;
					case 2:
						presentImage = Cell.redaxe_home;
						break;
					case 3:
						presentImage = Cell.bluesword_home;
						break;
					case 4:
						presentImage = Cell.bluespear_home;
						break;
					case 5:
						presentImage = Cell.blueaxe_home;
						break;
						
					}
				}
			}
		}
		
	}
	
	public int getTheX(){
		return x;
	}
	
	public int getTheY(){
		return y;
	}
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int i = arg0.getButton();
		if(tile.getIsActivated()){
			switch(i){
			case MouseEvent.BUTTON1:
				if(tile.getDirection()!=5&&tile.canMove(tile.getField().getController().getPresentPlayer())){
					tile.getField().getController().getPresentPlayer().move(tile.getDirection());
					tile.getField().getController().afterAnAction();
				    jpanelField.repaint();
				}
				break;
			case MouseEvent.BUTTON3:
				if(tile.getDirection()!=5&&tile.getField().getController().getPresentPlayer().getPresentPower()>=4){
					tile.getField().getController().getPresentPlayer().occupy(tile.getField(), tile.getDirection());
					tile.getField().getController().afterAnAction();
					jpanelField.repaint();
				}
				break;
			case MouseEvent.BUTTON2:
				tile.getField().getController().getPresentPlayer().changeState();
				tile.getField().getController().afterAnAction();
				jpanelField.repaint();
				break;
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
