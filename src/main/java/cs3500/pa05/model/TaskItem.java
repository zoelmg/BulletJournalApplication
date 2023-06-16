package cs3500.pa05.model;

public class TaskItem extends AbstractItem implements ITaskItem {
  private boolean isCompleted;
  public TaskItem(String name, String description) {
    super(name, description);
    this.isCompleted = false;
  }
  public TaskItem(String name, String description, Boolean isCompleted) {
    super(name, description);
    this.isCompleted = false;
  }


  @Override
  public boolean getIsComplete() {
    return this.isCompleted;
  }
}
