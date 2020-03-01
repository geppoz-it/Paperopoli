import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class PaperopoliTests {

    @Test
    @DisplayName("1 + 1 = 2")
    void addsTwoNumbers() {
        Inventario inventario = new Inventario();
        Oggetto o1=new Oggetto("chiave");
        inventario.aggiungi(o1);
        Oggetto o2=new Oggetto("moneta");
        inventario.aggiungi(o2);
        assertEquals("chiave,moneta",inventario.lista(),"la lista dovrebbe visualizzare due oggetti");
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    void add(int first, int second, int expectedResult) {
        Inventario inventario = new Inventario();
        assertEquals(expectedResult, inventario.add(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }


}
