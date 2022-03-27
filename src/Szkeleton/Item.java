package Szkeleton;

public abstract class Item  implements Cucc{
    /**
    *A TargyMegkapas() vegen hivodik, amikor a Virologus felvette az Itemet. A tenylegesen megvalositott leszarmazott irja le, hogy valoban mit csinal.
    *@param v - paramater virologus
    *@return void
    */
    public abstract void Effekt(Virologus v);
     /**
    *Leszarmazottban erdekes.
    *@param v - paramater virologus
    *@return void
    */
    public abstract void AntiEffekt(Virologus v);
     /**
    *Akkor hivodik meg, amikor a birtoklo virologust valamivel bekennek. Ilyenkor az Itemeknek van beleszolasa milyen agenssel lesz bekenve. 
    *@param v - virologus
    *@param a - agens
    *@return agens
    */
    public abstract agens BekenodesEffket(Virologus v, agens a);
     /**
    *Meghivja a v ItemVisit()-jet, ami majd visszahivja az AntiEffektet()
    *@param v - paramater virologus
    *@return void
    */
    public void removeCucc(Virologus v){
        v.ItemVisit(this);
        System.out.println("Item elvevodott");
    }
     /**
    *Eszkoz atadasa a parameterkent kapott virologusnak, ha igazzal ter vissza.
    *@param v - paramater virologus
    *@return boolean (true/false)
    */
    public boolean Itematadas(Virologus v){
            if(v.TargyMegkapas(this)) {
                System.out.println("Item atadodott");
                return true;
            }
            else {
                return false;
            }
    }
}
