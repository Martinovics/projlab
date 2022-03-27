package Szkeleton;

public class Aminosav extends Anyag{
    public Aminosav(){
       // System.out.println(this +" letrejott");
    }
    @Override
    public boolean KellCrafthoz(agens a) {
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
