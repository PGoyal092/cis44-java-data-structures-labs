public class AVLTreeDriver {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // TODO: Insert test values
        tree.insert(30);
        tree.insert(20);
        tree.insert(10);

        // TODO: Add more insertions to test all 4 rotation cases
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);
        tree.insert(45);
        tree.insert(42);

        // TODO: Print traversals
        System.out.print("Inorder: ");
        tree.inorder();

        System.out.print("Preorder: ");
        tree.preorder();

        System.out.print("Postorder: ");
        tree.postorder();

        // TODO: Add expected results as comments for verification
        /*
        inorder: 10 20 25 30 40 42 45 50
        preorder: 30 20 10 25 45 40 42 50
        postorder: 10 25 20 42 40 50 45 30
         */
    }
}
