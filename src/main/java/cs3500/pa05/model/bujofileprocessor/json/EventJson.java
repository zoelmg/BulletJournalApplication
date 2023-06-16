package cs3500.pa05.model.bujofileprocessor.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.DayOfWeek;

public record EventJson(@JsonProperty("name") String name,
                        @JsonProperty("description") String description,
                        @JsonProperty("start-time") String startTime,
                        @JsonProperty("duration") String duration) {
}
