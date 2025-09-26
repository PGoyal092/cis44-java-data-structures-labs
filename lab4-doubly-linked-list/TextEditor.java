public class TextEditor {
    private static class Node {
        String textState;
        Node prev;
        Node next;
        // Node constructor...
        Node(String textStatic, Node prev, Node next) {
            this.textState = textStatic;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node currentNode;

    public TextEditor() {
        // Start with an initial empty string state.
        this.currentNode = new Node("", null, null);
    }

    public void add(String newText) {
        // Create a new node with the updated text.
        // Set its 'prev' to the current node.
        // Set the current node's 'next' to this new node.
        // Finally, update currentNode to point to the new node.
        currentNode.next = null;
        Node newNode = new Node(currentNode.textState+newText, currentNode, null);
        currentNode.next = newNode;
        currentNode = newNode;
    }

    public String undo() {
        // Check if currentNode.prev is not null.
        // If it is, move currentNode back and return the text.
        // Otherwise, you can't undo.
        if (currentNode.prev != null) {
            currentNode = currentNode.prev;
        }
        return currentNode.textState;
    }

    public String redo() {
        // Check if currentNode.next is not null.
        // If it is, move currentNode forward and return the text.
        if (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return currentNode.textState;
    }

    public void printCurrent() {
        System.out.println(currentNode.textState);
    }
}