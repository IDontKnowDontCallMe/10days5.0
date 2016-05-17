package music;




public class MyRunnable implements Runnable {
	    public AudioPlayer map;
		public String musicNum = "";
		public int looptimes =1;
    public void run (){
    	 map = new AudioPlayer();
         for (int i=0; i<looptimes;i++){
    	 map.play(musicNum);
    	}
         
   
    }
    
    public 	AudioPlayer getMAP(){
    	return map;
    }
    	
}
