public class Lungs implements Runnable{
    private boolean lungsFull;
    public Lungs(){

    }

    @Override
    public void run() {
        while (true) {
            if (lungsFull) {
                System.out.println("Breathe out.");
                lungsFull = false;
            } else {
                System.out.println("Breathe in.");
                lungsFull = true;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}