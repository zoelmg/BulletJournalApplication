package cs3500.pa05.controller;

import cs3500.pa05.model.BujoPage;
import cs3500.pa05.model.BujoPageImp;
import cs3500.pa05.view.BujoGuiImp;
import cs3500.pa05.view.BujoGuiView;
import javafx.application.Application;
import javafx.stage.Stage;

public class BujoControllerImp extends Application implements BujoController{

  private BujoPage bujoPage;
  private BujoGuiView view;

  public BujoControllerImp(BujoPage bujoPage, BujoGuiView bujoGuiView) {
    this.bujoPage = bujoPage;
    this.view = bujoGuiView;
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

      // render the stage
      stage.show();
    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }

}
