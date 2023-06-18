package cs3500.pa05.controller;

import cs3500.pa05.MainStage;
import cs3500.pa05.model.BujoPage;
import cs3500.pa05.model.BujoPageImp;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.EventItem;
import cs3500.pa05.model.TaskItem;
import cs3500.pa05.model.bujofileprocessor.BujoReader;
import cs3500.pa05.model.bujofileprocessor.BujoReaderImp;
import cs3500.pa05.model.bujofileprocessor.BujoWriterImp;
import cs3500.pa05.model.bujofileprocessor.FileAppendable;
import cs3500.pa05.view.BujoGuiImp;
import cs3500.pa05.view.BujoGuiView;
import cs3500.pa05.view.EventView;
import cs3500.pa05.view.TaskView;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Pair;
import javafx.geometry.Insets;

public class BujoControllerImp implements BujoController {

  private BujoPage bujoPage;

  @FXML
  private HBox weekHBox;

  @FXML
  private ToolBar menubar;

  @FXML
  private GridPane buttonGP;

  @FXML
  private Label weeknameLabel;

  @FXML
  private HBox quotesAndNotes;

  @FXML
  private VBox taskQueue;

  private Path bujoPath;

  @FXML
  private Scene mainScene;

  public BujoControllerImp(BujoPage bujoPage) {
    this.bujoPage = bujoPage;
    this.bujoPath = Path.of("src/main/resources/" + bujoPage.getWeekName() + ".bujo");
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
    Button openButton = (Button) buttons.get(0);
    openButton.setOnAction(event -> handleOpen());

    //set nameWeekButton on action
    Button configWeekButton = (Button) buttons.get(2);
    configWeekButton.setOnAction(event -> handleConfigWeek());

    //set addEventMenuItem on action
    MenuButton addMenuButton = (MenuButton) buttons.get(3);
    List<MenuItem> allitems = addMenuButton.getItems();
    MenuItem eventItem = allitems.get(0);
    MenuItem taskItem = allitems.get(1);
    MenuItem quoteItem = allitems.get(2);
    MenuItem noteItem = allitems.get(3);
    MenuItem newWeek = allitems.get(4);

    taskItem.setOnAction(event -> handleCreateTask());
    eventItem.setOnAction(event -> handleCreateEvent());

    quoteItem.setOnAction(event -> handleCreateQuote());
    noteItem.setOnAction(event -> handleCreateNote());

    mainScene.setOnKeyPressed(ke ->  handleKeyCombs(
        Arrays.asList(KeyCode.E, KeyCode.T,KeyCode.S, KeyCode.O, KeyCode.DIGIT1, KeyCode.DIGIT2), ke));

 }

 private void handleNewWeek() {
    Dialog<BujoPage> dialog = new Dialog<>();
    dialog.setTitle("Create a New Week");
   ButtonType createQuoteButtonType = new ButtonType("Confirm", ButtonBar.ButtonData.OK_DONE);
   dialog.getDialogPane().getButtonTypes().addAll(createQuoteButtonType, ButtonType.CANCEL);


   GridPane grid = new GridPane();
   grid.setHgap(10);
   grid.setVgap(10);
   grid.setPadding(new Insets(20, 150, 10, 10));

   TextField weekName = new TextField();
   weekName.setPromptText("Enter Desired Week Name");


   grid.add(new Label("Week Name: "), 0, 0);
   grid.add(weekName, 1, 0);
   dialog.getDialogPane().setContent(grid);

   dialog.setResultConverter(dialogButton -> {
         if (dialogButton == createQuoteButtonType) {
           newWeekHelper(weekName);
         }
         return null;
       }
   );
   dialog.showAndWait();
 }

 private void newWeekHelper(TextField weekName) {
   handleSave();
   String newWeekName = weekName.getText();
   this.bujoPage = new BujoPageImp();
   this.bujoPage.setWeekName(newWeekName);
   this.bujoPath = Path.of("src/main/resources/" + bujoPage.getWeekName() + ".bujo");
   updatePage();
 }

