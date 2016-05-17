package gemelogic;

import java.awt.Point;
public class AxePlayer extends Player{

	public AxePlayer(Point presentLocation, Point homeLocation, int playerNumber, Field field) {
		super(presentLocation, homeLocation, playerNumber, field);
		// TODO Auto-generated constructor stub
	}
	public void occupy(Field field, int direction){
		
		presentPower -= 4;
		
		int x = presentLocation.x;
		int y = presentLocation.y;
		
		switch(direction){
		case 1:
			if (x>=1&&y>=1) {
				field.tilesArray[x-1][y-1].setOccupyState(playerNumber);
			}
			if (x<field.getTilesRow()-1&&y>=1) {
				field.tilesArray[x+1][y-1].setOccupyState(playerNumber);
			}
			if (y>=1) {
				field.tilesArray[x][y-1].setOccupyState(playerNumber);
			}
			if (x>=1) {
				field.tilesArray[x-1][y].setOccupyState(playerNumber);
			}
			if (x<field.getTilesRow()-1) {
				field.tilesArray[x+1][y].setOccupyState(playerNumber);
			}
			if (x>=1&&y<field.getTilesColumn()-1) {
				field.tilesArray[x-1][y+1].setOccupyState(playerNumber);
			}
			if (x<field.getTilesRow()-1&&y<field.getTilesColumn()-1) {
				field.tilesArray[x+1][y+1].setOccupyState(playerNumber);
			}
			this.setActionNumber(5);
			break;
		case 2:
			if (x>=1&&y>=1) {
				field.tilesArray[x-1][y-1].setOccupyState(playerNumber);
			}
			if (x<field.getTilesRow()-1&&y>=1) {
				field.tilesArray[x+1][y-1].setOccupyState(playerNumber);
			}
			if (x>=1) {
				field.tilesArray[x-1][y].setOccupyState(playerNumber);
			}
			if (x<field.getTilesRow()-1) {
				field.tilesArray[x+1][y].setOccupyState(playerNumber);
			}
			if (x>=1&&y<field.getTilesColumn()-1) {
				field.tilesArray[x-1][y+1].setOccupyState(playerNumber);
			}
			if (x<field.getTilesRow()-1&&y<field.getTilesColumn()-1) {
				field.tilesArray[x+1][y+1].setOccupyState(playerNumber);
			}
			if (y<field.getTilesColumn()-1) {
				field.tilesArray[x][y+1].setOccupyState(playerNumber);
			}
			this.setActionNumber(6);
			break;
		case 3:
			if (x>=1&&y>=1) {
				field.tilesArray[x-1][y-1].setOccupyState(playerNumber);
			}
			if (x<field.getTilesRow()-1&&y>=1) {
				field.tilesArray[x+1][y-1].setOccupyState(playerNumber);
			}
			if (y>=1) {
				field.tilesArray[x][y-1].setOccupyState(playerNumber);
			}
			if (x>=1) {
				field.tilesArray[x-1][y].setOccupyState(playerNumber);
			}
			if (x>=1&&y<field.getTilesColumn()-1) {
				field.tilesArray[x-1][y+1].setOccupyState(playerNumber);
			}
			if (x<field.getTilesRow()-1&&y<field.getTilesColumn()-1) {
				field.tilesArray[x+1][y+1].setOccupyState(playerNumber);
			}
			if (y<field.getTilesColumn()-1) {
				field.tilesArray[x][y+1].setOccupyState(playerNumber);
			}
			this.setActionNumber(7);
			break;
		case 4:
			if (x>=1&&y>=1) {
				field.tilesArray[x-1][y-1].setOccupyState(playerNumber);
			}
			if (x<field.getTilesRow()-1&&y>=1) {
				field.tilesArray[x+1][y-1].setOccupyState(playerNumber);
			}
			if (y>=1) {
				field.tilesArray[x][y-1].setOccupyState(playerNumber);
			}
			if (x<field.getTilesRow()-1) {
				field.tilesArray[x+1][y].setOccupyState(playerNumber);
			}
			if (x>=1&&y<field.getTilesColumn()-1) {
				field.tilesArray[x-1][y+1].setOccupyState(playerNumber);
			}
			if (x<field.getTilesRow()-1&&y<field.getTilesColumn()-1) {
				field.tilesArray[x+1][y+1].setOccupyState(playerNumber);
			}
			if (y<field.getTilesColumn()-1) {
				field.tilesArray[x][y+1].setOccupyState(playerNumber);
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
			if (x>=1&&y>=1) {
				field.tilesArray[x-1][y-1].resetToLastState();;
			}
			if (x<field.getTilesRow()-1&&y>=1) {
				field.tilesArray[x+1][y-1].resetToLastState();;
			}
			if (y>=1) {
				field.tilesArray[x][y-1].resetToLastState();;
			}
			if (x>=1) {
				field.tilesArray[x-1][y].resetToLastState();;
			}
			if (x<field.getTilesRow()-1) {
				field.tilesArray[x+1][y].resetToLastState();;
			}
			if (x>=1&&y<field.getTilesColumn()-1) {
				field.tilesArray[x-1][y+1].resetToLastState();;
			}
			if (x<field.getTilesRow()-1&&y<field.getTilesColumn()-1) {
				field.tilesArray[x+1][y+1].resetToLastState();;
			}
			break;
		case 2:
			if (x>=1&&y>=1) {
				field.tilesArray[x-1][y-1].resetToLastState();;
			}
			if (x<field.getTilesRow()-1&&y>=1) {
				field.tilesArray[x+1][y-1].resetToLastState();;
			}
			if (x>=1) {
				field.tilesArray[x-1][y].resetToLastState();;
			}
			if (x<field.getTilesRow()-1) {
				field.tilesArray[x+1][y].resetToLastState();;
			}
			if (x>=1&&y<field.getTilesColumn()-1) {
				field.tilesArray[x-1][y+1].resetToLastState();;
			}
			if (x<field.getTilesRow()-1&&y<field.getTilesColumn()-1) {
				field.tilesArray[x+1][y+1].resetToLastState();;
			}
			if (y<field.getTilesColumn()-1) {
				field.tilesArray[x][y+1].resetToLastState();;
			}
			
			break;
		case 3:
			if (x>=1&&y>=1) {
				field.tilesArray[x-1][y-1].resetToLastState();;
			}
			if (x<field.getTilesRow()-1&&y>=1) {
				field.tilesArray[x+1][y-1].resetToLastState();;
			}
			if (y>=1) {
				field.tilesArray[x][y-1].resetToLastState();;
			}
			if (x>=1) {
				field.tilesArray[x-1][y].resetToLastState();;
			}
			if (x>=1&&y<field.getTilesColumn()-1) {
				field.tilesArray[x-1][y+1].resetToLastState();;
			}
			if (x<field.getTilesRow()-1&&y<field.getTilesColumn()-1) {
				field.tilesArray[x+1][y+1].resetToLastState();;
			}
			if (y<field.getTilesColumn()-1) {
				field.tilesArray[x][y+1].resetToLastState();;
			}
			
			break;
		case 4:
			if (x>=1&&y>=1) {
				field.tilesArray[x-1][y-1].resetToLastState();;
			}
			if (x<field.getTilesRow()-1&&y>=1) {
				field.tilesArray[x+1][y-1].resetToLastState();;
			}
			if (y>=1) {
				field.tilesArray[x][y-1].resetToLastState();;
			}
			if (x<field.getTilesRow()-1) {
				field.tilesArray[x+1][y].resetToLastState();;
			}
			if (x>=1&&y<field.getTilesColumn()-1) {
				field.tilesArray[x-1][y+1].resetToLastState();;
			}
			if (x<field.getTilesRow()-1&&y<field.getTilesColumn()-1) {
				field.tilesArray[x+1][y+1].resetToLastState();;
			}
			if (y<field.getTilesColumn()-1) {
				field.tilesArray[x][y+1].resetToLastState();;
			}
			
			break;
			
		}
	}
	
	//public void returnHome(){
		
		//field.tilesArray[presentLocation.x][presentLocation.y].setPlayer(null);
		//rebirthTurns = field.getController().getrebirthPeriods();
		//if(this.getNumber()>2){
		//	presentLocation = field.tilesArray[8][0].getLocation();
		//}
		//else presentLocation = field.tilesArray[8][9].getLocation();
		//field.tilesArray[presentLocation.x][presentLocation.y].setPlayer(this);
	//}
}
