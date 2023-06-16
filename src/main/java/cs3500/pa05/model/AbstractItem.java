package cs3500.pa05.model;

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
}
