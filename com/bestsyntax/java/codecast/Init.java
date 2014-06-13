package com.bestsyntax.java.codecast;

import java.net.*;
import java.io.*;

public class Init {
  
  public static void main(String[] args) throws Exception {
    
    PodcastTape radiot = new PodcastTape("http://feeds.rucast.net/radio-t");
    URLReader radiotXML = new URLReader(radiot.getChanelUrl());
    
    //System.out.println(umputun.getChanelUrl());
    radiotXML.readLineFromBuffer();
    
  }
  
}