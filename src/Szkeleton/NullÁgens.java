package Szkeleton;

public class NullÁgens extends Ágens{
    public NullÁgens() {
        super(5,5);
    }

    @Override
    public void Effekt(Virologus v) {
        //Semmi
    }

    @Override
    public void AntiEffekt(Virologus v) {
        //Semmi
    }

    @Override
    public Ágens BekenődésEffekt(Ágens a) {
        return  this;
    }

    @Override
    public void Create(Virologus v){}

    public boolean equals(Ágens a){
        return  false;
    }
    public boolean equals(NullÁgens a){
        return true;
    }

}
