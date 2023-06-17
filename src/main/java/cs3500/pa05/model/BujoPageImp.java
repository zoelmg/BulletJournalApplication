package cs3500.pa05.model;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

/**
 * Represent a Weekly Bujo Page
 */
public class BujoPageImp implements BujoPage {
  private List<Day> week;
  private String weekName;
  private List<String> quotes;
  private List<String> notes;
  private int maxEvents;
  private int maxTasks;

  /**
   * Instantiate a default BujoPageImp with default week and week name
   */
  public BujoPageImp() {
    this.week = new ArrayList<>();
    this.quotes = new ArrayList<>();
    this.notes = new ArrayList<>();
    this.week.add(new Day(DayOfWeek.MONDAY));
    this.week.add(new Day(DayOfWeek.TUESDAY));
    this.week.add(new Day(DayOfWeek.WEDNESDAY));
    this.week.add(new Day(DayOfWeek.THURSDAY));
    this.week.add(new Day(DayOfWeek.FRIDAY));
    this.week.add(new Day(DayOfWeek.SATURDAY));
    this.week.add(new Day(DayOfWeek.SUNDAY));
    this.weekName = "Week Default Name";
    this.maxEvents = 2;
    this.maxTasks = 2;
  }

  /**
   * set the week name
   *
   * @param userWantedName the name of the week that the user would like to give
   */
  public void setWeekname(String userWantedName) {
    this.weekName = weekName;
  }

  public List<Day> getBujoWeek() {
    return this.week;
  }

  public String getWeekName() {
    return this.weekName;
  }

  public List<String> getNotes() {
    return this.notes;
  }

  public List<String> getQuotes() {
    return this.quotes;
  }

  public void setWeek(List<Day> week) {
    this.week = week;
  }

  public void setWeekName(String weekName) {
    this.weekName = weekName;
  }

  public void setQuotes(List<String> quotes) {
    this.quotes = quotes;
  }

  public void setNotes(List<String> notes) {
    this.notes = notes;
  }

  public boolean hasTaskCapacity(DayOfWeek day) {
    Day wantedDay = this.week.get(0);
    for (Day d : this.week) {
      if (d.getDayOfWeek() == day) {
        wantedDay = d;
      }
    }
    return this.maxTasks > wantedDay.getTasks().size();
  }

  public boolean hasEventCapacity(DayOfWeek day) {
    Day wantedDay = this.week.get(0);
    for (Day d : this.week) {
      if (d.getDayOfWeek() == day) {
        wantedDay = d;
      }
    }
    return this.maxEvents > wantedDay.getEvents().size();
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
