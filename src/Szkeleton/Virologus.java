package Szkeleton;

import java.util.ArrayList;


public class Virologus implements Steppable {
    /**@author Balogh Dávid
     * A virológus attribútumai
     * */

    public ArrayList<Anyag> anyagok;
    public ArrayList<Ágens> kódok;
    public ArrayList<Ágens> ágensek;
    public ArrayList<Ágens> buff;
    public Mező mező;
    public ArrayList<Item> felszerelés;
    public ILépés LépésViselkedés;
    private ArrayList<Cucc> rabolható;

    public int itemCapacity;
    public Virologus(){
        kódok = new ArrayList<>();
        ágensek = new ArrayList<>();
        buff = new ArrayList<>();
        anyagok = new ArrayList<>();
        felszerelés = new ArrayList<>();
        LépésViselkedés = Game.getAktorLépés();
        System.out.println(this +" létrejött");
    }

    public void PutOnMező(Mező m){
        mező = m;
        m.AcceptViro(this);
    }


    /**
     * @author Balogh Dávid
     * A virológus mozgatásáért felelős függvény
     * Kiszedi az egyik mezőről és berakja a másikba
     * @param m Mező
     * */
    public void move(Mező m){
        m.AcceptViro(this);
        this.mező.RemoveViro(this);
        mező = m;
        System.out.println(this +" átment a másik mezőre");
    }

    /**
     *@author Balogh Dávid
     * Ez a függvény is a mozgatáshoz kell
     *@param m Mező
     * */
    public void Letapogat(Mező m){
        m.Felfedez(this);
    }
    /**
     * @author Balogh Dávid
     * Az Ágensek elkészítését meghívó függvény
     * @param a Ágens
     * */
    public void ÁgensElőállít(Ágens a){
        a.Create(this);
        System.out.println(this +" előállított egy "+ a+ "-t");
    }
    /**
     * @author Balogh Dávid
     * Valamilyen dolgot egy mezőről felveszünk és eltárolunk
     * */

    public void CuccFelvétel(){
        this.mező.CuccÁtadás(this);
        System.out.println(this +" felvette a mezőről a cuccot");
    }

    /**
     * @author Balogh Dávid
     * Valamilyen kódot eltárolunk
     * @param a Ágens
     * */

    public boolean GénMegkapás(Ágens a){
        this.kódok.add(a);
        System.out.println(this +" megkapta a gént");
        return true;
    }

    /**
     * @author Balogh Dávid
     * Valamilyen anyagot eltárolunk
     * @param a Anyag
     * */

    public boolean AnyagMegkapás(Anyag a){
        System.out.println(this + "Megkapta az anyagot");
        this.anyagok.add(a);
        return true;
    }
    /**
     * @author Balogh Dávid
     * Valamilyen tárgyat eltárolunk
     * @param i Item
     * */

    public boolean TárgyMegkapás(Item i){
        System.out.println(this + "Megkapta a tárgyat");
        this.felszerelés.add(i);
        i.Effekt(this);
        return true;
    }

    /**
     * @author Balogh Dávid
     * Valamilyen kész ágenst eltárolunk
     * */
    public boolean ÁgensMegkapás(Ágens a){
        System.out.println(this + "Megkapta az ágenst");
        this.ágensek.add(a);
        return true;
    }
    /**
     * @author Balogh Dávid
     * Valamilyen ágens hatást aktiválunk, tehát szintén
     * kollekcióba eltárolunk
     * */
    public boolean BuffMegkapás(Ágens a){
        System.out.println(this + "Megkapta a buffot");
        this.buff.add(a);
        return true;
    }

    /**
     * @author Balogh Dávid
     * Valamilyen ágens hatást deaktiválunk, tehát szintén
     * kollekcióból kiszedünk
     * */
    public boolean RemoveBuff(Ágens a){
        System.out.println(this + " elvesztette a buffot");
        this.buff.remove(a);
        a.AntiEffekt(this);
        return true;
    }
    public boolean CuccMegkapás(Cucc c){
        c.CuccÁtadás(this);
        return true;
    }

