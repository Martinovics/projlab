package Szkeleton;

import java.util.*;






public class Óvóhely extends Mező {


    private List<Item> item;  // egyelemű lista




    public Óvóhely() {
        this.item = new ArrayList<>();
    }



    /*
     * Itemet ad a mezőhöz (egy mezőn, egy item)
     *
     * @param i A mezőhöz adandó item
     * @return void
     */
    public void AddItem(Item i) {
        if (this.item.size() == 0) {  // csak akkor adhatunk a mezőhöz itemet, ha nincs még rajta
            this.item.add(i);
        }
    }




    /*
     * Törli az itemet a mezőről
     *
     * @return void
     */
    public void RemoveItem() {
        this.item.clear();
    }




    /*
    * Átadja az itemet a megadott virológusnak
    *
    * @param v A virológus, melynek át akarjuk adni az itemet
    * @return void
    */
    @Override
    public void CuccÁtadás(Virologus v) {

        if (this.item.size() == 0) {  // a mezőn nincs már item, nincs mit átadni
            return;
        }

        // ha az item átadás sikeres, töröljük a mezőről az itemet
        // ha sikertelen, akkor nem kell törölni semmit
        //     lehetséges okok: (pl.) a virológus nem tud többet felvenni
        if (this.item.get(0).ItemÁtadás(v)) {
            RemoveItem();
        }
    }




}
