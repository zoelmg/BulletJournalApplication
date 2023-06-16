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
    this.maxEvents = 0;
    this.maxTasks = 1;
  }

  /**
   * @param task is TaskItem object to be added to this day
   */
  public void addItem(TaskItem task) {
    System.out.println(task.getName());
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
   *
   * @return the list of tasks for this day
   */
  public List<TaskItem> getTasks() {
    return tasks;
  }

  public int getMaxEvents() { return this.maxEvents; }

  public int getMaxTasks() {
    return maxTasks;
  }

  public void setMaxEvents(int n) {
    this.maxEvents = n;
  }

  public void setMaxTasks(int n) {
    this.maxTasks = n;
  }

}
