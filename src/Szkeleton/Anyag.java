package Szkeleton;

public class Anyag implements Cucc {

    public Anyag(){
       System.out.println(this +" letrejott");
    }
    public boolean KellCrafthoz(agens a){
        return true;
    }

    public boolean Anyagatadas(Virologus v){
        v.AnyagMegkapas(this);
        System.out.println(this+" atadodott");
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
     * @author Golyha Tamas
     * ezt a fuggvenyt valositjak meg a Cucc interfacet megvalosito osztalyok
     */
    @Override
    public void removeCucc(Virologus v) {
        v.AnyagVisit(this);
        System.out.println(this +" elvevodott");
    }

    @Override
    public boolean Cuccatadas(Virologus v) {
        v.AnyagMegkapas(this);
        return true;
    }


    @Override
    public String toString() {
        return "Anyag";
    }
}
