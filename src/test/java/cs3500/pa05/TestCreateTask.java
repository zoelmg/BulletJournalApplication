package cs3500.pa05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.controller.BujoController;
import cs3500.pa05.controller.BujoControllerImp;
import cs3500.pa05.model.BujoPage;
import cs3500.pa05.model.BujoPageImp;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.EventItem;
import cs3500.pa05.model.TaskItem;
import cs3500.pa05.view.BujoGuiImp;
import cs3500.pa05.view.BujoGuiView;
import java.time.DayOfWeek;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
class TestCreateTask {

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
  private void start(Stage stage) {
    this.stage = stage;
    this.bujopage = new BujoPageImp();
    this.controller = new BujoControllerImp(this.bujopage);
    this.view = new BujoGuiImp(this.controller);

    stage.setScene(view.load());
    controller.run();
    stage.show();

  }

  /**
   * @param robot - Will be injected by the test runner.
   */

  void should_contain_button_with_text(FxRobot robot) {
//    Assertions.assertThat(button).hasText("click me!");
    // or (lookup by css id):
    Assertions.assertThat(robot.lookup("#myButton").queryAs(Button.class)).hasText("click me!");

  }

  /**
   * @param robot - Will be injected by the test runner.
   */
  @Test
  void when_button_is_clicked_text_changes(FxRobot robot) {

//    // when:
//    robot.clickOn(".button");
//
//    // then:
//    Assertions.assertThat(button).hasText("clicked!");
//    // or (lookup by css id):
//    Assertions.assertThat(robot.lookup("#myButton").queryAs(Button.class)).hasText("clicked!");
//    // or (lookup by css class):
//    Assertions.assertThat(robot.lookup(".button").queryAs(Button.class)).hasText("clicked!");
//    // or (query specific type)
//    Assertions.assertThat(robot.lookup(".button").queryButton()).hasText("clicked!");
  }



@Test
  void testHandelCreateTask(FxRobot robot){
    robot.press(KeyCode.SHORTCUT, KeyCode.T);
    assertEquals(this.controller.getDialogCreateTask().getTitle(), "Create New Task");
    Dialog<TaskItem> dialog = this.controller.getDialogCreateTask();

    GridPane gridPane = (GridPane) dialog.getDialogPane().getChildren().get(3);
    robot.moveTo(gridPane.getChildren().get(1));
    robot.clickOn();
    robot.write("hello");
    robot.moveTo(gridPane.getChildren().get(3));
    robot.clickOn();
    robot.write("goodbye");
    ChoiceBox<String> choiceBox = (ChoiceBox<String>) gridPane.getChildren().get(5);
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

  @AfterAll
  static void close(){

  }

  //  @Test
//  void notHelper(FxRobot robot){
//    testHandelCreateEvent(robot);
//    VBox vBox = (VBox) this.controller.getWeekHBox().getChildren().get(0);
//    Label dayname = (Label) vBox.getChildren().get(0);
//    robot.moveTo(dayname);
//    robot.moveBy(0,30);
//    robot.clickOn();
//    robot.press(MouseButton.PRIMARY);
//    System.out.println(vBox.getChildren());
//  }
//
  private Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
    Node result = null;
    ObservableList<Node> childrens = gridPane.getChildren();

    for (Node node : childrens) {
      if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
        result = node;
        break;
      }
    }

    return result;
  }


//  @Test
//  void testHandelEventClicked(FxRobot robot) {
//    Day day = new Day(DayOfWeek.FRIDAY);
//    day.addItem(new TaskItem("blah", "blah", false));
//    day.addItem(new EventItem("blah1", "blah2", "blah3", "blah4"));
//    this.controller.getBujoPage().getBujoWeek().set(4, day);
//    this.controller.updatePage();
//    VBox v = (VBox) this.controller.getWeekHBox().getChildren().get(4);
//    robot.clickOn(v.getChildren().get(0));
//  }
}

