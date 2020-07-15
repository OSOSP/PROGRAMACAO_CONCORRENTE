public class Peterson implements Runnable { 
    private static boolean wantp = false;
    private static boolean wantq = false;
    private static volatile int turn = -1; 
    private final int id;

    // Construtor
    public Peterson(int i) { 
        id = i; 
    } 

    // Função Private
    private int other() { 
        return id == 0 ? 1 : 0; 
    }
    

    // Método Run de Threads
    @Override 
    public void run() { 
        in[id] = true; turn = other(); 
        while (in[other()] && turn == other()) { 
            System.out.println("[" + id + "] - Waiting..."); 
        } 
        System.out.println("[" + id + "] - Working (" + ((!in[other()]) ? "other done" : "my turn") + ")"); 
        in[id] = false; 
    }

    public static void main(String[] args) {
        new Thread(new Peterson(0), "Thread - 0").start(); 
        new Thread(new Peterson(1), "Thread - 1").start(); 
    } 
      
} 