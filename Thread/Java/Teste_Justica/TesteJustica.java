/**
 * Justiça em Programação Concorrente significa que enquanto um processo 
 * está habilitado, significa que ele vai ser executado em algum momento
 * portanto o programa é justo
 */

/**
 * ESTE PROGRAMA É INJUSTO PORQUE ELE NUNCA TERMINA O PROCESSO
 */
public class TesteJustica extends Thread {
    static volatile int n = 1;

    public void run(){
        System.out.println("Tentando o Programa!");
        n = n - 1;
        System.out.println("Justo!");
    }

    public static void main(String[] args){
        TesteJustica teste = new TesteJustica();
        teste.start();

        while(n > 0){
            n = n + 1;
            System.out.println("Valor de n: " + n);
        }
        System.out.println("Fim");
    }
}