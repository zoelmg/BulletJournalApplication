package cs3500.pa05.model.bujofileprocessor.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.DayOfWeek;

/**
 * The json data for the event
 *
 * @param name        the name of the event
 * @param description the desciption of the event
 * @param startTime   the start time of the event
 * @param duration    the duration of the event
 */
public record EventJson(@JsonProperty("name") String name,
                        @JsonProperty("description") String description,
                        @JsonProperty("start-time") String startTime,
                        @JsonProperty("duration") String duration) {
}
