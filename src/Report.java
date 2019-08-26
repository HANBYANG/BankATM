import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Report extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JButton return_button;
    Report(List<Transaction> transactions){
        this.setTitle("Report");
        this.setBounds(500, 400, 619, 400);
        this.setLayout(null);
        table=new JTable();
        model=new DefaultTableModel();
        table.setModel(model);
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(1, 0, 600, 300);
        this.add(jsp);
        return_button=new JButton("Return");
        return_button.setBounds(240, 310, 110, 30);
        return_button.addActionListener(new ReturnButtonAction());
        this.add(return_button);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);

        model.addColumn("Time");
        model.addColumn("From");
        model.addColumn("To");
        model.addColumn("Currency");
        model.addColumn("Charge");
        model.addColumn("Balance Left");
        model.addColumn("Description");
        String[] row=new String[7];
        for(int i = 0;i<transactions.size();i++){
            row[0]=transactions.get(i).date.toString();
            row[1]=transactions.get(i).FromUsr;
            row[2]=transactions.get(i).ToUsr;
            row[3]=transactions.get(i).value.toString();
            row[4]=transactions.get(i).charge.toString();
            row[5]=transactions.get(i).balanceLeft.toString();
            row[6]=transactions.get(i).description;
            model.addRow(row);
        }
    }

    Report(List<Transaction> transactions,Date date){
        this.setTitle("Report");
        this.setBounds(500, 400, 619, 400);
        this.setLayout(null);
        table=new JTable();
        model=new DefaultTableModel();
        table.setModel(model);
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(1, 0, 600, 300);
        this.add(jsp);
        return_button=new JButton("Return");
        return_button.setBounds(240, 310, 110, 30);
        return_button.addActionListener(new ReturnButtonAction());
        this.add(return_button);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);

        model.addColumn("Time");
        model.addColumn("From");
        model.addColumn("To");
        model.addColumn("Currency");
        model.addColumn("Charge");
        model.addColumn("Balance Left");
        model.addColumn("Description");
        String[] row=new String[7];
        for(int i = 0;i<transactions.size();i++){
            if(!transactions.get(i).date.equals(date))
                continue;
            row[0]=transactions.get(i).date.toString();
            row[1]=transactions.get(i).FromUsr;
            row[2]=transactions.get(i).ToUsr;
            row[3]=transactions.get(i).value.toString();
            row[4]=transactions.get(i).charge.toString();
            row[5]=transactions.get(i).balanceLeft.toString();
            row[6]=transactions.get(i).description;
            model.addRow(row);
        }
    }

    class ReturnButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
}
