package gemelogic;

import java.awt.Point;
import java.util.Random;

import system.Controller;

public class Player {
	
	public Point presentLocation;
	protected Point homeLocation;
	protected Point lastLocation;
	protected boolean wasOccupied;
	protected Field field;
	protected int playerNumber; 
	private int state; //0是现身，1是隐身
	protected int rebirthTurns; //表示剩余重生的回合数，0则表示可以进行动作
	private final int maxPower = 7;
	protected int presentPower;
	private boolean isActivated; //表示该player是否在当前回合可动
	private int actionNumber;  //表示上一个动作的编号，1-4表示四个方向的移动，5-8是占领，9是隐身现身切换
	
	public Player(Point presentLocation, Point homeLocation, int playerNumber, Field field){
		this.playerNumber = playerNumber;
		this.presentLocation = presentLocation;
		this.homeLocation= homeLocation;
		this.field = field;
		state = 0;
		rebirthTurns = 0;
		isActivated = false;
		actionNumber = 0;
	}
	
	public void updateHorizon(Tile[][] tiles){
		int x = presentLocation.x;
		int y = presentLocation.y;
		
		for(int i=x-3;i<x+7;i++){
			for(int j=y-3;j<y+7;j++){
				if((0<=i&&i<10)&&(0<=j&&j<10)){
					if(Math.abs(i-x)+Math.abs(j-y)<=3){
						tiles[i][j].setHorizon(true);
					}
				}
			}
		}
	}
	
	public void setWasOccupied(boolean b){
		wasOccupied = b;
	}
	
	//为了配合悔棋的实现，此方法只能用于被打回大本营时调用
	public void returnHome(){
		wasOccupied = true;
		lastLocation = presentLocation;
		
		rebirthTurns = field.getController().getrebirthPeriods();
		field.getTilesArray()[presentLocation.x][presentLocation.y].setPlayer(null);
		field.getTilesArray()[homeLocation.x][homeLocation.y].setPlayer(this);
		presentLocation = homeLocation;

	}
	
	//用于悔棋
	public void returnLastTile(){
		if(!wasOccupied){
			return;
		}
		
		rebirthTurns = 0;
		presentLocation = lastLocation;
		field.getTilesArray()[presentLocation.x][presentLocation.y].setPlayer(this);
		wasOccupied = false;
		
	}
	
	public void move(int direction){
		this.setSurrounding(false);
		field.tilesArray[presentLocation.x][presentLocation.y].setPlayer(null);
		switch(direction){
		case 1:
			presentLocation.y -=1;
			field.tilesArray[presentLocation.x][presentLocation.y].setPlayer(this);
			this.setActionNumber(2);
			break;
		case 2:
			presentLocation.y +=1;
			field.tilesArray[presentLocation.x][presentLocation.y].setPlayer(this);
			this.setActionNumber(1);
			break;
		case 3:
			presentLocation.x -=1;
			field.tilesArray[presentLocation.x][presentLocation.y].setPlayer(this);
			this.setActionNumber(4);
			break;
		case 4:
			presentLocation.x +=1;
			field.tilesArray[presentLocation.x][presentLocation.y].setPlayer(this);
			this.setActionNumber(3);
			break;
		case 5:
			return;
		}
		presentPower -= 1;
		this.setSurrounding(true);
	}
	
	public void changeState(){
		int occupyState = field.getTilesArray()[this.presentLocation.x][this.presentLocation.y].getOccupyState();
		if(!((occupyState==1&&this.playerNumber>2)||(occupyState==2&&this.playerNumber<=2))){
			if(state==0){
				state=1;
			}
			else state = 0;
			
			presentPower -= 1;
		}
		
		actionNumber = 9;
		
	}
	
	public void setHomeLocation(Point p){
		homeLocation = p;
	}
	
	public int getActionNumber(){
		return actionNumber;
	}
	
	public void setActionNumber(int act){
		actionNumber = act;
	}
	
	public void setActivated(boolean act){
		isActivated = act;
	}
	
	public void setPower(int n){
		presentPower = n;
	}
	
	public int getNumber(){
		return playerNumber;
	}
	
	public int getState(){
		return state;
	}
	
	public int getRebirthTurns(){
		return rebirthTurns;
	}
	
	public void setRebirthTurns(int n){
		rebirthTurns = n;
	}
	
	public Tile getTile(){
		return field.getTilesArray()[this.getPresentLocation().x][this.getPresentLocation().y];
	}
	
	public Point getHomeLocation(){
		return homeLocation;
	}
	
	public int getPresentPower(){
		return presentPower;
	}
	
	public Point getPresentLocation(){
		return presentLocation;
	}
	public void setX(int i) {
		presentLocation.x = i;
	}
	public void setY(int i) {
		presentLocation.y = i;
	}
	
	public void setSurrounding(boolean act){
		int x = presentLocation.x;
		int y = presentLocation.y;
		field.tilesArray[x][y].setActivated(act);
		field.tilesArray[x][y].setDirection(5);
		if(x>0){
			field.tilesArray[x-1][y].setActivated(act);
			field.tilesArray[x-1][y].setDirection(3);
		}
		if(x<9){
			field.tilesArray[x+1][y].setActivated(act);
			field.tilesArray[x+1][y].setDirection(4);
		}
		if(y>0){
			field.tilesArray[x][y-1].setActivated(act);
			field.tilesArray[x][y-1].setDirection(1);
		}
		if(y<9){
			field.tilesArray[x][y+1].setActivated(act);
			field.tilesArray[x][y+1].setDirection(2);
		}
	}
	
	public void setPresentLocation(Point p){
		presentLocation = p;
		field.tilesArray[p.x][p.y].setPlayer(this);
	}
	
	//occupy方法，特定兵种需override掉这个方法，方向1 2 3 4对应上下左右
	public void occupy(Field field, int direction){
		
	}
	
	//用于悔棋
	public void reOccupy(Field field, int direction){
		
	}
	
	//这个方法用来实现ai的player的动作，玩家的不需要涉及，ai的player需override掉
	public void play()  {
		
		Random rnd = new Random();
		
		int r = rnd.nextInt(3)+1;
		if(!((this.getPresentLocation().y==0&&r==1)||(this.getPresentLocation().y==9&&r==2)||
		(this.getPresentLocation().x==0&&r==3)||(this.getPresentLocation().x==9&&r==4))){
			this.occupy(field, r);
		}
		
		for(int i=0; i<3; i++){
			
			int n = rnd.nextInt(4)+1;
			switch(n){
			case 1:
				if(this.getPresentLocation().y>0&&this.field.getTilesArray()[this.getPresentLocation().x][this.getPresentLocation().y-1].canMove(this)){
					this.move(1);
				}                  
				break;
			case 2:
				if(this.getPresentLocation().y<9&&this.field.getTilesArray()[this.getPresentLocation().x][this.getPresentLocation().y+1].canMove(this)){
					this.move(2);
				} 
				break;
			case 3:
				if(this.getPresentLocation().x>0&&this.field.getTilesArray()[this.getPresentLocation().x-1][this.getPresentLocation().y].canMove(this)){
					this.move(3);
				} 
				break;
			case 4:
				if(this.getPresentLocation().x<9&&this.field.getTilesArray()[this.getPresentLocation().x+1][this.getPresentLocation().y].canMove(this)){
					this.move(4);
				} 
				break;
			}
		}
		
	}

}
