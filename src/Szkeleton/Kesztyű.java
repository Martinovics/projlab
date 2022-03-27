package Szkeleton;

public class Kesztyű extends Item{

    @Override
    public void AntiEffekt(Virologus v) {}

    @Override
    public void Effekt(Virologus v) { }

    @Override
    public Ágens BekenődésEffket(Virologus v, Ágens a) {
        v.overwhelmingBekenődés(a);
        return Game.ReturnN();
    }
}
