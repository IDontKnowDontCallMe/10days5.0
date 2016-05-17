package gemelogic;

import java.awt.Point;

import system.Controller;

public class Field {
	
	private Controller god;
	
	public Tile[][] tilesArray;
	public Player[] myGroup;
	public Player[] aiGroup;
	
	public Field(Controller con){
		
		god = con;
		
		tilesArray = new Tile[10][10];
		for(int i=0; i<10;i++){
			for(int j=0; j<10; j++){
				tilesArray[i][j]=new Tile(i,j,this);
			}
		}
		myGroup = new Player[3];
		myGroup[0] = new SwordPlayer(new Point(2,9),new Point(2,9), 0 , this);
		myGroup[1] = new SpearPlayer(new Point(5,9),new Point(5,9), 1 , this);
		myGroup[2] = new AxePlayer(new Point(8,9),new Point(8,9), 2 , this);
		aiGroup = new Player[3];
		aiGroup[0] = new SwordPlayer(new Point(2,0),new Point(2,0), 3 , this);
		aiGroup[1] = new SpearPlayer(new Point(5,0),new Point(5,0), 4 , this);
		aiGroup[2] = new AxePlayer(new Point(8,0),new Point(8,0), 5 , this);
		
	}
	
	public void setActivated(){
		
	}
	
	public void openAllField(){
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				tilesArray[i][j].setHorizon(true);
			}
		}
	}
	
	public void updateHorizon(){
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				tilesArray[i][j].setHorizon(false);
			}
		}
		
		if (getController().getAiTurn()) {
			for(Player p:aiGroup){
				p.updateHorizon(tilesArray);
			}
		}else {
			for(Player p:myGroup){
				p.updateHorizon(tilesArray);
			}
		}
		
		
		
	}
	
	public Tile[][] getTilesArray(){
		return tilesArray;
	}
	
	public Controller getController(){
		return god;
	}
	
	public int getTilesRow() {  //返回棋盘的横向长度
		return tilesArray.length;
	}
	
	public int getTilesColumn() { //返回棋盘的纵向长度
		return tilesArray[0].length;
	}
	
	public Player[] getMyPlayer(){
		return myGroup;
	}
	
	public Player[] getAiPlayer(){
		return aiGroup;
	}

}
