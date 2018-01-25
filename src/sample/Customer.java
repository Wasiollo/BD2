package sample;

public class Customer {

    public String login;

    public String cust_id;

    public Boolean logged;

    public Customer(String l, String id, Boolean logged) {
        this.login = l;
        this.cust_id = id;
        this.logged = logged;
    }

    public Customer() {
        this.login = "";
        this.cust_id = "";
        this.logged = false;
    }
}
