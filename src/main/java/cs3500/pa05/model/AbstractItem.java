package cs3500.pa05.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractItem implements Item {
  protected final String name;
  protected final String description;

  public AbstractItem(String name, String description) {
    this.name = name;
    this.description = description;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getDescription() {
    return this.description;
  }

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
        if (isValidLink(possibleLink) && ((count == subtext.length() - 1) ||
            (subtext.substring(count, count + 1).equals(" ")))) {
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
