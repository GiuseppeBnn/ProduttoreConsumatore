import java.util.concurrent.ThreadLocalRandom;

public class Consumer2 extends Thread {
    private ContainerMonitor containerMonitor;

    public Consumer2(ContainerMonitor monitor) {
        this.containerMonitor = monitor;
    }

    public void run() {

            while (true) {
                if (containerMonitor.isEmpty()) {
                    System.out.println("chiudo consumer 2--------------");
                    break;
                }
                System.out.println("CONSUMER 2:: consumo elemento: " + containerMonitor.getElement());
            }
        }
    }
