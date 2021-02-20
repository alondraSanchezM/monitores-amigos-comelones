
public class Cocinero extends Thread{
    private Comida casuela;
    private Turno turn;
    
    public Cocinero(Comida cas, Turno turn){
        super("Cocinero");
        casuela = cas;
        this.turn = turn;
    }
    
    public void run(){
        for(;;){
            if(casuela.ver_estado()){
                casuela.dormir_cocinero();
            }else{
               try{
                    sleep(200);
               }catch(InterruptedException e){}
            
                System.out.println(getName()+": gracias por despertarme, ahorita cocino más");
                casuela.llenar();
                System.out.println(getName()+": ya hay mas comida chicos, vengan a comer...");
                System.out.println(getName()+": hay "+casuela.cant_comida()+" raciones de comida");
                System.out.println(getName()+": voy a hecharme un sueñito....");
                casuela.casuela_llena();
                turn.lugarLibre();
            }
        }
    }
}
