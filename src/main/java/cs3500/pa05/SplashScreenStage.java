package cs3500.pa05;

import cs3500.pa05.controller.BujoController;
import cs3500.pa05.controller.BujoControllerImp;
import cs3500.pa05.controller.SplashScreenController;
import cs3500.pa05.controller.SplashScreenControllerImp;
import cs3500.pa05.model.BujoPage;
import cs3500.pa05.model.BujoPageImp;
import cs3500.pa05.view.BujoGuiImp;
import cs3500.pa05.view.BujoGuiView;
import cs3500.pa05.view.SplashScreenImp;
import cs3500.pa05.view.SplashScreenView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The Main Stage of the BujoPage
 */
public class SplashScreenStage extends Application {

  private SplashScreenController splashScreenController;
  private SplashScreenView splashScreenView;

  /**
   * Initializing a Main Stage with a view, controller, and model
   */
  public SplashScreenStage() {
    this.splashScreenController = new SplashScreenControllerImp();
    this.splashScreenView = new SplashScreenImp(splashScreenController);
  }

  /**
   * Starts the GUI for a default BujoPage FXML
   *
   * @param stage the JavaFX stage to add elements to
   */
  @Override
  public void start(Stage stage) {

    try {
      stage.setTitle("Bujo App");
      // load and place the view's scene onto the stage
      stage.setScene(splashScreenView.load());
      splashScreenController.run();

      // render the stage
      stage.show();

    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }

}
