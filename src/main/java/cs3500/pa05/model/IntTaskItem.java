package cs3500.pa05.model;

/**
 * An interface that represents a task
 */
public interface IntTaskItem extends Item {
  /**
   * get if the task is complete
   *
   * @return if the task is complete
   */
  boolean getIsComplete();
}
