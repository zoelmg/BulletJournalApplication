package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.DayOfWeek;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test methods related to Day
 */
class DayTest {

  Day day1;
  TaskItem task1;
  EventItem event1;

  /**
   * Sets up a Day object for use in in all future tests for the Day class
   */
  @BeforeEach
  void setup() {
    day1 = new Day(DayOfWeek.FRIDAY);

  }

  /**
   * Tests side effects of void method for adding a TaskItem to a Day object
   */
  @Test
  void testAddItemTask() {
    task1 = new TaskItem("task name 1", "task description 1");
    assertEquals(day1.getTasks().size(), 0);

    day1.addItem(task1);
    assertEquals(day1.getTasks().size(), 1);
  }

  /**
   * Tests side effects of void method for adding an EventItem to a Day object
   */
  @Test
  void testAddItemEvent() {
    //before adding an event
    event1 = new EventItem("event name 1", "event description 1",
        "start time 1", "duration 1");
    assertEquals(day1.getEvents().size(), 0);

    //after adding an event
    day1.addItem(event1);
    assertEquals(day1.getEvents().size(), 1);
  }

  /**
   * Tests side effects of void method for removing a TaskItem from a Day object
   */
  @Test
  void testRemoveItemTask() {
    //before removing a task
    task1 = new TaskItem("task name 1", "task description 1");
    day1.addItem(task1);
    assertEquals(day1.getTasks().size(), 1);

    //after removing a task
    day1.removeItem(task1);
    assertEquals(day1.getTasks().size(), 0);
  }

  /**
   * Tests side effects of void method for removing an EventItem from a Day object
   */
  @Test
  void testRemoveItemEvent() {
    //before removing an event
    event1 = new EventItem("event name 1", "event description 1",
        "start time 1", "duration 1");
    day1.addItem(event1);
    assertEquals(day1.getEvents().size(), 1);

    //after removing an event
    day1.removeItem(event1);
    assertEquals(day1.getEvents().size(), 0);
  }

  /**
   * Test for the getter method that retrieves the DayOfWeek of a given Day object
   */
  @Test
  void testGetDayOfWeek() {
    assertEquals(day1.getDayOfWeek(), DayOfWeek.FRIDAY);
  }

}