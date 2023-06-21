package cs3500.pa05.model.bujofileprocessor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa05.model.BujoPage;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test methods related to the BujoReader
 */
class BujoReaderImpTest {

  BujoReaderImp reader1;
  Readable readable1;

  /**
   * Sets up the Readable and BujoReaderImp objects before each test.
   */
  @BeforeEach
  void setup() {
    String string1 = "{\"Week\":[{\"week-day\":\"MONDAY\",\"events\""
        + ":[],\"tasks\":[]},{\"week-day\":\"TUESDAY\",\"events\":[{\"name\":\"ex Even"
        + "t\",\"description\":"
        + "\"ex description\",\"start-time\":\"3pm\",\"duration\":\"2hour\"}],\"task"
        + "s\":[{\"name\":\"ex Item"
        + "\",\"description\":"
        + "\"ex description\",\"completed\":false}]},{\"week-day\":\"WEDNESDAY\","
        + "\"events\":[],\"tasks\":[]},{\"week-day\":\"THURSDAY\",\"events\":[],\"tasks\":["
        + "]},{\"week-day\":\"FRIDAY\""
        + ",\"events\":[],\"tasks\":[]},{\"week-day\":\"SATURDAY\",\"events\":[],\"tasks\":["
        + "]},{\"week-day\":\""
        + "SUNDAY\",\"events\":[],\"tasks\":[]}],\"Week-Name\":\"test2\",\"quotebox\":{\"quot"
        + "es\":[\"hi\"]},\"notebox"
        + "\":{\"notes\":[\"hi\"]},\"maxEvents\":4,\"maxTasks\":2,\"password\":\"i love jav"
        + "adocs\"}";
    readable1 = new StringReader(string1);
    reader1 = new BujoReaderImp(readable1);
  }

  /**
   * Tests that the BujoReaderImp can rad a .bujo format file and
   * produce the correct BujoPage object
   */
  @Test
  void testReadBujoFile() {
    BujoPage actualPage = reader1.readBujoFile();
    assertEquals(4, actualPage.getMaxEvents());
    assertEquals(2, actualPage.getMaxTasks());
    assertEquals("test2", actualPage.getWeekName());
    List<String> quotesNotes = new ArrayList<>();
    quotesNotes.add("hi");
    assertEquals(quotesNotes, actualPage.getQuotes());
    assertEquals(quotesNotes, actualPage.getNotes());
  }

  @Test
  void testReadBujoFileException() {
    String string2 = "";
    BujoReader reader2 = new BujoReaderImp(new StringReader(string2));
    assertThrows(RuntimeException.class, () -> reader2.readBujoFile());
  }

}