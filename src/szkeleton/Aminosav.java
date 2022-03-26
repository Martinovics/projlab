package Szkeleton;

public class Aminosav extends Anyag{
    @Override
    public void KellCrafthoz(Ágens a) {
        a.AminosavVisit(this);
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
