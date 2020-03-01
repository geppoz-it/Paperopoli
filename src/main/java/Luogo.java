import java.util.ArrayList;

public class Luogo {
    String nome;
    String descrizione;
    Inventario oggetti_presenti;
    ArrayList<Personaggio> personaggi_presenti;

    public Luogo(String nome) {
        this.nome=nome;
        this.descrizione=nome;
        oggetti_presenti=new Inventario();
        personaggi_presenti=new ArrayList<>();
    }
}
