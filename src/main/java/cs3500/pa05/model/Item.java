package cs3500.pa05.model;

import java.util.List;

public interface Item {
  String getName();
  String getDescription();

  List<String> getValidLinks();
}
