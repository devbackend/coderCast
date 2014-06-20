package com.codastr.java.codecast;

import java.net.*;
import java.io.*;

public class URLReader {
    
    protected URL url;
    private URLConnection urlConnection;
    private BufferedReader buffer;
    
    public URLReader(String url) throws Exception {
        this.url = new URL(url);
        this.urlConnection = this.url.openConnection();
        this.buffer = new BufferedReader(new InputStreamReader(this.urlConnection.getInputStream()));
        
        /*String inputLine;
        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();   */
    }
    
    public String readLineFromBuffer() throws Exception {
        return this.buffer.readLine();
    }
    
    	
}
