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
import org.json.*;


/**
 *
 * @author lucas
 */
public class Chama extends BuscaPoke {
    
    private HttpURLConnection connection;
    private String line;
    
    
    public void pokechama(){
        boolean quebra = false;
        //Call the class with the scanner method for the pokemon name
        busca();
        BufferedReader reader;
        StringBuffer responseContent = new StringBuffer();
        try{
            //Connection with the API
            URL url = new URL("https://pokeapi.co/api/v2/pokemon/"+getNomepoke()+"/");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "foi");
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            
            int status = connection.getResponseCode();
            //System.out.println(status);
            
            if(status>299){
                //Status > 299 = page not found/reachable
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line = reader.readLine())!=null){
                    responseContent.append(line);
                }
                reader.close();
                quebra = true;
            }
            else{
                //Connection done
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line = reader.readLine())!=null){
                    //Pull the JSON into a String
                    responseContent.append(line);
                    tratamento();
                }
                reader.close();
            }
            //System.out.println(responseContent.toString());
            String poketeste = responseContent.toString();
            
        }
        catch(MalformedURLException e){}
        catch(IOException e){}
        finally{ connection.disconnect();}
        //Boolean (quebra==true) = Ask you to reenter the pokemon name because it was not found.
        if(quebra==true) {
            System.out.println("Pokemon nao encontrado.");
            pokechama();
        }
    }
    
    public void tratamento (){
        String tipo="";
        line = getLine();
        //Search and separate the info wanted from the JSON
        JSONObject objeto = new JSONObject(line);
        JSONArray arr = objeto.getJSONArray("types");
        for (int i = 0; i < arr.length(); i++){
            arr.getJSONObject(i).getJSONObject("type");
            tipo = arr.getJSONObject(i).getJSONObject("type").getString("name");
        }
        Float peso = objeto.getFloat("weight");
        Integer indice = objeto.getInt("id");
        String nome = getNomepoke();
        System.out.println("Nome: "+ nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase());
        System.out.println("Indice: "+indice);
        System.out.println("Tipo: "+tipo.substring(0,1).toUpperCase() + tipo.substring(1).toLowerCase());
        System.out.println("Peso: "+peso/10+" Kg");
    }

    /**
     * @return the line
     */
    public String getLine() {
        return line;
    }

    /**
     * @param line the line to set
     */
    public void setLine(String line) {
        this.line = line;
    }
}
