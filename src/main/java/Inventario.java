import java.util.ArrayList;

public class Inventario {

    ArrayList<Oggetto> contenuto;

    public Inventario() {
        this.contenuto =new ArrayList();
    }

    public void aggiungi(Oggetto a){
        contenuto.add(a);
    }

    public void rimuovi(String nome_oggetto){
    }

    public String lista(){
        StringBuffer l=new StringBuffer();
        for (Oggetto o:contenuto) {
            if (l.length()!=0) l.append(",");
            l.append(o.nome);
        }
        return l.toString();
    }
}
