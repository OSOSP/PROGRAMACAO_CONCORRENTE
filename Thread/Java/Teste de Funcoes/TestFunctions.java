/**
 * Testando as Funções 
 */

public class TestFunctions {
    // Cores
    public static String red = "\033[0;31m";
    public static final String blue = "\033[0;34m";
    public static final String yellow = "\033[0;33m";
    public static final String purple = "\033[0;35m";

    public static void main(String[] args) {
        // Criação de Processos
        FuncoesThread p1 = new FuncoesThread(1, red);
        FuncoesThread p2 = new FuncoesThread(2, blue);
        FuncoesThread p3 = new FuncoesThread(3, yellow);
        FuncoesThread p4 = new FuncoesThread(4, purple);

        // Inicialização dos Processos
        // -> usamos a Função start() e a função procura o run()
        p1.start();
        p2.start();
        p3.start();
        p4.start();

        
    }    
}