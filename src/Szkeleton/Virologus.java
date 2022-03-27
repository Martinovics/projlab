package Szkeleton;

import java.util.ArrayList;


public class Virologus implements Steppable {
    /**@author Balogh David
     * A virologus attributumai
     * */

    public ArrayList<Anyag> anyagok;
    public ArrayList<agens> kodok;
    public ArrayList<agens> agensek;
    public ArrayList<agens> buff;
    public Mezo mezo;
    public ArrayList<Item> felszereles;
    public ILepes LepesViselkedes;
    private ArrayList<Cucc> rabolhato;

    public int itemCapacity;
    public Virologus(){
        kodok = new ArrayList<>();
        agensek = new ArrayList<>();
        buff = new ArrayList<>();
        anyagok = new ArrayList<>();
        felszereles = new ArrayList<>();
        LepesViselkedes = Game.getAktorLepes();
        System.out.println(this +" letrejott");
    }

    public void PutOnMezo(Mezo m){
        mezo = m;
        m.AcceptViro(this);
    }


    /**
     * @author Balogh David
     * A virologus mozgatasaert felelos fuggveny
     * Kiszedi az egyik mezorol es berakja a masikba
     * @param m Mezo
     * */
    public void move(Mezo m){
        m.AcceptViro(this);
        this.mezo.RemoveViro(this);
        mezo = m;
        System.out.println(this +" atment a masik mezore");
    }

    /**
     *@author Balogh David
     * Ez a fuggveny is a mozgatashoz kell
     *@param m Mezo
     * */
    public void Letapogat(Mezo m){
        m.Felfedez(this);
    }
    /**
     * @author Balogh David
     * Az agensek elkesziteset meghivo fuggveny
     * @param a agens
     * */
    public void agensEloallit(agens a){
        a.Create(this);
        System.out.println(this +" eloallitott egy "+ a+ "-t");
    }
    /**
     * @author Balogh David
     * Valamilyen dolgot egy mezorol felveszunk es eltarolunk
     * */

    public void CuccFelvetel(){
        this.mezo.Cuccatadas(this);
        System.out.println(this +" felvette a mezorol a cuccot");
    }

    /**
     * @author Balogh David
     * Valamilyen kodot eltarolunk
     * @param a agens
     * */

    public boolean GenMegkapas(agens a){
        this.kodok.add(a);
        System.out.println(this +" megkapta a gent");
        return true;
    }

    /**
     * @author Balogh David
     * Valamilyen anyagot eltarolunk
     * @param a Anyag
     * */

    public boolean AnyagMegkapas(Anyag a){
        System.out.println(this + "Megkapta az anyagot");
        this.anyagok.add(a);
        return true;
    }
    /**
     * @author Balogh David
     * Valamilyen targyat eltarolunk
     * @param i Item
     * */

    public boolean TargyMegkapas(Item i){
        System.out.println(this + "Megkapta a targyat");
        this.felszereles.add(i);
        i.Effekt(this);
        return true;
    }

    /**
     * @author Balogh David
     * Valamilyen kesz agenst eltarolunk
     * */
    public boolean agensMegkapas(agens a){
        System.out.println(this + "Megkapta az agenst");
        this.agensek.add(a);
        return true;
    }
    /**
     * @author Balogh David
     * Valamilyen agens hatast aktivalunk, tehat szinten
     * kollekcioba eltarolunk
     * */
    public boolean BuffMegkapas(agens a){
        System.out.println(this + "Megkapta a buffot");
        this.buff.add(a);
        return true;
    }

    /**
     * @author Balogh David
     * Valamilyen agens hatast deaktivalunk, tehat szinten
     * kollekciobol kiszedunk
     * */
    public boolean RemoveBuff(agens a){
        System.out.println(this + " elvesztette a buffot");
        this.buff.remove(a);
        a.AntiEffekt(this);
        return true;
    }
    public boolean CuccMegkapas(Cucc c){
        c.Cuccatadas(this);
        return true;
    }

    /**
     * @author Balogh David
     * Valamilyen dolgot kiszedunk a kollekcionkbol
     * @param c Cucc
     * */

    public void RemoveCucc(Cucc c){
        System.out.println(this + " elvesztette a cuccot");
        c.removeCucc(this);
    }


    /**
     *@author Balogh David
     * Ez a fuggveny inditja el a rablas folyamatat
     * @param v Virologus
     * */
    public void Rabol(Virologus v){
        this.rabolhato=v.Rabolva();
        //felsorolunk toStringgel
    }

    /**
     * @author Balogh David
     * Visszateres a rabolhato targyak es anyagok kollekciojaval
     * */
    public  ArrayList<Cucc> Rabolva(){
        Stun s = new Stun();
        ArrayList<Cucc> c = new ArrayList<Cucc>();
        for (int i = 0; i < this.buff.size(); i++) {
            if(buff.get(i).equals(s)){

                c.addAll(felszereles);
                c.addAll(anyagok);

            }
        }

        return c;

    }

    /**
     * @author Balogh David
     *Itt vesszuk ki az adott virologus kollekciojabol a dolgokat
     *@param v Virologus
     *@param c Cucc
     * */
    public  void TargyElvetel(Virologus v, Cucc c){
        v.RemoveCucc(c);
        c.Cuccatadas(this);
    }


    /**
     * @author Balogh David
     * Kinullazzuk a virologus megtanult kodjainak a kollekciojat
     * */
    public void mindentElfelejt(){
        this.kodok.removeAll(kodok);
    }

    /**
     * @author Balogh David
     * LepesViselkedestol fuggoen lepunk a virologussal
     * */
    public void Step(){
        LepesViselkedes.Lepes(this);
    }
    /**
     * @author Balogh David
     * atallitjuk a LepesViselkedesunket
     * @param s ILepes
     * */
    public void setLepesBehaviour(ILepes s){
        this.LepesViselkedes=s;
    }

    /**
     * @author Balogh David
     * ELinditja a kenes folyamatat
     * @param v Virologus
     * @param a agens
     * */
    public void agensKenes(Virologus v, agens a){
        this.agensek.remove(a);
        System.out.println(this + "bekeni a masikat");
        v.Bekenodes(this,a);
    }

    /**
     * @author Balogh David
     * Bekenjuk az adott virologust es aktivaljuk az effektet
     * @param v Virologus
     * @param a agens
     * */

    public void Bekenodes(Virologus v, agens a){
        for (int i = 0; i < felszereles.size(); i++) {
            a=this.felszereles.get(i).BekenodesEffket(v,a);
        }
        for (int i = 0; i < buff.size(); i++) {
            a=this.buff.get(i).BekenodesEffekt(a);
        }
        System.out.println(this + " alkalmazva lett a(z) " + a) ;
        a.Buffatadas(this);
    }

    /**
     * @author Balogh David
     * A kenes vedekezest es visszadobast valositja meg
     * @param a agens
     * */
    public void overwhelmingBekenodes(agens a){
        System.out.println("right back at you buckaroo!!");
        a.Buffatadas(this);

    }
    /**
     * @author Balogh David
     * Kor vege
     * */
    public void EndRound(){

        System.out.println("Endround meghivva");
    }

    /**
     * @author Balogh David
     * Visitek
     * */
    public void visit(Mezo m){
        System.out.println("Mezo ososztaly visitelve lett");
    }
    public void visit(Labor l){
        System.out.println("Labor visitelve lett");

    }
    public void visit(Raktar r){
        System.out.println("Raktar visitelve lett");
    }
    public void visit(ovohely o){
        System.out.println("ovohely visitelve lett");
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