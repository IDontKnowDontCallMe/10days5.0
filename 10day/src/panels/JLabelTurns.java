package panels;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JLabel;

import image.Cell;
import system.GameFrame;

public class JLabelTurns extends JLabel{
	
private GameFrame gameFrame;
	
	private Image[] numbers;
	private Image hundred;
	private Image ten;
	private Image one;
	
	private int height;
	
	public JLabelTurns(GameFrame gf, int h){
		
		gameFrame = gf;
		height = h;
		
		numbers = new Image[10];
		numbers[0] = Cell.number0;
		numbers[1] = Cell.number1;
		numbers[2] = Cell.number2;
		numbers[3] = Cell.number3;
		numbers[4] = Cell.number4;
		numbers[5] = Cell.number5;
		numbers[6] = Cell.number6;
		numbers[7] = Cell.number7;
		numbers[8] = Cell.number8;
		numbers[9] = Cell.number9;
		
		setOpaque(false);
		
	}
	
	@Override
	public void paint(Graphics g){
		updateImage();
		g.drawImage(hundred, 0, 0,height,height, null);
		g.drawImage(ten, height, 0,height,height, null);
		g.drawImage(one, height*2, 0,height,height, null);
	}
	
	public void updateImage(){
		int turns = gameFrame.getController().getTurns();
		if(turns>gameFrame.getController().getMaxTurns()){
			return;
		}
		hundred = numbers[turns/100];
		ten = numbers[turns/10%10];
		one = numbers[turns%10];
	}

}
