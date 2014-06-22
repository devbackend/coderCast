import com.codastr.java.codecast.*;

import java.util.ArrayList;

public class Init {
  
  public static void main(String[] args) throws Exception {
    
    PodcastTape radiot = new PodcastTape("http://feeds.rucast.net/radio-t");

    for(int i=0; i<radiot.getPodcastList().size(); i++)
    {
        Podcast p = (Podcast) radiot.getPodcastList().get(i);

        String podcastInfo = "Title: " + p.getTitle() +
                "\nDate: " + p.getPubDate() +
                "\nLink: " + p.getLink() +
                "\nMp3: " + p.getMp3() + "\n****************************************************************";
        System.out.println(podcastInfo);
    }
    
  }
  
}
