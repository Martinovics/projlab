package Szkeleton;

public class VitusTánc extends  Ágens{
    public VitusTánc() {
        super(1, 5);
        System.out.println(this+" létrejött");
        Recept.add(new Nukleotid());
        Recept.add(new Nukleotid());
        Recept.add(new Aminosav());
    }

    @Override
    public void Effekt(Virologus v) {
        System.out.println(this+" effekt");
        v.setLépésBehaviour(Game.getVitusLépés());
    }

    @Override
    public void AntiEffekt(Virologus v) {
        System.out.println(this+" antieffekt");
        v.setLépésBehaviour(Game.getAktorLépés());
    }

    @Override
    public Ágens BekenődésEffekt(Ágens a) {
        System.out.println(this+" bekenődésEffekt");
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


    @Override
    public boolean equals(Ágens a) {
        return false;
    }
    @Override
    public boolean equals(VitusTánc a) {
        return true;
    }
    public String toString() {
        return "VitusTánc";
    }
}
