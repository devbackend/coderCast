package com.bestsyntax.java.codecast;

class PodcastTape {
  
  public static final int WRONG_CHANEL_LENGTH = 0;
  
  protected int count;
  protected String name;
  protected String chanelUrl;
  
  public PodcastTape(String chanelUrl) {
    this.setChanelUrl(chanelUrl);
  }
  
  public void setChanelUrl(String chanelUrl) {
    if(chanelUrl.length() < WRONG_CHANEL_LENGTH)
      System.out.println("Wrong chanel name parameter!");
    else
      this.chanelUrl = chanelUrl;
  }
  
  public String getChanelUrl() {
    return this.chanelUrl;
  }
  
}