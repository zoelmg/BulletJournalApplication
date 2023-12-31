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

  private String password;

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
    this.weekName = "Week Name";
    this.maxEvents = 2;
    this.maxTasks = 2;
    this.password = "i love javadocs";
  }

  /**
   * set the week name
   *
   * @param userWantedName the name of the week that the user would like to give
   */
  public void setWeekname(String userWantedName) {
    this.weekName = weekName;
  }

  /**
   * get the list of days in the bujopage
   *
   * @return the list of days in the bujopage
   */
  @Override
  public List<Day> getBujoWeek() {
    return this.week;
  }

  /**
   * get the name of the week
   *
   * @return the name of the week
   */
  @Override
  public String getWeekName() {
    return this.weekName;
  }


  /**
   * get the notes in the bujopage
   *
   * @return the notes in the bujopage
   */
  @Override
  public List<String> getNotes() {
    return this.notes;
  }

  /**
   * get the quotes in the bujopage
   *
   * @return the quotes in the bujoPage
   */
  @Override
  public List<String> getQuotes() {
    return this.quotes;
  }


  /**
   * set the days in the bujo page
   *
   * @param week the days in the bujo page
   */
  @Override
  public void setWeek(List<Day> week) {
    this.week = week;
  }


  /**
   * set the weekname in the bujo page
   *
   * @param weekName he weekname in the bujo page
   */
  @Override
  public void setWeekName(String weekName) {
    this.weekName = weekName;
  }


  /**
   * set the quotes in the bujo page
   *
   * @param quotes the quotes in the bujo page
   */
  @Override
  public void setQuotes(List<String> quotes) {
    this.quotes = quotes;
  }


  /**
   * set the notes in the bujo page
   *
   * @param notes notes in the bujo page
   */
  @Override
  public void setNotes(List<String> notes) {
    this.notes = notes;
  }


  /**
   * get the maximum events allowed in the bujo page
   *
   * @return the maximum events allowed in the bujo page
   */
  @Override
  public int getMaxEvents() {
    return this.maxEvents;
  }

  /**
   * get the maximum tasks allowed in the bujo page
   *
   * @return the maximum tasks allowed in the bujo page
   */
  @Override
  public int getMaxTasks() {
    return maxTasks;
  }


  /**
   * set the maximum events allowed in the bujo page
   *
   * @param n the maximum events allowed in the bujo page
   */
  @Override
  public void setMaxEvents(int n) {
    this.maxEvents = n;
  }

  /**
   * set the maximum tasks allowed in the bujo page
   *
   * @param n the maximum tasks allowed in the bujo page
   */
  @Override
  public void setMaxTasks(int n) {
    this.maxTasks = n;
  }

  /**
   * Returns the passsword of the bujoPage
   *
   * @return the password of the bujoPage
   */
  @Override
  public String getPassword() {
    return this.password;
  }

  /**
   * set the password for this bujopage
   *
   * @param password the password for this bujoPage
   */
  @Override
  public void setPassword(String password) {
    this.password = password;
  }

}
