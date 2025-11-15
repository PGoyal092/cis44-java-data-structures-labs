public class TwoFourTreeDriver {
    public static void main(String[] args) {
        TwoFourTree tree = new TwoFourTree();

        // Test sequence for splits
        int[] keys = {10, 20, 30, 40, 50, 60, 70, 80, 90, 5, 15, 25, 35};

        System.out.println("Inserting keys into 2-4 Tree...");
        for (int key : keys) {
            System.out.println("Inserting: " + key);
            tree.insert(key);
        }

        System.out.println("\nFinal Tree Traversals:");
        tree.inorder();
        tree.preorder();
        tree.postorder();

        // TODO: Students can also implement preorder/postorder traversal for practice

        System.out.println("\nExpected Inorder: 5 10 15 20 25 30 35 40 50 60 70 80 90");
        System.out.println("\nExpected Preorder: 15 30 60 5 10 20 25 35 40 50 70 80 90");
        System.out.println("\nExpected Postorder: 5 10 20 25 35 40 50 70 80 90 15 30 60");
    }
}