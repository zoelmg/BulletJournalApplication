package cs3500.pa05;

import cs3500.pa05.controller.BujoController;
import cs3500.pa05.controller.BujoControllerImp;
import cs3500.pa05.model.BujoPage;
import cs3500.pa05.model.BujoPageImp;
import cs3500.pa05.view.BujoGuiImp;
import cs3500.pa05.view.BujoGuiView;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
class TestLabel {

  private BujoController controller;
  private BujoPage bujopage;
  private BujoGuiView view;

  /**
   * Will be called with {@code @Before} semantics, i. e. before each test method.
   *
   * @param stage - Will be injected by the test runner.
   */
  @Start
  private void start(Stage stage) {
    this.bujopage = new BujoPageImp();
    this.controller = new BujoControllerImp(this.bujopage);
    this.view = new BujoGuiImp(this.controller);

    stage.setScene(view.load());
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
}