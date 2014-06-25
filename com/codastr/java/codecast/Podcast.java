package com.codastr.java.codecast;

import java.io.*;
import java.net.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Podcast {

	protected String title, link, pubDate, description, mp3;
	protected int fileSize;

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public int getFileSize() {
		return this.fileSize;
	}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }

  public Podcast() {

  }

  public Podcast(Element item) {

      this.setTitle(item.getElementsByTagName("title").item(0).getTextContent());
      this.setLink(item.getElementsByTagName("link").item(0).getTextContent());
      this.setPubDate(item.getElementsByTagName("pubDate").item(0).getTextContent());
      this.setDescription(item.getElementsByTagName("description").item(0).getTextContent());
      this.setMp3(item.getElementsByTagName("enclosure").item(0).getAttributes().item(2).getTextContent());
      this.setFileSize(Integer.parseInt(item.getElementsByTagName("enclosure").item(0).getAttributes().item(0).getTextContent()));
  }

  //загрузка подкастов
  public void download(String directoryDestinationName) throws Exception {
      URL connection = new URL(this.getMp3());
      HttpURLConnection urlconn;
      urlconn = (HttpURLConnection) connection.openConnection();
      urlconn.setRequestMethod("GET");
      urlconn.connect();
      InputStream in = null;
      in = urlconn.getInputStream();
      OutputStream writer = new FileOutputStream(directoryDestinationName+'/'+this.getTitle()+".mp3");
      byte buffer[] = new byte[1024];
      int c = in.read(buffer);
      while (c > 0) {
          writer.write(buffer, 0, c);
          c = in.read(buffer);
      }
      writer.flush();
      writer.close();
      in.close();
  }

}
