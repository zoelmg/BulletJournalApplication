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
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.spreadsheet.Grid;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
public class TestClick2 {


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

    this.controller = new BujoControllerImp(this.bujopage, "src/main/resources/test2.bujo");
    this.view = new BujoGuiImp(this.controller);

    stage.setScene(view.load());
    controller.run();
    stage.show();

  }





  @Test
  void testEventClicked(FxRobot robot){

    VBox vBox = (VBox) this.controller.getWeekHBox().getChildren().get(0);
    EventView eventView= (EventView) vBox.getChildren().get(1);
    robot.clickOn(eventView);
    VBox vBox1 = (VBox) this.controller.getDialog().getDialogPane().getChildren().get(3);
    Label label = (Label) vBox1.getChildren().get(0);
    GridPane gridPane = (GridPane) this.controller.getDialog().getDialogPane().getChildren().get(0);
    System.out.println(gridPane);

    assertEquals(label.getText(), "Event: Hello");

    robot.sleep(1000l);

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


  @AfterAll
  static void close(){

  }


}
