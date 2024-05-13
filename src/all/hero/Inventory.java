package all.hero;

import all.Stuff.Items;
import java.util.Iterator;
import java.util.ArrayList;

public class Inventory {
    private final ArrayList<Items> items;

    public Inventory(){
        items = new ArrayList<Items>();
    }

    public void addItems(Items item){
        items.add(item);
    }

    public void removeItems(Items item){
        items.remove(item);
    }

    public void displayInventory(){
        Iterator<Items> iterator = items.iterator();
        int i = 0;
        while (iterator.hasNext()){
            i++;
            Items item = iterator.next();
            System.out.println(i+". "+item);
        }
    }

}
