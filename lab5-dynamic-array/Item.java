import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Item{
    String name;

    //Constructor
    public Item(String name){
        this.name=name;
    }

    //getter
    public String getName() {
        return name;
    }

    //toString
    @Override
    public String toString() {
        return name;
    }
}
