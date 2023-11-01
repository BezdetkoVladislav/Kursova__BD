import junit.framework.TestCase;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

public class RozkladZanyatyTest extends TestCase {
    public void testChcklist1() {
        Connector connect = new Connector();
        CardLayout card = new CardLayout();
        JFrame fram = new JFrame();
        RozkladZanyaty roz = new RozkladZanyaty(connect,card,fram);
        roz.listnum=1;
        assertEquals ("Розклад адміністратора",roz.chcklist());
    }
    public void testChcklist2() {
        Connector connect = new Connector();
        CardLayout card = new CardLayout();
        JFrame fram = new JFrame();
        RozkladZanyaty roz = new RozkladZanyaty(connect,card,fram);
        roz.listnum=2;
        assertEquals ("Розклад вчителів",roz.chcklist());
    }
    public void testChcklist3() {
        Connector connect = new Connector();
        CardLayout card = new CardLayout();
        JFrame fram = new JFrame();
        RozkladZanyaty roz = new RozkladZanyaty(connect,card,fram);
        roz.listnum=3;
        assertEquals ("Розклад учнів",roz.chcklist());
    }

    public void testChcklistnumDoesntExist() {
        Connector connect = new Connector();
        CardLayout card = new CardLayout();
        JFrame fram = new JFrame();
        RozkladZanyaty roz = new RozkladZanyaty(connect,card,fram);
        roz.listnum=100;
        assertEquals ("Недопустиме значення ідентифікатору списку",roz.chcklist());
    }
    /*
    public void testGet_roz_table_acc() {
        Connector connect = new Connector();
        CardLayout card = new CardLayout();
        JFrame fram = new JFrame();
        RozkladZanyaty roz = new RozkladZanyaty(connect,card,fram);
        assert (roz.setvch()==null);
    }

    public void testSetbox() {
        Connector connect = new Connector();
        CardLayout card = new CardLayout();
        JFrame fram = new JFrame();
        RozkladZanyaty roz = new RozkladZanyaty(connect,card,fram);
        assert (roz.setvch()==null);
    }

    public void testSetkabs() {
        Connector connect = new Connector();
        CardLayout card = new CardLayout();
        JFrame fram = new JFrame();
        RozkladZanyaty roz = new RozkladZanyaty(connect,card,fram);
        assert (roz.setvch()==null);
    }

    public void testSetvch() {
        Connector connect = new Connector();
        CardLayout card = new CardLayout();
        JFrame fram = new JFrame();
        RozkladZanyaty roz = new RozkladZanyaty(connect,card,fram);
        assert (roz.setvch()==null);
    }

    @Test
    public void testAddem() {
        Connector connect = new Connector();
        CardLayout card = new CardLayout();
        JFrame fram = new JFrame();
        RozkladZanyaty roz = new RozkladZanyaty(connect,card,fram);
        roz.zmina = "1";
        roz.klas = "10-А";
        roz.predm = "Математика";
        roz.kab = "10";
        roz.vch = "Тетьяна Антонівна";
        roz.chas ="1";
        roz.nom = "1";
        assert (roz.addem()==null);
    }*/
}