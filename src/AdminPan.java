import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPan extends Menu {
    private JButton перейтиButton;
    private JButton співробітникиButton;
    private JButton списокУчнівButton;
    protected JPanel pan;
    protected JLabel pos;
    protected JLabel pib;
    private JButton вийтиButton;
    private JButton vch;
    private JButton тестButton;
    Admin acc;
    @Override
    public void inf_setter(){
        this.pib.setText(this.acc.pib);
        this.pos.setText(this.acc.pos);
    }
    @Override
    public void acc_objct(JFrame frame, CardLayout cardLayout,Connector connect,int id){
        frame.add(this.pan,"adm");
        Admin adm = new Admin(connect,id);
        this.acc = adm;
        this.inf_setter();
        frame.setSize(675,300);
        frame.setLocationRelativeTo(null);
        cardLayout.show(frame.getContentPane(),"adm");
    }
    protected AdminPan(Connector connect, CardLayout cardLayout, JFrame fram){
        KlasofUch ku = new KlasofUch(connect,cardLayout,fram);
        RozkladZanyaty rz = new RozkladZanyaty(connect,cardLayout,fram);
        Test ts = new Test(connect,cardLayout,fram);
        перейтиButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rz.listnum = 1;
                rz.a = acc;
                rz.chcklist();
                fram.add(rz.pan,"roz");
                fram.setSize(1375, 600);fram.setLocationRelativeTo(null);
                cardLayout.show(fram.getContentPane(),"roz");
            }
        });
        співробітникиButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ku.listnum = 1;
                ku.a = acc;
                ku.chcklist();
                fram.add(ku.pan,"kls");
                fram.setSize(1300, 600);fram.setLocationRelativeTo(null);
                cardLayout.show(fram.getContentPane(),"kls");
            }
        });
        списокУчнівButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ku.listnum = 2;
                ku.a = acc;
                ku.chcklist();
                fram.add(ku.pan,"kls");
                fram.setSize(1300, 600);fram.setLocationRelativeTo(null);
                cardLayout.show(fram.getContentPane(),"kls");
            }
        });
        vch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ku.listnum = 3;
                ku.a = acc;
                ku.chcklist();
                fram.add(ku.pan,"kls");
                fram.setSize(1300, 600);fram.setLocationRelativeTo(null);
                cardLayout.show(fram.getContentPane(),"kls");
            }
        });
        вийтиButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fram.dispose();
            }
        });
        тестButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fram.add(ts.pan,"ttt");
                fram.setSize(1200,800);
                fram.setLocationRelativeTo(null);
                fram.revalidate();
                fram.repaint();
                cardLayout.show(fram.getContentPane(),"ttt");
            }
        });
    }
}
