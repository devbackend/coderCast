package com.codastr.java.codecast;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Podcast {

  public Podcast() {

  }

  public Podcast(Node item) {
      System.out.println(item.getChildNodes().item(0).getTextContent());
  }
  
}
