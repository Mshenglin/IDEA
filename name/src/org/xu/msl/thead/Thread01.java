package org.xu.msl.thead;

public class Thread01 extends Thread {
    public void run() {
        StringBuffer str=new StringBuffer("西安是十三朝古都");
        for (int i = 0; i <str.length() ; i++) {
            char ch = str.charAt(i);
            System.out.print(ch);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread01 th=new Thread01();
    StringBuffer stringBuffer=new StringBuffer("西安是十三朝古都");
;
    th.start();
//    th.run(stringBu);
    }
}
