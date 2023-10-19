import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.concurrent.ThreadLocalRandom;
public class Add_new_user {
    private JLabel name;
    private JButton додаванняButton;
    private JTextField nameField;
    private JLabel secnameField;
    private JLabel parentnameField;
    private JLabel numField;
    private JTextField predmetField;
    private JTextField catField;
    private JTextField birthField;
    private JComboBox comboBox2;
    JFrame fram;
    ArrayList<String> specs = new ArrayList<>();

    protected Teacher createTeacher(String name,String prizv, String pib,int kat,String spez, Connector connector){
        int id = ThreadLocalRandom.current().nextInt(1, 1000000);
        Teacher teach = new Teacher(connector,id );
        teach.setKat(kat);
        teach.setPib(name+" "+prizv+" "+pib);
        teach.setSpec(spez);
        if(teach.kat!=0 && !teach.pib.equals(null) && !teach.spec.equals(null)){
            return null;
        }
        return teach;
    }
    protected boolean checkpib(String name, String priz, String batk){
        char c;
        String[] arr = {name, priz, batk};
        if (name.isEmpty() || priz.isEmpty() || batk.isEmpty()) {
            return false;
        }
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < arr[j].length(); i++) {
                c = arr[j].charAt(i);
                if (Character.isDigit(c)==true) {
                    return false;
                }
            }
        }
        return true;
    }

    protected int check_kat(int kat){
        if(kat>5 || kat<0){
            return 0;
        }

        return kat;
    }
    protected String check_spz(String spez){
        for (int i = 0; i < specs.size(); i++) {
            if(specs.get(i).equals(spez)){
                return spez;
            }
        }
        return null;
    }
    protected boolean check_date(String date){
        String regex = "^2\\d{3}-\\d{2}-\\d{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

    protected String check_katdat(String dat){
        if(check_date(dat)==false){
            return "2000-00-00";
        }
        return dat;
    }
    protected Add_new_user (Connector connect, CardLayout cardLayout, JFrame fram){
        this.fram = fram;String a=null,b=null,c=null,d=null,e=null,r =null;
        specs.add("Математика");
        specs.add("Українська мова");
        specs.add("Українська література");
        specs.add("Іноземна мова");
        specs.add("Фізика");

        додаванняButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }
}
