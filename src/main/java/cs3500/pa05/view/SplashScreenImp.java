package cs3500.pa05.view;

import static cs3500.pa05.controller.SplashScreenControllerImp.isShouldContinue;

import cs3500.pa05.controller.BujoController;
import cs3500.pa05.controller.BujoControllerImp;
import cs3500.pa05.model.BujoPage;
import cs3500.pa05.model.BujoPageImp;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Represents a Controller that controls solely the Splash Screen element of the Program
 */
public class SplashScreenImp implements BujoGuiView {

  private FXMLLoader loader;
  private BujoGuiView bujoGuiView;
  private BujoController controller;
  private BujoPage bujopage;
  private FXMLLoader loader2;

  /**
   * @param controller is BujoController object that will be used to coordinate this
   *                   program using this view
   */
  public SplashScreenImp(BujoController controller) {
    // look up and store the layout
    this.loader = new FXMLLoader();
    this.loader.setController(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("SplashScreen.fxml"));
    this.bujopage = new BujoPageImp();
    this.controller = new BujoControllerImp(this.bujopage);
    this.bujoGuiView = new BujoGuiImp(this.controller);
    this.loader2  = new FXMLLoader();
    this.loader2.setController(this.controller);
    this.loader2.setLocation(getClass().getClassLoader().getResource("BujoMockup.fxml"));
  }

  /**
   * @return a Scene with all elements of the GUI for this program.
   * @throws IllegalStateException when unable to load this BujoGuiImp's FXMLLoader
   */
  @Override
  public Scene load() throws IllegalStateException {
    try {
      if (isShouldContinue()) {
        return this.loader2.load();
      } else {
        return this.loader.load();
      }

    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
