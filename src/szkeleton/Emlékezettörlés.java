package Szkeleton;

public class Emlékezettörlés extends  Ágens{
    public Emlékezettörlés() {
        super(0, 5);
        Recept.add(new Nukleotid());
        Recept.add(new Nukleotid());
        Recept.add(new Nukleotid());
        Recept.add(new Aminosav());
    }

    @Override
    public void AntiEffekt(Virologus v) {

    }

    @Override
    public void Effekt(Virologus v) {
        v.mindentElfelejt();
    }

    @Override
    public Ágens BekenődésEffekt(Ágens a) {
        return a;
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
            Emlékezettörlés a_copy = new Emlékezettörlés();
            v.ÁgensMegkapás(a_copy);
        }

    }
}
