package cs3500.pa05.model.bujofileprocessor.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * The json data for a notebox
 *
 * @param notes the list of notes in the note box
 */
public record NoteBoxJson(@JsonProperty("notes") List<String> notes) {
}
