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
  BujoWriterImp bujoWriterImp2;
  Appendable output;
  Appendable output2;
  BujoPageImp bujoPageImp;
  BujoPageImp bujoPageImpChanged;


  /**
   * Set up required for testing Bujo Writer
   */
  @BeforeEach
  void setup() {
    output = new StringWriter();
    output2 = new StringWriter();
    bujoWriterImp = new BujoWriterImp(output);
    bujoWriterImp2 = new BujoWriterImp(output2);
    bujoPageImp = new BujoPageImp();
    bujoPageImpChanged = new BujoPageImp();
    bujoPageImpChanged.setWeekName("test if week name changed");
    bujoPageImpChanged.setMaxTasks(4);
    bujoPageImpChanged.setMaxEvents(3);
  }

  /**
   * Test that a default bujo Page is being serialized and written correctly in Json
   */
  @Test
  void testDefaultWriteBujoFile() {
    bujoWriterImp2.writeBujoFile(bujoPageImp);
    assertEquals("{\"Week\":[{\"week-day\":\"MONDAY\",\"events\":[],\"tasks\":[]" +
        "},{\"week-day\":\"TUESDAY\",\"events\":[],\"tasks\":[]},{\"week-day\":\"WEDNESDA" +
        "Y\",\"events\":[],\"tasks\":[]},{\"week-day\":\"THURSDAY\",\"events\":[],\"task" +
        "s\":[]},{\"week-day\":\"FRIDAY\",\"events\":[],\"tasks\":[]},{\"week-day\":\"SATUR" +
        "DAY\",\"events\":[],\"tasks\":[]},{\"week-day\":\"SUNDAY\",\"events\":[],\"tasks\":[" +
        "]}],\"Week-Name\":\"Week Name\",\"quotebox\":{\"quotes\":[\"hi\"]},\"notebox\":{\"not" +
        "es\":[]},\"maxEvents\":2,\"maxTasks\":2}", output2.toString());
  }
  /**
   * Test that a changed bujo page is being serialized and written correctly in Json
   */
  @Test
  void testWriteChangedBujoFile() {
  bujoWriterImp.writeBujoFile(bujoPageImpChanged);
  assertEquals("{\"Week\":[{\"week-day\":\"MONDAY\",\"events\":[],\"tasks\":[]},{\"week" +
          "-day\":\"TUESDAY\",\"events\":[],\"tasks\":[]},{\"week-day\":\"WEDNESDAY\",\"events" +
          "\":[],\"tasks\":[]},{\"week-day\":\"THURSDAY\",\"events\":[],\"tasks\":[]},{\"week-" +
          "day\":\"FRIDAY\",\"events\":[],\"tasks\":[]},{\"week-day\":\"SATURDAY\",\"events\":" +
          "[],\"tasks\":[]},{\"week-day\":\"SUNDAY\",\"events\":[],\"tasks\":[]}],\"Week-Nam" +
          "e\":\"test if week name changed\",\"quotebox\":{\"quotes\":[\"hi\"]},\"notebox\":{\"n" +
          "otes\":[]},\"maxEvents\":3,\"maxTasks\":4}",
      output.toString());
  }

}