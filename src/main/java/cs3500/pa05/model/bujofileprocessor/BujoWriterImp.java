package cs3500.pa05.model.bujofileprocessor;

import com.fasterxml.jackson.databind.JsonNode;
import cs3500.pa05.model.BujoPage;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.EventItem;
import cs3500.pa05.model.TaskItem;
import cs3500.pa05.model.bujofileprocessor.json.BujoPageJson;
import cs3500.pa05.model.bujofileprocessor.json.DayJson;
import cs3500.pa05.model.bujofileprocessor.json.EventJson;
import cs3500.pa05.model.bujofileprocessor.json.JsonUtil;

import cs3500.pa05.model.bujofileprocessor.json.NoteBoxJson;
import cs3500.pa05.model.bujofileprocessor.json.QuoteBoxJson;
import cs3500.pa05.model.bujofileprocessor.json.TaskJson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of BujoWriter which writes in a .bujo file with given BujoPage
 */
public class BujoWriterImp implements BujoWriter {

  private final Appendable appendable;

  public BujoWriterImp(Appendable appendable) {
    this.appendable = appendable;
  }

  /**
   * Given the bujo page containing all information and the output .bujo file path,
   * write the bujo page info onto the .bujo file
   *
   * @param bujoPage the bujo page containing all information that will be stored in .bujo file
   */
  @Override
  public void writeBujoFile(BujoPage bujoPage) {
    JsonNode nodesToWrite = serializeBujoPage(bujoPage);
    String result = nodesToWrite.toString();

    try {
      appendable.append(result); // this may fail, hence the try-catch
    } catch (IOException e) {
      System.err.println("An error occurred when writing the sr file messages");
      throw new IllegalArgumentException(e.getMessage());
    }
  }

  /**
   * Turn a ujoPage into a BujoPageJson
   *
   * @param bujoPage the BujoPage to be serialized into a JsonNode
   * @return a serialized BujoJson
   */
  private JsonNode serializeBujoPage(BujoPage bujoPage) {
    //Form List<DayJson>
    List<DayJson> dayJsonList = new ArrayList<>();
    for (Day d : bujoPage.getBujoWeek()) {
      List<EventItem> events = d.getEvents();
      List<EventJson> eventJson = new ArrayList<>();
      for (EventItem e : events) {
        eventJson.add(new EventJson(e.getName(), e.getDescription(),
            e.getStartTime(), e.getDuration()));
      }

      List<TaskItem> tasks = d.getTasks();
      List<TaskJson> taskJson = new ArrayList<>();
      for (TaskItem t : tasks) {
        taskJson.add(new TaskJson(t.getName(), t.getDescription(), t.getIsComplete()));
      }

      DayJson nextDay = new DayJson(d.getDayOfWeek(), eventJson, taskJson);

      dayJsonList.add(nextDay);
    }

    ArrayList<String> quotes = new ArrayList<>();
    quotes.add("hi");
    QuoteBoxJson quoteBoxJson = new QuoteBoxJson(quotes);
    NoteBoxJson noteBoxJson = new NoteBoxJson(bujoPage.getNotes());

    BujoPageJson bujoPageJson = new BujoPageJson(dayJsonList, bujoPage.getWeekName(),
        quoteBoxJson, noteBoxJson, bujoPage.getMaxEvents(), bujoPage.getMaxTasks());


    JsonNode result = JsonUtil.serializeRecord(bujoPageJson);
    return result;
  }
}
