package Szkeleton;

public class VitusTanc extends  agens{
    public VitusTanc() {
        super(1, 5);
        System.out.println(this+" letrejott");
        Recept.add(new Nukleotid());
        Recept.add(new Nukleotid());
        Recept.add(new Aminosav());
    }

    @Override
    public void Effekt(Virologus v) {
        System.out.println(this+" effekt");
        v.setLepesBehaviour(Game.getVitusLepes());
    }

    @Override
    public void AntiEffekt(Virologus v) {
        System.out.println(this+" antieffekt");
        v.setLepesBehaviour(Game.getAktorLepes());
    }

    @Override
    public agens BekenodesEffekt(agens a) {
        System.out.println(this+" bekenodesEffekt");
        return a;
    }

    /**
     * VitusTanc masolatot atad v Virologusnak
     * @param v Virologus, amelyik megkapja a masolatot
     */
    @Override
    protected void Create_(Virologus v) {
            VitusTanc a_copy = new VitusTanc();
            v.agensMegkapas(a_copy);
    }


    @Override
    public boolean equals(agens a) {
        return false;
    }
    @Override
    public boolean equals(VitusTanc a) {
        return true;
    }
    public String toString() {
        return "VitusTanc";
    }
}
