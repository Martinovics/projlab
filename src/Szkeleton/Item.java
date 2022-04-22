package Szkeleton;


public class Item implements Cucc {

    /**
     * Item konstruktora
     */
    public Item() {
        Item item = new Item();
    }
    /**
    *A TárgyMegkapás() végén hívódik, amikor a Virológus felvette az Itemet. A ténylegesen megvalósított leszármazott írja le, hogy valóban mit csinál.
    *@param v - paramáter virológus
    *@return void
    */
    public void Effekt(Virologus v){
        v.CuccFelvétel();
    }
     /**
    *Leszármazottban érdekes.
    *@param v - paramáter virológus
    *@return void
    */
    public void AntiEffekt(Virologus v){

    }
     /**
    *Akkor hívódik meg, amikor a birtokló virológust valamivel bekennék. Ilyenkor az Itemeknek van beleszólása milyen Ágenssel lesz bekenve. 
    *@param v - virológus
    *@param a - ágens
    *@return ágens
    */
    public Ágens BekendőésEffket(Virologus v, Ágens a){
        v.Bekenődés(v, a);
        return a;
    }
     /**
    *Meghívja a v ItemVisit()-jét, ami majd visszahívja az AntiEffektet()
    *@param v - paramáter virológus
    *@return void
    */
    public void RemoveCucc(Virologus v){
            v.ItemVisit(this);
    }
     /**
    *Eszköz átadása a paraméterként kapott virológusnak, ha igazzal tér vissza.
    *@param v - paramáter virológus
    *@return boolean (true/false)
    */
    public boolean ItemÁtadás(Virologus v){
            if(v.TárgyMEgkapés(this)) {
                return true;
            }
            else {
                return false;
            }
    }
}
