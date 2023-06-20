package cs3500.pa05.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The abstaction of an item on the bujo page
 */
public abstract class AbstractItem implements Item {
  protected final String name;
  protected final String description;

  /**
   * @param name the name of this abstract item
   * @param description the description of the item
   */
  public AbstractItem(String name, String description) {
    this.name = name;
    this.description = description;
  }


  /**
   * get the name of the item
   *
   * @return the name of the item
   */
  @Override
  public String getName() {
    return this.name;
  }


  /**
   * get the description of the item
   *
   * @return the description of the item
   */
  @Override
  public String getDescription() {
    return this.description;
  }

  /**
   * get the valid links in the item
   *
   * @return the valid links in the item
   */
  @Override
  public List<String> getValidLinks() {
    List<String> links = new ArrayList<>();
    String descriptionText = this.description + " ";
    int count = 1;

    while (descriptionText.contains("http")) {
      String possibleLink = "";
      String subtext = descriptionText.substring(descriptionText.indexOf("http"));
      while (count + 1 < subtext.length() + 1) {
        possibleLink = subtext.substring(0, count);
        String nextPossibleLink = subtext.substring(0, count + 1);
        if (isValidLink(possibleLink) && ((count == subtext.length() - 1)
            || (subtext.substring(count, count + 1).equals(" ")))) {
          links.add(possibleLink);
          break;
        }
        count += 1;
      }

      descriptionText = subtext.substring(count);
      count = 1;
    }
    return links;
  }

  /**
   * Determine if a string is a possible valid URL
   *
   * @param possibleLink the string of a possible valid URL
   * @return true if the string is actually a valid URL
   */
  private static boolean isValidLink(String possibleLink) {
    try {
      (new java.net.URL(possibleLink)).openStream().close();
      return true;
    } catch (IOException exception) {
      return false;
    }
  }
}
