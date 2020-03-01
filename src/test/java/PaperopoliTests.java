import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class PaperopoliTests {

    @Test
    @DisplayName("chiave + moneta = chiave,moneta")
    void dueOggettiInInventario() {
        Inventario inventario = new Inventario();
        Oggetto o1=new Oggetto("chiave");
        inventario.aggiungi(o1);
        Oggetto o2=new Oggetto("moneta");
        inventario.aggiungi(o2);
        assertEquals("chiave,moneta",inventario.lista(),"la lista dovrebbe visualizzare due oggetti");
    }

    @ParameterizedTest(name = "{0} + {1} - {2} = {3}")
    @CsvSource({
            "chiave,    moneta, moneta,  chiave",
            "oggetto1,    oggetto2,   oggetto1, oggetto2",
            "mela, pera, mela, pera"
    })
    void rimuoviOggettoDaInventario(String primo, String secondo, String da_togliere, String risultato) {
        Inventario inventario = new Inventario();
        Oggetto o1=new Oggetto(primo);
        inventario.aggiungi(o1);
        Oggetto o2=new Oggetto(secondo);
        inventario.aggiungi(o2);
        inventario.rimuovi(da_togliere);
        assertEquals(risultato, inventario.lista(),
                () -> "rimuovendo "+ da_togliere + " dovrebbe essere " + risultato);
    }


}
