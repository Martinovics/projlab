package Szkeleton;

public class Aminosav extends Anyag{
    @Override

    public boolean KellCrafthoz(Ágens a) {
        if(a.AminosavVisit(this)){
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Anyag a) {
        return false;
    }

    @Override
    public boolean equals(Aminosav a) {
        return true;
    }
}
