package Szkeleton;

import java.util.ArrayList;

public class Virologus implements Steppable {
    public ArrayList<Anyag> anyagok;

    public void move(Mező m){

    }
    public void Letapogat(Mező m){

    }
    public void ÁgensElőállít(Ágens a){

    }
    public void CuccFelvétel(){

    }
    public boolean GénMegkapás(Ágens a){
        return true;
    }
    public boolean AnyagMegkapás(Anyag a){

    }
    public boolean TárgyMegkapás(Item i){

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
    public void setLépésBehaviour(ILépés s){}
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
