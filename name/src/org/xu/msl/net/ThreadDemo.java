package org.xu.msl.net;

public class ThreadDemo implements Runnable{

    private  int num=10;

    public void run() {
        for(int i=0;i<100;i++)
        {
            if(num>0)
            {
                System.out.println("票数："+(num--));
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }


    }
    public static void main(String[] args) {
        ThreadDemo ticket=new ThreadDemo();
        Thread t=new Thread(ticket);
        t.start();
        Thread t1=new Thread(ticket);
        t1.start();
        Thread t2=new Thread(ticket);
        t2.start();
        Thread t3=new Thread(ticket);
        t3.start();
        Thread t4=new Thread(ticket);
        t4.start();

    }


}
