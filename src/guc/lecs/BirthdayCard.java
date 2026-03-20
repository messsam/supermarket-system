package guc.lecs;

public class BirthdayCard extends Card {
    public BirthdayCard(String recipient) {
        super(recipient);
    }

    public String greetings() {
        return "Happy Birthday, " + recipient + ".";
    }
}