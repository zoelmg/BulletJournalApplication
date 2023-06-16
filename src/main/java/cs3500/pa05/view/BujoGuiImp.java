package cs3500.pa05.view;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class BujoGuiImp implements BujoGuiView{
  private FXMLLoader loader;

  public BujoGuiImp() {
  // look up and store the layout
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("welcome.fxml"));
}

  @Override
  public Scene load() throws IllegalStateException {
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
