public class Teste extends Thread {
    
    //Variáveis
    private int n;

    public Teste(int n){
        this.n = n;
    }

    public void run(){
        while(n > 0){
            System.out.println("Valor Atual: " + n);
            n = n - 1;
        }
    }

    public static void main(String[] args){
        Teste teste = new Teste(10);
        teste.start();
    }
}
