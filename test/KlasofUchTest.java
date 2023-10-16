import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

public class KlasofUchTest {

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
    }
}