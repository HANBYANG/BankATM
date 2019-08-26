public class Transaction {

    Date date;
    String FromUsr;
    String ToUsr;
    Currency value;
    Currency charge;
    Currency balanceLeft;
    String description;

    Transaction(String from, String to, Currency val, Currency cha,Currency bal,String description){
        this.date = new Date();
        this.FromUsr = from;
        this.ToUsr = to;
        this.value = val;
        this.charge = cha;
        this.balanceLeft = bal;
        this.description = description;
    }
}
