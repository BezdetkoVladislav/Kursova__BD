import org.junit.Test;
import javax.swing.*;
import java.awt.*;
import static org.junit.Assert.*;

public class KlasofUchTest {
    @Test
    public void test_val1() {
        Connector connect = new Connector();
        CardLayout card = new CardLayout();
        JFrame fram = new JFrame();
        KlasofUch klas = new KlasofUch(connect, card, fram);
        klas.listnum = 1;
        assertEquals("Список співробітників", klas.chcklist());
    }
    @Test
    public void test_val2() {
        Connector connect = new Connector();
        CardLayout card = new CardLayout();
        JFrame fram = new JFrame();
        KlasofUch klas = new KlasofUch(connect, card, fram);
        klas.listnum = 2;
        assertEquals("Список вчителів", klas.chcklist());
    }
    @Test
    public void test_val3() {
        Connector connect = new Connector();
        CardLayout card = new CardLayout();
        JFrame fram = new JFrame();
        KlasofUch klas = new KlasofUch(connect, card, fram);
        klas.listnum = 3;
        assertEquals("Список усіх учнів", klas.chcklist());
    }
    @Test
    public void test_val4() {
        Connector connect = new Connector();
        CardLayout card = new CardLayout();
        JFrame fram = new JFrame();
        KlasofUch klas = new KlasofUch(connect, card, fram);
        klas.listnum = 4;
        assertEquals("Список учнів дисципліни", klas.chcklist());
    }
    @Test
    public void test_val5() {
        Connector connect = new Connector();
        CardLayout card = new CardLayout();
        JFrame fram = new JFrame();
        KlasofUch klas = new KlasofUch(connect, card, fram);
        klas.listnum = 5;
        assertEquals(klas.table1, klas.chcklist());
        klas.acc = new Ucheny(connect, 1);
        klas.acc.klass = "4";
        assertEquals("Список однокласників", klas.chcklist());
    }

    @Test
    public void test_valOutofBounds() {
        Connector connect = new Connector();
        CardLayout card = new CardLayout();
        JFrame fram = new JFrame();
        KlasofUch klas = new KlasofUch(connect, card, fram);
        klas.listnum = 4;
        assertEquals("Такого типу списку не існує", klas.chcklist());
    }
}
/*
    @Test
    public void prod() {
        Connector connect = new Connector();
        CardLayout card = new CardLayout();
        JFrame fram = new JFrame();
        KlasofUch klas = new KlasofUch(connect,card,fram);
        String id_vch = "1",id_kat = "1";
        klas.h1 = id_vch;
        klas.h2 = id_kat;
        assert (klas.prod("2020-03-03")==null);
    }*/
