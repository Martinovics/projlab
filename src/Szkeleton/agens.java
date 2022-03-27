package Szkeleton;
import java.util.ArrayList;

enum State{
    Buff,
    agens,
    Kod
}

public abstract class agens implements  Steppable{
    public int HatoIdo;
    public int ElbomlasIdo;
    protected ArrayList<Anyag> Recept;
    protected ArrayList<Anyag> Recept_temp;
    protected State state;

    /**
     * @author Lenkovics akos
     * agens konstrukatora
     * @param hi HatoIdo
     * @param ei ElbomlasIdo
     */
    public agens(int hi, int ei){
        System.out.println("agens letrejott");
        Recept = new ArrayList<Anyag>();
        HatoIdo = hi;
        ElbomlasIdo = ei;
        state = State.Kod;
        Game.AddSteppable(this);
    }

    /**
     * @author Lenkovics akos
     * Az agens hatasa. Akkor kell mehivni, amikor tenylegesen megkapja a Virologus az agenst.
     * @param v A virologus akire teszi a hatasat.
     */
    public abstract void Effekt(Virologus v);

    /**
     * @author Lenkovics akos
     * Az agenst hatasat levevo fuggveny.
     * Akkor kell meghivni amikor elmulik az agens hatasa.
     * @param v a Virologus akirol leveszi a hatasat.
     */
    public abstract void AntiEffekt(Virologus v);

    /**
     * @author Lenkovics akos
     * Minden agensnek van beleszolasa, a virologus uj agenssel valo bekenodesenek.
     * Akkor kell mehivni amikor a Virologus bekenodne az a agenssel.
     * @param a az az agens ami rakenodne a virologusra
     * @return azzal az agenssel ter vissza ami szerinte a virologusra kell kenodjon.
     */
    public agens BekenodesEffekt(agens a){
        return Game.ReturnN();
    }

    /**
     * @author Lenkovics akos
     * Create segedfuggvenye.
     * A lesezarmazottak ugy irjak felul, hogy egy hozzajuk hasonlo agenst hoznak letre.
     * Az agens Create_-jet hivni logikai hiba, de a program megengedi. Mehivva nem csinal semmit az agens Create_-je.
     * @param v
     */
    protected void Create_(Virologus v){}
    /**
     * @author Lenkovics akos
     * v Virologusnak atadja sajat maga masolatat, ha a Virologusnak megvannak hozza a megfelelo anyagok
     * Ha nincs akkor a lefoglalt anyagokat visszaadja
     * @param v a Virologus aki szeretne elkesziteni az agenst
     */
    public void Create(Virologus v){
        Recept_temp = new ArrayList<Anyag>();
        for(int i = 0; i < Recept.size(); i++){
            Recept_temp.add( new NullAnyag());
        }
        ArrayList<Integer> trace = new ArrayList<>();
        for(int i = 0; i < v.anyagok.size(); i++){
            if(v.anyagok.get(i).KellCrafthoz(this)){
                trace.add(i);
            }
        }
        if(Recept_temp_kiertkelo()) {
            for(int i = 0; i < trace.size(); i++){
                v.anyagok.remove(trace.get(i));
            }
            Create_(v);
        }else{
            for(int i = 0; i < Recept_temp.size(); i++){
                Anyag anyagProbe = new NullAnyag();
                if(!(Recept_temp.get(i).equals(anyagProbe))){
                    v.AnyagMegkapas(Recept_temp.get(i));
                }
            }
        }
    }

    /**
     * @author Lenkovics akos
     * Ezt a fuggvenyt hivja a Nukelotid ha a Create fgv.-ben hivva lett
     * @param n a nukleotid sajat magavaal hivja ezt a fuggvenyt
     * @return true-val ter vissza ha a Recepthez szukseg van az anyagra, egyebkent false-al
     */
    public boolean NukleotidVisit(Nukleotid n) {
        for (int i = 0; i < Recept.size(); i++) {
            if (Recept.get(i).equals(n) && !(Recept_temp.get(i).equals(n))) {
                Recept_temp.set(i, n);
                return true;
            }
        }
        return false;
    }

