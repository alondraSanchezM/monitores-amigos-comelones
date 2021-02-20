
public class Amigo extends Thread{
    private Comida racion;
    private final int num;
    private int c;
    private Turno turn;
    
    public Amigo(Comida cas, int numero, Turno turn){
        super(Integer.toString(numero));
        racion = cas;
        num = numero;
        this.turn = turn;
    }
    
    public void run(){
        for(;;){
             yield();
            turn.tomandoNum();
            if(racion.ver_estado()){// vamos a comer
               
                System.out.println("Amigo "+getName()+": va a comer");
                for(int i = racion.tomar_racion(); i > 0; i-- ){
                    System.out.println("Amigo "+getName()+": acaba en :"+i);
                    try{
                        sleep(200);
                    }catch(InterruptedException e){}
                }
                System.out.println("Amigo "+getName()+": que rico, ahora voy a hacer mis quehaceres, gracias");
                turn.lugarLibre();
                
                try{
                        sleep(9000);
                    }catch(InterruptedException e){}
                
            }else{
                System.out.println("Amigo "+getName()+": Cocinero ya no hay comida");
                
                racion.notifica();
            }
           
        }
        
    }
}
