package gemelogic;

import java.awt.Point;

public class SwordPlayer extends Player{

	public SwordPlayer(Point presentLocation, Point homeLocation, int playerNumber, Field field) {
		super(presentLocation, homeLocation, playerNumber, field);
		// TODO Auto-generated constructor stub
	}

	public void occupy(Field field, int direction){
		
		presentPower -= 4;
		
		int x = presentLocation.x;
		int y = presentLocation.y;
				
		switch(direction){
		case 1:
			if(x>0&&y>0) {
				field.tilesArray[x-1][y-1].setOccupyState(playerNumber);
			}
			for (int i = 1; i < 3; i++) {
				if (x==0) break;
				field.tilesArray[x-i][y].setOccupyState(playerNumber);
				if ((x-i)==0) break;
			}
			for (int i = 1; i < 3; i++) {
				if (y==0) break;
				field.tilesArray[x][y-i].setOccupyState(playerNumber);
				if ((y-i)==0) break;
			}
			this.setActionNumber(5);
			break;
		case 2:
			if(x<field.getTilesRow()-2&&y<field.getTilesColumn()-2) {
				field.tilesArray[x+1][y+1].setOccupyState(playerNumber);
			}
			for (int i = 1; i < 3; i++) {
				if(x==field.getTilesRow()-1) break;
				field.tilesArray[x+i][y].setOccupyState(playerNumber);
				if ((x+i)==field.getTilesRow()-1) break;
			}
			for (int i = 1; i < 3; i++) {
				if(y==field.getTilesColumn()-1) break;
				field.tilesArray[x][y+i].setOccupyState(playerNumber);
				if ((y+i)==field.getTilesColumn()-1) break;
			}
			this.setActionNumber(6);
			break;
		case 3:
			if(x>=1&&y<field.getTilesColumn()-2) {
				field.tilesArray[x-1][y+1].setOccupyState(playerNumber);
			}
			for (int i = 1; i <=2; i++) {
				if (x==0) break;
				field.tilesArray[x-i][y].setOccupyState(playerNumber);
				if ((x-i)==0) break;
			}
			for (int i = 1; i <=2; i++) {
				if(y==field.getTilesColumn()-1) break;
				field.tilesArray[x][y+i].setOccupyState(playerNumber);
				if ((y+i)==field.getTilesColumn()-1) break;
			}
			this.setActionNumber(7);
			break;
		case 4:
			if(x<field.getTilesRow()-2&&y>=1) {
				field.tilesArray[x+1][y-1].setOccupyState(playerNumber);
			}
			for (int i = 1; i <=2; i++) {
				if(x==field.getTilesRow()-1) break;
				field.tilesArray[x+i][y].setOccupyState(playerNumber);
				if ((x+i)==field.getTilesRow()-1) break;
			}
			for (int i = 1; i <=2; i++) {
				if (y==0) break;
				field.tilesArray[x][y-i].setOccupyState(playerNumber);
				if ((y-i)==0) break;
			}
			this.setActionNumber(8);
			break;
			
		}
	}
	
	@Override
	public void reOccupy(Field field, int direction){
		int x = presentLocation.x;
		int y = presentLocation.y;
				
		switch(direction){
		case 1:
			if(x>0&&y>0) {
				field.tilesArray[x-1][y-1].resetToLastState();;
			}
			for (int i = 1; i < 3; i++) {
				if (x==0) break;
				field.tilesArray[x-i][y].resetToLastState();;
				if ((x-i)==0) break;
			}
			for (int i = 1; i < 3; i++) {
				if (y==0) break;
				field.tilesArray[x][y-i].resetToLastState();;
				if ((y-i)==0) break;
			}
			
			break;
		case 2:
			if(x<field.getTilesRow()-2&&y<field.getTilesColumn()-2) {
				field.tilesArray[x+1][y+1].resetToLastState();;
			}
			for (int i = 1; i < 3; i++) {
				if(x==field.getTilesRow()-1) break;
				field.tilesArray[x+i][y].resetToLastState();;
				if ((x+i)==field.getTilesRow()-1) break;
			}
			for (int i = 1; i < 3; i++) {
				if(y==field.getTilesColumn()-1) break;
				field.tilesArray[x][y+i].resetToLastState();;
				if ((y+i)==field.getTilesColumn()-1) break;
			}
			
			break;
		case 3:
			if(x>=1&&y<field.getTilesColumn()-2) {
				field.tilesArray[x-1][y+1].resetToLastState();;
			}
			for (int i = 1; i <=2; i++) {
				if (x==0) break;
				field.tilesArray[x-i][y].resetToLastState();;
				if ((x-i)==0) break;
			}
			for (int i = 1; i <=2; i++) {
				if(y==field.getTilesColumn()-1) break;
				field.tilesArray[x][y+i].resetToLastState();;
				if ((y+i)==field.getTilesColumn()-1) break;
			}
			
			break;
		case 4:
			if(x<field.getTilesRow()-2&&y>=1) {
				field.tilesArray[x+1][y-1].resetToLastState();;
			}
			for (int i = 1; i <=2; i++) {
				if(x==field.getTilesRow()-1) break;
				field.tilesArray[x+i][y].resetToLastState();;
				if ((x+i)==field.getTilesRow()-1) break;
			}
			for (int i = 1; i <=2; i++) {
				if (y==0) break;
				field.tilesArray[x][y-i].resetToLastState();;
				if ((y-i)==0) break;
			}
			this.setActionNumber(8);
			break;
			
		}
	}
     //   public void returnHome(){
		
	//	field.tilesArray[presentLocation.x][presentLocation.y].setPlayer(null);
	//	rebirthTurns = field.getController().getrebirthPeriods();
	//	if(this.getNumber()>2){
	//		presentLocation = field.tilesArray[2][0].getLocation();
	//	}
	//	else presentLocation = field.tilesArray[2][9].getLocation();
	//	field.tilesArray[presentLocation.x][presentLocation.y].setPlayer(this);
	//}
}
