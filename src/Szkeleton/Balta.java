package Szkeleton;

public class Balta extends Item {

    /**
     * Az aktuális ID-ja za objektumnak, ami inkrementálódik.
     */
    static private int IDgen;
    /**
     * ID of the Object
     * @author Balogh Csaba
     */
    private int ID;
    /**
     * Balta konstruktora
     */
    public Balta() {
       //Balta balta = new Balta();
       ID = IDgen++;
    }
     /**
    *A TárgyMegkapás() végén hívódik, amikor a Virológus felvette az Itemet.
    *A balta Effekt metódusa nem csinál semmi érdemlegeset.
    *@param v - paraméter virológus
    *@return void
    */
    @Override
    public void Effekt(Virologus v) {
       v.setLépésBehaviour();
    }
     /**
    *A kesztyű AntiEffekt metódusa nem csinál semmi érdemlegeset.
    *@param v - paraméter virológus
    *@return void
    */
    @Override
    public void AntiEffekt(Virologus v) {
       v.setLépésBehaviour();
    }
     /**
    *A paraméterként kapott virológusra keni vissza az "a" ágenst, s Nullágenssel tér vissza.
    *@param v - paraméter virológus
    *@param a - paraméterként kapott ágens
    *@return Nullágens
    */
    @Override
    public Ágens BekendőésEffket(Virologus v, Ágens a) {
        return a;
    }
    /**
     * String osztály toString() fgv.jének füldefiniálása
     */
    @Override
    public String toString() {
        return "A Balta létrejött";
    }
    /**
     * True-val tér vissza, ha sikerült átvennie a kedvezményezett Virológusnak a Baltát.
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
