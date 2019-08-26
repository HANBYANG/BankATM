public class Checking_Account extends Account {
    public Checking_Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = new Currency();
    }
}
