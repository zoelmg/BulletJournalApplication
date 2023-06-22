package cs3500.pa05.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.BujoPage;
import cs3500.pa05.model.BujoPageImp;
import cs3500.pa05.view.BujoGuiImp;
import cs3500.pa05.view.BujoGuiView;
import cs3500.pa05.view.EventView;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

/**
 * Tests part 2 for the Click GUI functionality
 */
@ExtendWith(ApplicationExtension.class)
public class TestEventClicked {


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
   public void start(Stage stage) throws Exception {

    this.stage = stage;
    this.bujopage = new BujoPageImp();

    this.controller = new BujoControllerImp(this.bujopage, "src/main/resources/test2.bujo");
    this.view = new BujoGuiImp(this.controller);

    stage.setScene(view.load());
    controller.run();
    stage.show();

  }


  /**
   * Test when an Event on the weekview is clicked
   *
   * @param robot the fxrobot that will simulate action
   */
  @Test
  public void testEventClicked(FxRobot robot) throws Exception {

    VBox vbox = (VBox) this.controller.weekHbox.getChildren().get(0);
    EventView eventView = (EventView) vbox.getChildren().get(1);
    robot.clickOn(eventView);
    VBox vbox1 = (VBox) this.controller.dialogEventClicked.getDialogPane().getChildren().get(3);
    Label label = (Label) vbox1.getChildren().get(0);
    GridPane gridPane = (GridPane) this.controller.dialogEventClicked.getDialogPane()
        .getChildren().get(0);

    assertEquals(label.getText(), "Event: Hello");

    robot.sleep(1000L);

    Stage stage1 = this.stage;
    BujoControllerImp controller1 = this.controller;
    Platform.runLater(new Runnable() {
      @Override
      public void run() {
        assertEquals(controller1.getEventsCreated(), 0);
        stage1.close();
      }
    });

  }

}
