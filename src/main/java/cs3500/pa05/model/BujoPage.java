package cs3500.pa05.model;

import java.util.List;

/**
 * The interface for a bujo page. The bujo page contains all the data represented
 * in the bujo file.
 */
public interface BujoPage {

  /**
   * get the list of days in the bujopage
   *
   * @return the list of days in the bujopage
   */
  List<Day> getBujoWeek();

  /**
   * get the name of the week
   *
   * @return the name of the week
   */
  String getWeekName();

  /**
   * get the quotes in the bujopage
   *
   * @return the quotes in the bujoPage
   */
  List<String> getQuotes();

  /**
   * get the notes in the bujopage
   *
   * @return the notes in the bujopage
   */
  List<String> getNotes();

  /**
   * set the days in the bujo page
   *
   * @param week the days in the bujo page
   */
  void setWeek(List<Day> week);

  /**
   * set the weekname in the bujo page
   *
   * @param weekName he weekname in the bujo page
   */
  void setWeekName(String weekName);

  /**
   * set the quotes in the bujo page
   *
   * @param quotes the quotes in the bujo page
   */
  void setQuotes(List<String> quotes);

  /**
   * set the notes in the bujo page
   *
   * @param notes the notes in the bujo page
   */
  void setNotes(List<String> notes);

  /**
   * get the maximum events allowed in the bujo page
   *
   * @return the maximum events allowed in the bujo page
   */
  int getMaxEvents();

  /**
   * get the maximum tasks allowed in the bujo page
   *
   * @return the maximum tasks allowed in the bujo page
   */
  int getMaxTasks();

  /**
   * set the maximum events allowed in the bujo page
   *
   * @param n the maximum events allowed in the bujo page
   */
  void setMaxEvents(int n);

  /**
   * set the maximum tasks allowed in the bujo page
   *
   * @param n the maximum tasks allowed in the bujo page
   */
  void setMaxTasks(int n);


}
