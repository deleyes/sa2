package be.kdg.gson_controller.model;

public class BankAccount {
    private final String number;
    private final Customer customer;

    public BankAccount(String number, Customer customer) {
        this.number = number;
        this.customer = customer;
    }

    public String getNumber() {
        return number;
    }

    public Customer getCustomer() {
        return customer;
    }
}
