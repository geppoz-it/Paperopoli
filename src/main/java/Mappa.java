import java.util.ArrayList;
import java.util.HashMap;

public class Mappa {
    HashMap<String,Luogo> luoghi;
    HashMap<String,ArrayList<String>> passaggi; // sorgente, lista di destinazioni

    public Mappa() {
        this.luoghi = new HashMap<>();
        this.passaggi=new HashMap<>();
    }

    public void aggiungiLuogo(Luogo l){
        luoghi.put(l.nome,l);
        passaggi.put(l.nome,new ArrayList<>());
    }

    public void aggiungiPassaggio(String sorgente,String destinazione){
        passaggi.get(sorgente).add(destinazione);
    }
}
