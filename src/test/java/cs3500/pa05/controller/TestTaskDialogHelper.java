package cs3500.pa05.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.BujoPage;
import cs3500.pa05.model.BujoPageImp;
import cs3500.pa05.view.BujoGuiImp;
import cs3500.pa05.view.BujoGuiView;
import cs3500.pa05.view.TaskView;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

/**
 * Tests for the Task Creation Dialog  feature's GUI functionality
 */
@ExtendWith(ApplicationExtension.class)
public class TestTaskDialogHelper {


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



  /**
   * Test when a Task on the week view is clicked
   *
   * @param robot the fxrobot that will simulate action
   */
  @Test
  public void testTaskClicked(FxRobot robot) {
    robot.press(KeyCode.SHORTCUT, KeyCode.DIGIT7);
    VBox vbox = (VBox) this.controller.weekHbox.getChildren().get(0);
    TaskView taskView = (TaskView) vbox.getChildren().get(1);
    robot.clickOn(taskView);
    VBox vbox1 = (VBox) this.controller.dialogTaskClicked.getDialogPane().getChildren().get(3);
    Label label = (Label) vbox1.getChildren().get(0);

    assertEquals(label.getText(), "Task: _");
    robot.sleep(1000L);

    Stage stage1 = this.stage;
    Platform.runLater(new Runnable() {
      @Override
      public void run() {
        stage1.close();
      }
    });
  }
}

