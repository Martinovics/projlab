package Szkeleton;

public class Anyag implements Cucc {

    public Anyag(){
       System.out.println(this +" létrejött");
    }
    public boolean KellCrafthoz(Ágens a){
        return true;
    }

    public boolean AnyagÁtadás(Virologus v){
        v.AnyagMegkapás(this);
        System.out.println(this+" átadódott");
        return true;
    }

    public boolean equals(Anyag a) {
        return true;
    }
    public boolean equals(Aminosav a){
        return false;
    }
    public boolean equals(Nukleotid a){
        return  false;
    }
    public boolean equals(NullAnyag a){return  false;}

    /**
     * @param v
     * @author Golyha Tamás
     * ezt a függvényt valósítják meg a Cucc interfacet megvalósító osztályok
     */
    @Override
    public void removeCucc(Virologus v) {
        v.AnyagVisit(this);
        System.out.println(this +" elvevődött");
    }

    @Override
    public boolean CuccÁtadás(Virologus v) {
        v.AnyagMegkapás(this);
        return true;
    }


    @Override
    public String toString() {
        return "Anyag";
    }
}
