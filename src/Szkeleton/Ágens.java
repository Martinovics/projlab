package Szkeleton;
import java.util.ArrayList;

enum State{
    Buff,
    Ágens,
    Kód
}

public abstract class Ágens implements  Steppable{
    public int HatóIdő;
    public int ElbomlásIdő;
    protected ArrayList<Anyag> Recept;
    protected ArrayList<Anyag> Recept_temp;
    protected State state;

    /**
     * @author Lenkovics Ákos
     * Ágens konstrukatora
     * @param hi HatóIdő
     * @param ei ElbomlásIdő
     */
    public Ágens(int hi, int ei){
        HatóIdő = hi;
        ElbomlásIdő = ei;
        state = State.Kód;
        Game.AddSteppable(this);
    }

    /**
     * @author Lenkovics Ákos
     * Az ágens hatása. Akkor kell mehívni, amikor ténylegesen megkapja a Virológus az ágenst.
     * @param v A virológus akire teszi a hatását.
     */
    public abstract void Effekt(Virologus v);

    /**
     * @author Lenkovics Ákos
     * Az ágenst hatását levevő függvény.
     * Akkor kell meghívni amikor elmúlik az ágens hatása.
     * @param v a Virológus akiről leveszi a hatását.
     */
    public abstract void AntiEffekt(Virologus v);

    /**
     * @author Lenkovics Ákos
     * Minden ágensnek van beleszólása, a virológus új ágenssel való bekenődésének.
     * Akkor kell mehívni amikor a Virológus bekenődne az a ágenssel.
     * @param a az az ágens ami rákenődne a virológusra
     * @return azzal az ágenssel tér vissza ami szerinte a virológusra kell kenődjön.
     */
    public Ágens BekenődésEffekt(Ágens a){
        return Game.ReturnN();
    }

    /**
     * @author Lenkovics Ákos
     * Create segédfüggvénye.
     * A lesezármazottak úgy írják felül, hogy egy hozzájuk hasonló Ágenst hoznak létre.
     * Az Ágens Create_-jét hívni logikai hiba, de a program megengedi. Mehívva nem csinál semmit az Ágens Create_-je.
     * @param v
     */
    protected void Create_(Virologus v){}
    /**
     * @author Lenkovics Ákos
     * v Virológusnak átadja saját maga másolatát, ha a Virológusnak megvannak hozzá a megfelelő anyagok
     * Ha nincs akkor a lefoglalt anyagokat visszaadja
     * @param v a Virológus aki szeretné elkészíteni az ágenst
     */
    public void Create(Virologus v){
        Recept_temp = new ArrayList<Anyag>();
        for(int i = 0; i < Recept_temp.size(); i++){
            Recept_temp.add( new Anyag());
        }
        for(Anyag a : v.anyagok){
            if(a.KellCrafthoz(this)){
                v.RemoveCuc(a);
            }

        }
        if(Recept_temp_kiertkelo()) {
            Create_(v);
        }else{
            for(int i = 0; i < Recept_temp.size(); i++){
                Anyag anyagProbe = new Anyag();
                if(!(Recept_temp.get(i).equals(anyagProbe))){
                    v.AnyagMegkapás(Recept_temp.get(i));
                }

            }

        }
    }

    /**
     * @author Lenkovics Ákos
     * Ezt a függvényt hívja a Nukelotid ha a Create fgv.-ben hívva lett
     * @param n a nukleotid saját magávaal hívja ezt a függvényt
     * @return true-val tér vissza ha a Recepthez szükség van az anyagra, egyébként false-al
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
     * @author Lenkovics Ákos
     * Ezt a függvényt hívja az Aminosav, ha a Create fgv.-ben hívva lett.
     * @param a az aminosav  saját magávaal hívja ezt a függvényt
     * @return true-val tér vissza ha a Recepthez szükség van az anyagra, egyébként false-al
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
     * @author Lenkovics Ákos
     * A Create egy segéd fgv.-e. Akkor kell hívni, ha a Recept_temp-et már a lehető legjobban feltölötte a Create
     * a Virológus Anyag listájának megfelelően
     * @return igazzal tér vissza, ha a Recept és Recept_temp egyzik, egyébként hamissal.
     */
    protected boolean Recept_temp_kiertkelo(){
        try{
            for(int i = 0; i<Recept.size(); i++){
                //Ha van köztük nem egyező akkor biztosan nem sikerült a recept
                if(!(Recept_temp.get(i).equals(Recept.get(i))))
                    return false;
            }
            return  true;
        }catch(Exception e){
            return false;
        }
    }

    /**
     * @author Lenkovics Ákos
     * Steppable interfész metódusa.
     * Módosítja az ágens állaopta alapján az új visszamaradó idejét.
     */
    public void Step(){
        if(state.equals(State.Ágens)){
            if(ElbomlásIdő == 0){
                Game.RemoveSteppable(this);
                return;
            }
            ElbomlásIdő--;
        }else if(state.equals(State.Buff)){
            if(HatóIdő == 0){
                Game.RemoveSteppable(this);
                return;
            }
            HatóIdő--;
        }else if(state.equals(State.Kód)){
            //Itt nem csinál semmit
        }
    }

    /**
     * @author Lenkovics Ákos
     * Átadja v virológusnak saját magát, mint kód
     * @param v a Virológus aki megkapja ezt az Ágenst
     */
    public void KódÁtadás(Virologus v){
        if(v.GénMegkapás(this)) state = State.Kód;
    }

    /**
     * @author Lenkovics Ákos
     * Átadja v virológusnak saját magát, mint Buff
     * @param v a Virológus aki megkapja ezt az Ágenst
     */
    public void BuffÁtadás(Virologus v){
        if(v.BuffMegkapás(this)) state = State.Buff;
    }

    /**
     * @author Lenkovics Ákos
     * Átadja v virológusnak saját magát, mint "Ágens"
     * @param v a Virológus aki megkapja ezt az Ágenst
     */
    public void ÁgensÁtadás(Virologus v){
        if(v.ÁgensMegkapás(this)) state = State.Ágens;
    }

    /**
     * @author Lenkovics Ákos
     * Típus ellenőzés miatt, ha indokolt
     * @param a
     * @return true
     */
    public boolean equals(Ágens a){
        return true;
    }

    /**
     * @author Lenkovics Ákos
     * @param a
     * @return false
     */
    public boolean equals(VédőÁgens a){
        return false;
    }

    /**
     * @author Lenkovics Ákos
     * @param a
     * @return false
     */
    public boolean equals(Stun a){
        return false;
    }

    /**
     * @author Lenkovics Ákos
     * @param a
     * @return false
     */
    public boolean equals(VitusTánc a){
        return false;
    }

    /**
     * @author Lenkovics Ákos
     * @param a
     * @return false
     */
    public boolean equals(NullÁgens a){
        return false;
    }

    /**
     * @author Lenkovics Ákos
     * @param a
     * @return false
     */
    public boolean equals(Emlékezettörlés a){
        return false;
    }

    /**
     * @author Lenkovics Ákos
     * @param o egy Object objekutum
     * @return false
     */
    public boolean equals(Object o){
        return false;
    }
}