    /**
     * @author Lenkovics akos
     * Ezt a fuggvenyt hivja az Aminosav, ha a Create fgv.-ben hivva lett.
     * @param a az aminosav  sajat magavaal hivja ezt a fuggvenyt
     * @return true-val ter vissza ha a Recepthez szukseg van az anyagra, egyebkent false-al
     */
    public boolean AminosavVisit(Aminosav a){
        for (int i = 0; i < Recept.size(); i++) {
            if (Recept.get(i).equals(a) && !(Recept_temp.get(i).equals(a))) {
                Recept_temp.set(i, a);
                return true;
            }
        }
        return false;
    }

    /**
     * @author Lenkovics akos
     * A Create egy seged fgv.-e. Akkor kell hivni, ha a Recept_temp-et mar a leheto legjobban feltolotte a Create
     * a Virologus Anyag listajanak megfeleloen
     * @return igazzal ter vissza, ha a Recept es Recept_temp egyzik, egyebkent hamissal.
     */
    protected boolean Recept_temp_kiertkelo(){
        try{
            for(int i = 0; i<Recept.size(); i++){
                //Ha van koztuk nem egyezo akkor biztosan nem sikerult a recept
                if(!(Recept_temp.get(i).equals(Recept.get(i))))
                    return false;
            }
            return  true;
        }catch(Exception e){
            return false;
        }
    }

    /**
     * @author Lenkovics akos
     * Steppable interfesz metodusa.
     * Modositja az agens allaopta alapjan az uj visszamarado idejet.
     */
    public void Step(){
        if(state.equals(State.agens)){
            if(ElbomlasIdo == 0){
                Game.RemoveSteppable(this);
                return;
            }
            ElbomlasIdo--;
        }else if(state.equals(State.Buff)){
            if(HatoIdo == 0){
                Game.RemoveSteppable(this);
                return;
            }
            HatoIdo--;
        }else if(state.equals(State.Kod)){
            //Itt nem csinal semmit
        }
    }

    /**
     * @author Lenkovics akos
     * atadja v virologusnak sajat magat, mint kod
     * @param v a Virologus aki megkapja ezt az agenst
     */
    public void Kodatadas(Virologus v){
        System.out.print(this+ "atadja magat kodkent");
        if(v.GenMegkapas(this)) state = State.Kod;
    }

    /**
     * @author Lenkovics akos
     * atadja v virologusnak sajat magat, mint Buff
     * @param v a Virologus aki megkapja ezt az agenst
     */
    public void Buffatadas(Virologus v){
        System.out.print(this+ "atadja magat buffkent");
        if(v.BuffMegkapas(this)) state = State.Buff;
    }

    /**
     * @author Lenkovics akos
     * atadja v virologusnak sajat magat, mint "agens"
     * @param v a Virologus aki megkapja ezt az agenst
     */
    public void agensatadas(Virologus v){
        System.out.print(this+ " atadja magat agenskent");
        if(v.agensMegkapas(this)) state = State.agens;
    }

    /**
     * @author Lenkovics akos
     * Tipus ellenozes miatt, ha indokolt
     * @param a
     * @return true
     */
    public boolean equals(agens a){
        return true;
    }

    /**
     * @author Lenkovics akos
     * @param a
     * @return false
     */
    public boolean equals(Vedoagens a){
        return false;
    }

    /**
     * @author Lenkovics akos
     * @param a
     * @return false
     */
    public boolean equals(Stun a){
        return false;
    }

    /**
     * @author Lenkovics akos
     * @param a
     * @return false
     */
    public boolean equals(VitusTanc a){
        return false;
    }

    /**
     * @author Lenkovics akos
     * @param a
     * @return false
     */
    public boolean equals(Nullagens a){
        return false;
    }

    /**
     * @author Lenkovics akos
     * @param a
     * @return false
     */
    public boolean equals(Emlekezettorles a){
        return false;
    }

    /**
     * @author Lenkovics akos
     * @param o egy Object objekutum
     * @return false
     */
    public boolean equals(Object o){
        return false;
    }
}
