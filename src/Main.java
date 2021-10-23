import byitClass.Consumer;
import byitClass.Production;

public class Main {
    Object object = new Object();
    public static void main(String[] args) {
        Production production = new Production("Производство");
        ThreadProduction threadProduction = new ThreadProduction(production);

        Consumer consumer1 = new Consumer("Лари");
        Consumer consumer2 = new Consumer("Гари");
        Consumer consumer3 = new Consumer("Бари");

        ThreadConsumer threadConsumer1 = new ThreadConsumer(consumer1);
        ThreadConsumer threadConsumer2 = new ThreadConsumer(consumer2);
        ThreadConsumer threadConsumer3 = new ThreadConsumer(consumer3);

        threadConsumer1.start();
        threadConsumer2.start();
        threadConsumer3.start();
        threadProduction.start();

    }
    static class ThreadConsumer extends Thread{
        private Consumer consumer;

        public ThreadConsumer(Consumer consumer) {
            this.consumer = consumer;
        }
        public void run(){
            while (consumer.getPurchased() != 4){
                synchronized (this){
                    consumer.getWarehouse();
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    static class ThreadProduction extends Thread{
        private Production production;

        public ThreadProduction(Production production) {
            this.production = production;
        }
        public  void run(){
            while(production.getProduce() != 10){
                production.setWarehouse();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
