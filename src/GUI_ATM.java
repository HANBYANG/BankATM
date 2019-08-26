import javax.swing.*;

public class GUI_ATM extends JFrame {
    //public JPanel panel;
    GUI_ATM(){
        //this.panel = panel;
        if(!BankATM.Cur_Usr.equals("")){
            //JOptionPane.showMessageDialog(null, "ATM work on!!!!!", "Info", JOptionPane.INFORMATION_MESSAGE);
            new GUI_Query();
        }
        else{
            new GUI_Login();
        }
    }

}
