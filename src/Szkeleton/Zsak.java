package Szkeleton;

public class Zsak extends Item{
    public Zsak(){
        System.out.println(this+" letrejott");
    }

    /**
    *-9 ferohelyet “ad” a virologusnak.
    *@param v - parameter virologus
    *@return void
    */
    @Override
    public void AntiEffekt(Virologus v) {
        System.out.println(this+" antieffekt");
        v.itemCapacity -= 9;
    }
    /**
    *A TargyMegkapas() vegen hivodik, amikor a Virologus felvette az Itemet. A zsak +9 ferohelyet ad a virologusnak.
    *@param v - parameter virologus
    *@return void
    */
    @Override
    public void Effekt(Virologus v) {
        System.out.println(this+" effekt");
        v.itemCapacity+=9;
    }
    /**
    *Meghivodaskor “a” agenssel ter vissza.
    *@param v - parameter virologus
    *@return a - agens
    */
    @Override
    public agens BekenodesEffket(Virologus v, agens a) {
        System.out.println(this+" bekenodesEffekt");
        return a;

    }
    public String toString() {
        return "Zsak";
    }

    @Override
    public boolean Cuccatadas(Virologus v) {
        v.TargyMegkapas(this);
        return true;
    }
}
