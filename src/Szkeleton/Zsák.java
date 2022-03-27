package Szkeleton;

public class Zsák extends Item{
    /**
    *-9 férőhelyet “ad” a virológusnak.
    *@param v - paraméter virológus
    *@return void
    */
    @Override
    public void AntiEffekt(Virologus v) {
        v.itemCapacity -= 9;
    }
    /**
    *A TárgyMegkapás() végén hívódik, amikor a Virológus felvette az Itemet. A zsák +9 férőhelyet ad a virológusnak.
    *@param v - paraméter virológus
    *@return void
    */
    @Override
    public void Effekt(Virologus v) {
        v.itemCapacity+=9;
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
}
