import junit.framework.TestCase;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

public class RozkladZanyatyTest extends TestCase {

    public void testChcklist() {
        Connector connect = new Connector();
        CardLayout card = new CardLayout();
        JFrame fram = new JFrame();
        RozkladZanyaty roz = new RozkladZanyaty(connect,card,fram);
        roz.listnum=1;
        assert (roz.chcklist()!=0);
    }

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
    }
}