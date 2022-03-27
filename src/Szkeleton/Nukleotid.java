package Szkeleton;

public class Nukleotid extends  Anyag{
    public Nukleotid(){
        //System.out.println(this+" leeeeeétrejött");
    }
    @Override
    public boolean KellCrafthoz(Ágens a) {
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
