package Szkeleton;

public class NullAnyag extends Anyag{
    public NullAnyag(){
        System.out.println(this +" letrejott");
    }
    @Override
    public boolean KellCrafthoz(agens a) {
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
