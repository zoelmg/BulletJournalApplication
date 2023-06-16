package cs3500.pa05;

import cs3500.pa05.controller.BujoController;
import cs3500.pa05.controller.BujoControllerImp;
import cs3500.pa05.model.BujoPage;
import cs3500.pa05.model.BujoPageImp;
import cs3500.pa05.view.BujoGuiImp;
import cs3500.pa05.view.BujoGuiView;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainStage extends Application  {

  private BujoController controller;
  private BujoPage bujopage;
  private BujoGuiView view;

  public MainStage() {
    this.bujopage = new BujoPageImp();
    this.controller = new BujoControllerImp(this.bujopage);
    this.view = new BujoGuiImp(this.controller);
  }

  /**
   * Starts the GUI for a default BujoPage FXML
   *
   * @param stage the JavaFX stage to add elements to
   */
  @Override
  public void start(Stage stage) {

    try {
      stage.setTitle("Exam Study");
      // load and place the view's scene onto the stage
      stage.setScene(view.load());
      controller.run();

      // render the stage
      stage.show();
    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }

}
