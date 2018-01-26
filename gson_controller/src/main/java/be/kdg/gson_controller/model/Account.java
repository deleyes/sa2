package be.kdg.gson_controller.model;

public class Account {
    private final String number;
    private final Client client;

    public Account(String number, Client client) {
        this.number = number;
        this.client = client;
    }

    public String getNumber() {
        return number;
    }

    public Client getClient() {
        return client;
    }
}
