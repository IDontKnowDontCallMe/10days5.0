package gemelogic;

import java.awt.Point;

public class Tile {
	
	private Point location;
	private Player player;
	private Field field;
	private boolean isActivated;
	private boolean ishome;
	private int home; //-1表示不是营地，0-2表示我方，3-5表示ai
	private int occupyState; //0表示没有被占领，1表示被玩家占领，2表示被ai占领
	private int lastOccupyState;
	private boolean hasHorizon; //表示玩家是否拥有这一块tile的视野
	private int direction; //表示若此tile是activated的时候，此tile在当前player的方向
	
	
	public Tile(int x, int y, Field f){
		field = f;
		location = new Point(x,y);
		player = null;
		isActivated = false;
		home = -1;
		occupyState = 0;
	}
	
	public void setPlayer(Player player){
		this.player = player;
	}
	
	public void setOccupyState(int s){
		if(ishome){
			return;
		}
		if(player!=null){
			if((s<=2&&player.getNumber()>2)||(s>2&&player.getNumber()<=2)){
				player.returnHome();
			}
		}
		if(s<=2){
			lastOccupyState = occupyState;
			occupyState = 1;
		}
		else{
			lastOccupyState = occupyState;
			occupyState = 2;
		}
	}
	
	public void resetToLastState(){
		occupyState = lastOccupyState;
	}
	
	public void setDirection(int direction){
		this.direction = direction;
	}
	
	public void setHome(int n){
		home = n;
	}
	
	public int getDirection(){
		return direction;
	}
	
	public Field getField(){
		return field;
	}
	
	public Point getLocation(){
		return location;
	}
	
	public int getHome(){
		return home;
	}
	
	public int getOccupyState(){
		return occupyState;
	}
	
	public boolean getHasHorizon(){
		return hasHorizon;
	}
	
	public boolean getIsActivated(){
		return isActivated;
	}
	
	public Player getPlayer(){
	 	return player;
	}
	
	public void setActivated(boolean act){
		isActivated = act;
	}
	
	public void setHorizon(boolean horizon){
		hasHorizon = horizon;
	}
	
	public boolean canMove(Player p){
		if(p.getPresentPower()<1){
			return false;
		}
		if(player!=null){
			return false;
		}
		if((occupyState==1&&p.getNumber()>2&&p.getState()==1)||(occupyState==2&&p.getNumber()<3&&p.getState()==1)){
			return false;
		}
		if(home>=0&&!location.equals(p.getHomeLocation())){
			return false;
		}
		return true;
		
	}
	
	

}
