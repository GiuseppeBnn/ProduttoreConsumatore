public class T3 extends Thread{
    private ContainerMonitor containerMonitor;
    public T3(ContainerMonitor monitor){
        this.containerMonitor=monitor;
    }
    public void run(){
        long n=10;
        for(int i=0; i<n;i++){
            int numeroRandom=(int) (Math.random()*10000);
            String string=String.valueOf(numeroRandom);
            containerMonitor.putElement(string);
        }
    }
}
