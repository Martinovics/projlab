package Szkeleton;

public class Nukleotid extends  Anyag{
    public Nukleotid(){
        //System.out.println(this+" leeeeeetrejott");
    }
    @Override
    public boolean KellCrafthoz(agens a) {
        if(a.NukleotidVisit(this)){
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Nukleotid a) {
        return true;
    }

    @Override
    public String toString() {
        return "Nukleotid";
    }
}
