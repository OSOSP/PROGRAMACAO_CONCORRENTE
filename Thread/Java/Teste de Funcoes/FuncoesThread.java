/*********************************
* Classe com as Funções da Thread
*********************************/

public class FuncoesThread extends Thread{
    // Variáveis
    private int max = 10;
    private int id;
    private String color;

    // Cores
    private final String reset = "\033[0m";

    public FuncoesThread(int id, String color){
        this.id = id;
        this.color = color;

    }

    // Chamando a Função de run da Classe Thread
    public void run(){
        int value = 0;
        for(int i = 0 ; i < max ; i++){
            value += i;
            System.out.println(color + "Processo " + id + " : " + value + reset);
        }
    }
}
