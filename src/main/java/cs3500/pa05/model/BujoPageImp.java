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

  @Override
  /**
   * get the list of days in the bujopage
   * @return the list of days in the bujopage
   */
  public List<Day> getBujoWeek() {
    return this.week;
  }

  @Override
  /**
   * get the name of the week
   * @return the name of the week
   */
  public String getWeekName() {
    return this.weekName;
  }

  @Override
  /**
   * get the notes in the bujopage
   * @return the notes in the bujopage
   */
  public List<String> getNotes() {
    return this.notes;
  }

  @Override
  /**
   * get the quotes in the bujopage
   * @return the quotes in the bujoPage
   */
  public List<String> getQuotes() {
    return this.quotes;
  }

  @Override
  /**
   * set the days in the bujo page
   * @param week the days in the bujo page
   */
  public void setWeek(List<Day> week) {
    this.week = week;
  }

  @Override
  /**
   * set the weekname in the bujo page
   * @param weekName he weekname in the bujo page
   */
  public void setWeekName(String weekName) {
    this.weekName = weekName;
  }

  @Override
  /**
   * set the quotes in the bujo page
   * @param quotes the quotes in the bujo page
   */
  public void setQuotes(List<String> quotes) {
    this.quotes = quotes;
  }

  @Override
  /**
   * set the notes in the bujo page
   * @param notes notes in the bujo page
   */
  public void setNotes(List<String> notes) {
    this.notes = notes;
  }

  /**
   * Does the day have more task capacity?
   *
   * @param day the day of the week
   * @return if the day have more task capacity
   */
  public boolean hasTaskCapacity(DayOfWeek day) {
    Day wantedDay = this.week.get(0);
    for (Day d : this.week) {
      if (d.getDayOfWeek() == day) {
        wantedDay = d;
      }
    }
    return this.maxTasks > wantedDay.getTasks().size();
  }

  /**
   * Does the day have more event capacity?
   *
   * @param day the day of the week
   * @return if the day have more event capacity
   */
  public boolean hasEventCapacity(DayOfWeek day) {
    Day wantedDay = this.week.get(0);
    for (Day d : this.week) {
      if (d.getDayOfWeek() == day) {
        wantedDay = d;
      }
    }
    return this.maxEvents > wantedDay.getEvents().size();
  }

  @Override
  /**
   * get the maximum events allowed in the bujo page
   * @return the maximum events allowed in the bujo page
   */
  public int getMaxEvents() {
    return this.maxEvents;
  }

  @Override
  /**
   * get the maximum tasks allowed in the bujo page
   * @return the maximum tasks allowed in the bujo page
   */
  public int getMaxTasks() {
    return maxTasks;
  }

  @Override
  /**
   * set the maximum events allowed in the bujo page
   * @param n the maximum events allowed in the bujo page
   */
  public void setMaxEvents(int n) {
    this.maxEvents = n;
  }

  @Override
  /**
   * set the maximum tasks allowed in the bujo page
   * @param n the maximum tasks allowed in the bujo page
   */
  public void setMaxTasks(int n) {
    this.maxTasks = n;
  }

}
