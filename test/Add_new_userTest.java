import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

public class Add_new_userTest {
    Connector connect = new Connector();
    CardLayout card = new CardLayout();
    JFrame fram = new JFrame();
    protected Add_new_user add = new Add_new_user(connect,card,fram);
    String name, prizv,  pib, spez, dat;
    int kat;

    @Test
    public void checkpib() {
        this.name="Anatoliy";
        this.prizv = "Bakalov";
        this.pib = "Sergiyovich";
        assert (add.checkpib(this.name,this.prizv,this.pib)==true);
    }

    @Test
    public void check_kat() {
        this.kat =1;
        assert (add.check_kat(this.kat)!=0);
    }

    @Test
    public void check_spz() {
        this.spez="Математика";
        assert (!add.check_spz(this.spez).equals(null));
    }

    @Test
    public void check_katdat() {
        this.dat = "210-32";
        assert (add.check_date(add.check_katdat(dat))==true);
    }

    @Test
    public void createTeacher() {
        assert (add.createTeacher(name, prizv,  pib, kat, spez,connect)!=null);
    }
}