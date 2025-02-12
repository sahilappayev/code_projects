package note;

import util.InputOutput;


// value index-e data daxil etmek olmaz
// bosh indexleri eks eletdirmek
public class Note {

    public static void fillNotes() {
        String[] notes = new String[5];

        boolean isNoteArrFull = false;

        while (!isNoteArrFull) {
            int index = InputOutput.getUserIntInput("Enter note index or '-1' for exit: ");

            checkExitCommand(index, notes);

            if (index < 0 || index > notes.length) {
                InputOutput.printErrorText("Index must be between 0 and " + (notes.length - 1) + "!!!");
                continue;
            }

            String note = InputOutput.getUserTextInput("Enter note text: ");

            InputOutput.printText("Notes: ");

            addNote(notes, note, index);

            printNotes(notes);

            isNoteArrFull = isArrayFull(notes);
        }
    }

    public static void addNote(String[] notes,
                               String note,
                               int index) {
        notes[index] = note;
    }

    //varargs
    public static void printNotes(String ... notes) {
        InputOutput.printText("-----------------");
        for (String s : notes) {
            InputOutput.printText(s);
        }
        InputOutput.printText("-----------------");
    }

    public static boolean isArrayFull(String[] notes) {
        boolean nullCheckingFlag = true;

        for (String s : notes) {
            if (s == null) {
                nullCheckingFlag = false;
                break;
            }
        }

        return nullCheckingFlag;
    }

    public static void checkExitCommand(int index, String[] notes) {
        if (index == -1) {
            printNotes(notes);
            InputOutput.printText("App is closing...");
            System.exit(0);
        }
    }


}
