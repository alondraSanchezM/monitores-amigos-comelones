
public class Comida{
    private boolean casuela;
    private int comida;
    private int turno;
    
    public Comida(){
        casuela = false;
        turno = 0;
    }
    
    public void llenar(){
        comida = (int)(Math.random()*200);
    }
    
    public int cant_comida(){
        return comida;
    }
    
    public synchronized boolean ver_estado(){
        return casuela;
    }
    
    public synchronized void casuela_vacia(){
        casuela = false;
    }
    
    public synchronized void casuela_llena(){
        casuela = true;
    }
    
    public synchronized int tomar_racion(){
        int racion;
        racion = (int)(Math.random()*20);
        comida = comida - racion;
        if(comida < racion){
            racion = racion + comida;
            comida = 0;
            casuela_vacia();
        }
        System.out.println("se tomo: "+racion+" queda: "+comida);
        return racion;
    }
    
    public synchronized void dormir_cocinero(){
        while(casuela){
            try{
                wait();
            }catch(InterruptedException e){}
        }
    }
    
    public synchronized void notifica(){
        notifyAll();
    }
    
}
