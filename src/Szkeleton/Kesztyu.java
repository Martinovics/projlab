package Szkeleton;

public class Kesztyu extends Item{
    public  Kesztyu(){
        System.out.println(this+" letrejott");
    }

    @Override
    public void AntiEffekt(Virologus v) {
        System.out.println(this+" antieffekt");
    }

    @Override
    public void Effekt(Virologus v) {
        System.out.println(this+" effekt");
    }

    @Override
    public agens BekenodesEffket(Virologus v, agens a) {
        System.out.println(this+" bekenodesEffekt");
        v.overwhelmingBekenodes(a);
        return Game.ReturnN();
    }

    @Override
    public String toString() {
        return "Kesztyu";
    }

    @Override
    public boolean Cuccatadas(Virologus v) {
        v.TargyMegkapas(this);
        return true;
    }
}
