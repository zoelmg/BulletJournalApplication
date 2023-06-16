package cs3500.pa05.model.bujofileprocessor;

import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.model.BujoPage;
import cs3500.pa05.model.BujoPageImp;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.EventItem;
import cs3500.pa05.model.TaskItem;
import cs3500.pa05.model.bujofileprocessor.json.BujoPageJson;
import cs3500.pa05.model.bujofileprocessor.json.DayJson;
import cs3500.pa05.model.bujofileprocessor.json.EventJson;
import cs3500.pa05.model.bujofileprocessor.json.JsonUtil;
import cs3500.pa05.model.bujofileprocessor.json.TaskJson;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import javafx.scene.control.Button;
import com.fasterxml.jackson.core.JsonParser;

/**
 * An implementation of BujoReader which reads and process a .bujo file
 */
public class BujoReaderImp implements BujoReader{
  private final Readable readable;
  private final ObjectMapper mapper;

  public BujoReaderImp(Readable readable) {
    this.readable = Objects.requireNonNull(readable);
    this.mapper = new ObjectMapper();
  }
  /**
   * Reads, process, and extract a .bujo file into a BujoPage
   *
   * @return the information within the file as a BujoBoard
   */
  @Override
  public BujoPage readBujoFile() {
    BujoPageImp result = new BujoPageImp();
    JsonParser parser = null;
    try {
      parser = this.mapper.getFactory().createParser(this.read());
      BujoPageJson bujoPageJson = parser.readValueAs(BujoPageJson.class);
      ArrayList<Day> days = new ArrayList<Day>();
      for(DayJson dayJson: bujoPageJson.week()){
        Day day = new Day(dayJson.weekday());
        day.setMaxEvents(dayJson.maxEvents());
        day.setMaxTasks(day.getMaxTasks());

        for(EventJson eventJson: dayJson.events()){
          EventItem newEvent = new EventItem(eventJson.name(),
              eventJson.description(), eventJson.startTime(), eventJson.duration());
          day.addItem(newEvent);
        }
        for(TaskJson taskJson: dayJson.tasks()){
          TaskItem newTask = new TaskItem(taskJson.name(), taskJson.description(), taskJson.isCompleted());
          day.addItem(newTask);
        }

       days.add(day);
      }

      result.setWeek(days);
      result.setQuotes(bujoPageJson.quotebox().quotes());
      result.setWeekName(bujoPageJson.weekName());
      result.setNotes(bujoPageJson.notebox().notes());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return result;
  }

  // Constructor


  /**
   * read sr files
   * @return the contents of the file
   */
  public String read() {
    Scanner scanner = new Scanner(readable);
    StringBuilder output = new StringBuilder();
    while (scanner.hasNextLine()) {
      output.append(scanner.nextLine());
      output.append("\n");
    }
    return output.toString();
  }
}
