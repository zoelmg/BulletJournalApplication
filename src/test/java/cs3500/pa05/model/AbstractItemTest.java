package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.*;

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
    System.out.println(eventItem.getValidLinks());
  }

}