import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Inventory{
    private List<Item> items;
    public Inventory(){
        this.items = new ArrayList<>();
    }
    public void addItem(Item item){
        this.items.add(item);
    }
    public void display(){
        for (Item item : this.items) {
            System.out.println(item.getName());
        }
    }
    public void combineItems(String name1, String name2){
        boolean found1 =  false;
        boolean found2 = false;

        Iterator<Item> iter = items.iterator();
        while(iter.hasNext()){
            Item current = iter.next();
            if(current.getName().equals(name1)|| current.getName().equals(name2)){
                if(current.getName().equals(name1)&&!found1){
                    found1 = true;
                    iter.remove();
                }
                if(current.getName().equals(name2)&&!found2){
                    found2 = true;
                    iter.remove();
                }
            }
            if(found1&&found2){
                break;
            }
        }
        if(found1&&found2){
            String combinedName = name1+name2;
            Item combinedItem = new Item(combinedName);
            this.items.add(combinedItem);
            System.out.println("Item combination has been combined into: "+combinedName);
        }
    }
}
