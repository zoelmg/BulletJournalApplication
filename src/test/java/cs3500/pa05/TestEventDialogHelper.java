package cs3500.pa05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.controller.BujoControllerImp;
import cs3500.pa05.model.BujoPage;
import cs3500.pa05.model.BujoPageImp;
import cs3500.pa05.view.BujoGuiImp;
import cs3500.pa05.view.BujoGuiView;
import cs3500.pa05.view.EventView;
import cs3500.pa05.view.TaskView;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
public class TestEventDialogHelper {

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


  @Test
  void testConfigWeek(FxRobot robot){
    robot.press(KeyCode.SHORTCUT, KeyCode.DIGIT6);


    VBox vBox = (VBox) this.controller.getWeekHBox().getChildren().get(0);
    EventView eventView= (EventView) vBox.getChildren().get(1);
    robot.clickOn(eventView);
    VBox vBox1 = (VBox) this.controller.getDialog().getDialogPane().getChildren().get(3);
    Label label = (Label) vBox1.getChildren().get(0);
    GridPane gridPane = (GridPane) this.controller.getDialog().getDialogPane().getChildren().get(0);
    System.out.println(gridPane);

    assertEquals(label.getText(), "Event: _");

    Stage stage1 = this.stage;
    Platform.runLater(new Runnable() {
      @Override
      public void run() {
        stage1.close();
      }
    });
  }
//  @AfterAll
//  static void close(){
//    Platform.exit();
//  }

}
