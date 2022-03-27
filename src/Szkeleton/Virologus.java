package Szkeleton;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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

    /**
     * @author Balogh Dávid
     * A virológus mozgatásáért felelős függvény
     * Kiszedi az egyik mezőről és berakja a másikba
     * @param m Mező
     * */
    public void move(Mező m){

        m.AcceptViro(this);
        this.mező.RemoveViro(this);

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

    }
    /**
     * @author Balogh Dávid
     * Valamilyen dolgot egy mezőről felveszünk és eltárolunk
     * */
    public void CuccFelvétel(){
        this.mező.CuccÁtadás(this);
    }

    /**
     * @author Balogh Dávid
     * Valamilyen kódot eltárolunk
     * @param a Ágens
     * */
    public boolean GénMegkapás(Ágens a){
        this.kódok.add(a);
        return true;
    }
    /**
     * @author Balogh Dávid
     * Valamilyen anyagot eltárolunk
     * @param a Anyag
     * */
    public boolean AnyagMegkapás(Anyag a){
        this.anyagok.add(a);
        return true;
    }
    /**
     * @author Balogh Dávid
     * Valamilyen tárgyat eltárolunk
     * @param i Item
     * */
    public boolean TárgyMegkapás(Item i){
        this.felszerelés.add(i);
        i.Effekt(this);
        return true;
    }
    /**
     * @author Balogh Dávid
     * Valamilyen kész ágenst eltárolunk
     * */
    public boolean ÁgensMegkapás(Ágens a){
        this.ágensek.add(a);

        return true;
    }
    /**
     * @author Balogh Dávid
     * Valamilyen ágens hatást aktiválunk, tehát szintén
     * kollekcióba eltárolunk
     * */
    public boolean BuffMegkapás(Ágens a){
        this.buff.add(a);
        a.Effekt(this);
        return true;
    }
    /**
     * @author Balogh Dávid
     * Valamilyen ágens hatást deaktiválunk, tehát szintén
     * kollekcióból kiszedünk
     * */
    public void RemoveBuff(Ágens a){
        a.AntiEffekt(this);
        this.buff.remove(a);
    }



    /**
     * @author Balogh Dávid
     * Valamilyen dolgot kiszedünk a kollekciónkból
     * @param c Cucc
     * */

    public void RemoveCucc(Cucc c){

        c.RemoveCucc(this);

        /*try{
          this.felszerelés.remove(c);
        }
        catch (Exception e){

        }

        try {
            this.anyagok.remove(c);
        }
        catch (Exception e){

        }*/

    }


    /**
     *@author Balogh Dávid
     * Ez a függvény indítja el a rablás folyamatát
     * @param v Virologus
     * */
    public void Rabol(Virologus v){


        this.rabolható=v.Rabolva();

        //felsorolunk toStringgel

        /*Scanner scan = new Scanner(System.in);
        System.out.println("Válassz ki egy indexet");
        int num = scan.nextInt();
        if(num >rabolható.length||num<0){
            System.out.println("Érvénytelen index\nRETURN");
            return;
        }

        TárgyElvétel(v, rabolható, num);
        */

    }

    /**
     * @author Balogh Dávid
     * Visszatérés a rabolható tárgyak és anyagok kollekciójával
     * */
    public  ArrayList<Cucc> Rabolva(){
        /*
        Cucc[] tomb_1= (Cucc[]) this.felszerelés.toArray();
        Cucc[] tomb_2=(Cucc[]) this.anyagok.toArray();

        Cucc[] result = new Cucc[tomb_1.length+ tomb_2.length];
        for (int i = 0; i < tomb_1.length; i++){
            result[i]=tomb_1[i];
        }
        for (int i = 0; i < tomb_2.length; i++) {
            result[tomb_1.length]=tomb_2[i];
        }*/
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

        Item i = new Item();
        Anyag a = new Anyag();

        if(c.equals(a)){
            this.anyagok.remove(a);
        }
        else{
            this.felszerelés.remove(i);
        }
        /*
        if(num<=v.felszerelés.toArray().length-1){
            v.felszerelés.remove(c.get(num));
            this.felszerelés.add((Item) c.get(num));
        }
        else{
            v.anyagok.remove(c.get(num));
            this.anyagok.add((Anyag)c.get(num));
        }*/

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

       /*Object n = LépésViselkedés.getClass();

       if(n.equals(VitusLépés.class)){
           Random r = new Random();
           int i = r.nextInt(this.mező.szomszédok.size());
           Mező m = this.mező.szomszédok.get(i);
           this.move(m);
       }

       else {
           Scanner s = new Scanner(System.in);
           System.out.println("Add meg hányadik szomszédra akrsz lépni!\nElérhető szomszédok listája:\n");
           int cnt =0;
           for(Mező m : this.mező.szomszédok){
               System.out.print(cnt+"; ");
               cnt++;
           }
           int j = s.nextInt();
           if(j>this.mező.szomszédok.size()-1){
               System.out.println("Nem megfelelő index!\nRETURN");
               return;
           }

           move(this.mező.szomszédok.get(j));


       }*/

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
        Bekenődés(this,a);
    }

    /**
     * @author Balogh Dávid
     * Bekenjük az adott virológust és aktiváljuk az effektet
     * @param v Virologus
     * @param a Ágens
     * */
    public void Bekenődés(Virologus v, Ágens a){



        for (int i = 0; i < v.felszerelés.size(); i++) {
            a=this.felszerelés.get(i).BekendőésEffket(v,a);
        }

        for (int i = 0; i < v.buff.size(); i++) {
            a=this.buff.get(i).BekendőésEffekt(a);
        }

        a.BuffÁtadás(this);
        //this.BuffMegkapás(a);

        
    }



    /**
     * @author Balogh Dávid
     * A kenés védekezést és visszadobást valósítja meg
     * @param a Ágens
     * */
    public void overwhelmingBekenődés(Ágens a){
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
    }
    public void AnyagVisit(Anyag a){
        System.out.println("Anyag visitelve lett");
    }

}
