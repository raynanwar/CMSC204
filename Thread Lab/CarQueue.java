import java.util.*;

public class CarQueue {
    private Queue<Integer> queue = new LinkedList<>();

    public CarQueue() {
        queue.add(0);
        queue.add(3);
        queue.add(2);
        queue.add(1);
    }

    public void addToQueue() {
        class Runner implements Runnable {
            @Override
            public void run() {
                Random randomGenerator = new Random();
                while(true) {
                    try {
                        queue.add(randomGenerator.nextInt(4));
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }   
                
            }
        }
        Runner runner = new Runner(); 
        Thread thread = new Thread(runner); 
        thread.start();
    }

    public int deleteQueue() {
        return queue.remove();
    }
}
