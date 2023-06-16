package cs3500.pa05.view;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class TaskView extends VBox {

  private Label taskNameLabel;
  private Label descriptionLabel;
  private Label completeLabel;

  public TaskView(String taskName, String description, boolean complete) {
    Label taskNameLabel = new Label(taskName);
    Label descriptionLabel = new Label(description);
    Label completeLabel = new Label(String.valueOf(complete));

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
