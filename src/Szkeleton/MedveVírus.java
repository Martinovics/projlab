package Szkeleton;

public class MedveVírus extends Ágens {
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
     * MedveVírus konstruktora
     */
    public MedveVírus() {
        //MedveVírus medvevir = new MedveVírus();
        ID = IDgen++;
    }

    /*
    A paraméterként kapott a Ágenssel tér vissza.
    */
    public Ágens BekendőésEffket(Virologus v, Ágens a) {
        return a;
    }
    /**
    *A TárgyMegkapás() végén hívódik, amikor a Virológus felvette az Itemet.
    *A medvevírus Effekt metódusa nem csinál semmi érdemlegeset.
    *@param v - paraméter virológus
    *@return void
    */
    @Override
    public void Effekt(Virologus v) {
        System.out.println("Köpeny effektus");
    }
     /**
    *Nem csinál semmi érdemlegeset.
    *@param v - paraméter virológus
    *@return void
    */
    @Override
    public void AntiEffekt(Virologus v) {
        System.out.println("Medvevírus antieffektus");
    }
    /**
     * String osztály toString() fgv.jének füldefiniálása
     */
    public String toString() {
        return "A Medvevírus létrejött";
    }
    /**
     * Megfertőzi (átadja magát) a paraméterként kapott Virológust a MedveVírussal, s ennek hatására az állapota ,,Kod''-ra áll.
     * @param v
     */
    private void Fertőz(Virologus v) {
        if(v.BuffMegkapás(this)) {
            this.state = State.Kod;
        }
        else {
            
        }
    }
    /**
     * Meghívja a paraméterként kapott Virológusra a Fertőz() fgv.-t.
     * @param v
     */
    public void Buffátadás(Virologus v) {
        MedveVírus medvev = new MedveVírus();
        medvev.Fertőz(v);
    }
}
