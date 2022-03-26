package Szkeleton;

import java.util.Random;

        /*
        * 82.3%-al ad vissza NullÁgens-t, a többi esetben a paraméterként kapott a-t.
        @param v - paramáterként kapott virológus
        @param a - paraméterként kapott ágens
        *
        @return
        */
public class Köpeny extends Item{
    @Override
    public Ágens BekendőésEffket(Virologus v, Ágens a) {
        Random rand = new Random();
        rand.nextDouble();
        if(rand<=0.823) {
            return NullÁgens;
        }
        else {
            return a;
        }
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
    *Nem csinál semmi érdemlegeset.
    *@param v - paraméter virológus
    *@return void
    */
    @Override
    public void AntiEffekt(Virologus v) {
        Item.AntiEffekt(v);
    }
}
