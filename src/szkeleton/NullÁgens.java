package Szkeleton;

public class NullÁgens extends Ágens{
    public NullÁgens() {
        super(5,5);
    }

    @Override
    public void Effekt(Virologus v) {
        //Semmi
    }

    @Override
    public void AntiEffekt(Virologus v) {
        //Semmi
    }

    @Override
    public Ágens BekenődésEffekt(Ágens a) {
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


}
