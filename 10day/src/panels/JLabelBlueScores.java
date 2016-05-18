package panels;

import system.GameFrame;

public class JLabelBlueScores extends JLabelScores{
	
	public JLabelBlueScores(GameFrame gf, int h) {
		super(gf, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateImage(){
		int score = gameFrame.getController().getAiScores();
		hundred = numbers[score/100];
		ten = numbers[score/10%10];
		one = numbers[score%10];
	}
	

}
