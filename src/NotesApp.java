import java.util.Scanner;

public class NotesApp {

    private final Scanner scanner = new Scanner(System.in);
    private final NotesStorage notesStorage = new NotesStorage();


    private void startupMessage() {
        System.out.println("Добро пожаловать в приложение 'Заметки'!");
        System.out.println("1. Добавить заметку");
        System.out.println("2. Просмотреть заметки");
        System.out.println("3. Редактировать заметку");
        System.out.println("4. Удалить заметку");
        System.out.println("5. Выход");
    }

    private StringBuilder readNoteText() {
        String newLine = "";
        StringBuilder noteText = new StringBuilder();
        while (!newLine.equals("end")) {
            newLine = scanner.nextLine();
            if (!newLine.equals("end")) {
                noteText.append(newLine).append("\n");
            }
        }
        return noteText;
    }

    private void addNote() {
        System.out.println("Выберите заголовок заметки: ");
        String title = scanner.nextLine();
        System.out.println("Введите текст заметки (для завершения введите 'end'):");

        StringBuilder noteText = readNoteText();

        notesStorage.addNote(title, noteText.toString());
    }

    private void readNotes() {
        StringBuilder result = notesStorage.getNotes();
        if (result.isEmpty()) {
            System.out.println("Заметок нет");
        } else {
            System.out.println(notesStorage.getNotes().toString());

        }
    }

    private void editNote() {
        System.out.println("Введите номер заметки для изменения: ");
        int num = Integer.parseInt(scanner.nextLine());
        if (!notesStorage.keyInNotes(num)) {
            System.out.println("Заметки с таким номером нет!");
            return;
        }
        System.out.println("Введите новый текст заметки (для завершения введите \"end\"): ");
        StringBuilder noteText = readNoteText();
        notesStorage.editNote(num, noteText.toString());
        System.out.println("Заметка успешно удалена");

    }

    private void deleteNote() {
        System.out.println("Введите номер заметки для удаления: ");
        int num = Integer.parseInt(scanner.nextLine());
        if (!notesStorage.keyInNotes(num)) {
            System.out.println("Заметки с таким номером нет!");
            return;
        }
        String title = notesStorage.getTitle(num);
        notesStorage.deleteNote(num);
        System.out.printf("Заметка '%s' успешно удалена\n", title);
    }

    public void run() {
        startupMessage();
        while (true) {
            System.out.println("Выберите действие (введите номер): ");
            int command = Integer.parseInt(scanner.nextLine());
            switch (command) {
                case 1:
                    addNote();
                    break;
                case 2:
                    readNotes();
                    break;
                case 3:
                    editNote();
                    break;
                case 4:
                    deleteNote();
                    break;
                case 5:
                    System.out.println("До свидания!");
                    return;
                default:
                    System.out.println("Неизвестная команда!");
                    break;
            }
        }

    }
}
