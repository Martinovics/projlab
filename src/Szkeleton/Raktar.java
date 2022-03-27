package Szkeleton;

import java.util.*;


public class Raktar extends Mezo {


    private List<Anyag> anyag;  // egyelemu lista

    public Raktar() {
        System.out.println(this+" letrejott");
        this.anyag = new ArrayList<>();
    }

    /*
    * Anyagot ad a mezohoz (egy mezon, egy anyag)
    *
    * @param a A mezohoz adando anyag
    * @return void
    */
    public void AddAnyag(Anyag a) {
        if (this.anyag.size() == 0) {  // csak akkor adhatunk a mezohotz anyagot, ha nincs meg rajta
            this.anyag.add(a);
        }
    }

    /*
    * Torli az anyagot a mezorol
    *
    * @return void
    */
    public void RemoveAnyag() {
        this.anyag.clear();  // a lista teljes tartalmat torli
    }




    /*
    * atadja az anyagot a megadott virologusnak
    *
    * @param v A virologus, melynek at akarjuk adni az anyagot
    * @return void
    */
    @Override
    public void Cuccatadas(Virologus v) {

        if (this.anyag.size() == 0) {  // a mezon nincs mar anyag, nincs mit atadni
            return;
        }

        // ha az anyagatadas sikeres, toroljuk a mezorol az anyagot
        // ha sikertelen, akkor nem kell torolni semmit
        //     lehetseges okok: (pl.) a virologus nem tud tobb anyagot felvenni
        if (this.anyag.get(0).Anyagatadas(v)) {
            RemoveAnyag();
        }
    }

    @Override
    public String toString() {
        return "Raktar";
    }
}
