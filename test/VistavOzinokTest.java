import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

public class VistavOzinokTest {

    @Test
    public void addt() {
        Connector connect = new Connector();
        CardLayout card = new CardLayout();
        JFrame fram = new JFrame();
        VistavOzinok vist = new VistavOzinok(connect,card,fram);
        Teacher ac = new Teacher(connect,1);
        vist.ac = ac;
        assert(vist.addt("Математика","Катерина Таращук",10)==null);
    }
}