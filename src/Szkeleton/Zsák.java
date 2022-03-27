package Szkeleton;

public class Zsák extends Item{
    public Zsák(){
        System.out.println(this+" létrejött");
    }

    /**
    *-9 férőhelyet “ad” a virológusnak.
    *@param v - paraméter virológus
    *@return void
    */
    @Override
    public void AntiEffekt(Virologus v) {
        System.out.println(this+" antieffekt");
        v.itemCapacity -= 9;
    }
    /**
    *A TárgyMegkapás() végén hívódik, amikor a Virológus felvette az Itemet. A zsák +9 férőhelyet ad a virológusnak.
    *@param v - paraméter virológus
    *@return void
    */
    @Override
    public void Effekt(Virologus v) {
        System.out.println(this+" effekt");
        v.itemCapacity+=9;
    }
    /**
    *Meghívódáskor “a” ágenssel tér vissza.
    *@param v - paraméter virológus
    *@return a - ágens
    */
    @Override
    public Ágens BekenődésEffket(Virologus v, Ágens a) {
        System.out.println(this+" bekenődésEffekt");
        return a;

    }
    public String toString() {
        return "Zsák";
    }

    @Override
    public boolean CuccÁtadás(Virologus v) {
        v.TárgyMegkapás(this);
        return true;
    }
}
