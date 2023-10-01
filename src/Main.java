import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Connector cont = new Connector();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Register frame = new Register(cont);
                frame.frame.setVisible(true);
            }
        });
    }

}

