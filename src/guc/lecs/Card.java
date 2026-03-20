package guc.lecs;

public abstract class Card {
    String recipient;

    public Card(String recipient) {
        this.recipient = recipient;
    }

    protected abstract String greetings();
}