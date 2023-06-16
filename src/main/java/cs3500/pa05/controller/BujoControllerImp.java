package cs3500.pa05.controller;

import cs3500.pa05.model.BujoPage;
import cs3500.pa05.model.BujoPageImp;
import cs3500.pa05.view.BujoGuiImp;
import cs3500.pa05.view.BujoGuiView;
import javafx.application.Application;
import javafx.stage.Stage;

public class BujoControllerImp implements BujoController{

  private BujoPage bujoPage;

  @FXML
  private HBox weekHbox;

  @FXML
  private ToolBar menubar;

  @FXML
  private Label weeknameLabel;

  @FXML
  private HBox quotesAndNotes;



  public BujoControllerImp(BujoPage bujoPage) {
    this.bujoPage = bujoPage;
  }


  public void run() {
    setAll();
  }

}
