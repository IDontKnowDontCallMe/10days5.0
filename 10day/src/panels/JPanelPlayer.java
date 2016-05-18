package panels;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import gemelogic.Player;
import gemelogic.Tile;
import image.*;

public class JPanelPlayer extends JPanel implements MouseListener{
	
	private Player player ;
	private int number;
	private int length; //表示画在屏幕上的tile的长度
	private int x;
	private int y;  // x y表示此tile的坐标值
	private Image normalImage;
	private Image hidenImage;
	private Image presentImage;
	
	public JPanelPlayer(Player p){
		player = p;
		number = player.getNumber();
		length = 663/(player.getTile().getField().getController().getLength());
		init();
		this.setOpaque(false);
		this.updateLocation();
		this.setBounds(length*x, length*y, length, length);
		updatePresentImage();
	}
	
	public void init(){
		switch(player.getNumber()){
		case 0:
			normalImage = Samurai.redsword;
			hidenImage = Samurai.redsword_hide;
			break;
		case 1:
			normalImage = Samurai.redspear;
			hidenImage = Samurai.redspear_hide;
			break;
		case 2:
			normalImage = Samurai.redaxe;
			hidenImage = Samurai.redaxe_hide;
			break;
		case 3:
			normalImage = Samurai.bluesword;
			hidenImage = Samurai.bluesword_hide;
			break;
		case 4:
			normalImage = Samurai.bluespear;
			hidenImage = Samurai.bluespear_hide;
			break;
		case 5:
			normalImage = Samurai.blueaxe;
			hidenImage = Samurai.blueaxe_hide;
			break;
		}
	}
	
	public void updateLocation(){
		x = player.getPresentLocation().x;
		y = player.getPresentLocation().y;
	}
	
	public void updatePresentImage(){
		if(player.getTile().getHasHorizon()){
			if(player.getState()==0){
				presentImage = normalImage;
			}
			else presentImage = hidenImage;
		}
		else presentImage = null;
	}
	
	public Image getPresentImage(){
		return presentImage;
	}
	
	public int getLength(){
		return length;
	}
	
	public int getTheX(){
		return x;
	}
	
	public int getTheY(){
		return y;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		updatePresentImage();
		g.drawImage(presentImage, length/20, length/20, length-length/20-length/20,length-length/20-length/20,null);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
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
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
