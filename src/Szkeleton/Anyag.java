package Szkeleton;


public class Anyag implements Cucc {


    public boolean KellCrafthoz(Ágens a){
        return true;
    }
    public void RemoveCucc(Virologus v){
        v.RemoveCuc(this);
    }
    public boolean AnyagÁtadás(Virologus v){
        v.AnyagMegkapás(this);
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
}
