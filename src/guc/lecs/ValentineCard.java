package guc.lecs;

public class ValentineCard extends Card {
    public ValentineCard(String recipient) {
        super(recipient);
    }

    public String greetings() {
        return "Love and Kisses.";
    }
}