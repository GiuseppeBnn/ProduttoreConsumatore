import java.util.ArrayList;


public class ContainerMonitor {
    //attributi
    private boolean mutex=true;
    private int MAX_N_ELEMENTS=10;
    public ArrayList<String> List;
    //costruttore
    public ContainerMonitor(){
        this.List=new ArrayList<String>();
        System.out.println("Creato arrayList con elementi: "+List.size());
    }
    //metodi
    synchronized public boolean isEmpty(){
        if(List.size()==0){
            return true;
        }
        else{
            return false;
        }
    }


    synchronized public String getElement(){
        while(List.size()==0 || !mutex){
            try{
                wait();
            }catch(Exception e){e.printStackTrace();}
        }
        mutex=false;
        String stringa=List.remove(0);
        mutex=true;
        notifyAll();

        return stringa;

    }

    synchronized public void putElement(String element){
        while(!mutex){
            try{
                wait();
            }catch(Exception e){e.printStackTrace();}
        }
        mutex=false;
        List.add(element);
        mutex=true;
        notifyAll();
        //notifyAll();
    }
}
