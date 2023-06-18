package cs3500.pa05.model;

import java.util.List;

/**
 * An interface representing an item in the bujopage
 */
public interface Item {
  /**
   * get the name of the item
   *
   * @return the name of the item
   */
  String getName();

  /**
   * get the description of the item
   *
   * @return the description of the item
   */
  String getDescription();

  /**
   * get the valid links in the item
   *
   * @return the valid links in the item
   */
  List<String> getValidLinks();
}
