package Szkeleton;

public class Köpeny extends Item{
    public Köpeny(){
        System.out.println("Köpeny létrejött");
    }
    @Override
    public Ágens BekenődésEffket(Virologus v, Ágens a) {
        System.out.println(this+" bekenődésEffekt");
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
        return "Köpeny";
    }

    @Override
    public boolean CuccÁtadás(Virologus v) {
        v.TárgyMegkapás(this);
        return true;
    }
}
