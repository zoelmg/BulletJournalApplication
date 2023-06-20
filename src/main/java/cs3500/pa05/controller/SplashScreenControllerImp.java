package cs3500.pa05.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.controlsfx.tools.Platform;
import org.w3c.dom.Text;

public class SplashScreenControllerImp implements SplashScreenController{

  @FXML
  Button continueButton;

  @FXML
  TextField passwordTest;

  @FXML
  Text wrongText;

  private static boolean shouldContinue = false;


  public SplashScreenControllerImp(){
    this.wrongText.setTextContent("");

  }
  public void run(){
    this.continueButton.setOnAction(e -> {
      if(passwordTest.getText().equals("a")){
        shouldContinue = true;
      }
    });
  }

  public static boolean isShouldContinue() {
    return shouldContinue;
  }
}
