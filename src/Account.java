import java.util.ArrayList;
import java.util.List;

abstract class Account {
    String password;
    String username;

    Currency balance;
    public boolean hasLoan;
    public Loan loan;
    List<Transaction> transactions;
    public Account(){
        this.username = "";
        this.password = "";
        this.hasLoan = false;
        transactions = new ArrayList<Transaction>();
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    boolean set_loan(Loan l){
        if(!hasLoan){
            loan = l;
            hasLoan = true;
            return true;
        }
        return false;
    }

    public boolean payLoan(){
        if(hasLoan && balance.dec_value(loan.currency.get_Cur(),loan.currency.get_val()+loan.interest.get_val())){
            loan.payLoan();
            hasLoan = false;
            return true;
        }
        return false;
    }

}
