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
    protected  boolean[] Recept_temp;
    protected State state;

    public Ágens(int hi, int ei){
        HatóIdő = hi;
        ElbomlásIdő = ei;
        state = State.Kód;
        Game.AddSteppable(this);
    }
    public abstract void Effekt(Virologus v);
    public abstract void AntiEffekt(Virologus v);

    public Ágens BekenődésEffekt(Ágens a){
        return Game.ReturnN();
    }
    public abstract void Create(Virologus v);

    public void NukleotidVisit(Nukleotid n){
        for(int i = 0 ; i< Recept.size();i++){
            if(n.equals(Recept.get(i))){
                if(Recept_temp[i] == false) {
                    Recept_temp[i] = true;
                    return;
                }
            }
        }
    }

    /**
     * Aminosav hívja meg, a Create közben.
     * Végignézi a Recept listáját és ha van benne párosítatlan aminosav, akkor az ahhoz tartozó booleant true-ra állítja
     * @param a
     */
    public void AminosavVisit(Aminosav a){
        for(int i = 0 ; i< Recept.size();i++){
            if(a.equals(Recept.get(i))){
                if(Recept_temp[i] == false) {
                    Recept_temp[i] = true;
                    return;
                }
            }
        }
    }

    /**
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

    public void KódÁtadás(Virologus v){
        if(v.GénMegkapás(this)) state = State.Kód;
    }
    public void BuffÁtadás(Virologus v){
        if(v.BuffMegkapás(this)) state = State.Buff;
    }
    public void ÁgensÁtadás(Virologus v){
        if(v.ÁgensMegkapás(this)) state = State.Ágens;
    }

    protected boolean Recept_temp_kiertkelo(){
        for(int i = 0; i<Recept.size(); i++){
            if(!Recept_temp[i])
                return false;
        }
        return  true;
    }

    /**
     * Típus ellenőzés miatt, ha indokolt
     * @param a
     * @return true
     */
    public boolean equals(Ágens a){
        return true;
    }
    public boolean equals(VédőÁgens a){
        return false;
    }
    public boolean equals(Stun a){
        return false;
    }
    public boolean equals(VitusTánc a){
        return false;
    }
    public boolean equals(NullÁgens a){
        return false;
    }
    public boolean equals(Emlékezettörlés a){
        return false;
    }
    public boolean equals(Object o){
        return false;
    }
}
