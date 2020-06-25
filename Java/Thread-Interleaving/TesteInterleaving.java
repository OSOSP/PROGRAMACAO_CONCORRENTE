public class TesteInterleaving extends Thread{
    int max = 10;
    int id;

    public TesteInterleaving(int id){
        this.id = id;
    }

    public void run(){
        int value = 0;
        for(int i = 0 ; i < max ; i++){
            value += i;
            System.out.println("Processo " + id + " : " + value);
        }
    }

    public static void main(String[] args){
        TesteInterleaving t1 = new TesteInterleaving(1);
        TesteInterleaving t2 = new TesteInterleaving(2);
        TesteInterleaving t3 = new TesteInterleaving(3);

        t1.start();
        t2.start();
        t3.start();
    }

}