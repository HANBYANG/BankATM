import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankATM {

    public static String Cur_Usr="";
    public static Map<String,Account> accounts = new HashMap<>();
    public static JFrame frame1 = new JFrame("BankATM");
    public static JFrame frame2 = new JFrame("Query");

    public static void main(String[] args) {
        frame1.setSize(350, 200);
        frame1.setBounds(300,300,350,200);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(350, 200);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        new GUI_ATM();
        new GUI_Manager();
    }



}

