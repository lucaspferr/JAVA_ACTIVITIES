/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemonapi;

import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class BuscaPoke {
    private String nomepoke;
    
    public BuscaPoke(){
        this.nomepoke = nomepoke;
    }
    
    public void busca(){
        String nomep = "";
        Scanner buscap = new Scanner(System.in);
        System.out.println("Digite o nome do Pokemon");
        nomep = buscap.nextLine();
        setNomepoke(nomep.toLowerCase());
        
        
    }

    /**
     * @return the nomepoke
     */
    public String getNomepoke() {
        //nomepoke=nomepoke.substring(0,1).toUpperCase() + nomepoke.substring(1).toLowerCase();
        return nomepoke;
    }

    /**
     * @param nomepoke the nomepoke to set
     */
    public void setNomepoke(String nomepoke) {
        this.nomepoke = nomepoke;
    }
    
}
