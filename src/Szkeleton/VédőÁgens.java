package Szkeleton;

public class VédőÁgens extends Ágens{
    @Override
    public Ágens BekendőésEffekt(Ágens a) {
        return super.BekendőésEffekt(a);
    }

    @Override
    public void Effekt(Virologus v) {
        super.Effekt(v);
    }

    @Override
    public void AntiEffekt(Virologus v) {
        super.AntiEffekt(v);
    }
}
