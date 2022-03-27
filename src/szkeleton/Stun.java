package Szkeleton;

public class Stun extends Ágens{
    public Stun() {
        super(2, 5);
        Recept.add(new Nukleotid());
        Recept.add(new Aminosav());
        Recept.add(new Aminosav());
    }

    @Override
    public Ágens BekenődésEffekt(Ágens a) {
        return a;
    }

    /**
     * Stun másolatot átad v Virológusnak
     * @param v Virológus, amelyik megkapja a másolatot
     */
    @Override
    protected void Create_(Virologus v) {
        Stun a_copy = new Stun();
        v.ÁgensMegkapás(a_copy);
    }

    @Override
    public void Effekt(Virologus v) {
        v.setLépésBehaviour(Game.getStunLépés());
    }

    @Override
    public void AntiEffekt(Virologus v) {
        v.setLépésBehaviour(Game.getAktorLépés());

    }

    @Override
    public boolean equals(Ágens a) {
        return false;
    }
    @Override
    public boolean equals(Stun a) {
        return true;
    }
}
