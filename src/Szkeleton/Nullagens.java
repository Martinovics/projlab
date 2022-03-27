package Szkeleton;

public class Nullagens extends agens{
    public Nullagens() {
        super(5,5);
        System.out.println(this+" letrejott");
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
    public agens BekenodesEffekt(agens a) {
        System.out.println(this+" bekenodesEffekt");
        return  this;
    }

    /**
     * @author Lenkovics akos
     * atadja v virologusnak sajat magat, mint kod
     * @param v a Virologus aki megkapja ezt az agenst
     */
    public void Kodatadas(Virologus v){

    }

    /**
     * @author Lenkovics akos
     * atadja v virologusnak sajat magat, mint Buff
     * @param v a Virologus aki megkapja ezt az agenst
     */
    public void Buffatadas(Virologus v){

    }

    /**
     * @author Lenkovics akos
     * atadja v virologusnak sajat magat, mint "agens"
     * @param v a Virologus aki megkapja ezt az agenst
     */
    public void agensatadas(Virologus v){

    }

    @Override
    public void Create(Virologus v){}
    @Override
    protected void Create_(Virologus v){}

    public boolean equals(agens a){
        return  false;
    }
    public boolean equals(Nullagens a){
        return true;
    }

    @Override
    public String toString() {
        return "Nullagens";
    }
}
