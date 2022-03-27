package Szkeleton;

public class NullÁgens extends Ágens{
    public NullÁgens() {
        super(5,5);
        System.out.println(this+" létrejött");
    }

    @Override
    public void Effekt(Virologus v) {
        System.out.println(this+" effekt");
        //Semmi
    }

    @Override
    public void AntiEffekt(Virologus v) {
        System.out.println(this+" antieffekt");
        //Semmi
    }

    @Override
    public Ágens BekenődésEffekt(Ágens a) {
        System.out.println(this+" bekenődésEffekt");
        return  this;
    }

    /**
     * @author Lenkovics Ákos
     * Átadja v virológusnak saját magát, mint kód
     * @param v a Virológus aki megkapja ezt az Ágenst
     */
    public void KódÁtadás(Virologus v){

    }

    /**
     * @author Lenkovics Ákos
     * Átadja v virológusnak saját magát, mint Buff
     * @param v a Virológus aki megkapja ezt az Ágenst
     */
    public void BuffÁtadás(Virologus v){

    }

    /**
     * @author Lenkovics Ákos
     * Átadja v virológusnak saját magát, mint "Ágens"
     * @param v a Virológus aki megkapja ezt az Ágenst
     */
    public void ÁgensÁtadás(Virologus v){

    }

    @Override
    public void Create(Virologus v){}
    @Override
    protected void Create_(Virologus v){}

    public boolean equals(Ágens a){
        return  false;
    }
    public boolean equals(NullÁgens a){
        return true;
    }

    @Override
    public String toString() {
        return "NullÁgens";
    }
}
