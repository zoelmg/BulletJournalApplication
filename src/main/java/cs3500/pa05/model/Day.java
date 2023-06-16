package cs3500.pa05.model;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Day {

  private DayOfWeek dayOfWeek;
  private List<EventItem> events;
  private List<TaskItem> tasks;
  private int maxEvents;
  private int maxTasks;

  public Day(DayOfWeek dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
    this.events = new ArrayList<>();
    this.tasks = new ArrayList<>();
    this.maxEvents = 3;
    this.maxTasks = 3;
  }

  /**
   * @param task is TaskItem object to be added to this day
   */
  public void addItem(TaskItem task) {
    this.tasks.add(task);
  }

  /**
   * @param event is EventItem object to be added to this day
   */
  public void addItem(EventItem event) {
    this.events.add(event);
  }

  /**
   * @param task is TaskItem object to be removed from this day
   */
  public void removeItem(TaskItem task) {
    this.tasks.remove(task);
  }

  /**
   * @param event is EventItem object to be removed from this day
   */
  public void removeItem(EventItem event) {
    this.events.remove(event);
  }

}
