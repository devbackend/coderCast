import com.codastr.java.codecast.*;

import java.util.ArrayList;

public class Init {
  
  public static void main(String[] args) throws Exception {
    
    PodcastTape radiot = new PodcastTape("http://feeds.rucast.net/radio-t");
	
	Podcast p = (Podcast) radiot.getPodcastList().get(3);
	p.download(radiot.getName());
    
  }
  
}
