package cs3500.pa05.view;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * TaskView represents a JavaFx component that will display a Task with name, description,
 * and is complete details as given by the user into the View.
 */
public class TaskView extends VBox {

  private Label taskNameLabel;
  private Label descriptionLabel;
  private Label completeLabel;

  /**
   * @param taskName    is name for task as given by user
   * @param description is description for task as given by user
   * @param complete    is boolean value for task completeness as given by user
   */
  public TaskView(String taskName, String description, boolean complete) {
    this.taskNameLabel = new Label(" - Task: " + taskName);
    this.descriptionLabel = new Label(" - Description: " + description);
    this.completeLabel = new Label(" Completion Status: " + complete);

    this.setStyle("-fx-border-style: solid; -fx-background-color: lavender");
    this.setWidth(90);
    this.setHeight(200);

    List<Label> eventRelated = new ArrayList<>();
    eventRelated.add(taskNameLabel);
    eventRelated.add(descriptionLabel);
    eventRelated.add(completeLabel);

    for (Label each : eventRelated) {
      each.setFont(Font.font("Baskerville", 10));
      each.setPrefSize(90, 20);
    }

    this.getChildren().addAll(eventRelated);
  }


}
