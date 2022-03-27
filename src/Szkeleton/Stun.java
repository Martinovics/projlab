package Szkeleton;

public class Stun extends agens{
    public Stun() {
        super(2, 5);
        System.out.println(this+" letrejott");
        Recept.add(new Nukleotid());
        Recept.add(new Aminosav());
        Recept.add(new Aminosav());
    }

    @Override
    public agens BekenodesEffekt(agens a) {
        System.out.println(this+" bekenodesEffekt");
        return a;
    }

    /**
     * Stun masolatot atad v Virologusnak
     * @param v Virologus, amelyik megkapja a masolatot
     */
    @Override
    protected void Create_(Virologus v) {
        Stun a_copy = new Stun();
        v.agensMegkapas(a_copy);
    }

    @Override
    public void Effekt(Virologus v) {
        System.out.println(this+" effekt");
        v.setLepesBehaviour(Game.getStunLepes());
    }

    @Override
    public void AntiEffekt(Virologus v) {
        System.out.println(this+" antieffekt");
        v.setLepesBehaviour(Game.getAktorLepes());

    }

    @Override
    public boolean equals(agens a) {
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
