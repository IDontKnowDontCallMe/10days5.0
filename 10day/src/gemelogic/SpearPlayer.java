package gemelogic;

import java.awt.Point;

public class SpearPlayer extends Player{
	
	
	
	public SpearPlayer(Point presentLocation, Point homeLocation,int playerNumber, Field field) {
		super(presentLocation, homeLocation,playerNumber,field);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void occupy(Field field, int direction){
		
		presentPower -= 4;
		
		int x = presentLocation.x;
		int y = presentLocation.y;
		
		int max = 0;
		
		switch(direction){
		case 1:
			if(y>=4){
				max = y-4;
			}
			else max = 0;
			for(int i=y-1; i>=max; i--){
				field.tilesArray[x][i].setOccupyState(playerNumber);
			}
			this.setActionNumber(5);
			break;
		case 2:
			if(y<=field.getTilesColumn()-5){
				max = y+4;
			}
			else max = field.getTilesColumn()-1;
			for(int i=y+1; i<=max; i++){
				field.tilesArray[x][i].setOccupyState(playerNumber);
			}
			this.setActionNumber(6);
			break;
		case 3:
			if(x>=4){
				max = x-4;
			}
			else max = 0;
			for(int i=x-1; i>=max; i--){
				field.tilesArray[i][y].setOccupyState(playerNumber);
			}
			this.setActionNumber(7);
			break;
		case 4:
			if(x<=field.getTilesRow()-5){
				max = x+4;
			}
			else max = field.getTilesRow()-1;
			for(int i=x+1; i<=max; i++){
				field.tilesArray[i][y].setOccupyState(playerNumber);
			}
			this.setActionNumber(8);
			break;
			
		}
		
	}
	
	@Override
	public void reOccupy(Field field, int direction){
		int x = presentLocation.x;
		int y = presentLocation.y;
		
		int max = 0;
		
		switch(direction){
		case 1:
			if(y>=4){
				max = y-4;
			}
			else max = 0;
			for(int i=y-1; i>=max; i--){
				field.tilesArray[x][i].resetToLastState();;
			}
			
			break;
		case 2:
			if(y<=field.getTilesColumn()-5){
				max = y+4;
			}
			else max = field.getTilesColumn()-1;
			for(int i=y+1; i<=max; i++){
				field.tilesArray[x][i].resetToLastState();;
			}
			
			break;
		case 3:
			if(x>=4){
				max = x-4;
			}
			else max = 0;
			for(int i=x-1; i>=max; i--){
				field.tilesArray[i][y].resetToLastState();;
			}
			
			break;
		case 4:
			if(x<=field.getTilesRow()-5){
				max = x+4;
			}
			else max = field.getTilesRow()-1;
			for(int i=x+1; i<=max; i++){
				field.tilesArray[i][y].resetToLastState();;
			}
			
			break;
			
		}
	}
	
    // public void returnHome(){
		
	//	field.tilesArray[presentLocation.x][presentLocation.y].setPlayer(null);
	//	rebirthTurns = field.getController().getrebirthPeriods();
	//	if(this.getNumber()>2){
	//		presentLocation = field.tilesArray[5][0].getLocation();
	//	}
	//	else presentLocation = field.tilesArray[5][9].getLocation();
	//	field.tilesArray[presentLocation.x][presentLocation.y].setPlayer(this);
	//}

}
