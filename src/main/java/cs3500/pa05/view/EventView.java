package cs3500.pa05.view;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class EventView extends VBox {

  private Label eventNameLabel;
  private Label descriptionLabel;
  private Label startTimeLabel;
  private Label durationLabel;

  public EventView(String eventName, String description,
                   String startTime, String duration) {
    this.eventNameLabel = new Label("* Event Name: " + eventName);
    this.descriptionLabel = new Label(" Description: " + description);
    this.startTimeLabel = new Label(" Start Time: " + startTime);
    this.durationLabel = new Label(" Duration: " + duration);

   this.setStyle("-fx-border-style: solid; -fx-background-color: lavender");
   this.setWidth(90);
   this.setHeight(200);

    List<Label> eventRelated = new ArrayList<>();
    eventRelated.add(eventNameLabel);
    eventRelated.add(descriptionLabel);
    eventRelated.add(startTimeLabel);
    eventRelated.add(durationLabel);

    for (Label each : eventRelated) {
      each.setFont(Font.font("Baskerville", 10));
      each.setPrefSize(90, 20);
    }

    this.getChildren().addAll(eventRelated);

  }

}