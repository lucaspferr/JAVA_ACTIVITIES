package src;

import java.util.Scanner;

public class Principal extends Dados{
    private boolean verificador;
    public int alternativa;

    public void iniciar (){
       criar_perguntas();
        System.out.println("Olá, seja bem vindo!");
        System.out.print("Por favor, digite um nome de usuário: ");
        setUsuario(input_dados());
        System.out.println("Olá, "+getUsuario());
        jogar();
    }

    public void jogar(){
        for(int n_questao=0; n_questao<5; n_questao++){
            printar_perg(n_questao);
            verificador=true;
            while(verificador){
                switch ((input_dados()).toUpperCase()){
                    case "A":
                        verificador=false;
                        alternativa = 1;
                        break;
                    case "B":
                        verificador=false;
                        alternativa = 2;
                        break;
                    case "C":
                        verificador=false;
                        alternativa = 3;
                    default:
                        System.out.println("Escolha uma alternativa válida (A, B ou C)");
                        break;
                }
            }
            if(corrigir(alternativa, n_questao)) {
                System.out.println("Você acertou!");
            }else{
                System.out.println("Você errou.");
            }
        }

    }

    public String input_dados(){
        //Metodo com a criacao e uso do scanner
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }
}
