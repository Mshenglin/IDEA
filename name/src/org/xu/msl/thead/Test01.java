package org.xu.msl.thead;

public class Test01  implements Runnable{
//    Test01 w=new Test01();
    Bank bank=new Bank();
int sum=0;
    @Override
    public synchronized void run() {

        for (int i = 0; i <10 ; i++) {
            sum=bank.add(100);
        System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        Test01 test01=new Test01();
        Thread thread=new Thread(test01);
        Thread thread1=new Thread(test01);
        thread.start();
        thread1.start();
    }
}
