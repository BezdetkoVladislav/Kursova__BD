import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UchMenu extends Menu {
    private JButton переглянутиButton;
    private JButton переглянутиButton1;
    private JButton переглядButton;
    private JButton вихідButton;
    protected JPanel pan;
    protected JLabel klas;
    protected JLabel pib;
    protected JLabel ball;
    protected JLabel date;
    protected JLabel har;
    Ucheny acc=null;
    @Override
    public void inf_setter(){
        this.klas.setText(this.acc.klass);
        this.pib.setText(this.acc.pib);
        this.ball.setText(String.valueOf(this.acc.avg_mark));
        this.date.setText(this.acc.date);
        this.har.setText(this.acc.har);
    }
    @Override
    public void acc_objct(JFrame frame, CardLayout cardLayout,Connector connect,int id){
        frame.add(this.pan, "uch");
        Ucheny uch = new Ucheny(connect,id);
        this.acc = uch;
        this.inf_setter();
        frame.setSize(600,300);
        frame.setLocationRelativeTo(null);
        cardLayout.show(frame.getContentPane(),"uch");
    }
    protected UchMenu(Connector connect, CardLayout cardLayout, JFrame fram){
        RozkladZanyaty rz = new RozkladZanyaty(connect,cardLayout,fram);
        Ozinku oz = new Ozinku(connect,cardLayout,fram);
        KlasofUch ku = new KlasofUch(connect,cardLayout,fram);
        переглянутиButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rz.listnum = 3;
                rz.acc =acc;
                rz.chcklist();
                fram.add(rz.pan,"roz");
                fram.setSize(1375, 600);fram.setLocationRelativeTo(null);
                cardLayout.show(fram.getContentPane(),"roz");
            }
        });
        переглянутиButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oz.listnum=1;
                oz.acc=acc;
                oz.chcklist();
                fram.add(oz.pan,"ozk");fram.setSize(1300, 600);fram.setLocationRelativeTo(null);
                cardLayout.show(fram.getContentPane(),"ozk");
            }
        });
        переглядButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ku.listnum=5;
                ku.acc = acc;
                ku.chcklist();
                fram.add(ku.pan,"kls");fram.setSize(1300, 600);fram.setLocationRelativeTo(null);
                cardLayout.show(fram.getContentPane(),"kls");
            }
        });
        вихідButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fram.dispose();
            }
        });
    }
}
