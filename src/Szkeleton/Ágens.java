package Szkeleton;


enum State{
    Agens,
    Kod,
    Buff
}

public class Ágens implements  Steppable{
    public int HatóIdő;
    public int ElbomlásIdő;
    protected State state;
    public void Effekt(Virologus v){}
    public void AntiEffekt(Virologus v){}

    public Ágens BekendőésEffekt(Ágens a){
        NullÁgens n =  Game.ReturnN();
        return n;
    }
    public void Create(Virologus v){}
    public void NukleotidVisit(Nukleotid n){}
    public void AminosavVisit(Aminosav a){}
    public void Step(){}
    public void KódÁtadás(){}
}
