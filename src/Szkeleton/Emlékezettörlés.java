package Szkeleton;

public class Emlékezettörlés extends  Ágens{
  
    public Emlékezettörlés(){
        super(0, 5);
        System.out.println(this +" létrejött");
        Recept.add(new Nukleotid());
        Recept.add(new Nukleotid());
        Recept.add(new Nukleotid());
        Recept.add(new Aminosav());
    }

    @Override
    public void AntiEffekt(Virologus v) {
        System.out.println(this +"antieffekt");
    }

    @Override
    public void Effekt(Virologus v) {
        v.mindentElfelejt();
        System.out.println(this +" effekt");
    }

    @Override
    public Ágens BekenődésEffekt(Ágens a) {
        System.out.println(this +" bekenődésEffekt");
        return a;
    }

    /**
     * Emlékezettörlés másolatot átad v Virológusnak
     * @param v Virológus, amelyik megkapja a másolatot
     */
    @Override
    protected void Create_(Virologus v) {
        Emlékezettörlés a_copy = new Emlékezettörlés();
        v.ÁgensMegkapás(a_copy);
    }
    @Override
    public boolean equals(Ágens a) {
        return false;
    }
    @Override
    public boolean equals(Emlékezettörlés a) {
        return true;
    }

    @Override
    public String toString() {
        return "Emlékezettörlés";
    }
}
