public class TesteSleep extends Thread{
    //Variáveis
    private int id;

    public TesteSleep(int id){
        this.id = id;
    }

    public void run(){
        int value = 0;
        while(value < 60000){
            try{
                System.out.println("Processo " + id + " Vai parar por " + value + " Milissegundos" );
                Thread.sleep(value);
                value = value + 1000;
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}