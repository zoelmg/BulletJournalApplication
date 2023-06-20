package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test methods related to Abstract Item
 */
class AbstractItemTest {

  EventItem eventItem;

  /**
   * Set up a valid EventItem
   */
  @BeforeEach
  void setup() {
    eventItem = new EventItem("blah",
        "blah https://www.google.com blah "
            + "https://yahoo.com", "blah", "blah");
  }

  /**
   * Test an event item that has a description containing two valid links
   * and getValidLinks is correctly returning them in a list
   */
  @Test
  void testGetValidLinks() {
    assertEquals("https://www.google.com", eventItem.getValidLinks().get(0));
    assertEquals("https://yahoo.com", eventItem.getValidLinks().get(1));
    assertEquals(2, eventItem.getValidLinks().size());
  }

  /**
   * Test that nothing will be added to valid link if there are no valid links in the description
   */
  @Test
  void testValidLinks2() {
    EventItem eventItem2 = new EventItem("name", "",
        "start time", "duration");
    List<String> expected = eventItem2.getValidLinks();
    assertEquals(expected.size(), 0);
  }

}