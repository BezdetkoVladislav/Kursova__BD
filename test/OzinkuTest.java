import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

public class OzinkuTest {

    @Test
    public void get_oz_pred() {
        Connector connect = new Connector();
        CardLayout card = new CardLayout();
        JFrame fram = new JFrame();
        Ozinku vist = new Ozinku(connect,card,fram);
        Teacher ac = new Teacher(connect,1);
        vist.ac=ac;
        assert (vist.get_oz_pred("Математика",0)!=null);
    }

    @Test
    public void get_oz_bm() {
        Connector connect = new Connector();
        CardLayout card = new CardLayout();
        JFrame fram = new JFrame();
        Ozinku vist = new Ozinku(connect,card,fram);
        Teacher ac = new Teacher(connect,1);
        vist.ac=ac;
        assert (vist.get_oz_bm("Більше",1,0)!=null);
    }
}