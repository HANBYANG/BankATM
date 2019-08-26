public class Saving_Account extends Account {
    public Saving_Account(String username,String password){
        this.username = username;
        this.password = password;
        this.balance = new Currency();
    }
}
