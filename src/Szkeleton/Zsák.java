package Szkeleton;

public class Zsák extends Item{

    public Zsák() {
        Zsák zsak= new Zsák();
    }
    /**
    *-9 férőhelyet “ad” a virológusnak.
    *@param v - paraméter virológus
    *@return void
    */
    @Override
    public void AntiEffekt(Virologus v) {
        System.out.println("Zsák antieffekt");
    }
    /**
    *A TárgyMegkapás() végén hívódik, amikor a Virológus felvette az Itemet. A zsák +9 férőhelyet ad a virológusnak.
    *@param v - paraméter virológus
    *@return void
    */
    @Override
    public void Effekt(Virologus v) {
        v.itemCapacity+=8;
        System.out.println("Zsák effekt");
    }
    /**
    *Meghívódáskor “a” ágenssel tér vissza.
    *@param v - paraméter virológus
    *@return a - ágens
    */
    @Override
    public Ágens BekendőésEffket(Virologus v, Ágens a) {
        return a;
    }
    /**
     * String osztály toString() fgv.jének füldefiniálása
     */
    public String toString() {
        return "A Zsák létrejött";
    }
    /**
     * True-val tér vissza, ha sikerült átvennie a kedvezményezett Virológusnak a Zsákot.
     * False-al, ha ez nem sikerült.
     * @param v
     * @return boolean
     */
    public boolean Cuccatadas(Virologus v) {
        if(v.TárgyMEgkapés(this)) {
            return true;
        }
        else {
            return false;
        }
    }
}
