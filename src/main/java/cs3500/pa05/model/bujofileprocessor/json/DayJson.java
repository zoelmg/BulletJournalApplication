package cs3500.pa05.model.bujofileprocessor.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.DayOfWeek;
import java.util.List;

public record DayJson(@JsonProperty("week-day") DayOfWeek weekday,
                      @JsonProperty("events") List<EventJson> events,
                      @JsonProperty("tasks") List<TaskJson> tasks) {
}
