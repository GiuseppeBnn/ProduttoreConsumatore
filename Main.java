public class Main {
    public static void main(String[] args) throws InterruptedException {
        ContainerMonitor containerMonitor=new ContainerMonitor();
        T1 Thread1=new T1(containerMonitor);
        T2 Thread2=new T2(containerMonitor);
        T3 Thread3=new T3(containerMonitor);
        Consumer consumer=new Consumer(containerMonitor);
        Consumer2 consumer2=new Consumer2(containerMonitor);

        Thread1.start();
        Thread2.start();
        Thread3.start();
        Thread.sleep(1);
        consumer.start();
        consumer2.start();

        try {
            Thread1.join();
            Thread2.join();
            Thread3.join();
            consumer.join();
            consumer2.join();
        } catch (InterruptedException e) {e.printStackTrace();}



        if(containerMonitor.List.size()==0){
            System.out.println("CONTAINER SVUOTATO");
        }else {
            System.out.println(containerMonitor.List);
        }
        System.exit(12);
    }
}
