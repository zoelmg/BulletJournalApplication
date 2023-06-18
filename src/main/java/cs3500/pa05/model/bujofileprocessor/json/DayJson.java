package cs3500.pa05.model.bujofileprocessor.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.DayOfWeek;
import java.util.List;

/**
 * Json data for a day in the week
 *
 * @param weekday the day of the week
 * @param events  the events in the day
 * @param tasks   the tasks in the day
 */
public record DayJson(@JsonProperty("week-day") DayOfWeek weekday,
                      @JsonProperty("events") List<EventJson> events,
                      @JsonProperty("tasks") List<TaskJson> tasks) {
}
