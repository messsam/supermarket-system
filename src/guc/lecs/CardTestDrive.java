package guc.lecs;

import org.junit.*;
import static org.junit.Assert.*;

public class CardTestDrive {
    @Test public void valentineTest() {
        Card vc = new ValentineCard("Sara");
        assertEquals("Love and Kisses.", vc.greetings());
    }
    @Test public void HolidayTest() {
        Card hc = new HolidayCard("Sara", Season.Summer);
        assertEquals("Summer's Greetings, Sara.", hc.greetings());
    }
    @Test public void birthdayTest() {
        Card bc = new BirthdayCard("Sara");
        assertEquals("Happy Birthday, Sara.", bc.greetings());
    }
}
