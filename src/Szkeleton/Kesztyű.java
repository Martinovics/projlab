package Szkeleton;

public class Kesztyű extends Item{

    @Override
    public void AntiEffekt(Virologus v) {
        super.AntiEffekt(v);
    }

    @Override
    public void Effekt(Virologus v) {
        super.Effekt(v);
    }

    @Override
    public Ágens BekendőésEffket(Virologus v, Ágens a) {
        return super.BekendőésEffket(v, a);
    }
}
