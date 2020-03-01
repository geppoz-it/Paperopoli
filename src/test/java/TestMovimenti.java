import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(Lifecycle.PER_CLASS)
public class TestMovimenti {

    Personaggio p;
    Mappa m;

    @BeforeAll
    void inizializza() {
        p=new Personaggio("paperino");
        m=new Mappa();
        Luogo l1=new Luogo("cucina");
        m.aggiungiLuogo(l1);
        Luogo l2=new Luogo("soggiorno");
        m.aggiungiLuogo(l2);
        Luogo l3=new Luogo("ingresso");
        m.aggiungiLuogo(l3);
        Luogo l4=new Luogo("strada");
        m.aggiungiLuogo(l4);
        m.aggiungiPassaggio("cucina","soggiorno");
        m.aggiungiPassaggio("soggiorno","cucina");
        m.aggiungiPassaggio("soggiorno","ingresso");
        m.aggiungiPassaggio("ingresso","soggiorno");
        m.aggiungiPassaggio("ingresso","strada");
    }

    @ParameterizedTest(name = "da {0} a {1} = {3}")
    @CsvSource({
            "soggiorno,    cucina, ok",
            "cucina,    soggiorno,  ok",
            "cucina, ingresso, ko",
            "ingresso, strada, ok",
            "strada, ingresso, ko"
    })
    void muoviPersonaggio(String sorgente, String destinazione, String risultato) {
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
