package Szkeleton;
import java.util.*;

public class Virologus implements Steppable {


    public ILépés LépésViselkdés;
    public Mező mező;
    public  ArrayList<Ágens> ágensek;
    public ArrayList<Ágens> kódok;
    public ArrayList<Ágens> buff;
    public ArrayList<Anyag> anyagok;
    public ArrayList<Item> felszerelés;




    public void move(Mező m){
        m.AcceptViro(this);
        this.mező.RemoveViro(this);
    }

    public void Letapogat(Mező m){

    }
    public void ÁgensElőállít(Ágens a){

    }

    public void CuccFelvétel(){
        this.mező.CuccÁtadás(this);

    }

    public boolean GénMegkapás(Ágens a){
        return true;
    }

    public boolean AnyagMegkapás(Anyag a){
        this.anyagok.add(a);
    }
    public boolean TárgyMEgkapés(Item i){

    }
    public boolean ÁgensMegkapás(Ágens a){

    }
    public boolean BuffMegkapás(Ágens a){

    }
    public void RemoveBuff(Ágens a){}
    public void ÁgensKenés(Virologus v, Ágens a){}
    public  void TárgyElvétel(Virologus v, Cucc c){}
    public void RemoveCuc(Cucc c){}
    public void Rabol(Virologus v){}
    public  Cucc[] Rabolva(){}
    public void mindentElfelejt(){}
    public void Step(){}
    public void setLépésBehaviour(){}
    public void Bekenődés(Virologus v, Ágens a){}
    public void overwhelmingBekenődés(Ágens a){}
    public void EndRound(){}
    public void visit(Mező m){}
    public void visit(Labor l){}
    public void visit(Raktár r){}
    public void visit(Óvóhely o){}
    public void ItemVisit(Item i){}
    public void AnyagVisit(Anyag a){}




}
