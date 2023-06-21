package cs3500.pa05.controller;

import static javafx.application.Application.launch;

import cs3500.pa05.MainStage;
import cs3500.pa05.model.BujoPage;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class SplashScreenControllerImp implements BujoController{

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
  public SplashScreenControllerImp(BujoPage bujoPage){
    this.wrongText = new Text();
    this.passwordText = new TextField();
    this.bujoPage = bujoPage;
    this.wrongText.setText("a");

  }


  /**
   *
   */
  public void run(){
    this.continueButton.setOnAction(e -> handelClick());
    this.wrongText.setText("");
  }

  private void handelClick(){
    if (passwordText.getText().equals(this.bujoPage.getPassword())){
        shouldContinue = true;
      }
  }

  /**
   * 
   * @return true based on the state of this
   */
  public static boolean isShouldContinue() {
    return shouldContinue;
  }
}
