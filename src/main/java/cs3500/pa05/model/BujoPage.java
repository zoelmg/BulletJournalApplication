package cs3500.pa05.model;

import java.util.List;

public interface BujoPage {

  List<Day> getBujoWeek();

  String getWeekName();

  List<String> getQuotes();

  List<String> getNotes();
}
