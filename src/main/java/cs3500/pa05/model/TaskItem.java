package cs3500.pa05.model;

/**
 * An item that represents a task
 */
public class TaskItem extends AbstractItem implements IntTaskItem {
  private boolean isCompleted;

  /**
   * @param name The name of the task
   * @param description the description of the task
   */
  public TaskItem(String name, String description) {
    super(name, description);
    this.isCompleted = false;
  }

  public TaskItem(String name, String description, Boolean isCompleted) {
    super(name, description);
    this.isCompleted = false;
  }

  /**
   * get if the task is complete
   *
   * @return if the task is complete
   */
  @Override
  public boolean getIsComplete() {
    return this.isCompleted;
  }

}
