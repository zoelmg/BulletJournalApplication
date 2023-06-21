package cs3500.pa05.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sun.javafx.event.EventHandlerManager;
import cs3500.pa05.model.BujoPage;
import cs3500.pa05.model.BujoPageImp;
import cs3500.pa05.model.EventItem;
import cs3500.pa05.model.TaskItem;
import cs3500.pa05.view.BujoGuiImp;
import cs3500.pa05.view.BujoGuiView;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
class TestLabel {

  private BujoControllerImp controller;
  private BujoPage bujopage;
  private BujoGuiView view;
  private Stage stage;

  /**
   * Will be called with {@code @Before} semantics, i. e. before each test method.
   *
   * @param stage - Will be injected by the test runner.
   */
  @Start
  public void start(Stage stage) {
    this.stage = stage;
    this.bujopage = new BujoPageImp();
    this.controller = new BujoControllerImp(this.bujopage);
    this.view = new BujoGuiImp(this.controller);

    stage.setScene(view.load());
    controller.run();
    stage.show();

  }



  @Test
  public void testHandelCreateEvent(FxRobot robot){
    robot.press(KeyCode.SHORTCUT, KeyCode.E);
    assertEquals(this.controller.dialogCreateEvent.getTitle(), "Create New Event");
    Dialog<EventItem> dialog = this.controller.dialogCreateEvent;

    GridPane gridPane = (GridPane) dialog.getDialogPane().getChildren().get(3);
    robot.moveTo(gridPane.getChildren().get(1));
    robot.clickOn();
    robot.write("hello");
    robot.moveTo(gridPane.getChildren().get(3));
    robot.clickOn();
    robot.write("goodbye");
    robot.moveTo(gridPane.getChildren().get(5));
    robot.clickOn();
    robot.write("food");
    robot.moveTo(gridPane.getChildren().get(7));
    robot.clickOn();
    robot.write("bed");
    ChoiceBox<String> choiceBox = (ChoiceBox<String>) gridPane.getChildren().get(9);
    robot.moveTo(choiceBox);
    robot.clickOn();

    robot.moveBy(0, 20);
    robot.clickOn();
    ButtonBar buttonBar = (ButtonBar) dialog.getDialogPane().getChildren().get(2);
    Button button = (Button) buttonBar.getButtons().get(0);
    robot.moveTo(button);
    robot.clickOn();
    robot.press(MouseButton.PRIMARY);

    assertEquals(choiceBox.getValue(), "Monday");
    assertEquals(this.controller.getEventCreationCount(),0);
    robot.sleep(1000l);

    Stage stage1 = this.stage;
    Platform.runLater(new Runnable() {
      @Override
      public void run() {
        stage1.close();
      }
    });

  }


}

