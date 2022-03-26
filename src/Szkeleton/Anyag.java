package Szkeleton;

public abstract class Anyag {

    public abstract void KellCrafthoz(Ágens a);
    public void RemoveCucc(Virologus v){
        v.RemoveCuc((Cucc) this);
    }
    public boolean AnyagÁtadás(Virologus v){
        v.TárgyMegkapás(this);
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
