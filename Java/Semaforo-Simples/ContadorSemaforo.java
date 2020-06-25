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
        semaforo = new Semaphore(1);//somente um processo permitido por vez 
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

    public void run(){
        for(int i = 0 ; i < limite ; i++){
            semaforo.incremento(id);
            System.out.println("Thread #" + id + " : " + "Valor de N: " + semaforo.valor());
        }
    }
}


public class ContadorSemaforo {
    public static void main(String[] args){
        int limite = 150;
        SemaforoIncremento semaforo= new SemaforoIncremento();
        ThreadsContador thread1 = new ThreadsContador(1, semaforo, limite);
        ThreadsContador thread2 = new ThreadsContador(2, semaforo, limite);

        // Iniciando os Threads
        thread1.start();
        thread2.start();

        // Fazendo os Valores se unirem em um unico valor 
        try{
            thread1.join();
            thread2.join(); 
        }catch(InterruptedException e){}

        System.out.println("Valor de N: " + semaforo.valor());

    }
    
}