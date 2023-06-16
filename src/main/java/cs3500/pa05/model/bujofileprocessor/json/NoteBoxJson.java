package cs3500.pa05.model.bujofileprocessor.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record NoteBoxJson(@JsonProperty("notes") List<String> notes) {
}
