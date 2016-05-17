package system;

import java.util.ArrayList;
import java.util.Vector;

import gemelogic.Field;
import gemelogic.Player;
import gemelogic.Tile;
import panels.JPanelHome;

public class Controller {
	
	private GameFrame gameFrame;
	
	private Field field;
	private Tile[][] tilesArray;
	private Player[] myGroup;
	private Player[] aiGroup;
	private Player[] allPlayer;
	private Player presentPlayer;
	private Player nextPlayer;
	
	public ArrayList<Integer> arrayList = new ArrayList<Integer>();
	
	private int[] sequence = {0,3,4,1,2,5,3,0,1,4,5,2};
	private int rebirthPeriods;
	private int maxTurns;
	private int turns;
	private int maxPower;
	private boolean isAiTurn;
	private boolean vsPlayer;
	
	
	public Controller(GameFrame game){
		gameFrame = game;
		field = new Field(this);
		tilesArray = field.getTilesArray();
		myGroup = field.getMyPlayer();
		aiGroup = field.getAiPlayer();
		allPlayer = new Player[6];
		allPlayer[0] = myGroup[0];
		allPlayer[1] = myGroup[1];
		allPlayer[2] = myGroup[2];
		allPlayer[3] = aiGroup[0];
		allPlayer[4] = aiGroup[1];
		allPlayer[5] = aiGroup[2];
		
		presentPlayer = myGroup[0];
		nextPlayer = aiGroup[0];
		
		this.init();
		
	}
	
	public void init(){
		//��ʼ����Ϸ��Ϣ
		rebirthPeriods = 12;
		maxTurns = 60;
		turns = -1;
		maxPower = 7;
		
		tilesArray[2][9].setHome(0);
		tilesArray[2][9].setPlayer(myGroup[0]);
		tilesArray[5][9].setHome(1);
		tilesArray[5][9].setPlayer(myGroup[1]);
		tilesArray[8][9].setHome(2);
		tilesArray[8][9].setPlayer(myGroup[2]);
		tilesArray[2][0].setHome(3);
		tilesArray[2][0].setPlayer(aiGroup[0]);
		tilesArray[5][0].setHome(4);
		tilesArray[5][0].setPlayer(aiGroup[1]);
		tilesArray[8][0].setHome(5);
		tilesArray[8][0].setPlayer(aiGroup[2]);
		
		
	}
	
	
	public void updateGameInfo(){
		//����ÿ��player������ʣ��غ���������0����Ҫ����
		for(int i=0; i<3 ; i++){
			if(myGroup[i].getRebirthTurns()>0){
				myGroup[i].setRebirthTurns(myGroup[i].getRebirthTurns()-1);
				myGroup[i].setWasOccupied(false);
			}
		}
		for(int i=0; i<3 ; i++){
			if(aiGroup[i].getRebirthTurns()>0){
				aiGroup[i].setRebirthTurns(aiGroup[i].getRebirthTurns()-1);
				aiGroup[i].setWasOccupied(false);
			}
		}
		
		
		
		//���µ�ǰ��Ұ���������tile��activated;
		updatePresentPlayer();
		field.updateHorizon();
		
		
		
	}
	
	public boolean isGameOver(){
		if(turns >= maxTurns){
			return true;
		}
		return false;
	}
	
	//������һ�غ�
	public void nextTurn(){
		turns = turns +1;
		updateGameInfo();
		arrayList.clear();
		
		if(vsPlayer){
			if(!isGameOver()){
				
					if(presentPlayer.getRebirthTurns()!=0){
						nextTurn();
						//this.gameFrame.getJPanelHome().getJpanelBattleField().repaint();
					}
				
				
			}
				
			else{
				for(int i = 0; i<6 ; i++){
					allPlayer[i].setActivated(false);
					allPlayer[i].setSurrounding(false);
				}
				field.openAllField();
			}
				
		}
			
		else{
			if(!isGameOver()){
				if(isAiTurn){
					if(presentPlayer.getRebirthTurns()==0){
						presentPlayer.play();
						this.gameFrame.getJPanelHome().getJpanelBattleField().repaint();
					    nextTurn();
						
					}
				}
				else{
					if(presentPlayer.getRebirthTurns()!=0){
						nextTurn();
					}
				}
				
			}
			else{
				for(int i = 0; i<6 ; i++){
					allPlayer[i].setActivated(false);
					allPlayer[i].setSurrounding(false);
				}
				field.openAllField();
			}
		}
			
	}
	