 private void handleCreateQuote() {
   Dialog<TaskItem> dialog = new Dialog<>();
   dialog.setTitle("Create New Quote");
   ButtonType createQuoteButtonType = new ButtonType("Confirm", ButtonBar.ButtonData.OK_DONE);
   dialog.getDialogPane().getButtonTypes().addAll(createQuoteButtonType, ButtonType.CANCEL);

   GridPane grid = new GridPane();
   grid.setHgap(10);
   grid.setVgap(10);
   grid.setPadding(new Insets(20, 150, 10, 10));

   TextField quoteText = new TextField();
   quoteText.setPromptText("Write quote here ");


   grid.add(new Label("Quote: "), 0, 0);
   grid.add(quoteText, 1, 0);

   dialog.getDialogPane().setContent(grid);

   dialog.setResultConverter(dialogButton -> {
         if (dialogButton == createQuoteButtonType) {
           dialogQuoteHelper(quoteText);
           updatePage();
         }
         return null;
       }
   );

   dialog.showAndWait();
 }

 private void dialogQuoteHelper(TextField quoteText) {
    List<String> newQuotes = bujoPage.getQuotes();
    newQuotes.add(quoteText.getText());
    bujoPage.setQuotes(newQuotes);

 }

 private void handleCreateNote() {
   Dialog<TaskItem> dialog = new Dialog<>();
   dialog.setTitle("Create New Note");
   ButtonType createNoteButtonType = new ButtonType("Confirm", ButtonBar.ButtonData.OK_DONE);
   dialog.getDialogPane().getButtonTypes().addAll(createNoteButtonType, ButtonType.CANCEL);

   GridPane grid = new GridPane();
   grid.setHgap(10);
   grid.setVgap(10);
   grid.setPadding(new Insets(20, 150, 10, 10));

   TextField noteText = new TextField();
   noteText.setPromptText("Write note here ");

   grid.add(new Label("Note: "), 0, 0);
   grid.add(noteText, 1, 0);

   dialog.getDialogPane().setContent(grid);

   dialog.setResultConverter(dialogButton -> {
         if (dialogButton == createNoteButtonType) {
           dialogNoteHelper(noteText);
           updatePage();
         }
         return null;
       }
   );
   dialog.showAndWait();
 }

  private void dialogNoteHelper(TextField noteText) {
    List<String> newNotes = bujoPage.getNotes();
    newNotes.add(noteText.getText());
    bujoPage.setNotes(newNotes);
  }


 private void handleKeyCombs(List<KeyCode> eventkeys, KeyEvent keyevent){
    for(KeyCode keyCode: eventkeys){
      handleKeyComb(keyCode, keyevent);
    }
 }

  private void handleKeyComb(KeyCode eventKey, KeyEvent keyEvent){
    KeyCombination keycomb = new KeyCodeCombination(eventKey, KeyCombination.CONTROL_DOWN);
    KeyCombination keycomb2 = new KeyCodeCombination(eventKey, KeyCombination.SHORTCUT_DOWN);
    if(keycomb.match(keyEvent) || keycomb2.match(keyEvent)){
      switch (eventKey) {
        case E -> handleCreateEvent();
        case T -> handleCreateTask();
        case S -> handleSave();
        case O -> handleOpen();
        case DIGIT1 -> handleCreateNote();
        case DIGIT2 -> handleCreateQuote();
      }
    }
  }

  private void handleSave() {
    BujoWriterImp writer = new BujoWriterImp(new FileAppendable(bujoPath.toFile()));
    writer.writeBujoFile(this.bujoPage);
  }

  private void handleOpen() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open A Bujo File");

    fileChooser.setInitialDirectory(new File("/Users/primaryuser/Code/CS3500/Lecture "
        + "Notes/pa05-blessedbujobeasts/src/main/resources"));

