import org.junit.Test;

import static org.junit.Assert.*;

public class UchenyTest {

    @Test
    public void check_markVidsutni() {
        Connector connector = new Connector();
        Ucheny uch = new Ucheny(connector,8);
        assertEquals("На поточний момент оцінки відсутні.",uch.check_mark());
    }
    @Test
    public void check_markNezadovilny() {
        Connector connector = new Connector();
        Ucheny uch = new Ucheny(connector,3);
        assertEquals("Незадовільний рівень успішності.",uch.check_mark());
    }
    @Test
    public void check_markDostatniy() {
        Connector connector = new Connector();
        Ucheny uch = new Ucheny(connector,1);
        assertEquals("Достатній рівень успішності.",uch.check_mark());
    }
    @Test
    public void check_markVisokiy() {
        Connector connector = new Connector();
        Ucheny uch = new Ucheny(connector,2);
        assertEquals("Високий рівень успішності.",uch.check_mark());
    }
    @Test
    public void check_markPomilka() {
        Connector connector = new Connector();
        Ucheny uch = new Ucheny(connector,9);
        assertEquals("Зверніться до адміністратора щодо стану відомостей.",uch.check_mark());
    }
}