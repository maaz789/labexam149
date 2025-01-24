

package sed149exam;



 class OddNumberThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 20; i++) {
                if (i % 2 != 0) {
                    System.out.println("Odd: " + i);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in OddNumberThread: " + e.getMessage());
        }
    }
}

class EvenNumberThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 20; i++) {
                if (i % 2 == 0) {
                    System.out.println("Even: " + i);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in EvenNumberThread: " + e.getMessage());
        }
    }
}

public class NumberPrinter {
    public static void main(String[] args) {
        try {
            // Creating and starting threads for odd and even numbers
            Thread oddThread = new OddNumberThread();
            Thread evenThread = new EvenNumberThread();

            oddThread.start();
            evenThread.start();
            
            // Wait for both threads to finish
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
    }
}

