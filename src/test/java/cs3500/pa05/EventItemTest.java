package cs3500.pa05;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.EventItem;
import jdk.jfr.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EventItemTest {
   EventItem eventItem;
   @BeforeEach
  void setup(){
     eventItem = new EventItem("blah",
         "blah https://www.google.com blah " +
             "https://yahoo.com", "blah", "blah");
   }

   @Test
  void testGetValidLinks(){
     System.out.println(eventItem.getValidLinks());
   }

}
