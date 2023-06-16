package cs3500.pa05.controller;

import cs3500.pa05.model.BujoPage;
import cs3500.pa05.model.BujoPageImp;
import cs3500.pa05.model.bujofileprocessor.BujoWriterImp;
import cs3500.pa05.model.bujofileprocessor.FileAppendable;
import cs3500.pa05.view.BujoGuiImp;
import cs3500.pa05.view.BujoGuiView;
import java.nio.file.Path;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BujoControllerImp implements BujoController{

  private BujoPage bujoPage;

  @FXML
  private HBox weekHbox;

  @FXML
  private ToolBar menubar;

  @FXML
  private GridPane buttonGP;

  @FXML
  private Label weeknameLabel;

  @FXML
  private HBox quotesAndNotes;

  private Path bujoPath;


  public BujoControllerImp(BujoPage bujoPage) {
    this.bujoPage = bujoPage;
    this.bujoPath = Path.of("src/main/resources/defaultBujo.bujo");
  }


  public void run() {
    setAll();
  }

  private void setAll() {
    //Get list of buttons in menu bar
    List<Node> buttons = buttonGP.getChildren();

    //set saveButton on action
    Button saveButton = (Button) buttons.get(1);
    saveButton.setOnAction(event -> handleSave());

    //set openButton on action
    Button openButton = (Button) buttons.get(2);
    openButton.setOnAction(event -> handleOpen());

  }


  private void handleSave() {
    BujoWriterImp writer = new BujoWriterImp(new FileAppendable(bujoPath.toFile()));
    writer.writeBujoFile(this.bujoPage);
  }

  private void handleOpen() {
    //reset this.bujoPath to equal the path of file user has given in.
  }

  private void handleCreateTask() {

  }

  private void handleCreateEvent() {

  }
}
