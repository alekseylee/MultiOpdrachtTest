import java.util.Random;

public class Person implements Runnable{
    private String name;
    private int age;
    private Thread heart;
    private Thread breathing;
    private Thread life;

    public Person(String name, int age, int heartBeatMilliSeconds) {
        this.name = name;
        this.age = age;
        breathing= new Thread(this);
        heart= new Thread(this);
        life= new Thread(this);
    }

    public void startLife() {
        heart.start();
        breathing.start();
        life.start();
    }

    public void endLife() {
        life.interrupt();
        System.out.println(name + " has died");
        System.out.println("*********************");
    }

    @Override
    public void run() {
        Random rand = new Random();
        for (int i = age; i < 100; i++) {
            System.out.println(name + " is now " + i + " years old.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                endLife();
                return;
            }
            if (rand.nextInt(20) == 13) {
                endLife();
                return;
            }
        }

    }
}
