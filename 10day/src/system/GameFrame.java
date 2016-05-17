package system;

import javax.swing.JFrame;

import music.MusicThread;
import panels.*;


public class GameFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Controller god;
	private JPanelHome jpanelHome;
	public MusicThread musicThread;
	//private JPanelField jpanelField;
	
	public void Launch(){
		god = new Controller(this);
		jpanelHome = new JPanelHome(this);
		musicThread = new MusicThread();
		
		//jpanelField = new JPanelField(god.getMyGroup(),god.getAiGroup(),god);
		//for(int i=0; i<10; i++){
		//	for(int j=0; j<10; j++){
		//		jpanelField.add(new JPanelTile(god.getTiles()[i][j],jpanelField));
		//	}
		//}
		
		//for(int i=0; i<3 ; i++){
			//jpanelField.add(new JPanelPlayer(god.getMyGroup()[i]));
		//}
		
		//for(int i=0; i<3 ; i++){
			//jpanelField.add(new JPanelPlayer(god.getAiGroup()[i]));
		//}
		
		setResizable(true);
		setSize(1366,795);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		
		//add(jpanelField);
		
		//god.nextTurn();
		
		//jpanelField.repaint();
		this.setContentPane(jpanelHome);
		musicThread.creatMT("ºùÂ«Ë¿", 2);
		musicThread.start();
	}
	
	public Controller getController(){
		return god;
	}
	
	public void setController(Controller c){
		god = c;
	}

	
	public JPanelHome getJPanelHome(){
		return jpanelHome;
	}
	
	public void setNewJPanelHome(JPanelHome jPanelHome) {
		jpanelHome = jPanelHome;
	}
	

}
