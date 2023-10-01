import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TchMenu extends Menu {
    private JButton розкладЗанятьButton;
    private JButton редагуванняОцінокButton;
    private JButton списокУчнівButton;
    protected JPanel pan;
    protected JLabel pos;
    protected JLabel pib;
    protected JLabel spec;
    protected JLabel kat;
    private JButton вийтиButton;
    private JButton перегляд;
    Teacher acc;
    @Override
    public void inf_setter(){
        this.pib.setText(this.acc.pib);
        this.kat.setText(this.acc.kat);
        this.spec.setText(this.acc.spec);
    }
    @Override
    public void acc_objct(JFrame frame, CardLayout cardLayout,Connector connect,int id){
        frame.add(this.pan,"tch");
        Teacher tch = new Teacher(connect,id);
        this.acc = tch;
        this.inf_setter();
        frame.setSize(675,300);
        frame.setLocationRelativeTo(null);
        cardLayout.show(frame.getContentPane(),"tch");
    }

    protected TchMenu(Connector connect, CardLayout cardLayout, JFrame fram){
        KlasofUch ku = new KlasofUch(connect,cardLayout,fram);
        RozkladZanyaty rz = new RozkladZanyaty(connect,cardLayout,fram);
        Ozinku oz = new Ozinku(connect,cardLayout,fram);
        VistavOzinok vo = new VistavOzinok(connect,cardLayout,fram);
        перегляд.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oz.listnum=2;
                oz.ac=acc;
                oz.chcklist();
                fram.add(oz.pan,"ozk");fram.setSize(1300, 600);fram.setLocationRelativeTo(null);
                cardLayout.show(fram.getContentPane(),"ozk");
            }
        });

        розкладЗанятьButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rz.listnum=2;
                rz.ac = acc;
                rz.chcklist();
                fram.add(rz.pan,"roz");fram.setSize(1375, 600);fram.setLocationRelativeTo(null);
                cardLayout.show(fram.getContentPane(),"roz");
            }
        });

        редагуванняОцінокButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vo.listnum = 1;
                vo.ac =acc;
                vo.chcklist();
                fram.add(vo.pan,"vot");fram.setSize(1300, 600);fram.setLocationRelativeTo(null);
                cardLayout.show(fram.getContentPane(),"vot");
            }
        });

        списокУчнівButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ku.listnum = 4;
                ku.ac = acc;
                ku.chcklist();
                fram.add(ku.pan,"kls");fram.setSize(1300, 600);fram.setLocationRelativeTo(null);
                cardLayout.show(fram.getContentPane(),"kls");
            }
        });
        вийтиButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fram.dispose();
            }
        });
    }
}
