import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.HashMap;

public class Register {
    private JPanel header;
    private JPanel left;
    private JTextField textField2;
    private JButton button1;
    private JPanel right;
    private JTextField textField1;
    private JPanel overall;
    JFrame frame = new JFrame();
    String position;
    int id;
    CardLayout cardLayout = new CardLayout();

    protected Register(Connector connect){

        frame.setLayout(cardLayout);
        frame.add(overall, "acc");
        button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!textField1.getText().isEmpty() && !textField2.getText().isEmpty()){
                        try {
                           id = connect.chck_user(textField2.getText(), textField1.getText());
                           position = connect.position;
                        } catch (Exception eee) {
                        }
                        System.out.println(position);
                        if(position!=null && position.equals("Учень")){
                            UchMenu um = new UchMenu(connect, cardLayout,frame);
                            um.acc_objct(frame,cardLayout,connect,id);
                            um.inf_setter();
                        } else if (position!=null  && position.equals("Вчитель")) {
                            TchMenu tm = new TchMenu(connect, cardLayout,frame);
                            tm.acc_objct(frame,cardLayout,connect,id);
                            tm.inf_setter();
                        } else if (position!=null  && position.equals("Адміністратор")) {
                            AdminPan ap = new AdminPan(connect, cardLayout,frame);
                            frame.add(ap.pan,"adm");
                            ap.acc_objct(frame,cardLayout,connect,id);
                            ap.inf_setter();
                        } else {
                            JOptionPane.showMessageDialog(null, "Account data is corrupted!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Обов'язкове поле пусте!");
                    }
                }
            });
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
