package Szkeleton;

public class VédőÁgens extends Ágens{
    /**
    *NullÁgenssel tér vissza
    *@param v - virológus
    *@return ágens
    */
    @Override
    public Ágens BekendőésEffekt(Ágens a) {
        return NullÁgenssel;
    }
    /**
    *Lásd:Ágens. + Semlegesít minden ágenst, amit a körben és a következő egy körben  a Virológusra kentek.
    *@param v - virológus
    *@return void
    */
    @Override
    public void Effekt(Virologus v) {
        Item.Effekt(v);
    }
    /**
    *Nem csinál semmit.
    *@param v - virológus
    *@return void
    */
    @Override
    public void AntiEffekt(Virologus v) {

    }
}
