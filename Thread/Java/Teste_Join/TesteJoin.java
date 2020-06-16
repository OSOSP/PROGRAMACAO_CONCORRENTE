/**
 * Podemos usar a Função Join para juntar duas Threads
 * No caso abaixo ele pega o valor final das duas threads e soma
 * Esses valores podem ser bem diferentes(menores que 20000) porque
 * ele está lidando em nivel de instrução que pode dar problemas
 */
public class TesteJoin extends Thread{
    static int n = 0;
    public void run(){
       for(int i = 0 ; i < 10000 ; i++){
            n++;
        }
    }

    public static void main(String[] args){
        TesteJoin t1 = new TesteJoin();
        TesteJoin t2 = new TesteJoin();

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch(InterruptedException e){}

        System.out.println("Valor de N: " + n);
    }


    
}