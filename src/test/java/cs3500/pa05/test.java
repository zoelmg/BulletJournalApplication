package cs3500.pa05;

import cs3500.pa05.model.BujoPageImp;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.EventItem;
import cs3500.pa05.model.TaskItem;
import cs3500.pa05.model.bujofileprocessor.BujoReader;
import cs3500.pa05.model.bujofileprocessor.BujoReaderImp;
import cs3500.pa05.model.bujofileprocessor.BujoWriterImp;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {
  BujoWriterImp bujoWriterImp;
  BujoWriterImp bujoWriterImp2;
  Appendable output;
  Appendable output2;
  BujoPageImp bujoPageImp;
  BujoPageImp bujoPageImp2;
  BujoReaderImp bujoReaderImp;
  Readable input;


  @BeforeEach
  void setup(){
    output = new StringWriter();
    output2 = new StringWriter();
    bujoWriterImp = new BujoWriterImp(output);
    bujoWriterImp2 = new BujoWriterImp(output2);
    bujoPageImp = new BujoPageImp();
    bujoPageImp2 = new BujoPageImp();
    List<Day> days = new ArrayList<>();
    Day day = new Day(DayOfWeek.FRIDAY);
    day.addItem(new TaskItem("blah", "blah", false));
    day.addItem(new EventItem("blah1", "blah2", "blah3", "blah4"));
    days.add(day);
    bujoPageImp2.setWeek(days);
    bujoPageImp2.setWeekName("friesDay");
    bujoPageImp2.setNotes(Arrays.asList("blah", "blah2"));
    bujoPageImp2.setQuotes(Arrays.asList("blah", "blah2"));
    input = new StringReader("{\\\"Week\\\":[{\\\"week-day\\\":\\\"FRIDAY\\\",\\\"\" +\n" +
        "        \"events\\\":[{\\\"name\\\":\\\"blah1\\\",\\\"description\\\":\\\"blah2\\\",\\\"start-time\\\":\\\"bl\" +\n" +
        "        \"ah3\\\",\\\"duration\\\":\\\"blah4\\\"}],\\\"tasks\\\":[]}],\\\"Week-Nam\" +\n" +
        "        \"e\\\":\\\"friesDay\\\",\\\"quotebox\\\":{\\\"quotes\\\":[\\\"hi\\\"]},\\\"notebox\\\"\" +\n" +
        "        \":{\\\"notes\\\":[\\\"blah\\\",\\\"blah2\\\"]}}");
    bujoReaderImp = new BujoReaderImp(input);
  }

  @Test
  void testWriteBujoFile(){
//    bujoWriterImp.writeBujoFile(bujoPageImp);
//    assertEquals(output.toString(), "{\"Week\":[{\"week-d" +
//        "ay\":\"MONDAY\",\"events\":[],\"tasks\":[]},{\"week-day\":\"TU" +
//        "ESDAY\",\"events\":[],\"tasks\":[]},{\"week-day\":\"WEDNESDAY\",\"e" +
//        "vents\":[],\"tasks\":[]},{\"week-day\":\"THURSDAY\",\"events\":[],\"ta" +
//        "sks\":[]},{\"week-day\":\"FRIDAY\",\"events\":[],\"tasks\":[]},{\"week-" +
//        "day\":\"SATURDAY\",\"events\":[],\"tasks\":[]},{\"week-day\":\"SUNDAY\",\"even" +
//        "ts\":[],\"tasks\":[]}],\"Week-Name\":\"Week Default Name\",\"quotebox\":{\"qu" +
//        "otes\":[\"hi\"]},\"notebox\":{\"notes\":[]}}");
//    bujoWriterImp2.writeBujoFile(bujoPageImp2);
//
//    assertEquals(output2.toString(), "{\"Week\":[{\"week-day\":\"FRIDAY\",\"" +
//        "events\":[{\"name\":\"blah1\",\"description\":\"blah2\",\"start-time\":\"bl" +
//        "ah3\",\"duration\":\"blah4\"}],\"tasks\":[]}],\"Week-Nam" +
//        "e\":\"friesDay\",\"quotebox\":{\"quotes\":[\"hi\"]},\"notebox\"" +
//        ":{\"notes\":[\"blah\",\"blah2\"]}}");
//
//    assertEquals(bujoReaderImp.readBujoFile(), bujoPageImp2);
  }



}
