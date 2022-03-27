package Szkeleton;

public class Kesztyű extends Item{
    public  Kesztyű(){
        System.out.println(this+" létrejött");
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
    public Ágens BekenődésEffket(Virologus v, Ágens a) {
        System.out.println(this+" bekenődésEffekt");
        v.overwhelmingBekenődés(a);
        return Game.ReturnN();
    }

    @Override
    public String toString() {
        return "Kesztyű";
    }

    @Override
    public boolean CuccÁtadás(Virologus v) {
        v.TárgyMegkapás(this);
        return true;
    }
}
