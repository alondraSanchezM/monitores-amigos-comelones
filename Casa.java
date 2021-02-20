
public class Casa {
    
    public static void main(String []args){
        Comida cazuela = new Comida();
        Turno turn= new Turno();
        Cocinero oscar = new Cocinero(cazuela,turn);

        Amigo []amigos = new Amigo[5];
        for(int i = 0; i < 5; i++){
            amigos[i] = new Amigo(cazuela,i,turn);
        }
        
        oscar.start();
        for(int i = 0; i < 5; i++){
            amigos[i].start();
        }
    }
}
