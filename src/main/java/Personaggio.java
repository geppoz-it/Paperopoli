public class Personaggio {
    String nome;
    String posizione;

    public Personaggio(String nome) {
        this.nome = nome;
    }

    public boolean sposta(String destinazione){
        if (Paperopoli.mappa.esistePassaggio(posizione,destinazione)){
            posizione=destinazione;
            return true;
        } else {
            return false;
        }
    }

}
