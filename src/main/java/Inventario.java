import java.util.ArrayList;

public class Inventario {

    ArrayList<Oggetto> contenuto=new ArrayList();

    public void aggiungi(Oggetto a){
        contenuto.add(a);
    }

    public void rimuovi(Oggetto a){
        contenuto.remove(a);
    }

    public String lista(){
        return "da fare";
    }
}
