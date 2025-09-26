public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.add("Hello");
        editor.printCurrent();  // Output: Hello

        editor.add(", world!");
        editor.printCurrent();  // Output: Hello, world!

        editor.undo();
        editor.printCurrent();  // Output: Hello

        editor.redo();
        editor.printCurrent();  // Output: Hello, world!

        editor.undo();
        editor.add(" there!");
        editor.printCurrent();  // Output: Hello there!

        editor.redo(); // Does nothing — redo history was cleared when new text was added.
        editor.printCurrent();  // Output: Hello there!
    }
}