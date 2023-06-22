package cs3500.pa05.model;

import java.time.DayOfWeek;

public class DayUtil {

  /**
   * @param dayString is a string containing a name of a week day
   * @return the DayOfWeek enum equivalent of given String day
   */
  public static DayOfWeek getDay(String dayString) {
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
