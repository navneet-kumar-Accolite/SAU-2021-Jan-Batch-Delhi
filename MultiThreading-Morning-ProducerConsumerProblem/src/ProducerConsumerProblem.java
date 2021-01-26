import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerProblem {
		Queue<Integer> items = new LinkedList<>();
        int capacity=3;
        
        public void produce() throws InterruptedException {
            int value = 1;
            while(true) {
                synchronized (this) {
                    while(items.size()==capacity){
                        System.out.println("Bucket full\n");
                        wait();
                    }
                    System.out.println("Produced item number: "+ value);
                    items.add(value++);

                    notify();
                    Thread.sleep(1000);
                }
            }
        }
        
        public void consume() throws InterruptedException {
            while(true) {
                synchronized (this) {
                    while(items.isEmpty()) {
                        System.out.println("Consumer is waiting\n");
                        wait();
                    }
                    int consumedValue=items.remove();
                    System.out.println("The Consumer consumed : "+ consumedValue);

                    notify();
                    Thread.sleep(500);
                }
            }
        }
        
    public static void main(String[] args)  {
        final ProducerConsumerProblem pc = new ProducerConsumerProblem();
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    System.out.println("Error: " + e);
                }
            }
        });

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                	e.printStackTrace();
                }
            }
        });

        try {
            // starting threads
            producerThread.start();
            consumerThread.start();

            // producerThread finishes before consumerThread
            producerThread.join();
            consumerThread.join();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Ending Producer Consumer");
        }
    }
}