package cs3500.pa05.controller;

import static javafx.application.Application.launch;

import cs3500.pa05.model.BujoPage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


/**
 * Represents a Controller for the Splash Screen shown before the Main Bujo
 */
public class SplashScreenControllerImp implements BujoController {

  @FXML
  Button continueButton;

  @FXML
  TextField passwordText;

  @FXML
  Text wrongText;

  BujoPage bujoPage;

  private static boolean shouldContinue = false;


  /**
   * Initializing a SplashScreenController
   *
   * @param bujoPage the bujoPage that is being loaded
   */
  public SplashScreenControllerImp(BujoPage bujoPage) {
    this.wrongText = new Text();
    this.passwordText = new TextField();
    this.bujoPage = bujoPage;
    this.wrongText.setText("a");

  }


  /**
   * run the splash screen controller
   */
  public void run() {
    this.continueButton.setOnAction(e -> handleClick());
    this.wrongText.setText("");
  }

  /**
   * Checks that user entered password is correct onc
   */
  private void handleClick() {
    if (passwordText.getText().equals(this.bujoPage.getPassword())) {
      shouldContinue = true;
    }
  }

  /**
   * @return true based on the state of this
   */
  public static boolean isShouldContinue() {
    return shouldContinue;
  }
}
