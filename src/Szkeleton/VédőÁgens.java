package Szkeleton;

public class VédőÁgens extends Ágens{
    public VédőÁgens(){
        super(1,5);
        Recept.add(new Aminosav());
        Recept.add(new Aminosav());
    }

    /**
     * meghívja az ős BekenődésEffektjét mert pont azt csinálja amit a VédőÁgensnek kell.
     * @param a
     * @return
     */
    @Override
    public Ágens BekenődésEffekt(Ágens a) {
        return Game.ReturnN();
    }

    /**
     * Nem csinál semmit a VédőÁgens Effektje
     * @param v
     */
    @Override
    public void Effekt(Virologus v) {
        //Itt az Effekt nem csinál semmit
    }

    /**
     * Nem csinál semmit a VédőÁgens AntiEffektje
     * @param v
     */
    @Override
    public void AntiEffekt(Virologus v) {
        //AnitEffekt nem csinál semmit
    }

    /**
     * VédőÁgens másolatot átad v Virológusnak
     * @param v Virológus, amelyik megkapja a másolatot
     */
    @Override
    protected void Create_(Virologus v) {
        VédőÁgens a_copy = new VédőÁgens();
        v.ÁgensMegkapás(a_copy);
    }

    @Override
    public boolean equals(Ágens a) {
        return false;
    }
    @Override
    public boolean equals(VédőÁgens a) {
        return true;
    }
}
