package cs3500.pa05.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.BujoPage;
import cs3500.pa05.model.BujoPageImp;
import cs3500.pa05.view.BujoGuiImp;
import cs3500.pa05.view.BujoGuiView;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

/**
 * Tests for the Create Quote feature's GUI functionality
 */
@ExtendWith(ApplicationExtension.class)
public class TestCreateQuote {

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
    this.controller = new BujoControllerImp(this.bujopage, "src/main/resources/test.bujo");
    this.view = new BujoGuiImp(this.controller);
    stage.setScene(view.load());
    controller.run();
    stage.show();
  }

  /**
   * Test when a new Quote is created
   *
   * @param robot the fxrobot that will simulate action
   */
  @Test
  public void testNewQuote(FxRobot robot) {
    robot.press(KeyCode.SHORTCUT, KeyCode.DIGIT2);
    assertEquals(this.controller.dialogCreateQuote.getTitle(), "New Quote");
    Stage stage1 = this.stage;
    Platform.runLater(new Runnable() {
      @Override
      public void run() {
        stage1.close();
      }
    });
  }
}
