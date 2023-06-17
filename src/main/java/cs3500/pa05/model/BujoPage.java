package cs3500.pa05.model;

import java.util.List;

public interface BujoPage {

  List<Day> getBujoWeek();

  String getWeekName();

  List<String> getQuotes();

  List<String> getNotes();

  void setWeek(List<Day> week);

  void setWeekName(String weekName);

  void setQuotes(List<String> quotes);

  void setNotes(List<String> notes);

  int getMaxEvents();

  int getMaxTasks();

  void setMaxEvents(int n);

  void setMaxTasks(int n);

}
