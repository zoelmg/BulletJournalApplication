package cs3500.pa05.view;

import cs3500.pa05.controller.BujoController;
import cs3500.pa05.controller.BujoControllerImp;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Represents the GUI provided to User with JavaFx and SceneBuilder
 */
public class BujoGuiImp implements BujoGuiView {

  private FXMLLoader loader;

  /**
   * @param controller is BujoController object that will be used to coordinate this
   *                   program using this view
   */
  public BujoGuiImp(BujoController controller) {
    // look up and store the layout
    this.loader = new FXMLLoader();
    this.loader.setController(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("BujoMockup.fxml"));
  }

  /**
   * @return a Scene with all elements of the GUI for this program.
   * @throws IllegalStateException when unable to load this BujoGuiImp's FXMLLoader
   */
  @Override
  public Scene load() throws IllegalStateException {
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
