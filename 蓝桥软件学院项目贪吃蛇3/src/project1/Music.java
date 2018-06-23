package project1;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.URL;

public class Music {
	URL cb;
	File f;
	AudioClip aau;
	public Music(){
		try{
			f = new File("snake.wav");
			cb = f.toURL();
			aau = Applet.newAudioClip(cb);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
