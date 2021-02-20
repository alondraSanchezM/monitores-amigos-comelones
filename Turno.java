
public class Turno{

    boolean bandera;

    public Turno(){
        bandera=false;
    } 

    synchronized public void tomandoNum(){
        while(bandera){
            try{
               wait();
            }catch(Exception e){}
        }
        bandera=true;
    }

    synchronized public void lugarLibre(){
       bandera=false;
        notifyAll();
    }
}
