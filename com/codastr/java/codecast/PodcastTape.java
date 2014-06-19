package com.bestsyntax.java.codecast;

import java.net.*;
import java.io.*;
import java.util.regex.*;

class PodcastTape {
  
  public static final int WRONG_CHANEL_LENGTH = 0;
  public static final String XML_FEED_HEADER  = "\\<\\?xml version=\"\\d+\\.\\d+\" encoding=\"[a-zA-Z0-9-]+\"\\s*\\?\\>";
  
  protected int count;
  protected String name;
  protected String chanelUrl;
  protected Podcast[] podcasts;
  
  public PodcastTape(String chanelUrl) throws Exception {
    try {
    	this.setChanelUrl(chanelUrl);
    	this.fill();
    } catch(Exception e) {
    	System.out.println(e.getMessage());
    }
    
  }
  
  public void setChanelUrl(String chanelUrl) throws Exception {
    
    if(chanelUrl.length() < WRONG_CHANEL_LENGTH)
      throw new Exception("Wrong chanel name parameter!");
    
    this.chanelUrl = chanelUrl;
  }
  
  public String getChanelUrl() {
    return this.chanelUrl;
  }
  
  private void fill() throws Exception {
  	Pattern pcreXml;
    Matcher m;
    
  	URLReader xml = new URLReader(this.getChanelUrl());
    String line   = xml.readLineFromBuffer();
    pcreXml = Pattern.compile(XML_FEED_HEADER);
    m = pcreXml.matcher(line);
    
    if(m.matches() == false)
    	throw new Exception("Invalid xml-feed");
    
    String fullXml = xml.readLineFromBuffer();
    System.out.println(fullXml);
  }
  
}
