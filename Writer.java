package ReadCNN;

public class Writer implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("2. This is " + Thread.currentThread().getId());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
