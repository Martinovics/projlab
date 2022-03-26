package Szkeleton;

public class Stun extends Ágens{
    public Stun() {
        super(2, 5);
        Recept.add(new Nukleotid());
        Recept.add(new Aminosav());
        Recept.add(new Aminosav());
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
            Stun a_copy = new Stun();
            v.ÁgensMegkapás(a_copy);
        }

    }

    @Override
    public void Effekt(Virologus v) {
        v.setLépésBehaviour(Game.getStunLépés());
    }

    @Override
    public void AntiEffekt(Virologus v) {
        v.setLépésBehaviour(Game.getAktorLépés());

    }
}
