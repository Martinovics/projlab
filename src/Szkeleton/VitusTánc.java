package Szkeleton;

public class VitusTánc extends  Ágens{
    public VitusTánc() {
        super(1, 5);
        Recept.add(new Nukleotid());
        Recept.add(new Nukleotid());
        Recept.add(new Aminosav());
    }

    @Override
    public void Effekt(Virologus v) {
        v.setLépésBehaviour(Game.getVitusLépés());
    }

    @Override
    public void AntiEffekt(Virologus v) {
        v.setLépésBehaviour(Game.getAktorLépés());
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
            VitusTánc a_copy = new VitusTánc();
            v.ÁgensMegkapás(a_copy);
        }

    }
}
