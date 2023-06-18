package cs3500.pa05.model;

/**
 * An item that represents an event
 */
public class EventItem extends AbstractItem implements IntEventItem {

  private String startTime;
  private String duration;

  public EventItem(String name, String description, String startTime, String duration) {
    super(name, description);
    this.startTime = startTime;
    this.duration = duration;
  }


  /**
   * get the start time of this event
   *
   * @return the String containing the start time of this event
   */
  @Override
  public String getStartTime() {
    return this.startTime;
  }

  /**
   * get the duration of this event
   *
   * @return the String containing the duration of this event
   */
  @Override
  public String getDuration() {
    return this.duration;
  }


}
