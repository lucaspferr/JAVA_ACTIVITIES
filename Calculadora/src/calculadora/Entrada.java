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
public class Entrada {

    /**
     * @return the operador
     */
    public String getOperador() {
        return operador;
    }

    /**
     * @param operador the operador to set
     */
    public void setOperador(String operador) {
        this.operador = operador;
    }

    private String e1;
    private String e2;
    private String s_res;
    private String operador;
    private double num1;
    private double num2;
    private double result;

    /**
     * @return the e1
     */
    public String getE1() {
        return e1;
    }

    /**
     * @param e1 the e1 to set
     */
    public void setE1(String e1) {
        this.e1 = e1;
    }

    /**
     * @return the e2
     */
    public String getE2() {
        return e2;
    }

    /**
     * @param e2 the e2 to set
     */
    public void setE2(String e2) {
        this.e2 = e2;
    }

    /**
     * @return the e3
     */
    public String getS_res() {
        return s_res;
    }

    /**
     * @param e3 the e3 to set
     */
    public void setS_res(String s_res) {
        this.s_res = s_res;
    }

    /**
     * @return the num1
     */
    public double getNum1() {
        return num1;
    }

    /**
     * @param num1 the num1 to set
     */
    public void setNum1(double num1) {
        this.num1 = num1;
    }

    /**
     * @return the num2
     */
    public double getNum2() {
        return num2;
    }

    /**
     * @param num2 the num2 to set
     */
    public void setNum2(double num2) {
        this.num2 = num2;
    }

    /**
     * @return the result
     */
    public double getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(double result) {
        this.result = result;
    }
    
    public void  entrada1(){
        System.out.println("Digite o primeiro número: ");
        Scanner ent1 = new Scanner(System.in);
        e1 = ent1.nextLine();
        try{
            Double.parseDouble(e1);
            num1 = Double.parseDouble(e1);
            setNum1(num1);
        }
        catch(NumberFormatException e){
                System.out.println("Digite um número valido");
                entrada1();
        }
    }
    
    public void  entrada2(){
        System.out.println("Digite o segundo número: ");
        Scanner ent2 = new Scanner(System.in);
        e2 = ent2.nextLine();
        try{
            Double.parseDouble(e2);
            num2 = Double.parseDouble(e2);
            setNum2(num2);
        }
        catch(NumberFormatException e){
                System.out.println("Digite um número valido");
                entrada2();
        }
    }
}
    

