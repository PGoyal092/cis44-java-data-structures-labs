public class Main{
    public static void main(String[] args){
        Inventory inventory = new Inventory();
        inventory.addItem(new Item("Hello"));
        inventory.addItem(new Item("World"));
        inventory.addItem(new Item("Mine"));
        inventory.addItem(new Item("Yep"));
        inventory.display();
        inventory.combineItems("Hello",  "World");
        inventory.display();
    }
}
