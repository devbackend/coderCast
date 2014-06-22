package com.codastr.java.codecast;

import java.net.*;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.regex.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class PodcastTape {
  
  public static final int WRONG_CHANEL_LENGTH = 0;
  public static final String XML_FEED_HEADER  = "\\<\\?xml version=\"\\d+\\.\\d+\" encoding=\"[a-zA-Z0-9-]+\"\\s*\\?\\>";
  
  protected int count;
  protected String name;
  protected String chanelUrl;
  protected ArrayList<Object> podcastList = new ArrayList<Object>(Arrays.asList(new Podcast()));
  
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

  public void setName(String name) throws Exception {
      if(name == null)
          throw new Exception("Tape name is NULL!");

      this.name = name;
  }

  public String getName() {
      return this.name;
  }

  private void fill() throws Exception {

    //формируем xml объект
    URLReader xml = new URLReader(this.getChanelUrl());

    //формируем из xml объект для парсинга
    Document doc = parseXML(xml.getUrlConnection().getInputStream());

    // /получаем список узлов документа в виде массива
    NodeList podcastTitles = doc.getElementsByTagName("title");

    //инициализируем имя подкаст-ленты
    this.setName(podcastTitles.item(0).getTextContent());

    //initialise podacst items from elements
    NodeList podcastItems = doc.getElementsByTagName("item");

    for(int i=0; i < podcastItems.getLength(); i++)
    {
        this.podcastList.add(new Podcast(podcastItems.item(i)));
    }

  }

  private Document parseXML(InputStream stream) throws Exception
  {
      DocumentBuilderFactory objDocumentBuilderFactory = null;
      DocumentBuilder objDocumentBuilder = null;
      Document doc = null;
      try
      {
          objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
          objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

          doc = objDocumentBuilder.parse(stream);
      }
      catch(Exception ex)
      {
          throw ex;
      }

      return doc;
  }
  
}
