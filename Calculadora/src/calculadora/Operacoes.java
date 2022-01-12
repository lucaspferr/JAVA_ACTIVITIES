/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

import java.util.Scanner;

/**
 *
 * @author Lucas Pimentel Ferreira
 */
public class Operacoes extends Entrada{
    
    Terminal objet2 = new Terminal();
    private boolean verif_dados = false;
    
    public void menu(){
        System.out.println("");
        objet2.h_calc();
        calculo();
        objet2.m_calc();
        resultado();
        objet2.b_calc();
        direcionamento();
    }
    
    public void direcionamento(){
        System.out.println("Digite a operação que deseje fazer: ");
        boolean retorno = true;
        Scanner info = new Scanner(System.in);
        String info2 = info.nextLine();
        switch(info2){
            case "A": case "a":
                System.out.println("Adicao");
                break;
            case "S": case"s":
                System.out.println("Subtracao");
                break;
            case "M": case"m":
                System.out.println("Multiplicacao");
                break;
            case "D": case "d":
                System.out.println("Divisao");
                break;
            case "E": case "e":
                System.out.println("Exponenciacao");
                break;
            case "R": case "r":
                System.out.println("Raiz");
                break;
            default:
                retorno=false;
                break;
        }
        if(retorno==false) menu();
    }
    
    public void calculo(){
        if(verif_dados==false){
            System.out.println("        Nada ainda informado       ");
        }
    }
    
    public void resultado(){
        if(verif_dados==false){
            System.out.println("        Nada ainda informado       ");
        }
        
    }
}
