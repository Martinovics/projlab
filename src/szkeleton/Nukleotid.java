package Szkeleton;

public class Nukleotid extends  Anyag{
    @Override
    public void KellCrafthoz(Ágens a) {
        a.NukleotidVisit(this);
    }

    @Override
    public boolean equals(Anyag a) {
        return false;
    }

    @Override
    public boolean equals(Nukleotid a) {
        return true;
    }
}
