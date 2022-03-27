package Szkeleton;

import java.util.*;

public class ovohely extends Mezo {
    private List<Item> item;  // egyelemu lista

    public ovohely() {
        System.out.println("ovohely letrejott");
        this.item = new ArrayList<>();
    }

    /*
     * Itemet ad a mezohoz (egy mezon, egy item)
     *
     * @param i A mezohoz adando item
     * @return void
     */
    public void AddItem(Item i) {
        if (this.item.size() == 0) {  // csak akkor adhatunk a mezohoz itemet, ha nincs meg rajta
            this.item.add(i);
        }
    }

    /*
     * Torli az itemet a mezorol
     *
     * @return void
     */
    public void RemoveItem() {
        this.item.clear();
    }

    /*
    * atadja az itemet a megadott virologusnak
    *
    * @param v A virologus, melynek at akarjuk adni az itemet
    * @return void
    */
    @Override
    public void Cuccatadas(Virologus v) {

        if (this.item.size() == 0) {  // a mezon nincs mar item, nincs mit atadni
            return;
        }

        // ha az item atadas sikeres, toroljuk a mezorol az itemet
        // ha sikertelen, akkor nem kell torolni semmit
        //     lehetseges okok: (pl.) a virologus nem tud tobbet felvenni
        if (this.item.get(0).Itematadas(v)) {
            RemoveItem();
        }
    }
}