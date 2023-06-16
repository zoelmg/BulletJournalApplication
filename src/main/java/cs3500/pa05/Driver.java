package cs3500.pa05;

import static javafx.application.Application.launch;

import cs3500.pa05.controller.BujoControllerImp;

public class Driver {

  /**
   * Runs the Bujo application.
   *
   * @param args the command-line arguments
   */
  public static void main(String[] args) {
    launch(BujoControllerImp.class, args);
  }
}
