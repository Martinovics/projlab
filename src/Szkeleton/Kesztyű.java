package Szkeleton;

public class Kesztyű extends Item{
     /**
    *Nem csinál semmi érdemlegeset.
    *@param v - paraméter virológus
    *@return void
    */
    @Override
    public void AntiEffekt(Virologus v) {
        Item.AntiEffekt(v);
        v.TárgyElvétel(v, this);
        
    }
    /**
    *A TárgyMegkapás() végén hívódik, amikor a Virológus felvette az Itemet.
    *A kesztyű Effekt metódusa nem csinál semmi érdemlegeset.
    *@param v - paraméter virológus
    *@return void
    */
    @Override
    public void Effekt(Virologus v) {
        Item.Effekt(v);
    }
     /**
    *A paraméterként kapott virológusra keni vissza az "a" ágenst, s Nullágenssel tér vissza.
    *@param v - paraméter virológus
    *@param a - paraméterként kapott ágens
    *@return Nullágens
    */
    @Override
    public Ágens BekendőésEffket(Virologus v, Ágens a) {
        v.BekendőésEffket(v, a);
        return NullÁgens;
    }
}
