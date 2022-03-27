package Szkeleton;

public class Köpeny extends Item{
    @Override
    public Ágens BekenődésEffket(Virologus v, Ágens a) {
        System.out.println("Köpeny BekenődésEfffekt()");
        return a;
    }

    @Override
    public void Effekt(Virologus v) {}

    @Override
    public void AntiEffekt(Virologus v) {}
}
