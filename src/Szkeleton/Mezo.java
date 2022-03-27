package Szkeleton;
import java.util.ArrayList;

public class Mezo {
    private ArrayList<Virologus> virologusok;  // valahol tarolni kell, hogy kik tartozkodnak a Mezon
    public ArrayList<Mezo> szomszedok;

    public Mezo() {
        System.out.println(this+" letrejott");
        this.virologusok = new ArrayList<>();
        this.szomszedok = new ArrayList<>();
    }

    /*
    * A virologus egy uj mezore leptetese
    *
    * @param v A virologus, amely a mezore lep
    * @return void
    */
    public void AcceptViro(Virologus v) {
        System.out.println(this+" Elfogadta a virologust");
        this.virologusok.add(v);
    }

    /*
    * Torli a megadott virologust a mezorol.
    *
    * @param v A virologus melyet torolni szeretnenk
    * @return void
    */
    public void RemoveViro(Virologus v) {
        System.out.println(this+" eltavolitotta a virologust");
        this.virologusok.remove(v);
    }

    /*
    * Az anyag es item felvetelere szolgalo fuggveny
    */
    public void Cuccatadas(Virologus v) {
        System.out.println(this+" nem adott semmit a virologusnak (nincs mit adnia)");
    }


    /*
    *
    */
    public void Felfedez(Virologus v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return "Mezo";
    }
}
