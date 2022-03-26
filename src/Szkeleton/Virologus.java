package Szkeleton;

import java.util.ArrayList;

public class Virologus implements Steppable {
    public ArrayList<Anyag> anyagok;
    public ArrayList<Ágens> kódok;
    public ArrayList<Ágens> ágensek;
    public ArrayList<Ágens> buff;
    public Mező mező;
    public ArrayList<Item> felszerelés;
    public ILépés LépésViselkedés;


    public void move(Mező m){
        m.AcceptViro(this);
        this.mező.RemoveViro(this);
    }
    public void Letapogat(Mező m){

    }
    public void ÁgensElőállít(Ágens a){
        a.Create(this);

    }

    public void CuccFelvétel(){
        this.mező.CuccÁtadás(this);
    }
    public boolean GénMegkapás(Ágens a){
        this.kódok.add(a);
        return true;
    }
    public boolean AnyagMegkapás(Anyag a){
        this.anyagok.add(a);
        return true;
    }
    public boolean TárgyMegkapás(Item i){
        this.felszerelés.add(i);
        return true;
    }
    public boolean ÁgensMegkapás(Ágens a){
        this.ágensek.add(a);
        return true;
    }
    public boolean BuffMegkapás(Ágens a){
        this.buff.add(a);
        return true;
    }
    public void RemoveBuff(Ágens a){
        this.buff.remove(a);
    }
    public void ÁgensKenés(Virologus v, Ágens a){}
    public  void TárgyElvétel(Virologus v, Cucc c){}

    public void RemoveCucc(Cucc c){
        this.felszerelés.remove(c);
        this.anyagok.remove(c);
    }

    public void Rabol(Virologus v){}
    public  Cucc[] Rabolva(){}

    public void mindentElfelejt(){
        this.kódok.removeAll(kódok);
    }

    public void Step(){}

    public void setLépésBehaviour(ILépés s){
        this.LépésViselkedés=s;
    }

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
