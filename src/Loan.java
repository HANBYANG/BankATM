
public class Loan {
    public String username;
    public Currency currency;
    public Date startDate;
    public int term_month;
    public Currency interest;
    public boolean paied;
    public Loan(String username,Currency currency,int term_month){
        this.startDate = new Date();
        this.username = username;
        this.currency = currency;
        this.term_month = term_month;
        this.interest = new Currency(currency.get_Cur(),cal_interest(currency.get_val(),term_month));

    }
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

    public void payLoan(){
        paied = true;
    }
}