	public void afterAnAction(){
		field.updateHorizon();
		
		//�����������,���ڻ���
		arrayList.add(getPresentPlayer().getActionNumber());
		//if(presentPlayer.getPresentPower()<=0){
			//nextTurn();
		//}
	}
	
	//���ݻغ���ȷ����ǰ���ж�player,��������ֵ����Ϊ�������ֵ�����player��ai�ģ�����false�����򷵻�true
	//��������ҵ�player��������activated
	public void updatePresentPlayer(){
		int now = sequence[turns%12];
		int next = sequence[(turns+1)%12];
		presentPlayer.setActivated(false);
		presentPlayer.setSurrounding(false);
		presentPlayer = allPlayer[now];
		presentPlayer.setPower(maxPower);
		presentPlayer.setActionNumber(5); // ��ʼʱ��������һ������5"�ƶ�"
		presentPlayer.setActivated(true);
		presentPlayer.setSurrounding(true);
		nextPlayer = allPlayer[next];
		//gameFrame.getJPanelHome();
			if(now==0||now==1||now==2){
				isAiTurn = false;
			}
			else{
				isAiTurn = true;
			}
		}
		
		/*
		if(turns%6<=2){
			presentPlayer.setActivated(false);
			presentPlayer.setSurrounding(false);
			presentPlayer = myGroup[turns%6];
			presentPlayer.setPower(maxPower);
			presentPlayer.setActivated(true);
			presentPlayer.setSurrounding(true);
			isAiTurn = false;
			return  true;
		}
		else{
			presentPlayer.setActivated(false);
			presentPlayer.setSurrounding(false);
			presentPlayer = aiGroup[turns%6-3];
			presentPlayer.setPower(maxPower);
			isAiTurn = true;
			return false;
		}
		*/
	
	public void setVsPlayer(boolean vs){
		vsPlayer = vs;
	}
	
	public int getrebirthPeriods(){
		return rebirthPeriods;
	}
	
	public int getMaxTurns(){
		return maxTurns;
	}
	
	public int getTurns(){
		return turns+1;
	}
	
	public int getLeftTurns(){
		return maxTurns - turns-1;
	}
	
	public int getMyScores(){
		int score = 0;
		for(int i=0; i<10 ; i++){
			for(int j=0; j<10 ; j++){
				if(field.getTilesArray()[i][j].getOccupyState()==1){
					score += 1 ;
				}
			}
		}
		return score;
	}
	
	public Player getPresentPlayer(){
		return presentPlayer;
	}
	
	public Player getNextPlayer(){
		return nextPlayer;
	}
	
	public Tile[][] getTiles(){
		return tilesArray;
	}
	
	public Player[] getAllPlayer(){
		return allPlayer;
	}
	
	public Player[] getMyGroup(){
		return myGroup;
	}
	
	public Player[] getAiGroup(){
		return aiGroup;
	}
	
	public Field getField(){
		return field;
	}
	public void setTurns(int i) {
		turns = i;
	}
	public boolean getAiTurn() {
		return isAiTurn;
	}
	public void setAiTurn(boolean b){
		isAiTurn = b;
	}
	public void resetLocation() {
		for (int i = 0; i < allPlayer.length; i++) {
			allPlayer[i].setSurrounding(false);
		}
		for (int i = 0; i < aiGroup.length; i++) {
			aiGroup[i].presentLocation=aiGroup[i].getHomeLocation();
		}
		for (int i = 0; i < myGroup.length; i++) {
			myGroup[i].presentLocation = myGroup[i].getHomeLocation();
		}
	}



}
