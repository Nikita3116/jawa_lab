import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Shop {
    private static final int MAX_CAPACITY = 10;
    private static final int PRODUCE_TIME = 1000;
    private static final int CONSUME_TIME = 1500;
    private static final int MAX_PRODUCT_AMOUNT = 5;

    public static void main(String[] args) {
        BlockingQueue<Integer> warehouse = new LinkedBlockingQueue<>(MAX_CAPACITY);

        Thread producer = new Thread(new Producer(warehouse));
        Thread consumer = new Thread(new Consumer(warehouse));

        producer.start();
        consumer.start();
    }

    static class Producer implements Runnable {
        private final BlockingQueue<Integer> warehouse;
        private final Random random = new Random();

        Producer(BlockingQueue<Integer> warehouse) {
            this.warehouse = warehouse;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    int product = random.nextInt(MAX_PRODUCT_AMOUNT) + 1;
                    System.out.println("Производитель пытается поставить " + product + " товар(ов).");
                    for (int i = 0; i < product; i++) {
                        if (warehouse.offer(1, PRODUCE_TIME, TimeUnit.MILLISECONDS)) {
                            System.out.println("Производитель поставил товар на склад. Текущий запас: " + warehouse.size());
                        } else {
                            System.out.println("Склад переполнен. Не удалось поставить товар.");
                        }
                    }
                    Thread.sleep(PRODUCE_TIME);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class Consumer implements Runnable {
        private final BlockingQueue<Integer> warehouse;

        Consumer(BlockingQueue<Integer> warehouse) {
            this.warehouse = warehouse;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    int productNeeded = 1; // Каждое потребление — один товар
                    if (warehouse.poll(CONSUME_TIME, TimeUnit.MILLISECONDS) != null) {
                        System.out.println("Покупатель забрал товар. Текущий запас: " + warehouse.size());
                    } else {
                        System.out.println("Недостаточно товара на складе для покупателя.");
                    }
                    Thread.sleep(CONSUME_TIME);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
