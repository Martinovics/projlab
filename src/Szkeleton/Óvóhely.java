package Szkeleton;

import java.util.*;






public class Óvóhely extends Mező {


    private List<Item> item;  // egyelemű lista




    public Óvóhely() {
        this.item = new ArrayList<>();
    }




    public void AddItem(Item i) {
        if (this.item.size() == 0) {  // csak akkor adhatunk a mezőhöz itemet, ha nincs még rajta
            this.item.add(i);
        }
    }




    public void RemoveItem() {
        this.item.clear();
    }




    @Override
    public void CuccÁtadás(Virologus v) {

        if (this.item.size() == 0) {  // a mezőn nincs már item, nincs mit átadni
            return;
        }

        // ha az anyagátadás sikeres, töröljük a mezőről az itemet
        // ha sikertelen, akkor nem kell törölni semmit
        //     lehetséges okok: (pl.) a virológus nem tud többet felvenni
        if (this.item.get(0).ItemÁtadás(v)) {
            RemoveItem();
        }
    }




}
