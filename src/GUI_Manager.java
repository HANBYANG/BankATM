import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GUI_Manager extends JFrame {
    private JTextField numberField;
    private JTextField dayField;
    private JTextField monthField;
    private JTextField yearField;

    private JButton viewTransbutton;
    private JButton viewDayTrans;
    private JButton viewUser;
    GUI_Manager(){
        this.setTitle("Manager");
        this.setBounds(1200, 200, 600, 400);
        this.setLayout(null);
        JLabel Title = new JLabel("Hello Boss!");
        Title.setFont(new Font("Serif", Font.PLAIN, 36));
        Title.setBounds(200,30,200,40);
        this.add(Title);

        JLabel numberLabel = new JLabel("Enter Account ID:");
        numberField = new JTextField(10);
        numberLabel.setBounds(50,100,100,25);
        numberField.setBounds(150,100,250,25);
        this.add(numberLabel);
        this.add(numberField);

        Date date = new Date();

        JLabel dayLabel = new JLabel("           Enter date");
        dayField = new JTextField(10);
        dayLabel.setBounds(50,150,100,25);
        dayField.setBounds(150,150,50,25);
        dayField.setText(Integer.toString(date.getDay()));
        this.add(dayLabel);
        this.add(dayField);


        JLabel monthLabel = new JLabel("    month");
        monthField = new JTextField(10);
        monthLabel.setBounds(200,150,50,25);
        monthField.setBounds(250,150,50,25);
        monthField.setText(Integer.toString(date.getMonth()));
        this.add(monthLabel);
        this.add(monthField);

        JLabel yearLabel = new JLabel("       year");
        yearField = new JTextField(10);
        yearLabel.setBounds(300,150,50,25);
        yearField.setBounds(350,150,50,25);
        yearField.setText(Integer.toString(date.getYear()));
        this.add(yearLabel);
        this.add(yearField);



        viewUser=new JButton("Check User");
        viewUser.setBounds(420, 95, 130, 30);
        viewUser.addActionListener(new ViewUserAction());
        this.add(viewUser);

        viewDayTrans=new JButton("Check Day Trans");
        viewDayTrans.setBounds(420, 145, 130, 30);
        viewDayTrans.addActionListener(new ViewDayTransAction());
        this.add(viewDayTrans);

        viewTransbutton=new JButton("All Transactions");
        viewTransbutton.setBounds(330, 250, 150, 30);
        viewTransbutton.addActionListener(new ViewTransAction());
        this.add(viewTransbutton);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    class ViewUserAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String theAccount = numberField.getText();
            if(BankATM.accounts.containsKey(theAccount)){
                new Report(BankATM.accounts.get(theAccount).transactions);
            }
            else{
                JOptionPane.showMessageDialog(null,"Account doesn't exist. Try again.");
            }
        }
    }

    class ViewDayTransAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input_day = dayField.getText();
            String input_month = monthField.getText();
            String input_year = yearField.getText();
            try {
                int day = Integer.parseInt(input_day);
                int month = Integer.parseInt(input_month);
                int year = Integer.parseInt(input_year);

                Date theday = new Date(day,month,year);

                List<Transaction> allTrans = new ArrayList<>();
                for(Account entry : BankATM.accounts.values()){
                    allTrans.addAll(entry.transactions);
                }
                new Report(allTrans,theday);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid date input!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    class ViewTransAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            List<Transaction> allTrans = new ArrayList<>();
            for(Account entry : BankATM.accounts.values()){
                allTrans.addAll(entry.transactions);
            }
            new Report(allTrans);
        }
    }
}

