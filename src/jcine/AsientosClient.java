/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcine;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import sun.net.www.http.HttpClient;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Michael
 */

public class AsientosClient {
    private URL entryPoint;
    
    public AsientosClient(String entryPoint) throws MalformedURLException
    {
        this.entryPoint = new URL(entryPoint);
    }
    
    public Asiento[] getAsientos() throws IOException, ParseException
    {
        
        HttpURLConnection conn = (HttpURLConnection) entryPoint.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoOutput(true);
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        String line;
        while ((line = reader.readLine()) != null)
        {
            builder.append(line);
        }
        
        JSONParser parser = new JSONParser();
        
        
        JSONArray list = (JSONArray) parser.parse(builder.toString());
        
        Asiento[] result = new Asiento[list.size()];
        
        for (int i=0; i<list.size(); i++)
        {
            JSONObject obj = (JSONObject)list.get(i);
            String name = (String)obj.get("numero");
            Long posX = (Long)obj.get("posicionX");
            Long posY = (Long)obj.get("posicionY");
            
            result[i] = new Asiento(name, posX.intValue(), posY.intValue());
            
        }
        
        return result;
    }
}
