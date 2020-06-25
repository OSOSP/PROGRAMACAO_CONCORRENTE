import java.util.concurrent.Semaphore;

/**
* Um semáforo é uma estrutura de dados que controla o acesso de aplicações aos
* recursos, baseando-se em um número inteiro, que representa a quantidade de
* acessos que podem ser feitos. Assim usamos semáforos para controlar a
* quantidade de acesso a um recurso
*/

/**
* Todo semáforo precisa possuir dois métodos: P(parsen/passar) e V(vrygeren/liberar) 
* e nos Semáforos implementaos em Java possui os Métodos acquire() como parsen e release para liberar
* Essa estrutura foi definida por Dijkstra para evitar o Deadlock.
*/

public class Semaforo extends Thread{
    // Atributos
    private int idThread;
    private Semaphore semaforo;

    // Cores
    public static String yellow = "\033[0;33m";
    public static String blue = "\033[0;34m";
    public static String red = "\033[0;31m";
    public static String nulo = "\033[0m";

    // Construtor
    public Semaforo(int id, Semaphore semaphore){
        this.idThread = id;
        this.semaforo = semaphore;
    }

    // Método para poder fazer uma Thread dormir por um tempo
    private void processando(){
        try{
            System.out.println(yellow + "Tread #" + idThread + " Processando" + nulo);
            Thread.sleep((long)(Math.random() * 10000)); //sleep aleatório
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // Método para simular um acesso não-critico(quando n é necessário travar o Processo)
    private void regiaoNaoCritica(){
        System.out.println(blue + "Thread #" + idThread + " Em região Não-Crítica" + nulo);
        processando();
    }

    // Método quando estiver em uma Região Crítica
    private void regiaoCritica(){
        System.out.println(red + "Thread #" + idThread + " Em uma região Crítica" + nulo);
        processando();
        System.out.println("Thread #" + idThread + " Saindo da Região Crítica");
    }

    // Método run da Thread
    public void run(){
        regiaoNaoCritica();
        try{
            semaforo.acquire(); //requisita o acesso ao semáforo
            regiaoCritica();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            semaforo.release(); //libera o acesso do semáforo
        }
    }

    // Método main para rodar

    /**
    *  Para construir um semáforo é preciso informar o nro máximo de Threads
    * que podem acessar o recurso ao mesmo tempo. 
    */
    public static void main(String[] args){
        int nroPermissoes = 2;
        int nroProcessos = 6;

        Semaphore semaforo = new Semaphore(nroPermissoes);
        Semaforo[] processos = new Semaforo[nroProcessos];
        for(int i = 0 ; i < nroProcessos; i++){
            processos[i] = new Semaforo(i,semaforo);
            processos[i].start();
        }
    }



}