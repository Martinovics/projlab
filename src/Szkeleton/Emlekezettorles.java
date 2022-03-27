package Szkeleton;

public class Emlekezettorles extends  agens{
  
    public Emlekezettorles(){
        super(0, 5);
        System.out.println(this +" letrejott");
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
    public agens BekenodesEffekt(agens a) {
        System.out.println(this +" bekenodesEffekt");
        return a;
    }

    /**
     * Emlekezettorles masolatot atad v Virologusnak
     * @param v Virologus, amelyik megkapja a masolatot
     */
    @Override
    protected void Create_(Virologus v) {
        Emlekezettorles a_copy = new Emlekezettorles();
        v.agensMegkapas(a_copy);
    }
    @Override
    public boolean equals(agens a) {
        return false;
    }
    @Override
    public boolean equals(Emlekezettorles a) {
        return true;
    }

    @Override
    public String toString() {
        return "Emlekezettorles";
    }
}
