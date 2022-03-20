package src;

public class Interface {
    public void h_screen(){
        System.out.println("          ---------- QUIZ DE CONHECIMENTOS GERAIS ----------");
        System.out.println("");
    }
    public void m_screen(){
        System.out.println("");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("INSTRUÇÕES: Pare responder as repostas digite a alternativa desejada.");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("");
    }
    public void b_screen(String usuario, int acertos, int erros){
        System.out.println("----------------------------------------------------------------------");
        System.out.println("USUÁRIO : "+usuario);
        System.out.println("ACERTOS : "+acertos);
        System.out.println("ERROS : "+erros);
        System.out.println("----------------------------------------------------------------------");
    }
}