    /**
     * @author Balogh Dávid
     * Valamilyen dolgot kiszedünk a kollekciónkból
     * @param c Cucc
     * */

    public void RemoveCucc(Cucc c){
        System.out.println(this + " elvesztette a cuccot");
        c.removeCucc(this);
    }


    /**
     *@author Balogh Dávid
     * Ez a függvény indítja el a rablás folyamatát
     * @param v Virologus
     * */
    public void Rabol(Virologus v){
        this.rabolható=v.Rabolva();
        //felsorolunk toStringgel
    }

    /**
     * @author Balogh Dávid
     * Visszatérés a rabolható tárgyak és anyagok kollekciójával
     * */
    public  ArrayList<Cucc> Rabolva(){
        Stun s = new Stun();
        ArrayList<Cucc> c = new ArrayList<Cucc>();
        for (int i = 0; i < this.buff.size(); i++) {
            if(buff.get(i).equals(s)){

                c.addAll(felszerelés);
                c.addAll(anyagok);

            }
        }

        return c;

    }

    /**
     * @author Balogh Dávid
     *Itt vesszük ki az adott virológus kollekciójából a dolgokat
     *@param v Virologus
     *@param c Cucc
     * */
    public  void TárgyElvétel(Virologus v, Cucc c){
        v.RemoveCucc(c);
        c.CuccÁtadás(this);
    }


    /**
     * @author Balogh Dávid
     * Kinullázzuk a virológus megtanult kódjainak a kollekcióját
     * */
    public void mindentElfelejt(){
        this.kódok.removeAll(kódok);
    }

    /**
     * @author Balogh Dávid
     * LépésViselkedéstől függően lépünk a virológussal
     * */
    public void Step(){
        LépésViselkedés.Lépés(this);
    }
    /**
     * @author Balogh Dávid
     * Átállítjuk a LépésViselkedésünket
     * @param s ILépés
     * */
    public void setLépésBehaviour(ILépés s){
        this.LépésViselkedés=s;
    }

    /**
     * @author Balogh Dávid
     * ELindítja a kenés folyamatát
     * @param v Virologus
     * @param a Ágens
     * */
    public void ÁgensKenés(Virologus v, Ágens a){
        this.ágensek.remove(a);
        System.out.println(this + "bekeni a másikat");
        v.Bekenődés(this,a);
    }

    /**
     * @author Balogh Dávid
     * Bekenjük az adott virológust és aktiváljuk az effektet
     * @param v Virologus
     * @param a Ágens
     * */

    public void Bekenődés(Virologus v, Ágens a){
        for (int i = 0; i < felszerelés.size(); i++) {
            a=this.felszerelés.get(i).BekenődésEffket(v,a);
        }
        for (int i = 0; i < buff.size(); i++) {
            a=this.buff.get(i).BekenődésEffekt(a);
        }
        System.out.println(this + " alkalmazva lett a(z) " + a) ;
        a.BuffÁtadás(this);
    }

    /**
     * @author Balogh Dávid
     * A kenés védekezést és visszadobást valósítja meg
     * @param a Ágens
     * */
    public void overwhelmingBekenődés(Ágens a){
        System.out.println("right back at you buckaroo!!");
        a.BuffÁtadás(this);

    }
    /**
     * @author Balogh Dávid
     * Kör vége
     * */
    public void EndRound(){

        System.out.println("Endround meghívva");
    }

    /**
     * @author Balogh Dávid
     * Visitek
     * */
    public void visit(Mező m){
        System.out.println("Mező ősosztály visitelve lett");
    }
    public void visit(Labor l){
        System.out.println("Labor visitelve lett");

    }
    public void visit(Raktár r){
        System.out.println("Raktár visitelve lett");
    }
    public void visit(Óvóhely o){
        System.out.println("Óvóhely visitelve lett");
    }
    public void ItemVisit(Item i){
        System.out.println("Item visitelve lett");
        i.AntiEffekt(this);
    }
    public void AnyagVisit(Anyag a){
        System.out.println("Anyag visitelve lett");
    }

    @Override
    public String toString() {
        return "Virologus";
    }
}