package cs3500.pa05;

import static cs3500.pa05.controller.SplashScreenControllerImp.isShouldContinue;

import cs3500.pa05.controller.BujoController;
import cs3500.pa05.controller.BujoControllerImp;
import cs3500.pa05.controller.SplashScreenControllerImp;
import cs3500.pa05.model.BujoPage;
import cs3500.pa05.model.BujoPageImp;
import cs3500.pa05.view.BujoGuiImp;
import cs3500.pa05.view.BujoGuiView;
import cs3500.pa05.view.SplashScreenImp;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * The Main Stage of the BujoPage
 */
public class MainStage extends Application {

  private BujoController controller;
  private BujoPage bujopage;
  private BujoGuiView view;
  private BujoController splashScreenController;
  private BujoGuiView splashScreenView;


  /**
   * Initializing a Main Stage with a view, controller, and model
   */
  public MainStage() {
    this.bujopage = new BujoPageImp();
    this.controller = new BujoControllerImp(this.bujopage);
    this.view = new BujoGuiImp(this.controller);
    this.splashScreenController = new SplashScreenControllerImp(bujopage);
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
      new Thread(() -> {
        while (!isShouldContinue()) {
          // Sleep to avoid busy-waiting
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

        // Run on JavaFX Application Thread
        Platform.runLater(() -> {
          // Close the splash screen
          stage.close();

          // Create the main stage
          Stage mainStage = new Stage();
          mainStage.setTitle("Bujo App");

          // load and place the view's scene onto the main stage
          try {
            mainStage.setScene(view.load());
            splashScreenController.run();
          } catch (IllegalStateException e) {
            System.err.println("Unable to load main GUI.");
          }

          // Run the main controller
          controller.run();

          // render the main stage
          mainStage.show();
        });
      }).start();

    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }

  }

}
