package src;

public class Dados {
    private String questoes [][] = new String[5][4];
    private String usuario;
    private String alternativas[]={"A - ","B - ","C - "};
    private int acerto=0;
    private int erros=0;
    public Interface interface_pontos = new Interface();

    public int getAcerto() {
        return acerto;
    }

    public int getErros() {
        return erros;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void criar_perguntas(){
        questoes[0][0]=" é a capital do Rio Grande do Sul";
        questoes[0][1]="Rio Grande";
        questoes[0][2]="Pelotas";
        questoes[0][3]="Porto Alegre";
        questoes[1][0]=" das linguagens de programação abaixo o símbolo é associado com uma xícara de café";
        questoes[1][1]="Java";
        questoes[1][2]="C++";
        questoes[1][3]="Python";
        questoes[2][0]=" é o ponto mais alto do planeta Terra";
        questoes[2][1]="Monte Everest - 8848m";
        questoes[2][2]="Montanha K2 - 8848m";
        questoes[2][3]="Monte Everest - 8957m";
        questoes[3][0]=" é a forma correta de conversão de graus Celsius para Fahrenheit";
        questoes[3][1]="F = C * 2 + 35";
        questoes[3][2]="F = C * 1.8 + 32";
        questoes[3][3]="F = C * 1.5 + 32";
        questoes[4][0]=" foi o ano de fundação da empresa UOL";
        questoes[4][1]="1995";
        questoes[4][2]="1996";
        questoes[4][3]="1997";
    }

    public void printar_perg(int n1){
        interface_pontos.h_screen();
        System.out.println("Qual "+questoes[n1][0]+"?");
        interface_pontos.m_screen();
        for(int i=1; i<4; i++){
            System.out.println(alternativas[i-1]+questoes[n1][i]);
        }
        interface_pontos.b_screen(getUsuario(),getAcerto(),getErros());
    }

    public boolean corrigir(int alternativa, int n_questao){

        if((n_questao==0 && alternativa==3)||(n_questao==1 && alternativa==1)||(n_questao==2 && alternativa==1)||
                (n_questao==3 && alternativa==2)||(n_questao==4 && alternativa==2)){
            acerto++;
            return true;
        }else{
            erros++;
            return false;
        }
    }

}
