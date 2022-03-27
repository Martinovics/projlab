package Szkeleton;

public class NullAnyag extends Anyag{
    public NullAnyag(){
        System.out.println(this +" létrejött");
    }
    @Override
    public boolean KellCrafthoz(Ágens a) {
        return true;
    }

    @Override
    public boolean equals(NullAnyag a) {
        return true;
    }

    @Override
    public String toString() {
        return "NullAnyag";
    }
}
