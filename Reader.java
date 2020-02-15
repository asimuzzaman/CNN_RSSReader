package ReadCNN;

public class Reader implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("1. This is " + Thread.currentThread().getId());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
