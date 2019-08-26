import com.sun.javaws.util.JfxHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Query extends JFrame {
    private JFrame mainFrame;
    private JFrame inputFrame;
    private JFrame transferFrame;
    private JFrame loanFrame;
    private JFrame CurrencyFrame;

    private JTextField numberField;
    private JTextField currencyField;

    private JTextField tnumberField;
    private JTextField tcurrencyField;
    private JTextField taccountField;

    private JTextField lnumberField;
    private JTextField lcurrencyField;
    private JTextField ltermField;

    private JTextField sCurField;

    private JLabel verifyLabel;
    private JLabel outLabel;

    private JButton depositButton;
    private JButton withdrawButton;
    private JButton transferButton;
    private JButton setCurButton;
    private JButton viewTransButton;

    private JButton loanButton;
    private JButton payloanButton;
    private JButton viewloanButton;

    private JButton makeDepositButton;
    private JButton makeWithdrawalButton;
    private JButton makeTransferButton;
    private JButton makeSetCurButton;
    private JButton makeLoanButton;

    private Double theAmount;
    private String theCurrency;
    private String theAccount;
    private int theTerm;

    private int width;
    private int height;
    private int DW=0;
    //ArrayList accounts;
    public GUI_Query() {
        int xLocation = 200;
        int yLocation = 200;

        // define frames
        mainFrame = BankATM.frame2;
        inputFrame = new JFrame("Enter Amount");
        transferFrame = new JFrame("Enter Amount and Target Account");
        loanFrame = new JFrame("Enter Amount and Term Needed");
        CurrencyFrame = new JFrame("Enter the Currency you want to switch to");

        mainFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        inputFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        transferFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        loanFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        CurrencyFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        mainFrame.setLocation(xLocation,yLocation);
        inputFrame.setLocation(xLocation,yLocation);
        transferFrame.setLocation(xLocation,yLocation);
        loanFrame.setLocation(xLocation,yLocation);
        CurrencyFrame.setLocation(xLocation,yLocation);

        mainFrame.setVisible(true);


        // the main frame panel
        JPanel thePanel = new JPanel();
        width = 1000;
        height = 400;
        thePanel.setPreferredSize(new Dimension(width,height));
        thePanel.setBackground(Color.LIGHT_GRAY);
        thePanel.setLayout(new FlowLayout(FlowLayout.CENTER,500,20));

        JPanel inputPanel = new JPanel();
        JPanel transferPanel = new JPanel();
        JPanel loanPanel = new JPanel();
        JPanel curPanel = new JPanel();

//===========================================================================
        JLabel numberLabel = new JLabel("Type and Press Enter.   Amount:");
        numberField = new JTextField(10);
        NumberFieldAction nbaction = new NumberFieldAction();
        numberField.addActionListener(nbaction);
        inputPanel.add(numberLabel);
        inputPanel.add(numberField);

        JLabel currencyLabel = new JLabel(" Currency:");
        currencyField = new JTextField(10);
        currencyField.addActionListener(nbaction);
        inputPanel.add(currencyLabel);
        inputPanel.add(currencyField);

//==============================================================================
        JLabel sCurrencyLabel = new JLabel(" Currency:");
        sCurField = new JTextField(10);
        sCurField.addActionListener(new SCurFieldAction());
        curPanel.add(sCurrencyLabel);
        curPanel.add(sCurField);

//============================================================================
        JLabel tnumberLabel = new JLabel("Type and Press Enter.   Amount:");
        tnumberField = new JTextField(10);
        //NumberFieldAction nbaction = new NumberFieldAction();
        TransferFieldAction transferFieldAction = new TransferFieldAction();
        tnumberField.addActionListener(transferFieldAction);
        transferPanel.add(tnumberLabel);
        transferPanel.add(tnumberField);

        JLabel tcurrencyLabel = new JLabel("Currency:");
        tcurrencyField = new JTextField(10);
        tcurrencyField.addActionListener(transferFieldAction);
        transferPanel.add(tcurrencyLabel);
        transferPanel.add(tcurrencyField);


        JLabel taccountLabel = new JLabel("Transfer to Account:");
        taccountField = new JTextField(10);
        taccountField.addActionListener(transferFieldAction);
        transferPanel.add(taccountLabel);
        transferPanel.add(taccountField);
//===============================================================================

        JLabel lnumberLabel = new JLabel("Type and Press Enter.   Amount:");
        lnumberField = new JTextField(10);
        LoanFieldAction loanFieldAction = new LoanFieldAction();
        lnumberField.addActionListener(loanFieldAction);
        loanPanel.add(lnumberLabel);
        loanPanel.add(lnumberField);

        JLabel lcurrencyLabel = new JLabel("Currency:");
        lcurrencyField = new JTextField(10);
        lcurrencyField.addActionListener(loanFieldAction);
        loanPanel.add(lcurrencyLabel);
        loanPanel.add(lcurrencyField);


        JLabel ltermLabel = new JLabel("Term needed:");
        ltermField = new JTextField(10);
        ltermField.addActionListener(loanFieldAction);
        loanPanel.add(ltermLabel);
        loanPanel.add(ltermField);

//===============================================================================
        JPanel verifyPanel = new JPanel();
        verifyLabel = new JLabel("No Amount Entered");
        verifyPanel.add(verifyLabel);

        JPanel choosePanel = new JPanel();
        JLabel chooseLabel = new JLabel("Choose Transaction");
        choosePanel.add(chooseLabel);

        JPanel buttonPanel = new JPanel();
        JPanel makeButtonPanel = new JPanel();
        JPanel loanButtonPanel = new JPanel();

        JButton balanceButton = new JButton("Balance");
        balanceButton.addActionListener(new BalanceButtonAction());
        buttonPanel.add(balanceButton);

        depositButton = new JButton("Deposit");
        depositButton.addActionListener(new DepositButtonAction());
        buttonPanel.add(depositButton);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new WithdrawButtonAction());
        buttonPanel.add(withdrawButton);

        transferButton = new JButton("Transfer");
        transferButton.addActionListener(new TransferButtonAction());
        buttonPanel.add(transferButton);

        setCurButton = new JButton("Set Currency");
        setCurButton.addActionListener(new SetCurButtonAction());
        buttonPanel.add(setCurButton);

        viewTransButton = new JButton("View Transactions");
        viewTransButton.addActionListener(new ViewTransButtonAction());
        buttonPanel.add(viewTransButton);

        loanButton = new JButton("Loan");
        loanButton.addActionListener(new LoanButtonAction());
        loanButtonPanel.add(loanButton);

        payloanButton = new JButton("Pay Loan");
        payloanButton.addActionListener(new PayLoanButtonAction());
        loanButtonPanel.add(payloanButton);

        viewloanButton = new JButton("View Loan");
        viewloanButton.addActionListener(new ViewLoanButtonAction());
        loanButtonPanel.add(viewloanButton);


        makeDepositButton = new JButton("Make Deposit");
        makeDepositButton.addActionListener(new MakeDepositButtonAction());
        makeButtonPanel.add(makeDepositButton);

        makeWithdrawalButton = new JButton("Make Withdrawal");
        makeWithdrawalButton.addActionListener(new MakeWithdrawalButtonAction());
        makeButtonPanel.add(makeWithdrawalButton);

        makeTransferButton = new JButton("Make Transfer");
        makeTransferButton.addActionListener(new MakeTransferButtonAction());
        makeButtonPanel.add(makeTransferButton);

        makeSetCurButton = new JButton("Make Set Currency");
        makeSetCurButton.addActionListener(new MakeSetCurButtonAction());
        makeButtonPanel.add(makeSetCurButton);

        makeLoanButton = new JButton("Make Loan");
        makeLoanButton.addActionListener(new MakeLoanButtonAction());
        makeButtonPanel.add(makeLoanButton);

        JPanel finishButtonPanel = new JPanel();
        JButton finishButton = new JButton("Finish");
        finishButton.addActionListener(new FinishButtonAction());
        finishButtonPanel.add(finishButton);

        JPanel outPanel = new JPanel();
        outPanel.setBackground(Color.LIGHT_GRAY);
        outLabel = new JLabel("");
        outLabel.setForeground(Color.RED);
        outLabel.setFont(new Font("Courier",Font.BOLD,20));
        outPanel.add(outLabel);

        thePanel.add(choosePanel);
        thePanel.add(verifyPanel);
        thePanel.add(buttonPanel);
        thePanel.add(loanButtonPanel);
        thePanel.add(makeButtonPanel);
        thePanel.add(finishButtonPanel);
        thePanel.add(outPanel);


        mainFrame.getContentPane().add(thePanel);
        mainFrame.pack();

        inputFrame.getContentPane().add(inputPanel);
        inputFrame.pack();

        transferFrame.getContentPane().add(transferPanel);
        transferFrame.pack();

        loanFrame.getContentPane().add(loanPanel);
        loanFrame.pack();

        CurrencyFrame.getContentPane().add(curPanel);
        CurrencyFrame.pack();

        makeDepositButton.setEnabled(false);
        makeLoanButton.setEnabled(false);
        makeTransferButton.setEnabled(false);
        makeWithdrawalButton.setEnabled(false);
        makeSetCurButton.setEnabled(false);
    }




    class NumberFieldAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = numberField.getText();
            if( ! isInputOK(input) ) {
                JOptionPane.showMessageDialog(null,"Invalid input. Try again.");
                numberField.requestFocus();
                return;
            } // end if
            theAmount = Double.parseDouble(input);
            input = currencyField.getText();
            if( !BankATM.accounts.get(BankATM.Cur_Usr).balance.rate.containsKey(input)) {
                JOptionPane.showMessageDialog(null,"Invalid input. Try again.");
                currencyField.requestFocus();
                return;
            } // end if
            theCurrency = input;
            if(DW == 0){
                makeDepositButton.setEnabled(true);
            }
            else{
                makeWithdrawalButton.setEnabled(true);
            }
            inputFrame.setVisible(false);
            mainFrame.setVisible(true);
            verifyLabel.setText("Amount Entered was " + theCurrency + " " + theAmount);

        } // end actionPerformed
    } // end NumberButtonAction

    class TransferFieldAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = taccountField.getText();
            if( !BankATM.accounts.containsKey(input) ) {
                JOptionPane.showMessageDialog(null,"Account does not exist. Try again.");
                taccountField.requestFocus();
                return;
            } // end if
            if( input.equals(BankATM.Cur_Usr) ) {
                JOptionPane.showMessageDialog(null,"Cannot send money to yourself. Try again.");
                taccountField.requestFocus();
                return;
            } // end if
            theAccount = input;
            input = tnumberField.getText();
            if( ! isInputOK(input) ) {
                JOptionPane.showMessageDialog(null,"Invalid input. Try again.");
                tnumberField.requestFocus();
                return;
            } // end if
            theAmount = Double.parseDouble(input);
            input = tcurrencyField.getText();
            if( !BankATM.accounts.get(BankATM.Cur_Usr).balance.rate.containsKey(input)) {
                JOptionPane.showMessageDialog(null,"Invalid input. Try again.");
                tcurrencyField.requestFocus();
                return;
            } // end if
            theCurrency = input;
            makeTransferButton.setEnabled(true);
            transferFrame.setVisible(false);
            mainFrame.setVisible(true);
            //makeTransferButton.setEnabled(true);
            verifyLabel.setText("Sending "+ theCurrency + " " + theAmount + " to " + theAccount);

        } // end actionPerformed
    } // end TransferButtonAction

    class SCurFieldAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = sCurField.getText();
            if(BankATM.accounts.get(BankATM.Cur_Usr).balance.rate.containsKey(input)){
                theCurrency = input;
                verifyLabel.setText("Ready to set your currency to "+ theCurrency);
                makeSetCurButton.setEnabled(true);
                CurrencyFrame.setVisible(false);
                return;
            }
            JOptionPane.showMessageDialog(null,"Invalid input. Try again.");
        }
    }
    class LoanFieldAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = lnumberField.getText();
            if( ! isInputOK(input) ) {
                JOptionPane.showMessageDialog(null,"Invalid input. Try again.");
                lnumberField.requestFocus();
                return;
            } // end if
            theAmount = Double.parseDouble(input);

            input = lcurrencyField.getText();
            if( !BankATM.accounts.get(BankATM.Cur_Usr).balance.rate.containsKey(input) ) {
                JOptionPane.showMessageDialog(null,"Invalid currency. Try again.");
                lcurrencyField.requestFocus();
                return;
            } // end if
            theCurrency = input;
            input = ltermField.getText();
            if( !isAllDigits(input) ) {
                JOptionPane.showMessageDialog(null,"Invalid term number. Try again.");
                ltermField.requestFocus();
                return;
            } // end if
            theTerm = Integer.parseInt(input);
            makeLoanButton.setEnabled(true);
            loanFrame.setVisible(false);
            mainFrame.setVisible(true);
            verifyLabel.setText("Loaning "+ theCurrency + " " + theAmount + " ,term: " + theTerm + " interest:" + cal_interest(theAmount,theTerm));

        } // end actionPerformed
    } // end TransferButtonAction

    public Double cal_interest(Double Val,int term_month){
        Double c = 2*Val;
        if(term_month<=3){
            c = Val*0.2;
        }
        else if(term_month <= 6){
            c = Val*0.45;
        }
        else if(term_month <= 12){
            c = Val;
        }
        return c;
    }

    class BalanceButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            numberField.requestFocus();
            drawBalance(outLabel,BankATM.accounts.get(BankATM.Cur_Usr));
        } // end actionPerformed
    } // end BalanceButtonAction

    class DepositButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            inputFrame.setVisible(true);
            numberField.setText("");
            currencyField.setText("");
            numberField.requestFocus();
            //makeDepositButton.setEnabled(true);
            DW = 0;
        } // end actionPerformed
    } // end DepositButtonAction

    class WithdrawButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            inputFrame.setVisible(true);
            numberField.setText("");
            currencyField.setText("");
            numberField.requestFocus();
            //transferButton.setEnabled(false);
            //makeWithdrawalButton.setEnabled(true);
            DW = 1;
        } // end actionPerformed
    } // end WithdrawButtonAction

    class TransferButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            transferFrame.setVisible(true);
            tnumberField.setText("");
            tcurrencyField.setText("");
            taccountField.setText("");
            tnumberField.requestFocus();
            //makeTransferButton.setEnabled(true);
        } // end actionPerformed
    } // end TransferButtonAction

    class SetCurButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CurrencyFrame.setVisible(true);
            currencyField.setText("");
            currencyField.requestFocus();
            //makeSetCurButton.setEnabled(true);
        } // end actionPerformed
    } // end TransferButtonAction

    class ViewTransButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Report report = new Report(BankATM.accounts.get(BankATM.Cur_Usr).transactions);
        } // end actionPerformed
    } // end TransferButtonAction

    class LoanButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            loanFrame.setVisible(true);
            lnumberField.setText("");
            lcurrencyField.setText("");
            ltermField.setText("");
            lnumberField.requestFocus();

            //makeLoanButton.setEnabled(true);
        } // end actionPerformed
    } // end LoanButtonAction

    class PayLoanButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(!BankATM.accounts.get(BankATM.Cur_Usr).hasLoan){
                JOptionPane.showMessageDialog(null, "Don't have loan.");
                return;
            }
            if(!BankATM.accounts.get(BankATM.Cur_Usr).payLoan()){
                JOptionPane.showMessageDialog(null, "Pay Loan failed! Check balance.");
                return;
            }
            JOptionPane.showMessageDialog(null, "Loan Paid!");
            BankATM.accounts.get(BankATM.Cur_Usr).transactions.add(new Transaction(BankATM.Cur_Usr,"BANK",new Currency(BankATM.accounts.get(BankATM.Cur_Usr).loan.currency.mergeCur(BankATM.accounts.get(BankATM.Cur_Usr).loan.interest)),new Currency(BankATM.accounts.get(BankATM.Cur_Usr).balance.get_Cur(),BankATM.accounts.get(BankATM.Cur_Usr).balance.get_lastCharge()),new Currency(BankATM.accounts.get(BankATM.Cur_Usr).balance),"Loan Paid"));
            outLabel.setText("Loan Paid");
        } // end actionPerformed
    } // end PayLoanButtonAction

    class ViewLoanButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(BankATM.accounts.get(BankATM.Cur_Usr).hasLoan)
                outLabel.setText("Loan: Currency:"+BankATM.accounts.get(BankATM.Cur_Usr).loan.currency.get_Cur()+" Amount:"
                        + BankATM.accounts.get(BankATM.Cur_Usr).loan.currency.get_val()
                        +" Term:"+BankATM.accounts.get(BankATM.Cur_Usr).loan.term_month + " month(s)"
                        +" Interest:"+BankATM.accounts.get(BankATM.Cur_Usr).loan.interest.get_val()+" Start Date:"
                        + BankATM.accounts.get(BankATM.Cur_Usr).loan.startDate.toString());
            else{
                outLabel.setText("Don't have Loan for now.");
            }
        } // end actionPerformed
    } // end ViewLoanButtonAction

    class MakeDepositButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            makeDepositButton.setEnabled(false);
            if(!BankATM.accounts.get(BankATM.Cur_Usr).balance.add_value(theCurrency,theAmount)) {
                JOptionPane.showMessageDialog(null, "Deposit failed.");
                return;
            }
            BankATM.accounts.get(BankATM.Cur_Usr).transactions.add(new Transaction("ATM",BankATM.Cur_Usr,new Currency(theCurrency,theAmount),new Currency(BankATM.accounts.get(BankATM.Cur_Usr).balance.get_Cur(),BankATM.accounts.get(BankATM.Cur_Usr).balance.get_lastCharge()),new Currency(BankATM.accounts.get(BankATM.Cur_Usr).balance),"Deposit."));
            JOptionPane.showMessageDialog(null, "Deposit succeeded.");
        } // end actionPerformed
    } // end MakeDepositButtonAction

    class MakeWithdrawalButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            makeWithdrawalButton.setEnabled(false);
            // add code here to make the withdrawal
            if(!BankATM.accounts.get(BankATM.Cur_Usr).balance.dec_value(theCurrency,theAmount)) {
                JOptionPane.showMessageDialog(null, "Withdrawal failed.");
                return;
            }
            BankATM.accounts.get(BankATM.Cur_Usr).transactions.add(new Transaction(BankATM.Cur_Usr,"ATM",new Currency(theCurrency,theAmount),new Currency(BankATM.accounts.get(BankATM.Cur_Usr).balance.get_Cur(),BankATM.accounts.get(BankATM.Cur_Usr).balance.get_lastCharge()),new Currency(BankATM.accounts.get(BankATM.Cur_Usr).balance),"Withdraw."));
            JOptionPane.showMessageDialog(null, "Withdrawal succeeded!");
        } // end actionPerformed
    } // end MakeWithDrawalButtonAction

    class MakeTransferButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            makeTransferButton.setEnabled(false);
            if(!BankATM.accounts.get(BankATM.Cur_Usr).balance.dec_value(theCurrency,theAmount)) {
                JOptionPane.showMessageDialog(null, "Don't have enough money.");
                return;
            }
            BankATM.accounts.get(theAccount).balance.add_value(theCurrency,theAmount);
            BankATM.accounts.get(BankATM.Cur_Usr).transactions.add(new Transaction(BankATM.Cur_Usr,theAccount,new Currency(theCurrency,theAmount),new Currency(BankATM.accounts.get(BankATM.Cur_Usr).balance.get_Cur(),BankATM.accounts.get(BankATM.Cur_Usr).balance.get_lastCharge()),new Currency(BankATM.accounts.get(BankATM.Cur_Usr).balance),"Transfer"));
            BankATM.accounts.get(theAccount).transactions.add(new Transaction(BankATM.Cur_Usr,theAccount,new Currency(theCurrency,theAmount),new Currency(BankATM.accounts.get(theAccount).balance.get_Cur(),BankATM.accounts.get(theAccount).balance.get_lastCharge()),new Currency(BankATM.accounts.get(theAccount).balance),"Transfer"));
            JOptionPane.showMessageDialog(null, "Transfer succeeded!");
        } // end actionPerformed
    } // end MakeTransferButtonAction

    class MakeSetCurButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            makeSetCurButton.setEnabled(false);
            BankATM.accounts.get(BankATM.Cur_Usr).balance.set_Cur(theCurrency);
            BankATM.accounts.get(BankATM.Cur_Usr).transactions.add(new Transaction(BankATM.Cur_Usr,BankATM.Cur_Usr,new Currency(theCurrency,BankATM.accounts.get(BankATM.Cur_Usr).balance.get_val()),new Currency(BankATM.accounts.get(BankATM.Cur_Usr).balance.get_Cur(),BankATM.accounts.get(BankATM.Cur_Usr).balance.get_lastCharge()),new Currency(BankATM.accounts.get(BankATM.Cur_Usr).balance),"Set Currency"));
            JOptionPane.showMessageDialog(null, "Currency set succeeded!");
        } // end actionPerformed
    } // end MakeSetCurButtonAction

    class MakeLoanButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            makeLoanButton.setEnabled(false);
            if(theTerm>60){
                JOptionPane.showMessageDialog(null, "Won't accept a term over 5 years.");
                return;
            }
            if(!BankATM.accounts.get(BankATM.Cur_Usr).set_loan(new Loan(BankATM.Cur_Usr,new Currency(theCurrency,theAmount),theTerm))) {
                JOptionPane.showMessageDialog(null, "You have unpaid loan! Loan rejected.");
                return;
            }
            BankATM.accounts.get(BankATM.Cur_Usr).balance.add_value(theCurrency,theAmount);
            BankATM.accounts.get(BankATM.Cur_Usr).transactions.add(new Transaction("BANK",BankATM.Cur_Usr,new Currency(theCurrency,theAmount),new Currency(BankATM.accounts.get(BankATM.Cur_Usr).balance.get_Cur(),BankATM.accounts.get(BankATM.Cur_Usr).balance.get_lastCharge()),new Currency(BankATM.accounts.get(BankATM.Cur_Usr).balance),"Loan"));
            JOptionPane.showMessageDialog(null, "Loan sent!");
        } // end actionPerformed
    } // end MakeWithDrawalButtonAction

    class FinishButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            outLabel.setText("");
            verifyLabel.setText("No Amount Entered");
            BankATM.frame2.dispose();
            //BankATM.frame2.setVisible(false);
            //BankATM.frame1.setVisible(true);
            BankATM.Cur_Usr = "";
            dispose();
            new GUI_ATM();
        } // end actionPerformed
    } // end FinishButtonAction

    boolean isInputOK(String input) {
        input = input.trim();
        if( input.equals("") ) {
            return false;
        } // end if
        int decimalIndex = input.indexOf(".");
        if( decimalIndex == -1 ) {
            return isAllDigits(input);
        } else {
            String first = input.substring(0,decimalIndex);
            String last = input.substring(decimalIndex+1);
            boolean firstAndLastAllDigits = isAllDigits(first) && isAllDigits(last);
            boolean lastlengthOK = last.length() == 2;
            return firstAndLastAllDigits && lastlengthOK;
        } // end if
    } // end is InputOK

    boolean isAllDigits(String input) {
        int index = 0;
        while( index < input.length() ) {
            if( ! Character.isDigit(input.charAt(index) ) ) {
                return false;
            } // end if
            index++;
        } // end while
        return true;
    } // end isAllDigits

    boolean isAmountOK(double amount)	 {
        if( amount <= 0.0 ) {
            JOptionPane.showMessageDialog(null, "Enter an Positive Amount First");
            return false;
        } // end if
        return true;
    } // isAmountOK

    void drawBalance(JLabel outLabel, Account account) {
        outLabel.setText("The balance is "+ account.balance.get_Cur() + " " + account.balance.get_val() );
    } // end drawBalance

}
