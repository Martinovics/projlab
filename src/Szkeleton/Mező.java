package Szkeleton;

import java.util.*;






public class Mező {


    private List<Virologus> virologusok;  // valahol tárolni kell, hogy kik tartózkodnak a Mezőn
    public List<Mező> szomszédok;




    public Mező() {
        this.virologusok = new ArrayList<>();
        this.szomszédok = new ArrayList<>();
    }




    public void AcceptViro(Virologus v) {

        // hozzáadjuk a virológust az aktuális mezőhöz
        this.virologusok.add(v);

        // kitöröljük a virológust az egyik szomszédos mezőről (mert csak onnan jöhetett)
        for (Mező mezo : this.szomszédok) {
            mezo.RemoveViro(v);  // ha nincs rajta a virológus, akkor sem dob hibát -> összes szomszédra meghívható
        }

    }




    public void RemoveViro(Virologus v) {
        this.virologusok.remove(v);
    }




    public void CuccÁtadás(Virologus v) { }  // az ősben itt nincs teendő




    public void Felfedez(Virologus v) {
        v.visit(this);
    }
}
