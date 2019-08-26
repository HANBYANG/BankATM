import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Login extends  JFrame{

    public JTextField userText = new JTextField(20);
    public JPasswordField passwordText = new JPasswordField(20);

    public GUI_Login() {
        //this.panel = panel;
        //this.accounts = accounts;
        //BankATM.Cur_Usr = Cur_Usr;

        //this.setBounds(100,200,100,200);

        JPanel panel = new JPanel();
        BankATM.frame1.add(panel);
        BankATM.frame1.setVisible(true);
        panel.setLayout(null);

        JLabel userLabel = new JLabel("User:");

        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);



        userText.setBounds(100,20,165,25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);



        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.addActionListener(new buttonListenerLogin());
        panel.add(loginButton);


        JButton createaccountButton = new JButton("create account");
        createaccountButton.setBounds(145, 80, 120, 25);
        createaccountButton.addActionListener(new buttonListenerCreate());
        panel.add(createaccountButton);


        JButton enterManager = new JButton("I'm the manager");
        enterManager.setBounds(175, 120, 150, 25);
        enterManager.addActionListener(new enterManager());
        panel.add(enterManager);

    }

    class enterManager implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new GUI_Manager();
        }
    }

    class buttonListenerLogin implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String usrnm = userText.getText();
            String psw = String.valueOf(passwordText.getPassword());
            if(BankATM.accounts.containsKey(usrnm)&&BankATM.accounts.get(usrnm).getPassword().equals(psw)){
                BankATM.Cur_Usr = usrnm;
                JOptionPane.showMessageDialog(null, "Login successful!", "Info", JOptionPane.INFORMATION_MESSAGE);
                //panel.removeAll();
                //
                //BankATM.frame1.remove(panel);
                userText.setText("");
                passwordText.setText("");
                BankATM.frame1.setVisible(false);
                dispose();
                //BankATM.frame1.removeAll();
                new GUI_ATM();
            }
            else{
                JOptionPane.showMessageDialog(null, "Wrong Username or Password!", "Info", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class buttonListenerCreate implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String usrnm = userText.getText();
            String psw = String.valueOf(passwordText.getPassword());
            if(!BankATM.accounts.containsKey(usrnm)&&(!usrnm.equals(""))&&(!usrnm.equals("BANK"))&&(!usrnm.equals("ATM"))){
                Object[] options = {"Checking Account","Saving Account","Cancel"};
                int response=JOptionPane.showOptionDialog(new Panel(), "Please select your account type:", "Creating an account",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if(response==0){
                    BankATM.accounts.put(usrnm, new Saving_Account(usrnm,psw));
                    BankATM.Cur_Usr = usrnm;
                    JOptionPane.showMessageDialog(null, "Registered successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    userText.setText("");
                    passwordText.setText("");
                    BankATM.frame1.setVisible(false);
                    dispose();
                    new GUI_ATM();
                }
                else if(response == 1){
                    BankATM.accounts.put(usrnm, new Checking_Account(usrnm,psw));
                    BankATM.Cur_Usr = usrnm;
                    JOptionPane.showMessageDialog(null, "Registered successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    userText.setText("");
                    passwordText.setText("");
                    BankATM.frame1.setVisible(false);
                    dispose();
                    new GUI_ATM();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Request canceled", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "This user name already exists or invalid", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
