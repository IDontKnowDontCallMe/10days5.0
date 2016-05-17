package music;

import music.MyRunnable;
import music.AudioPlayer;

public class MusicThread {
    String  musictag="00";
    int Looptimes =1;
    public MyRunnable threadJob = new MyRunnable();;
    public Thread thread;
    public AudioPlayer map;
    public boolean isRunning=false;
   
	public  void choosemusic (String a){
		switch (a){
		case "³ß°Ë":
			musictag = "³ß°Ë";
			break;
		case "ºùÂ«Ë¿":
			musictag = "ºùÂ«Ë¿";
			break;
		
		}
	}
	
	public  void changeLoopTimes (int b){
		Looptimes = b;
		
	}
	public  void creatMT(String c , int d){
		choosemusic (c);
		changeLoopTimes(d);
		
		
	    threadJob.musicNum= musictag;
	    threadJob.looptimes=Looptimes;
	   
	   
	   // thread.start();
	  
	}
	public void start (){
		isRunning = true; 
	//	System.out.println("mt start");
		thread = new Thread(threadJob);
	    thread.start();
	    
	    
	}
	public void stop (){
		threadJob.getMAP().stop();
		isRunning = false;
	//	System.out.println ("mt end");
	}
}
