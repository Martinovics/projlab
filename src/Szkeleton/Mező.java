package Szkeleton;
import java.util.ArrayList;

public class Mező {
    private ArrayList<Virologus> virologusok;  // valahol tárolni kell, hogy kik tartózkodnak a Mezőn
    public ArrayList<Mező> szomszédok;

    public Mező() {
        System.out.println(this+" létrejött");
        this.virologusok = new ArrayList<>();
        this.szomszédok = new ArrayList<>();
    }

    /*
    * A virológus egy új mezőre léptetése
    *
    * @param v A virológus, amely a mezőre lép
    * @return void
    */
    public void AcceptViro(Virologus v) {
        System.out.println(this+" Elfogadta a virológust");
        this.virologusok.add(v);
    }

    /*
    * Törli a megadott virológust a mezőről.
    *
    * @param v A virológus melyet törölni szeretnénk
    * @return void
    */
    public void RemoveViro(Virologus v) {
        System.out.println(this+" eltávolította a virológust");
        this.virologusok.remove(v);
    }

    /*
    * Az anyag és item felvételére szolgáló függvény
    */
    public void CuccÁtadás(Virologus v) {
        System.out.println(this+" nem adott semmit a virológusnak (nincs mit adnia)");
    }


    /*
    *
    */
    public void Felfedez(Virologus v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return "Mező";
    }
}
