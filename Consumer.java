public class Consumer extends Thread{
    private ContainerMonitor containerMonitor;
    public Consumer(ContainerMonitor monitor){
        this.containerMonitor=monitor;
    }

    public void run(){
        while(true){
            if(containerMonitor.isEmpty()){
                System.out.println("chiudo consumer 1--------------");
                break;
            }
            System.out.println("CONSUMER 1:: consumo elemento: "+ containerMonitor.getElement());

        }
    }
}
