package cs3500.pa05.model;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

/**
 * A day on the bujo board
 */
public class Day {

  private DayOfWeek dayOfWeek;
  private List<EventItem> events;
  private List<TaskItem> tasks;

  /**
   * Initializing a default day
   *
   * @param dayOfWeek the week day that this day is
   */
  public Day(DayOfWeek dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
    this.events = new ArrayList<>();
    this.tasks = new ArrayList<>();
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

  /**
   * @return the day of week
   */
  public DayOfWeek getDayOfWeek() {
    return dayOfWeek;
  }

  /**
   * @return the list of events for this day
   */
  public List<EventItem> getEvents() {
    return events;
  }

  /**
   * @return the list of tasks for this day
   */
  public List<TaskItem> getTasks() {
    return tasks;
  }


}
