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

    @Override
    public void Create(Virologus v) {
        Recept_temp = new boolean[Recept.size()];
        for (int i = 0; i<Recept.size(); i++){
            Recept_temp[i] = false;
        }
        for(Anyag a : v.anyagok){
            a.KellCrafthoz(this);
        }
        if(Recept_temp_kiertkelo()){
            for(Anyag a : v.anyagok){
                a.equals(Recept)
            }
            VédőÁgens a_copy = new VédőÁgens();
            v.ÁgensMegkapás(a_copy);
        }

    }

}
