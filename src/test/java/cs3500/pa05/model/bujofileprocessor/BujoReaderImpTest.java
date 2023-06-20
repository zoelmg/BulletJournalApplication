package cs3500.pa05.model.bujofileprocessor;

import static org.junit.jupiter.api.Assertions.*;

import cs3500.pa05.model.BujoPage;
import cs3500.pa05.model.BujoPageImp;
import java.io.StringReader;
import java.util.ArrayList;
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
    String string1 = "{\"Week\":[{\"week-day\":\"MONDAY\",\"events\"" +
        ":[],\"tasks\":[]},{\"week-day\":\"TUESDAY\",\"events\":[],\"tasks\":[]},{\"week-day\":\"WEDNESDAY\","
        + "\"events\":[],\"tasks\":[]},{\"week-day\":\"THURSDAY\",\"events\":[],\"tasks\":[]},{\"week-day\":\"FRIDAY\""
        + ",\"events\":[],\"tasks\":[]},{\"week-day\":\"SATURDAY\",\"events\":[],\"tasks\":[]},{\"week-day\":\""
        + "SUNDAY\",\"events\":[],\"tasks\":[]}],\"Week-Name\":\"test2\",\"quotebox\":{\"quotes\":[]},\"notebox"
        + "\":{\"notes\":[]},\"maxEvents\":4,\"maxTasks\":2}";
    readable1 = new StringReader(string1);
    reader1 = new BujoReaderImp(readable1);
  }

  /**
   * Tests that the BujoReaderImp can rad a .bujo format file and produce the correct BujoPage object
   */
  @Test
  void testReadBujoFile() {
    BujoPage actualPage = reader1.readBujoFile();
    assertEquals(4, actualPage.getMaxEvents());
    assertEquals(2, actualPage.getMaxTasks());
    assertEquals("test2", actualPage.getWeekName());
    assertEquals(new ArrayList<>(), actualPage.getQuotes());
    assertEquals(new ArrayList<>(), actualPage.getNotes());
  }

}