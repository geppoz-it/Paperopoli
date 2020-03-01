import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestMovimenti {

    Personaggio p;
    Mappa m;

    @BeforeAll
    void inizializza() {
        p=new Personaggio("paperino");
        m=new Mappa();
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
                () -> "rimuovendo "+ da_togliere + " la lista dovrebbe essere " + risultato);
    }


}