    Stage stage = new Stage();
    File selectedFile = fileChooser.showOpenDialog(stage);
    if (selectedFile != null) {
      this.bujoPath = Path.of(selectedFile.getAbsolutePath());
    }
    //reset this.bujoPath to equal the path of file user has given in.
    try {
      BujoReader reader = new BujoReaderImp(new FileReader(bujoPath.toFile()));
      this.bujoPage = reader.readBujoFile();
    } catch (IOException e) {
      throw new IllegalArgumentException("Unable to read given file");
    }

    updatePage();
  }

  private void handleConfigWeek() {
    Dialog<TaskItem> dialog = new Dialog<>();
    dialog.setTitle("Config This Week");
    dialog.setHeaderText("Give this week a custom name, max amount of tasks and max " +
        "amount of events for every day, or change what day of the week starts with ");

    ButtonType configWeekButtonType = new ButtonType("Confirm", ButtonBar.ButtonData.OK_DONE);
    dialog.getDialogPane().getButtonTypes().addAll(configWeekButtonType, ButtonType.CANCEL);

    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(20, 150, 10, 10));

    TextField weekName = new TextField();
    weekName.setPromptText("Week Name");

    List<Integer> max = Arrays.asList(1, 2, 3, 4, 5);
    List<String> days = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday");
    ChoiceBox<Integer> maxEvents = new ChoiceBox<>();
    maxEvents.getItems().addAll(max);
    ChoiceBox<Integer> maxTasks = new ChoiceBox<>();
    maxTasks.getItems().addAll(max);
    ChoiceBox<String> weekStart = new ChoiceBox<>();
    weekStart.getItems().addAll(days);


    grid.add(new Label("Week Name:"), 0, 0);
    grid.add(weekName, 1, 0);
    grid.add(new Label("Max Tasks:"), 0, 1);
    grid.add(maxTasks, 1, 1);
    grid.add(new Label("Max Events:"), 0, 2);
    grid.add(maxEvents, 1, 2);
    grid.add(new Label("Week Starts With:"), 0, 3);
    grid.add(weekStart, 1, 3);

    dialog.getDialogPane().setContent(grid);

    dialog.setResultConverter(dialogButton -> {
          if (dialogButton == configWeekButtonType) {
            dialogConfigWeekHelper(weekName, maxEvents, maxTasks, weekStart);
            updatePage();
          }
          return null;
        }
    );

    dialog.showAndWait();
  }

  private void dialogConfigWeekHelper(TextField weekName, ChoiceBox<Integer> maxEvents,
                                    ChoiceBox<Integer> maxTasks, ChoiceBox<String> weekStart) {
    if (!weekName.getText().isEmpty()) {
      this.bujoPage.setWeekName(weekName.getText());
    }
    if (maxEvents.getValue() != null) {
      this.bujoPage.setMaxEvents(maxEvents.getValue());
    }
    if (maxTasks.getValue() != null) {
      this.bujoPage.setMaxTasks(maxTasks.getValue());
    }
    if (weekStart.getValue() != null) {
    handleChangeWeekStart(weekStart.getValue());
  }
  }

  private void handleChangeWeekStart(String weekStartDay) {
    List<VBox> boxlist = new ArrayList<>();
    for (int i = 0; i < 7; i++) {
      VBox dayBox = (VBox) weekHBox.getChildren().get(i);
      boxlist.add(dayBox);
    }

    List<Label> labelList = new ArrayList<>();
    for (VBox box : boxlist) {
      Label daylabel = (Label) box.getChildren().get(0);
      labelList.add(daylabel);
    }

    while (!(weekStartDay.equals(labelList.get(0).getText()))) {
      bujoPage.getBujoWeek().add(bujoPage.getBujoWeek().get(0));
      bujoPage.getBujoWeek().remove(0);
      labelList.add(labelList.get(0));
      labelList.remove(0);
      VBox addToEnd = (VBox) weekHBox.getChildren().get(0);
      weekHBox.getChildren().remove(0);
      weekHBox.getChildren().add(6, addToEnd);
    }
  }

  private void updatePage() {
    System.out.println("update page started");
    weeknameLabel.setText(bujoPage.getWeekName());
    List<Day> days = bujoPage.getBujoWeek();
    List<Node> allboxes = this.weekHBox.getChildren();
    List<VBox> allDayVBoxes = new ArrayList<>();

    for (Node n : allboxes) {
      allDayVBoxes.add((VBox) n);
    }

    taskQueue.getChildren().removeAll(taskQueue.getChildren());

    //updates each day's tasks and events
    for (int i = 0; i < 7; i += 1) {
      Day currentDay = days.get(i);
      VBox currentBox = allDayVBoxes.get(i);
      Label dayName = (Label) currentBox.getChildren().get(0);
      currentBox.getChildren().removeAll(currentBox.getChildren());
      currentBox.getChildren().add(dayName);

      updateTaskAndEvents(currentDay, currentBox);
      updateTaskQueue(currentDay);
    }

    //update quotes and notes

    updateQuotesAndNotes();

    //update the task queue, call on the function that will fill in task queue

  }

  private void updateTaskAndEvents(Day currentDay, VBox currentBox) {
    for (EventItem event : currentDay.getEvents()) {
      //get all event related info from event
      EventView eventView = new EventView(event.getName(), event.getDescription(),
          event.getStartTime(), event.getDuration());
      eventView.setOnMouseClicked(mouseEvent -> handleEventClicked(event, currentDay));
      currentBox.getChildren().add(eventView);
    }

    for (TaskItem task : currentDay.getTasks()) {
      TaskView taskView = new TaskView(task.getName(), task.getDescription(), task.getIsComplete());
      taskView.setOnMouseClicked(mouseEvent -> handleTaskClicked(task, currentDay));
      currentBox.getChildren().add(taskView);
    }
  }

  private void updateTaskQueue(Day currentDay) {
    for (TaskItem task : currentDay.getTasks()) {
      TaskView taskView = new TaskView(task.getName(), task.getDescription(), task.getIsComplete());
      this.taskQueue.getChildren().add(taskView);
    }
  }

  private void handleEventClicked(EventItem event, Day currentDay) {
    Dialog<EventItem> dialog = new Dialog<>();
    ButtonType deleteButtonType = new ButtonType("Delete", ButtonBar.ButtonData.OK_DONE);
    dialog.getDialogPane().getButtonTypes().addAll(deleteButtonType);
    List<Label> allLabels = new ArrayList<>();

    allLabels.add(new Label("Event: " + event.getName()));
    allLabels.add(new Label("Description : " + event.getDescription()));
    allLabels.add(new Label("Start Time: " + event.getStartTime()));
    allLabels.add(new Label("Duration: " + event.getDuration()));
    dialog.setTitle(event.getName());
    VBox infoHolder = new VBox();
    infoHolder.setPrefSize(600, 400);
    for (Label l : allLabels) {
      l.setFont(Font.font("Baskerville", 20));
      l.setPrefWidth(400);
      l.setPrefHeight(100);
      infoHolder.getChildren().add(l);
    }
    dialog.getDialogPane().setContent(infoHolder);

    dialog.setResultConverter(dialogButton -> {
          if (dialogButton == deleteButtonType) {
            currentDay.removeItem(event);
            updatePage();
          }
          return null;
        }
    );

    dialog.showAndWait();
    dialog.close();
  }

  private void handleTaskClicked(TaskItem task, Day currentDay) {
    Dialog<EventItem> dialog = new Dialog<>();
    ButtonType deleteButtonType = new ButtonType("Delete", ButtonBar.ButtonData.OK_DONE);
    dialog.getDialogPane().getButtonTypes().addAll(deleteButtonType);
    List<Label> allLabels = new ArrayList<>();

    allLabels.add(new Label("Task: " + task.getName()));
    allLabels.add(new Label("Description: " + task.getDescription()));
    allLabels.add(new Label("Completion Status: " + task.getIsComplete()));
    dialog.setTitle(task.getName());
    VBox infoHolder = new VBox();
    infoHolder.setPrefSize(600, 400);
    for (Label l : allLabels) {
      l.setFont(Font.font("Baskerville", 20));
      l.setPrefWidth(400);
      l.setPrefHeight(100);
      infoHolder.getChildren().add(l);

    }


    dialog.getDialogPane().setContent(infoHolder);

    dialog.setResultConverter(dialogButton -> {
          if (dialogButton == deleteButtonType) {
            currentDay.removeItem(task);
            updatePage();
          }
          return null;
        }
    );

    dialog.showAndWait();
    dialog.close();
  }

  private void updateQuotesAndNotes() {
    List<String> quotes = this.bujoPage.getQuotes();
    List<String> notes = this.bujoPage.getNotes();
    List<Node> quotesAndNotes = this.quotesAndNotes.getChildren();
    VBox quoteVBox = (VBox) quotesAndNotes.get(0);
    Label quoteLabel = (Label) quoteVBox.getChildren().get(0);
    quoteVBox.getChildren().removeAll(quoteVBox.getChildren());
    quoteVBox.getChildren().add(quoteLabel);

    VBox noteVBox = (VBox) quotesAndNotes.get(2);
    Label noteLabel = (Label) noteVBox.getChildren().get(0);
    noteVBox.getChildren().removeAll(noteVBox.getChildren());
    noteVBox.getChildren().add(noteLabel);

    addString(quotes, quoteVBox);
    addString(notes, noteVBox);

  }

  private void addString(List<String> toBeAdded, VBox box) {
    for (String s : toBeAdded) {
      Label newNote = new Label(" * " + s);
      newNote.setStyle("-fx-background-color: lavender");
      newNote.setFont(Font.font("Baskerville", 15));
      newNote.setPrefSize(400, 30);
      box.getChildren().add(newNote);
    }
  }

  private void handleCreateTask() {
    Dialog<TaskItem> dialog = new Dialog<>();
    dialog.setTitle("Create New Task");
    dialog.setHeaderText("Enter Task Info");
    ButtonType createTaskButtonType = new ButtonType("Confirm", ButtonBar.ButtonData.OK_DONE);
    dialog.getDialogPane().getButtonTypes().addAll(createTaskButtonType, ButtonType.CANCEL);

    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(20, 150, 10, 10));

    TextField taskName = new TextField();
    taskName.setPromptText("Task Name");
    TextField taskDescription = new TextField();
    taskDescription.setPromptText("Task Description");

    ChoiceBox<String> dayOfWeek = new ChoiceBox<>();
    List<String> days = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday");
    dayOfWeek.getItems().addAll(days);

    grid.add(new Label("Task Name:"), 0, 0);
    grid.add(taskName, 1, 0);
    grid.add(new Label("Description:"), 0, 1);
    grid.add(taskDescription, 1, 1);
    grid.add(new Label("Day of Week:"), 0, 2);
    grid.add(dayOfWeek, 1, 2);
    dialog.getDialogPane().setContent(grid);

    dialog.setResultConverter(dialogButton -> {
          if (dialogButton == createTaskButtonType) {
            taskDialogHelper(taskName, taskDescription, dayOfWeek);
          }
          return null;
        }
    );

    dialog.showAndWait();
  }

  private void taskDialogHelper(TextField taskName, TextField taskDescription,
                                ChoiceBox<String> dayOfWeek) {
    if (taskName.getText().isEmpty() || dayOfWeek.getValue() == null) {
      Alert notCompleted = new Alert(Alert.AlertType.ERROR);
      notCompleted.setContentText("Enter All Fields");
      notCompleted.show();

    } else {
      DayOfWeek desiredDay = getDay(dayOfWeek.getValue());

      Day day = bujoPage.getBujoWeek().stream().filter(d -> d.getDayOfWeek().equals(desiredDay))
          .toList().get(0);

      if (day.getTasks().size() < bujoPage.getMaxTasks()) {
        day.addItem(new TaskItem(taskName.getText(),
            !taskDescription.getText().isEmpty() ? taskDescription.getText() : "Not entered"));
        updatePage();
      } else {
        Alert atCapacity = new Alert(Alert.AlertType.ERROR);
        atCapacity.setContentText("Already Reached Max Tasks for the chosen Day");
        atCapacity.show();
      }
    }
  }

  private void handleCreateEvent() {
    Dialog<TaskItem> dialog = new Dialog<>();
    dialog.setTitle("Create New Event");
    dialog.setHeaderText("Enter Event Info");
    ButtonType createEventButtonType = new ButtonType("Confirm", ButtonBar.ButtonData.OK_DONE);
    dialog.getDialogPane().getButtonTypes().addAll(createEventButtonType, ButtonType.CANCEL);

    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(20, 150, 10, 10));
    TextField eventName = new TextField(), eventDes = new TextField(),
        eventSt = new TextField(), eventDur = new TextField();

    eventName.setPromptText("Event Name");
    eventDes.setPromptText("Event Description");
    eventSt.setPromptText("Event StartTime");
    eventDur.setPromptText("Event Duration");

    ChoiceBox<String> dayOfWeek = new ChoiceBox<>();
    List<String> days = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday");
    dayOfWeek.getItems().addAll(days);

    grid.add(new Label("Event Name:"), 0, 0);
    grid.add(eventName, 1, 0);
    grid.add(new Label("Description:"), 0, 1);
    grid.add(eventDes, 1, 1);
    grid.add(new Label("Start Time:"), 0, 2);
    grid.add(eventSt, 1, 2);
    grid.add(new Label("Duration:"), 0, 3);
    grid.add(eventDur, 1, 3);
    grid.add(new Label("Day of Week:"), 0, 4);
    grid.add(dayOfWeek, 1, 4);
    dialog.getDialogPane().setContent(grid);

    dialog.setResultConverter(dialogButton -> {
          if (dialogButton == createEventButtonType) {
            eventDialogHelper(eventName, eventDes, eventSt, eventDur, dayOfWeek);
          }
          return null;
        }
    );

    dialog.showAndWait();
  }

  private void eventDialogHelper(TextField eventName, TextField eventDes, TextField eventSt,
                                 TextField eventDur, ChoiceBox<String> dayOfWeek) {
    if (eventName.getText().isEmpty() || eventSt.getText().isEmpty()
        || eventDur.getText().isEmpty() || dayOfWeek.getValue() == null) {
      Alert notCompleted = new Alert(Alert.AlertType.ERROR);
      notCompleted.setContentText("Enter All Fields");
      notCompleted.show();

    } else {
      DayOfWeek desiredDay = getDay(dayOfWeek.getValue());
      Day day = bujoPage.getBujoWeek().stream().filter(d -> d.getDayOfWeek().equals(desiredDay))
          .toList().get(0);

      if (day.getEvents().size() < bujoPage.getMaxEvents()) {
        //add new task to the day
        day.addItem(new EventItem(eventName.getText(),
            !eventDes.getText().isEmpty() ? eventDes.getText() : "Not Entered",
            eventSt.getText(), eventDur.getText()));
        updatePage();
      } else {
        Alert atCapacity = new Alert(Alert.AlertType.ERROR);
        atCapacity.setContentText("Already Reached Max Event for the chosen Day");
        atCapacity.show();
      }
    }
  }


  private DayOfWeek getDay(String dayString) {
    return switch (dayString) {
      case "Monday" -> DayOfWeek.MONDAY;
      case "Tuesday" -> DayOfWeek.TUESDAY;
      case "Wednesday" -> DayOfWeek.WEDNESDAY;
      case "Thursday" -> DayOfWeek.THURSDAY;
      case "Friday" -> DayOfWeek.FRIDAY;
      case "Saturday" -> DayOfWeek.SATURDAY;
      case "Sunday" -> DayOfWeek.SUNDAY;
      default -> null;
    };
  }


}
