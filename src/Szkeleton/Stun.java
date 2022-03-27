package Szkeleton;

public class Stun extends Ágens{
    public Stun() {
        super(2, 5);
        System.out.println(this+" létrejött");
        Recept.add(new Nukleotid());
        Recept.add(new Aminosav());
        Recept.add(new Aminosav());
    }

    @Override
    public Ágens BekenődésEffekt(Ágens a) {
        System.out.println(this+" bekenődésEffekt");
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
        System.out.println(this+" effekt");
        v.setLépésBehaviour(Game.getStunLépés());
    }

    @Override
    public void AntiEffekt(Virologus v) {
        System.out.println(this+" antieffekt");
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
    public String toString() {
        return "Stun";
    }
}
