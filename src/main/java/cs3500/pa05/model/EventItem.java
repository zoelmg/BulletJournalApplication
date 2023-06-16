package cs3500.pa05.model;

public class EventItem extends AbstractItem implements IEventItem {

  private String startTime;
  private String duration;

  public EventItem(String name, String description, String startTime, String duration) {
    super(name, description);
    this.startTime = startTime;
    this.duration = duration;
  }


  @Override
  public String getStartTime() {
    return this.startTime;
  }

  @Override
  public String getDuration() {
    return this.duration;
  }
}
