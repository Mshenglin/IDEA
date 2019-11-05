

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadDomo threadDomo = new ThreadDomo();
        Thread t = new Thread(threadDomo);
        Thread t1= new Thread(threadDomo);

        t.start();
        t1.start();

    }
}


