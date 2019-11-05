public class Thread02 extends Thread {
    public Thread02() {
    }

    public Thread02(Runnable target) {
        super(target);
    }

    public Thread02(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public Thread02(String name) {
        super(name);
    }

    public Thread02(ThreadGroup group, String name) {
        super(group, name);
    }

    public Thread02(Runnable target, String name) {
        super(target, name);
    }

    public Thread02(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public Thread02(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }
}
