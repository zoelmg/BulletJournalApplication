package cs3500.pa05.model.bujofileprocessor;

import static org.junit.jupiter.api.Assertions.*;

import cs3500.pa05.model.BujoPageImp;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.EventItem;
import cs3500.pa05.model.TaskItem;
import java.io.StringReader;
import java.io.StringWriter;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test methods related to BujoWriter
 */
class BujoWriterImpTest {

  BujoWriterImp bujoWriterImp;
  BujoWriterImp bujoWriterImpChanged;
  BujoWriterImp invalidWriter;
  Appendable invalidAppendable;
  Appendable output;
  Appendable outputChanged;
  BujoPageImp bujoPageImp;
  BujoPageImp bujoPageImpChanged;


  /**
   * Set up required for testing Bujo Writer
   */
  @BeforeEach
  void setup() {
    output = new StringWriter();
    outputChanged = new StringWriter();
    invalidAppendable = new MockAppendable();
    invalidWriter = new BujoWriterImp(invalidAppendable);
    bujoWriterImp = new BujoWriterImp(output);
    bujoWriterImpChanged = new BujoWriterImp(outputChanged);
    bujoPageImp = new BujoPageImp();
    bujoPageImpChanged = new BujoPageImp();
    bujoPageImpChanged.setWeekName("test if week name changed");
    bujoPageImpChanged.setMaxTasks(4);
    bujoPageImpChanged.setMaxEvents(3);
    EventItem exEvent = new EventItem("ex Event", "ex description",
        "3pm", "2hour");
    TaskItem exItem = new TaskItem("ex Item", "ex description");
    bujoPageImpChanged.getBujoWeek().get(1).addItem(exEvent);
    bujoPageImpChanged.getBujoWeek().get(2).addItem(exItem);
  }

  /**
   * Test that a default bujo Page is being serialized and written correctly in Json
   */
  @Test
  void testDefaultWriteBujoFile() {
    bujoWriterImp.writeBujoFile(bujoPageImp);
    assertEquals("{\"Week\":[{\"week-day\":\"MONDAY\",\"events\":[],\"tasks\":[]},{\"w"
            + "eek-day\":\"TUESDAY\",\"events\":[],\"tasks\":[]},{\"week-day\":\"WEDNESDAY\",\"ev"
            + "ents\":[],\"tasks\":[]},{\"week-day\":\"THURSDAY\",\"events\":[],\"tasks\":[]},{\"w"
            + "eek-day\":\"FRIDAY\",\"events\":[],\"tasks\":[]},{\"week-day\":\"SATURDAY\",\"ev"
            + "ents\":[],\"tasks\":[]},{\"week-day\":\"SUNDAY\",\"events\":[],\"tasks\":[]}],\"W"
            + "eek-Name\":\"Week Name\",\"quotebox\":{\"quotes\":[]},\"notebox\":{\"notes\":[]}"
            + ",\"maxEvents\":2,\"maxTasks\":2}",
        output.toString());
  }

  /**
   * Test that a changed bujo page is being serialized and written correctly in Json
   */
  @Test
  void testWriteChangedBujoFile() {
  bujoWriterImpChanged.writeBujoFile(bujoPageImpChanged);
  assertEquals("{\"Week\":[{\"week-day\":\"MONDAY\",\"events\":[],\"tasks\":[]},{\"we"
          + "ek-day\":\"TUESDAY\",\"events\":[{\"name\":\"ex Event\",\"description\":\"ex des"
          + "cription\",\"start-time\":\"3pm\",\"duration\":\"2hour\"}],\"tasks\":[]},{\"week"
          + "-day\":\"WEDNESDAY\",\"events\":[],\"tasks\":[{\"name\":\"ex Item\",\"descripti"
          + "on\":\"ex description\",\"completed\":false}]},{\"week-day\":\"THURSDAY\",\"event"
          + "s\":[],\"tasks\":[]},{\"week-day\":\"FRIDAY\",\"events\":[],\"tasks\":[]},{\"week-"
          + "day\":\"SATURDAY\",\"events\":[],\"tasks\":[]},{\"week-day\":\"SUNDAY\",\"events\":["
          + "],\"tasks\":[]}],\"Week-Name\":\"test if week name changed\",\"quotebox\":{\"quote"
          + "s\":[]},\"notebox\":{\"notes\":[]},\"maxEvents\":3,\"maxTasks\":4}",
      outputChanged.toString());
  }

  @Test
  void testInvalidAppendable() {
    assertThrows(IllegalArgumentException.class, () -> invalidWriter.writeBujoFile(bujoPageImp));
  }

}