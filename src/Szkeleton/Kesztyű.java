package Szkeleton;

public class Kesztyű extends Item{
    /*
    NoUses - alapértelmezés szerint 3, de ha 0-ra állítódik megsemmisíti önmagát.
    */
    private int NoUses;
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
    Konstruktor, alapértelmezett 3-as értékre állítja az attribútum értékét.
    */
    public Kesztyű(){
        this.setNoUses(3);
        ID = IDgen++;
    }

    @Override
    public void AntiEffekt(Virologus v) {
        //v.TárgyElvétel(v, this);
        System.out.println("Kesztyű antieffektus");
    }

    /*
    Getter fgv. a NoUses attribútumnak.
    */
    public int getNoUses() {
        return NoUses;
    }

    /*
    Setter fgv. a NoUses attribútumnak.
    */
    public void setNoUses(int noUses) {
        this.NoUses = noUses;
    }
    /**
    *A TárgyMegkapás() végén hívódik, amikor a Virológus felvette az Itemet.
    *A kesztyű Effekt metódusa nem csinál semmi érdemlegeset.
    *@param v - paraméter virológus
    *@return void
    */
    @Override
    public void Effekt(Virologus v) {
        System.out.println("Kesztyű effektus");
    }
     /**
    *A paraméterként kapott virológusra keni vissza az "a" ágenst, s Nullágenssel tér vissza.
    *@param v - paraméter virológus
    *@param a - paraméterként kapott ágens
    *@return Nullágens
    */
    @Override
    public Ágens BekendőésEffket(Virologus v, Ágens a) {
        v.Bekenődés(v, a);
        NullÁgens nulla = new NullÁgens();
        if(this.getNoUses()>0) {
            this.setNoUses(this.getNoUses()-1);
        }
        else if(this.getNoUses()==0) {
            v.RemoveCuc(this);
        }
        return nulla;
    }
    /**
     * String osztály toString() fgv.jének füldefiniálása
     */
    public String toString() {
        return "A Kesztyű létrejött";
    }

    /**
     * True-val tér vissza, ha sikerült átvennie a kedvezményezett Virológusnak a Kesztyűt.
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
