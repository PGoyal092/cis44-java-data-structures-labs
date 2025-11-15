import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TwoFourNode{
    List<Integer> keys;
    List<TwoFourNode> children;
    TwoFourNode parent;

    public TwoFourNode(){
        keys = new ArrayList<>();
        children = new ArrayList<>();
        parent = null;
    }
    public boolean isLeaf(){
        return children.isEmpty();
    }
    public boolean isFull(){
        return keys.size()==3;
    }
    public TwoFourNode getNextChild(int key){
        int i = 0;
        while (i<keys.size() && key>keys.get(i)){
            i++;
        }
        return children.get(i);
    }
    public void insertKey(int key){
        keys.add(key);
        Collections.sort(keys);
    }
    public void insertChild(int index, TwoFourNode child){
        children.add(index, child);
        child.parent = this;
    }
}
public class TwoFourTree{
    private TwoFourNode root;
    public TwoFourTree(){
        root = new TwoFourNode();
    }
    public void insert(int key){
        TwoFourNode node = root;
        while(!node.isLeaf()){
            node=node.getNextChild(key);
        }
        node.insertKey(key);
        while(node!=null&&node.keys.size()>3){
            split(node);
            node=node.parent;
        }
    }
    private void split(TwoFourNode node){
        System.out.println("split: "+node.keys);
        int midKey = node.keys.get(2);
        TwoFourNode right = new TwoFourNode();
        List<Integer> leftKeys = new ArrayList<>();
        leftKeys.add(node.keys.get(0));
        leftKeys.add(node.keys.get(1));
        List<Integer> rightKeys = new ArrayList<>();
        rightKeys.add(node.keys.get(3));
        node.keys = leftKeys;
        right.keys = rightKeys;
        if (node.isLeaf()) {
            node.children = new ArrayList<>();
            right.children = new ArrayList<>();
        } else {
            // existing internal-node children handling
            List<TwoFourNode> leftChildren = new ArrayList<>();
            List<TwoFourNode> rightChildren = new ArrayList<>();

            leftChildren.add(node.children.get(0));
            leftChildren.add(node.children.get(1));

            rightChildren.add(node.children.get(2));
            rightChildren.add(node.children.get(3));

            node.children = leftChildren;

            for (TwoFourNode c : rightChildren) c.parent = right;
            right.children = rightChildren;
        }
        if(node.parent == null){
            TwoFourNode newRoot = new TwoFourNode();
            newRoot.keys.add(midKey);
            newRoot.children.add(node);
            newRoot.children.add(right);
            node.parent = newRoot;
            right.parent = newRoot;
            root = newRoot;
            return;
        }
        TwoFourNode parent = node.parent;
        int insertIndex = 0;
        while(insertIndex<parent.keys.size()&&midKey>parent.keys.get(insertIndex)){
            insertIndex++;
        }
        parent.keys.add(insertIndex, midKey);
        parent.children.add(insertIndex+1, right);
        right.parent=parent;
    }
    public void inorder(){
        System.out.println("inorder: ");
        inorder(root);
        System.out.println();
    }
    public void preorder() {
        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();
    }

    public void postorder() {
        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();
    }
    private void inorder(TwoFourNode node){
        if(node==null) return;
        if(node.isLeaf()){
            for(int key : node.keys){
                System.out.print(key+" ");
            }
        } else{
            int i;
            for(i=0;i<node.keys.size();i++){
                inorder(node.children.get(i));
                System.out.print(node.keys.get(i)+" ");
            }
            inorder(node.children.get(i));
        }
    }
    private void preorder(TwoFourNode node) {
        if (node == null) return;
        for (int key : node.keys) {
            System.out.print(key + " ");
        }
        for (TwoFourNode child : node.children) {
            preorder(child);
        }
    }
    private void postorder(TwoFourNode node) {
        if (node == null) return;
        for (TwoFourNode child : node.children) {
            postorder(child);
        }
        for (int key : node.keys) {
            System.out.print(key + " ");
        }
    }
}