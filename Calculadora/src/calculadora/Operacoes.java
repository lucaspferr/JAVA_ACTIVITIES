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
                setOperador("+");
                break;
            case "S": case"s":
                System.out.println("Subtracao");
                setOperador("-");
                break;
            case "M": case"m":
                System.out.println("Multiplicacao");
                setOperador("*");
                break;
            case "D": case "d":
                System.out.println("Divisao");
                setOperador("/");
                break;
            case "E": case "e":
                System.out.println("Exponenciacao");
                setOperador("^");
                break;
            case "R": case "r":
                System.out.println("Raiz");
                setOperador("v");
                break;
            default:
                setOperador("");
                retorno=false;
                break;
        }
        if(retorno==true) operacao();
        if(retorno==false) menu();
    }
    
    public void calculo(){
        if(verif_dados==false){
            System.out.println("        Nada ainda informado       ");
        }
        else{
            System.out.println("     "+getS_res());
        }
    }
    
    public void resultado(){
        if(verif_dados==false){
            System.out.println("        Nada ainda informado       ");
        }
        else{
            System.out.println("     Resultado: "+getResult());
        }
        
    }
    
    public void operacao(){
        //Pegar entrada 1 e fazer teste
        entrada1();
        //Pegar entrada 2 e fazer teste
        entrada2();
        //Montar operacao
        if(getOperador().equals("+")) setResult(getNum1()+getNum2());
        if(getOperador().equals("-")) setResult(getNum1()-getNum2());
        if(getOperador().equals("*")) setResult(getNum1()*getNum2());
        if(getOperador().equals("/")) setResult(getNum1()/getNum2());
        if(getOperador().equals("^")) setResult(Math.pow(getNum1(),getNum2()));
        if(getOperador().equals("v")) setResult(Math.pow(getNum1(),(1/getNum2())));
        //Salvar operacao como string e mostrar em calculo
        if(getOperador().equals("v")){
            setS_res("Indice: "+getNum2()+"\r\n     Radicando: "+getNum1() + "\r\n     Resultado: "+getResult());
        }
        else setS_res(getNum1()+" "+getOperador()+" "+getNum2()+" = "+getResult());
        //Resultado da operacao mostrar em resultado
        verif_dados=true;
        menu();
    }
}
