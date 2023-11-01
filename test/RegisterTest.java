import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegisterTest {

    @Test
    public void usr_method1() {
        Connector connector=new Connector();
        Register reg = new Register(connector);
        reg.position = "Учень";
        assertEquals("Учень",reg.usr_method(connector));
    }
    @Test
    public void usr_method2() {
        Connector connector=new Connector();
        Register reg = new Register(connector);
        reg.position = "Вчитель";
        assertEquals("Вчитель",reg.usr_method(connector));
    }
    @Test
    public void usr_method3() {
        Connector connector=new Connector();
        Register reg = new Register(connector);
        reg.position = "Адміністратор";
        assertEquals("Адміністратор",reg.usr_method(connector));
    }
    @Test
    public void usr_method4() {
        Connector connector=new Connector();
        Register reg = new Register(connector);
        reg.position = null;
        assertEquals("Обов'язкове поле пусте!",reg.usr_method(connector));
    }

}