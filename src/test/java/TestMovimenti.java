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

    @BeforeAll
    void inizializza() {
        Mappa m=new Mappa();
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
        Paperopoli.mappa=m;
        p=new Personaggio("paperino");
    }

    @ParameterizedTest(name = "da {0} a {1} = {3}")
    @CsvSource({
            "soggiorno,    cucina, true",
            "cucina,    soggiorno,  true",
            "cucina, ingresso, false",
            "ingresso, strada, true",
            "strada, ingresso, false"
    })
    void muoviPersonaggio(String sorgente, String destinazione, String risultato) {
        p.posizione=sorgente;
        assertEquals(Boolean.parseBoolean(risultato), p.sposta(destinazione),
                () -> "spostando da "+ sorgente +" a "+ destinazione + " il risultato dovrebbe essere " + risultato);
    }


}
