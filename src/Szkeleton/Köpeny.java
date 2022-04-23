package Szkeleton;

import java.util.Random;

    /**
     * Az aktuális ID-ja za objektumnak, ami inkrementálódik.
     */

    /*
        * 82.3%-al ad vissza NullÁgens-t, a többi esetben a paraméterként kapott a-t.
        @param v - paramáterként kapott virológus
        @param a - paraméterként kapott ágens
        *
        @return
    */
public class Köpeny extends Item{
     
    /**
     * Az aktuális ID-ja za objektumnak, ami inkrementálódik.
     */
    static private int IDgen;
    /**
     * ID of the Object
     * @author Balogh Csaba
     */
    private int ID;
    /*
    Köpeny konstruktora
    */
    public Köpeny(){
        ID = IDgen++;
    }

    /*
    82.3 % valószínűséggel ad vissza NullÁgenst(üres), a többi esetben a paraméterként kapott a ágenst adja vissza.
    */
    @Override
    public Ágens BekendőésEffket(Virologus v, Ágens a) {
        Random rand = new Random();
        double drand = rand.nextDouble();
        if(drand<=0.823) {
            NullÁgens nulla = new NullÁgens();
            return nulla;
        }
        else {
            return a;
        }
    }
    /**
    *A TárgyMegkapás() végén hívódik, amikor a Virológus felvette az Itemet.
    *A köpeny Effekt metódusa nem csinál semmi érdemlegeset.
    *@param v - paraméter virológus
    *@return void
    */
    @Override
    public void Effekt(Virologus v) {
        System.out.println("Köpeny effekt");
    }
     /**
    *Nem csinál semmi érdemlegeset.
    *@param v - paraméter virológus
    *@return void
    */
    @Override
    public void AntiEffekt(Virologus v) {
        System.out.println("Köpeny antieffektus");
    }
    /**
     * String osztály toString() fgv.jének füldefiniálása
     */
    public String toString() {
        return "A Köpeny létrejött";
    }

    /**
     * True-val tér vissza, ha sikerült átvennie a kedvezményezett Virológusnak a Köpenyt.
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
