package Szkeleton;

import java.util.*;






public class Mező {


    private List<Virologus> virologusok;  // valahol tárolni kell, hogy kik tartózkodnak a Mezőn
    public List<Mező> szomszédok;




    public Mező() {
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

        this.virologusok.add(v);

        for (Mező mezo : this.szomszédok) {  // kitöröljük a virológust szomszédos mezőről (mert csak onnan jöhetett)
            mezo.RemoveViro(v);
        }

    }



    /*
    * Törli a megadott virológust a mezőről.
    *
    * @param v A virológus melyet törölni szeretnénk
    * @return void
    */
    public void RemoveViro(Virologus v) {
        this.virologusok.remove(v);
    }




    /*
    * Az anyag és item felvételére szolgáló függvény
    */
    public void CuccÁtadás(Virologus v) { }




    /*
    *
    */
    public void Felfedez(Virologus v) {
        v.visit(this);
    }
}
