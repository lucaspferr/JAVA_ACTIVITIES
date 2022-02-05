/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemonapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author lucas
 */
public class Chama extends BuscaPoke {
    
    private HttpURLConnection connection;
    
    
    public void pokechama(){
        busca();
        BufferedReader reader;
        String  line;
        StringBuffer responseContent = new StringBuffer();
        try{
            URL url = new URL("https://pokeapi.co/api/v2/pokemon/"+getNomepoke()+"/");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "foi");
            //Setup de pedido
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            
            int status = connection.getResponseCode();
            System.out.println(status);
            
            if(status>299){
                //Testa se nao foi possivel ler a pag ( pex 402,403,404)
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line = reader.readLine())!=null){
                    responseContent.append(line);
                }
                reader.close();
                pokechama();
            }
            else{
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line = reader.readLine())!=null){
                    responseContent.append(line);
                }
                reader.close();
            }
            System.out.println(responseContent.toString());
            String poketeste = responseContent.toString();
            
        }
        catch(MalformedURLException e){}
        catch(IOException e){}
        finally{ connection.disconnect();}
        
    }
}
