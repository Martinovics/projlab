package Szkeleton;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


import java.util.ArrayList;

public class Virologus implements Steppable {
    public ArrayList<Anyag> anyagok;
    public ArrayList<Ágens> kódok;
    public ArrayList<Ágens> ágensek;
    public ArrayList<Ágens> buff;
    public Mező mező;
    public ArrayList<Item> felszerelés;
    public ILépés LépésViselkedés;
    private ArrayList<Cucc> rabolható;
    public int itemCapacity;



    public void move(Mező m){
        m.AcceptViro(this);
        this.mező.RemoveViro(this);
    }
  
    public void Letapogat(Mező m){
        m.Felfedez(this);
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
        i.Effekt(this);
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
        a.Effekt(this);
        return true;
    }
    public void RemoveBuff(Ágens a){
        a.AntiEffekt(this);
        this.buff.remove(a);
    }




    public void RemoveCucc(Cucc c){
        try{
          this.felszerelés.remove(c);
        }
        catch (Exception e){

        }

        try {
            this.anyagok.remove(c);
        }
        catch (Exception e){

        }

    }

    public void Rabol(Virologus v){
        this.rabolható=v.Rabolva();
        //felsorolunk toStringgel
    }


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

    public  void TárgyElvétel(Virologus v, Cucc c){

        Item i = new Item();
        Anyag a = new Anyag();

        if(c.equals(a)){
            this.anyagok.remove(a);
        }
        else{
            this.felszerelés.remove(i);
    }


    public void mindentElfelejt(){
        this.kódok.removeAll(kódok);
    }

    public void Step(){
        LépésViselkedés.Lépés(this);
    }

    public void setLépésBehaviour(ILépés s){
        this.LépésViselkedés=s;
    }



    public void ÁgensKenés(Virologus v, Ágens a){
        this.ágensek.remove(a);
        Bekenődés(this,a);
    }
      
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




    public void overwhelmingBekenődés(Ágens a){
        a.BuffÁtadás(this);

    }
    public void EndRound(){

        System.out.println("Endround meghívva");
    }


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