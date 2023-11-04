import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class UchenyTest {
/*
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
*/

    public Ucheny uch_creat(int num) {
        Connector connector = new Connector();
        Ucheny uch = new Ucheny(connector,1);
        uch.avg_mark = num;
        return uch;
    }

    @Test
    public void check_mark_n2() {
        Ucheny uch = uch_creat(-2);
        assertEquals("Зверніться до адміністратора щодо стану відомостей.",uch.check_mark());
    }
    @Test
    public void check_mark_n1() {
        Ucheny uch = uch_creat(-1);
        assertEquals("Зверніться до адміністратора щодо стану відомостей.",uch.check_mark());
    }

    @Test
    public void check_mark0() {
        Ucheny uch = uch_creat(0);
        assertEquals("На поточний момент оцінки відсутні.",uch.check_mark());
    }
    @Test
    public void check_mark1() {
        Ucheny uch = uch_creat(1);
        assertEquals("Незадовільний рівень успішності.",uch.check_mark());
    }
    @Test
    public void check_mark2() {
        Ucheny uch = uch_creat(2);
        assertEquals("Незадовільний рівень успішності.",uch.check_mark());
    }
    @Test
    public void check_mark3() {
        Ucheny uch = uch_creat(3);
        assertEquals("Незадовільний рівень успішності.",uch.check_mark());
    }
    @Test
    public void check_mark4() {
        Ucheny uch = uch_creat(4);
        assertEquals("Незадовільний рівень успішності.",uch.check_mark());
    }
    @Test
    public void check_mark5() {
        Ucheny uch = uch_creat(5);
        assertEquals("Достатній рівень успішності.",uch.check_mark());
    }
    @Test
    public void check_mark6() {
        Ucheny uch = uch_creat(6);
        assertEquals("Достатній рівень успішності.",uch.check_mark());
    }
    @Test
    public void check_mark7() {
        Ucheny uch = uch_creat(7);
        assertEquals("Достатній рівень успішності.",uch.check_mark());
    }
    @Test
    public void check_mark8() {
        Ucheny uch = uch_creat(8);
        assertEquals("Достатній рівень успішності.",uch.check_mark());
    }
    @Test
    public void check_mark9() {
        Ucheny uch = uch_creat(9);
        assertEquals("Високий рівень успішності.",uch.check_mark());
    }
    @Test
    public void check_mark10() {
        Ucheny uch = uch_creat(10);
        assertEquals("Високий рівень успішності.",uch.check_mark());
    }
    @Test
    public void check_mark11() {
        Ucheny uch = uch_creat(11);
        assertEquals("Високий рівень успішності.",uch.check_mark());
    }
    @Test
    public void check_mark12() {
        Ucheny uch = uch_creat(12);
        assertEquals("Високий рівень успішності.",uch.check_mark());
    }
    @Test
    public void check_mark13() {
        Ucheny uch = uch_creat(13);
        assertEquals("Зверніться до адміністратора щодо стану відомостей.",uch.check_mark());
    }
    @Test
    public void check_mark14() {
        Ucheny uch = uch_creat(14);
        assertEquals("Зверніться до адміністратора щодо стану відомостей.",uch.check_mark());
    }

}