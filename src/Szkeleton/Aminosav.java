package Szkeleton;

public class Aminosav extends Anyag{
    public Aminosav(){
       // System.out.println(this +" létrejött");
    }
    @Override
    public boolean KellCrafthoz(Ágens a) {
        if (a.AminosavVisit(this)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Aminosav a) {
        return true;
    }

    @Override
    public String toString() {
        return "Aminosav";
    }
}
