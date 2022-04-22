package Szkeleton;

public class MedveVírus extends Ágens {
    
    public MedveVírus() {
        MedveVírus medvevir = new MedveVírus();
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

    private void Fertőz(Virologus v) {
        if(v.BuffMegkapás(this)) {
            this.KódÁtadás();
        }
        else {
            
        }
    }

    public void Buffátadás(Virologus v) {
        MedveVírus medvev = new MedveVírus();
        medvev.Fertőz(v);
    }
}
