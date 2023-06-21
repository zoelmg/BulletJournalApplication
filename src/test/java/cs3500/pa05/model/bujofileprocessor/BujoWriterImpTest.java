package cs3500.pa05.model.bujofileprocessor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa05.model.BujoPageImp;
import cs3500.pa05.model.EventItem;
import cs3500.pa05.model.TaskItem;
import java.io.StringWriter;
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
            + "eek-day\":\"TUESDAY\",\"events\":[],\"tasks\":[]},{\"week-day\":\"WEDNESDAY\",\"e"
            + "vents\":[],\"tasks\":[]},{\"week-day\":\"THURSDAY\",\"events\":[],\"tasks\":[]},{\"w"
            + "eek-day\":\"FRIDAY\",\"events\":[],\"tasks\":[]},{\"week-day\":\"SATURDAY\",\"even"
            + "ts\":[],\"tasks\":[]},{\"week-day\":\"SUNDAY\",\"events\":[],\"tasks\":[]}],\"Week-N"
            + "ame\":\"Week Name\",\"quotebox\":{\"quotes\":[]},\"notebox\":{\"notes\":[]},\"maxEve"
            + "nts\":2,\"maxTasks\":2,\"password\":\"i love javadocs\"}",
        output.toString());
  }

  /**
   * Test that a changed bujo page is being serialized and written correctly in Json
   */
  @Test
  void testWriteChangedBujoFile() {
    bujoWriterImpChanged.writeBujoFile(bujoPageImpChanged);
    assertEquals("{\"Week\":[{\"week-day\":\"MONDAY\",\"events\":[],\"tasks\":[]},{\"wee"
            + "k-day\":\"TUESDAY\",\"events\":[{\"name\":\"ex Event\",\"description\":\"ex descript"
            + "ion\",\"start-time\":\"3pm\",\"duration\":\"2hour\"}],\"tasks\":[]},{\"week-d"
            + "ay\":\"W"
            + "EDNESDAY\",\"events\":[],\"tasks\":[{\"name\":\"ex Item\",\"description\":\"ex descr"
            + "iption\",\"completed\":false}]},{\"week-day\":\"THURSDAY\",\"events\":[],\"tasks\":"
            + "[]},{\"week-day\":\"FRIDAY\",\"events\":[],\"tasks\":[]},{\"week-day\":\"SATURDA"
            + "Y\",\"events\":[],\"tasks\":[]},{\"week-day\":\"SUNDAY\",\"events\":[],\"tasks\":"
            + "[]}],\"Week-Name\":\"test if week name changed\",\"quotebox\":{\"quotes\":[]},\"n"
            + "otebox\":{\"notes\":[]},\"maxEvents\":3,\"maxTasks\":4,\"password\":\"i love jav"
            + "adocs\"}",
        outputChanged.toString());
  }

  @Test
  void testInvalidAppendable() {
    assertThrows(IllegalArgumentException.class, () -> invalidWriter.writeBujoFile(bujoPageImp));
  }

}