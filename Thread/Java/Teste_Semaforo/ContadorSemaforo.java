import java.util.concurrent.Semaphore;

/**
 * Exemplo de Contador com Semáforo
 */

// Criando um Semáforo para incrementar
class SemaforoIncremento{
    private int n; //valor que vai ser incrementado
    private Semaphore semaforo; //semaforo que vai ser usado

    public SemaforoIncremento(){
        n = 0; //valor iniciado em zero
        semaforo = new Semaphore(2);//somente um processo permitido por vez 
    }

    public void incremento(int id){
        try{
            semaforo.acquire();
        }catch(InterruptedException e){}

        n++;
        semaforo.release();
    }

    public int valor(){return n;}
}

// Criando Threads para os Semáforos
class ThreadsContador extends Thread{
    private int id;
    private SemaforoIncremento semaforo;
    private int limite; //limite de Threads ao mesmo tempo

    public ThreadsContador(int id,SemaforoIncremento semaforo,int limite){
        this.id = id;
        this.semaforo = semaforo;
        this.limite = limite;
    }

    public SemaforoIncremento getSemaforo(){return semaforo;}

    public void run(){
        for(int i = 0 ; i < limite ; i++){
            semaforo.incremento(id);
        }
    }
}


public class ContadorSemaforo {
    public static void main(String[] args){
        int limite = 100;
        SemaforoIncremento semaforo1 = new SemaforoIncremento();
        SemaforoIncremento semaforo2 = new SemaforoIncremento();
        ThreadsContador thread1 = new ThreadsContador(0, semaforo1, limite);
        ThreadsContador thread2 = new ThreadsContador(1, semaforo2, limite);

        thread1.start();
        thread2.start();

        System.out.println("Valor de N na Thread 1: " + thread1.getSemaforo().valor());
        System.out.println("Valor de N na Thread 2: " + thread2.getSemaforo().valor());


    }
    
}