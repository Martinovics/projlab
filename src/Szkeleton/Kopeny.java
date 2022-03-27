package Szkeleton;

public class Kopeny extends Item{
    public Kopeny(){
        System.out.println("Kopeny letrejott");
    }
    @Override
    public agens BekenodesEffket(Virologus v, agens a) {
        System.out.println(this+" bekenodesEffekt");
        return a;
    }

    @Override
    public void Effekt(Virologus v) {
        System.out.println(this+" effekt");
    }

    @Override
    public void AntiEffekt(Virologus v) {
        System.out.println(this+" antieffekt");
    }

    @Override
    public String toString() {
        return "Kopeny";
    }

    @Override
    public boolean Cuccatadas(Virologus v) {
        v.TargyMegkapas(this);
        return true;
    }
}
