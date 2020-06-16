
public class SessaoCritica extends Thread {
    
    // Variáveis
    static int n = 0;
    static boolean wantP = false;
    static boolean wantQ = false;
    static int last;

    public void run(){
       for(int i = 0 ; i < 10000 ; i++){
            n++;
        }
    }

    public static void main(String[] args){
        SessaoCritica t1 = new SessaoCritica();
        SessaoCritica t2 = new SessaoCritica();

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch(InterruptedException e){}

        System.out.println("Valor de N: " + n);
    }
}