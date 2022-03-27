package Szkeleton;

public class Nukleotid extends  Anyag{
    @Override
    public boolean KellCrafthoz(Ágens a) {
        if(a.NukleotidVisit(this)){
            return true;
        }
        return false;
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
