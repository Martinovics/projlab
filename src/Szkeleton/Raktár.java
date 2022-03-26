package Szkeleton;

import java.util.*;






public class Raktár extends Mező {


    private List<Anyag> anyag;  // egyelemű lista




    public Raktár() {
        this.anyag = new ArrayList<>();
    }




    public void AddAnyag(Anyag a) {
        if (this.anyag.size() == 0) {  // csak akkor adhatunk a mezőhötz anyagot, ha nincs még rajta
            this.anyag.add(a);
        }
    }




    public void RemoveAnyag() {
        this.anyag.clear();  // a lista teljes tartalmát törli
    }




    @Override
    public void CuccÁtadás(Virologus v) {

        if (this.anyag.size() == 0) {  // a mezőn nincs már anyag, nincs mit átadni
            return;
        }

        // ha az anyagátadás sikeres, töröljük a mezőről az anyagot
        // ha sikertelen, akkor nem kell törölni semmit
        //     lehetséges okok: (pl.) a virológus nem tud több anyagot felvenni
        if (this.anyag.get(0).AnyagÁtadás(v)) {
            RemoveAnyag();
        }


    }




}
