package Szkeleton;

public class VitusTánc extends  Ágens{
    public VitusTánc() {
        super(1, 5);
        Recept.add(new Nukleotid());
        Recept.add(new Nukleotid());
        Recept.add(new Aminosav());
    }

    @Override
    public void Effekt(Virologus v) {
        v.setLépésBehaviour(Game.getVitusLépés());
    }

    @Override
    public void AntiEffekt(Virologus v) {
        v.setLépésBehaviour(Game.getAktorLépés());
    }

    @Override
    public Ágens BekenődésEffekt(Ágens a) {
        return a;
    }

    /**
     * VitusTánc másolatot átad v Virológusnak
     * @param v Virológus, amelyik megkapja a másolatot
     */
    @Override
    protected void Create_(Virologus v) {
            VitusTánc a_copy = new VitusTánc();
            v.ÁgensMegkapás(a_copy);
    }
}
