package guc.lecs;

public class HolidayCard extends Card {
    Season season;

    public HolidayCard(String recipient, Season season) {
        super(recipient);
        this.season = season;
    }
    public HolidayCard(String recipient, String season) {
        super(recipient);
        try {
            this.season = Season.valueOf(season);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("Invalid input.");
        }
    }

    public String greetings() {
        return season + "'s Greetings, " + recipient + ".";
    }
}