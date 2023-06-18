package cs3500.pa05.model;

/**
 * An Item that represents an event
 */
public interface IntEventItem extends Item {

  /**
   * get the start time of the event
   *
   * @return the start time of the event
   */
  String getStartTime();

  /**
   * get the duration of the event
   *
   * @return the duration of the event
   */
  String getDuration();
}
