package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test methods related to Abstract Item
 */
class AbstractItemTest {

  EventItem eventItem;

  @BeforeEach
  void setup() {
    eventItem = new EventItem("blah",
        "blah https://www.google.com blah "
            + "https://yahoo.com", "blah", "blah");
  }

  @Test
  void testGetValidLinks() {
    assertEquals("https://www.google.com", eventItem.getValidLinks().get(0));
    assertEquals("https://yahoo.com", eventItem.getValidLinks().get(1));
    assertEquals(2, eventItem.getValidLinks().size());
  }

  @Test
  void testValidLinks2() {
    EventItem eventItem2 = new EventItem("name", "", "start time", "duration");
   List<String> expected = eventItem2.getValidLinks();
   assertEquals(expected.size(), 0);
  }

}