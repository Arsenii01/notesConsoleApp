import java.time.LocalDate;
import java.util.*;

public class NotesStorage {

    private int counter = 1;

    private final Map<Integer, String> notesTitle = new HashMap<>();
    private final Map<Integer, String> notesText = new HashMap<>();

    private final Map<Integer, LocalDate> notesDates = new HashMap<>();

    public void addNote(String title, String text) {
        notesTitle.put(counter, title);
        notesText.put(counter, text);
        notesDates.put(counter, LocalDate.now());
        counter++;
    }

    public StringBuilder getNotes() {
        StringBuilder result = new StringBuilder();
        List<Integer> keys = new ArrayList<>(notesTitle.keySet());
        Collections.sort(keys);
        for (int num: keys) {
            result.append(num).append(". ").append(notesTitle.get(num)).append(" - ").append(notesDates.get(num));
            result.append("\n").append(notesText.get(num));
        }
        return result;
    }

    public void editNote(int num, String newText) {
        notesText.put(num, newText);
        notesDates.put(num, LocalDate.now());
    }

    public void deleteNote(int num) {
        notesText.remove(num);
        notesTitle.remove(num);
        notesDates.remove(num);
    }

    public String getTitle(int num) {
        return notesTitle.get(num);
    }

    public boolean keyInNotes(int num) {
        return notesTitle.containsKey(num);
    }
}
