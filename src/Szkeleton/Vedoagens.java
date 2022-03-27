package Szkeleton;

public class Vedoagens extends agens{
    public Vedoagens(){
        super(1,5);
        System.out.println(this+" letrejott");
        Recept.add(new Aminosav());
        Recept.add(new Aminosav());
    }

    /**
     * meghivja az os BekenodesEffektjet mert pont azt csinalja amit a Vedoagensnek kell.
     * @param a
     * @return
     */
    @Override
    public agens BekenodesEffekt(agens a) {
        System.out.println(this+" bekenodesEffekt");
        return Game.ReturnN();
    }

    /**
     * Nem csinal semmit a Vedoagens Effektje
     * @param v
     */
    @Override
    public void Effekt(Virologus v) {
        System.out.println(this+" effekt");
        //Itt az Effekt nem csinal semmit
    }

    /**
     * Nem csinal semmit a Vedoagens AntiEffektje
     * @param v
     */
    @Override
    public void AntiEffekt(Virologus v) {
        System.out.println(this+" antieffekt");
        //AnitEffekt nem csinal semmit
    }

    /**
     * Vedoagens masolatot atad v Virológusnak
     * @param v Virológus, amelyik megkapja a masolatot
     */
    @Override
    protected void Create_(Virologus v) {
        Vedoagens a_copy = new Vedoagens();
        v.agensMegkapas(a_copy);
    }

    @Override
    public boolean equals(agens a) {
        return false;
    }
    @Override
    public boolean equals(Vedoagens a) {
        return true;
    }
    public String toString() {
        return "Vedoagens";
    }
}
